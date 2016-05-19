package com.asd.framework.car;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.asd.framework.R;

public class CarMainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout layoutDeveloper, layoutContent;
    private RelativeLayout layoutCheckout, layoutSettlement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_main);

        getSupportActionBar().setTitle(getResources().getString(R.string.title_car_rental));
        getSupportActionBar().setSubtitle(getResources().getString(R.string.vailable_product));

        // View Initialization
        initView();

        // Animation
        moveViewBottomToCenter(layoutDeveloper);
        moveViewTopToCenter(layoutContent);
    }


    private void initView() {

        layoutContent = (LinearLayout) findViewById(R.id.layoutContent);
        layoutDeveloper = (LinearLayout) findViewById(R.id.layoutDeveloper);

        layoutCheckout = (RelativeLayout) findViewById(R.id.layoutCheckout);
        layoutSettlement = (RelativeLayout) findViewById(R.id.layoutSettlement);

        layoutCheckout.setOnClickListener(this);
        layoutSettlement.setOnClickListener(this);
    }

    public void moveViewBottomToCenter(LinearLayout layout) {

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translation_from_bottom);
        anim.setInterpolator((new AccelerateDecelerateInterpolator()));
        anim.setFillAfter(true);
        layout.setAnimation(anim);
    }

    public void moveViewTopToCenter(LinearLayout view) {

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translation_from_top);
        anim.setInterpolator((new AccelerateDecelerateInterpolator()));
        anim.setFillAfter(true);
        view.setAnimation(anim);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layoutCheckout:
                Intent checkOutIntent = new Intent(getApplicationContext(), ProductListingActivity.class);
                startActivity(checkOutIntent);
                break;
            case R.id.layoutSettlement:
                Intent settlementIntent = new Intent(getApplicationContext(), ProductSettlementActivity.class);
                startActivity(settlementIntent);
                break;
            default:
                break;
        }

    }
}
