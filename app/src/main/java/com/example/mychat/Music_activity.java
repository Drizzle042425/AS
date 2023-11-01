package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;

public class Music_activity extends AppCompatActivity {

    MyService2.MyBinder binder;
    Button button1,button2,button3,button4;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_activity);

        button1 = findViewById(R.id.buttonM1);
        button2 = findViewById(R.id.buttonM2);
        button3 = findViewById(R.id.buttonM3);
        button4 = findViewById(R.id.buttonM4);

        Intent intent = new Intent(
                Music_activity.this,MyService1.class);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });

        Intent intent3=new Intent((this),MyService2.class);
        ServiceConnection connection=new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                binder=(MyService2.MyBinder) iBinder;
                binder.Todo();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                binder=null;
            }
        };
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View view){

                bindService(intent3,connection,BIND_AUTO_CREATE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unbindService(connection);
            }
        });
    }
}