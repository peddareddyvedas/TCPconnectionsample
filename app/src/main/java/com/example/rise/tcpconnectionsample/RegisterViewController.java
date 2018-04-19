package com.example.rise.tcpconnectionsample;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.Nullable;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;
import io.socket.client.Socket;


/**
 * Created by Rise on 08/02/2018.
 */
public class RegisterViewController extends Activity {
    EditText userNameTextField, passwordTextField, confirmPasswordTextField,otp;
    String st_emailorphone, st_psw, st_confirm_psw;
    private Socket mSocket;
    public static boolean isFromRegister=false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        ButterKnife.bind(this);



    }

    private void init() {

        userNameTextField = (EditText) findViewById(R.id.editText_Email);
        passwordTextField = (EditText) findViewById(R.id.editText_password);
        confirmPasswordTextField = (EditText) findViewById(R.id.confirmPasswordTextField);


        ChatApplication app=(ChatApplication)getApplication();
        mSocket=app.getSocket();
    }
    @OnClick(R.id.signin)
    public void sign() {
        signupAction();
    }

    @OnClick(R.id.back)
    public void back() {
        finish();
    }


    // Validations for//
    public void signupAction() {

        st_emailorphone = userNameTextField.getText().toString();
        st_psw = passwordTextField.getText().toString();
        st_confirm_psw = confirmPasswordTextField.getText().toString();
        if (st_emailorphone.length() > 0) {
            if (isValidEmail(st_emailorphone)) {
                if (st_psw.length() > 0) {

                    if (isValidPasword(st_psw)) {
                        if (st_confirm_psw.length() > 0) {
                            if (st_psw.equals(st_confirm_psw)) {
                                if (isConn()) {


                                } else {
                                }
                            } else {
                            }

                        } else {

                        }

                    } else {


                    }

                } else {

                }

            } else {

            }

        } else {

        }
        JSONObject json=new JSONObject();
        try {
            json.put("username",st_emailorphone);
            json.put("password",st_psw);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.e("json",""+json);
        mSocket.emit("add user",json);
    }


    public boolean isValidEmail(String target) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(target).matches();
    }

    // Validate password
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


}