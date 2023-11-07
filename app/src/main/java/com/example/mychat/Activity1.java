package com.example.mychat;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends AppCompatActivity {

    Button button1,button2;
    TextView textView_1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        textView_1 = findViewById(R.id.textView_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity1.this, Activity2.class);

                intent.putExtra("name","dxy");
                intent.putExtra("age",20);

                Bundle bundle = new Bundle();
                bundle.putString("name","dxy");
                bundle.putInt("age",20);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        ActivityResultLauncher launcher= registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                            @Override
                            public void onActivityResult(ActivityResult result) {
                                if(result.getResultCode() == 666){
                                    String str = result.getData().getStringExtra("result");
                                    textView_1.setText(str);
                                }
                            }
                        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(Activity1.this,Activity3.class);
                launcher.launch(intent3);
            }
        });
        Log.d("dxy","1:onCreate...");
        MediaPlayer player=MediaPlayer.create(this,R.raw.music1);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("dxy","1:onDestroy...");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("dxy","1:onStop...");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("dxy","1:onResume...");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("dxy","1:onStart...");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("dxy","1:onPostResume...");
    }
}