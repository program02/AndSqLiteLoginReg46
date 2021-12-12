package com.example.loginregr46;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText id,name,email,password;
    DbHelper helper;
    Student s;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //id = findViewById(R.id.regid);
        name = findViewById(R.id.logname);
        //email = findViewById(R.id.regemail);
        password = findViewById(R.id.logpassword);
        helper = new DbHelper(this);
    }
    public void login(View view){
              s = helper.login(name.getText().toString(),password.getText().toString());
              if(s!=null){
                  intent = new Intent(this, LoginSuccessActivity.class);
                  intent.putExtra("email",s.getEmail());
                  startActivity(intent);
                  Toast.makeText(this,"Login Successfull",Toast.LENGTH_LONG).show();
              }else {
                  Toast.makeText(this,"Wrong information, Try again",Toast.LENGTH_LONG).show();
              }
    }
    public void  gotoRegistration(View view){
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}