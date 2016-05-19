package com.asd.framework.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.asd.framework.R;
import com.asd.framework.car.adapter.AdapterProductList;
import com.asd.framework.car.adapter.AdapterProductSettlement;
import com.asd.framework.car.beans.Product;
import com.asd.framework.car.beans.ProductCar;
import com.asd.framework.utils.HorizontalListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import project.asd.rentalframework.core.ASettleProcessor;
import project.asd.rentalframework.core.AbstractProduct;
import project.asd.rentalframework.core.ItemAvailableState;
import project.asd.rentalframework.core.Transaction;


public class ProductSettlementActivity extends ASettleProcessor {

    private List<ProductCar> productList;
    private TextView txtTotalBill;
    private double billAmount;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_settlement_rental));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        productList = new ArrayList<>();

        ProductCar product1 = new ProductCar("Madza Celerio 50", "TATA Motors", "2015", 4, "Available", 20.50, "car_silver", new Date(), new ItemAvailableState(null));
        ProductCar product2 = new ProductCar("Innova 1000", "Innova Motors", "2015", 4, "Available", 23.50, "car_black", new Date(), new ItemAvailableState(null));

        productList.add(product1);
        productList.add(product2);

        txtTotalBill = (TextView) findViewById(R.id.txtTotalBill);

        HorizontalListView selectedProductList = (HorizontalListView) findViewById(R.id.selectedProductList);
        AdapterProductSettlement adapter = new AdapterProductSettlement(getApplicationContext(), productList);
        selectedProductList.setAdapter(adapter);

        selectedProductList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AbstractProduct product = productList.get(position);
                List<AbstractProduct> products = new ArrayList<AbstractProduct>();
                products.add(product);
                Transaction transaction = new Transaction(products, null);

                billAmount = product.getPrice();
                settleTransaction(transaction);


            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean settle(List<HashMap<AbstractProduct, Double>> abstractProducts) {
        return false;
    }

    @Override
    public void printBill(boolean shouldGenerateBill) {

        txtTotalBill.setText(""+ billAmount);
    }
}
