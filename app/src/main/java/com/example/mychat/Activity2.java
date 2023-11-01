package com.example.mychat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("dxy","2:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("dxy","2:onStop...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dxy","2:onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("dxy","2:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("dxy","2:onPostResume...");
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView textview;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        textview=findViewById(R.id.textview2);
        Log.d("dxy","2:onCreate...");
        Intent intent=getIntent();
        String str=intent.getStringExtra("name")+"-"
                +intent.getIntExtra("age",1);
        String str2=intent.getExtras().getString("name")+"--"+intent.getExtras().getInt("age");
        textview.setText(str2);
    }
}