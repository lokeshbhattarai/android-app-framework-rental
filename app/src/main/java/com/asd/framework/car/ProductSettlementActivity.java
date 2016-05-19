package com.asd.framework.car;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.asd.framework.R;
import com.asd.framework.car.adapter.AdapterProductList;
import com.asd.framework.car.beans.Product;
import com.asd.framework.utils.HorizontalListView;

import java.util.ArrayList;
import java.util.List;


public class ProductSettlementActivity extends AppCompatActivity {

    private List<Product> productList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_settlement_rental));

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

//        HorizontalListView selectedProductList = (HorizontalListView) findViewById(R.id.selectedProductList);
//        AdapterProductList adapter = new AdapterProductList(getApplicationContext(), productList);
//        selectedProductList.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
