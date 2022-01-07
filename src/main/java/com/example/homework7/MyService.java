package com.example.homework7;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {
    public class MyBinder extends Binder{
        public MyService getService(){
            return MyService.this;
        }
    }

    private MyBinder binder = new MyBinder();
    private String id = "19301141";
    private String name = "陈俊哲";


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("Service", "bind successfully");
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.i("service start", "id: " + id + " name: " + name);
        return START_STICKY;
    }

    public void showMessage(){
        Log.i("invoke inner method", "id: " + id + " name: " + name);
    }
}
