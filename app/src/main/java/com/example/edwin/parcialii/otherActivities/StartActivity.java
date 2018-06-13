package com.example.edwin.parcialii.otherActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.edwin.parcialii.R;
import com.example.edwin.parcialii.otherActivities.LoginActivity;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        /* if(working offline){
            intent = new Intent(this,MainActivity.class }
            else{
            intent = new Intent(this,LoginActivity.class }
         */
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
