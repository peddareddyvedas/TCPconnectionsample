package com.example.rise.tcpconnectionsample;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Rise on 19/09/2017.
 */

public class ForgotpasswordViewController extends AppCompatActivity {
    Button back;
    EditText userNameTextField,otp;
    String st_emailandphone;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
        ButterKnife.bind(this);
        init();

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if(bd != null)
        {
            String emailString  = (String) bd.get("email");
            userNameTextField.setText(emailString);

        }



    }

    private void init() {
        userNameTextField = (EditText) findViewById(R.id.editText_Email);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @OnClick(R.id.forgotpassword)
    public void getpasword() {
        mForgotpsw();

    }
    public void mForgotpsw() {
        st_emailandphone = userNameTextField.getText().toString();
        if (st_emailandphone.length() > 0) {
            if (isValidEmail(st_emailandphone)) {

                if (isConn()) {


                } else {
                }
            } else {
            }
        } else {

        }
    }
    public boolean isValidEmail(String target) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(target).matches();
    }

    private boolean isValidPhone(String pass) {
        return pass != null && pass.length() == 13;

    }
    public boolean isConn() {
        ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity.getActiveNetworkInfo() != null) {
            if (connectivity.getActiveNetworkInfo().isConnected())
                return true;
        }
        return false;
    }



    public String getCurrentTime() {
        String attempt_time = String.valueOf(System.currentTimeMillis() / 1L);
        Log.e("attem", "" + attempt_time);
        return attempt_time;
    }

}
