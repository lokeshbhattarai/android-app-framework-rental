package com.asd.framework.car;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.asd.framework.R;
import com.asd.framework.car.beans.Product;
import com.asd.framework.car.beans.ProductCar;
import com.asd.framework.utils.AppLogger;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import project.asd.rentalframework.core.AbstractProduct;
import project.asd.rentalframework.core.AcheckoutProcessor;
import project.asd.rentalframework.core.ItemAvailableState;
import project.asd.rentalframework.core.Transaction;

public class ProductCheckoutActivity extends AcheckoutProcessor implements DatePickerDialog.OnDateSetListener {

    private ArrayList<AbstractProduct> productList;
    Product SELECTED_PRODUCT;
    private TextView bookingDate, txtTotalBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_checkout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SELECTED_PRODUCT = (Product) getIntent().getSerializableExtra("SELECTED_PRODUCT");
        productList = new ArrayList<>();

        AbstractProduct product = new ProductCar(SELECTED_PRODUCT.getTitle(), SELECTED_PRODUCT.getSubTitle(),SELECTED_PRODUCT.getModelNumber(),
                SELECTED_PRODUCT.getSeats(), SELECTED_PRODUCT.getAvailableStatus(), SELECTED_PRODUCT.getDailyChargeRate(), SELECTED_PRODUCT.getIconName(),
                new Date(), new ItemAvailableState(null));
        productList.add(product);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        // Init View
        initView();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        ProductCheckoutActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.show(getFragmentManager(), "Date Picker");


            }
        });
    }

    private void initView() {
        bookingDate = (TextView) findViewById(R.id.bookingDate);
        txtTotalBill = (TextView) findViewById(R.id.txtTotalBill);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        DatePickerDialog dpd = (DatePickerDialog) getFragmentManager().findFragmentByTag("Date Picker");

        if(dpd != null) dpd.setOnDateSetListener(this);
    }

    @Override
    public List<AbstractProduct> setItemsForCheckout() {
        return productList;
    }

    @Override
    public double calculatePrice() {
        int days = 0;
        if (bookingDate.getText() != null){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date strDate = null;

            try {
                strDate = sdf.parse(bookingDate.getText().toString());

            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (new Date().after(strDate)) {
                days = new Date().compareTo(strDate);
            }
        }
        double price = (double) days * SELECTED_PRODUCT.getDailyChargeRate();
        txtTotalBill.setText(" $ "+ price );
        return  price;
    }

    @Override
    public Transaction confirmCheckout(double totalPriceofTransaction) {
        return null;
    }

    @Override
    public boolean checkout() {
        return false;
    }

    @Override
    public void returnPayment() {

    }

    @Override
    public void printBill(boolean shouldGenerateBill) {

    }

    @Override
    public void updateCartPrice(double newTotalCartPrice) {

    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        String date = ""+dayOfMonth+"/"+(monthOfYear+1)+"/"+year;
        //AppLogger.Debugger("Checkout", date);
        bookingDate.setText(date);
    }




}
