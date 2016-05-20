package com.asd.framework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.asd.framework.car.CarMainActivity;
import com.asd.framework.constant.Config;
import com.asd.framework.utils.AppLogger;

import org.json.JSONObject;

import java.util.HashMap;

import project.asd.rentalframework.login.AbstractLoginProcessor;


public class LoginActivity extends AbstractLoginProcessor implements View.OnClickListener {

    private EditText inputUserName, inputPassword;
    private Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initView();

    }

    private void initView() {
        inputUserName = (EditText) findViewById(R.id.inputUserName);
        inputPassword = (EditText) findViewById(R.id.inputPassword);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public HashMap<String, String> getCredentials() {
        HashMap<String, String> userCredential = new HashMap<>();
        userCredential.put("userName", inputUserName.getText().toString());
        userCredential.put("password", inputPassword.getText().toString());
        return userCredential;
    }

    @Override
    public String getLoginUrl() {
        return Config.LOGIN_URL;
    }

    @Override
    public String getRequestType() {
        return "POST";
    }

    @Override
    public void onLoginResult(JSONObject response) {
        AppLogger.Debugger("Login Response", ""+ response);

        Intent intentCar = new Intent(getApplicationContext(), CarMainActivity.class);
        startActivity(intentCar);
        this.finish();
    }

    @Override
    public void onClick(View v) {

        if ((!TextUtils.isEmpty(inputUserName.getText().toString()) &&
                (!TextUtils.isEmpty(inputPassword.getText().toString())))) {
            initiateLogin();
        }

    }
}
