package com.example.mychat;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    MediaPlayer player;
    public MyService2() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return】】 the communication channel to the service.
        Log.d("dxy", "MyService2:onBind...");
        MyBinder myBinder=new MyBinder();
        return myBinder;
    }

    class MyBinder extends Binder{
       public MyBinder(){

        }
        public void Todo(){
           player.start();
           Log.d("dxy", "MyService2:Todo...");
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("dxy","MyService2:onCreate...");
        player = MediaPlayer.create(this,R.raw.music1);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("dxy","MyService2:onStartCommand...");
        //player.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        super.onDestroy();
        Log.d("dxy","MyService2:onDestroy...");
    }
}