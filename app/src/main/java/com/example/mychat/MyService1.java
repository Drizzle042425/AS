package com.example.mychat;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MyService1 extends Service {
    MediaPlayer player;
    public MyService1() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return】】 the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("dxy","MyService1:onCreate...");
        player = MediaPlayer.create(this,R.raw.music1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("dxy","MyService1:onStartCommand...");
        player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
        Log.d("dxy","MyService1:onDestroy...");
    }
}