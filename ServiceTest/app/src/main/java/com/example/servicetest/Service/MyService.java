package com.example.servicetest.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class MyService extends Service {


    private int mRandomNumber;
    private boolean mIsRandomOn;
    private final int MIN = 0;
    private final int MAX = 100;


    private static final String DEBUG_TAG = "[ServiceTest]";
    private final IBinder mBinder = new MyServiceBinder();

    class MyServiceBinder extends Binder {

        public MyService getService(){ return MyService.this; }
    }


    @Override
    public IBinder onBind(Intent intent) {
        Log.d( DEBUG_TAG, "In OnBind" );
        return mBinder;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.i( DEBUG_TAG ,"In OnReBind");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRandomNumber();
        Log.i(DEBUG_TAG,"Service Destroyed");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i( DEBUG_TAG,"In onStartCommand, thread id: " + Thread.currentThread().getId() );
        mIsRandomOn = true;
        //it must be in another Thread to avoid blocking the MainThread app
        new Thread(() -> startRandomNumber()).start();
        return START_STICKY;
    }

    private void startRandomNumber(){
        while ( mIsRandomOn ) {
            try{
                Thread.sleep(1000);
                if ( mIsRandomOn ){
                    mRandomNumber = new Random().nextInt(MAX)+MIN;
                    Log.i(DEBUG_TAG,"Thread id: " +Thread.currentThread().getId() +", Random Number: "+ mRandomNumber);
                }
            }catch (Exception e){
                Log.i(DEBUG_TAG,"Thread Interrupted");
            }
        }
    }

    private void stopRandomNumber(){
        mIsRandomOn = false;
    }

    public int getmRandomNumber(){
        return mRandomNumber;
    }
}
