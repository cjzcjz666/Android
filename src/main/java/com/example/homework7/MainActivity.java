package com.example.homework7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyService service = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            MyService.MyBinder myBinder = (MyService.MyBinder) binder;
            service = myBinder.getService();
            Log.i("Activity", "bind successfully");
            service.showMessage();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i("DemoLog", "ActivityA onServiceDisconnected");
        }
    };

    public void startService(View view){
        Log.i("DemoLog", "start");
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, conn, BIND_AUTO_CREATE);
    }

    public void startIntentService(View view){
        startService(new Intent(getBaseContext(), MyIntentService.class));
    }
}