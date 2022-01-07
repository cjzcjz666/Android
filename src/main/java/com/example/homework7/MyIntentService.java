package com.example.homework7;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {
    private String id = "19301141";
    private String name = "陈俊哲";

    public MyIntentService(){
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i("intent service start", "id: " + id + " name: " + name);
    }
}