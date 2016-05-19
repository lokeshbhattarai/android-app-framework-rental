package com.asd.framework.car;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ListView;

import com.asd.framework.R;
import com.asd.framework.car.adapter.AdapterProductList;
import com.asd.framework.car.beans.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductListingActivity extends AppCompatActivity {

    private FloatingActionButton revealFAB;
    private ListView productListView;
    private List<Product> productList;
    private AdapterProductList adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_car_rental));
        getSupportActionBar().setSubtitle(getResources().getString(R.string.vailable_product));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        initView();

        prepareDummyData();

        adapter = new AdapterProductList(getApplicationContext(), productList);
        productListView.setAdapter(adapter);
    }

    private void prepareDummyData() {
        productList = new ArrayList<>();

        // Dummy Product
        Product mazdaCar = new Product("Madza Celerio 50", "TATA Motors", "2015", 4, "Available", 20.50, "car_silver");
        Product mazdaCar1 = new Product("Madza Celerio 70", "TATA Motors", "2015", 4, "Unavailable", 20.50, "car_red");
        Product etos500 = new Product("Etos 500", "TATA Motors", "2015", 4, "Unavailable", 25.50, "car_gray");
        Product innova = new Product("Innova 1000", "Innova Motors", "2015", 4, "Available", 23.50, "car_black");

        productList.add(mazdaCar);
        productList.add(mazdaCar1);
        productList.add(innova);
        productList.add(etos500);
    }

    private void initView() {

        productListView = (ListView) findViewById(R.id.productListView);

        revealFAB = (FloatingActionButton) findViewById(R.id.fabAddProduct);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}
