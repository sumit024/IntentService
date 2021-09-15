package com.app_devs.intentservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import java.util.concurrent.ThreadLocalRandom

class MyService:Service() {
    val TAG="My Service"
    override fun onBind(intent: Intent?): IBinder? =null
    init {
        Log.d(TAG,"Service is running")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString=intent?.getStringExtra("EXTRA_DATA")
        dataString?.let{
            Log.d(TAG,dataString)
        }
        Thread{
            while(true){
            }
        }.start()

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"service is being killed")
    }
}