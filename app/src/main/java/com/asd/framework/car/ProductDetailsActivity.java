package com.asd.framework.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import com.asd.framework.R;
import com.asd.framework.car.beans.Product;
import com.asd.framework.car.beans.ProductCar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import project.asd.rentalframework.core.AbstractProduct;
import project.asd.rentalframework.core.AcheckoutProcessor;
import project.asd.rentalframework.core.ItemAvailableState;
import project.asd.rentalframework.core.ItemState;
import project.asd.rentalframework.core.Transaction;


public class ProductDetailsActivity extends AcheckoutProcessor {

    private List<AbstractProduct> productList;
    private ItemState state;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Product SELECTED_PRODUCT = (Product) getIntent().getSerializableExtra("SELECTED_PRODUCT");
        productList = new ArrayList<>();

       AbstractProduct product = new ProductCar(SELECTED_PRODUCT.getTitle(), SELECTED_PRODUCT.getSubTitle(),SELECTED_PRODUCT.getModelNumber(),
                SELECTED_PRODUCT.getSeats(), SELECTED_PRODUCT.getAvailableStatus(), SELECTED_PRODUCT.getDailyChargeRate(), SELECTED_PRODUCT.getIconName(),
                new Date(), new ItemAvailableState(null));
        productList.add(product);

        getSupportActionBar().setTitle(SELECTED_PRODUCT.getTitle());
        getSupportActionBar().setSubtitle(SELECTED_PRODUCT.getSubTitle());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        /*HorizontalListView selectedProductList = (HorizontalListView) findViewById(R.id.selectedProductList);
        AdapterProductList adapter = new AdapterProductList(getApplicationContext(), productList);
        selectedProductList.setAdapter(adapter);*/

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public List<AbstractProduct> setItemsForCheckout() {
        return productList;
    }

    @Override
    public double calculatePrice() {
        return 0;
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
}
