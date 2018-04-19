package com.example.rise.tcpconnectionsample;

import android.Manifest;
import android.animation.Animator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

/**
 * Created by Rise on 19/09/2017.
 */

public class LoginViewController extends AppCompatActivity {

    EditText userNameTextField, passwordTextField;
    String st_emailandphone, st_password;
    ProgressDialog mProgress;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        ButterKnife.bind(this);

    }

    private void init() {

        userNameTextField = (EditText) findViewById(R.id.editText_Email);
        passwordTextField = (EditText) findViewById(R.id.editText_password);
    }

    @OnClick(R.id.signin)
    public void login() {
        mLogin();

    }

    @OnClick(R.id.forgotpassword)
    public void forgot() {
        moveToForgetPasswordPage(userNameTextField.getText().toString());
    }

    private void moveToForgetPasswordPage(String emailInfo) {

        Intent intent = new Intent(LoginViewController.this, ForgotpasswordViewController.class);
        intent.putExtra("email", emailInfo);
        startActivity(intent);

    }

    @OnClick(R.id.signup)
    public void signup() {
        Intent in = new Intent(LoginViewController.this, RegisterViewController.class);
        startActivity(in);
    }






    public void mLogin() {

        st_emailandphone = userNameTextField.getText().toString();
        st_password = passwordTextField.getText().toString();


        if (st_emailandphone.length() > 0) {

            if (st_password.length() > 0) {

                if (isConn()) {

                } else {
                }

            } else {
            }
        } else {

        }


    }

    public boolean isConn() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity.getActiveNetworkInfo() != null) {
            if (connectivity.getActiveNetworkInfo().isConnected())
                return true;
        }
        return false;
    }




}
