package com.example.mychat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fragment2Detail extends AppCompatActivity {
    TextView dName,textView1,textView2,textView3;
    ImageView dImage;
    Button button_r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab02_details);
        //获取上一个Actvity传过来的intent
        Intent intent=getIntent();
        dName=findViewById(R.id.textDetail);
        dImage=findViewById((R.id.imageDetail));
        //根据intent获取得到的数据设置item控件的值
        dImage.setImageResource(intent.getIntExtra("image",R.drawable.wode));
        dName.setText(intent.getStringExtra("details"));
        textView1=findViewById(R.id.songer2);
        textView2=findViewById(R.id.song2);
        textView3=findViewById(R.id.wxtag2);
        textView1.setText(intent.getStringExtra("songer"));
        textView2.setText(intent.getStringExtra("song"));
        textView3.setText(intent.getStringExtra("tag"));
        button_r=findViewById(R.id.returnButton);

    }
}