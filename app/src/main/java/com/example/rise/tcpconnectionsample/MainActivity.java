package com.example.rise.tcpconnectionsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    @OnClick(R.id.button)
    public void getpasword() {

        startActivity(new Intent(getApplicationContext(), LoginViewController.class));

    }
}
