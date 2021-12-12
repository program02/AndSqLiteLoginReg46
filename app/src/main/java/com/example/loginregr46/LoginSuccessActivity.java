package com.example.loginregr46;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class LoginSuccessActivity extends AppCompatActivity {
TextView tvmsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);
        Intent intent = getIntent();
        tvmsg= findViewById(R.id.welcome);
        String  email = intent.getStringExtra("email");
        tvmsg.setText("Hello "+ email);
    }
}