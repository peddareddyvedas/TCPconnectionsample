package com.example.rise.tcpconnectionsample;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

/**
 * Created by Rise on 20/09/2017.
 */

public class NewpasswordViewController extends AppCompatActivity {

    Button back, done;
    EditText passwordTextField;
    String st_password;
    String emailString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpassword);
        ButterKnife.bind(this);

        init();


        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null) {
            emailString = (String) bd.get("email");

        }
    }

    private void init() {

        passwordTextField = (EditText) findViewById(R.id.editText_Password);

        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NewpasswordViewController.this, ForgotpasswordViewController.class);
                startActivity(in);


            }


            public void mConformpassword() {

                st_password = passwordTextField.getText().toString();

                if (st_password.length() > 0) {
                    if (isValidPasword(st_password)) {
                        if (isConn()) {
                        } else {
                        }


                    } else {
                    }
                } else {

                }


            }


            private boolean isValidPasword(String password) {
                boolean isValid = false;

                String expression = "^(?=.*[a-z])(?=.*[$@$#!%*?&])[A-Za-z\\d$@$#!%*?&]{8,}";
                CharSequence inputStr = password;

                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(inputStr);
                if (matcher.matches()) {
                    System.out.println("if");
                    isValid = true;
                } else {
                    System.out.println("else");
                }
                return isValid;
            }

            public boolean isConn() {
                ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                if (connectivity.getActiveNetworkInfo() != null) {
                    if (connectivity.getActiveNetworkInfo().isConnected())
                        return true;
                }
                return false;
            }

        });
    }
}
