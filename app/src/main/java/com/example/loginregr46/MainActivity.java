package com.example.loginregr46;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText id,name,email,password;
DbHelper helper;
Intent intent;
    Student s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id = findViewById(R.id.regid);
        name = findViewById(R.id.logname);
        email = findViewById(R.id.regemail);
        password = findViewById(R.id.logpassword);
        helper = new DbHelper(this);
    }
    public void registration(View view){
       s= new Student(Integer.parseInt(id.getText().toString()),name.getText().toString(),email.getText().toString(),password.getText().toString());
       helper.insert(s);
        intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}