package com.example.android.himusic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class BootCompletedBroadcastReceiver extends BroadcastReceiver {

    private String TAG="BootCompletedBroadcastReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        Log.d(TAG,action+" received");
        if(action != null) {
            if (action.equals(Intent.ACTION_BOOT_COMPLETED) ) {
                Intent intentToService = new Intent(context,MusicService.class);
                intentToService.putExtra("bootNotification", "BOOT");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    context.startForegroundService(intentToService);
                    Log.d(TAG, "onReceive: intent sent to service class ");
                } else {
                    context.startService(intentToService);
                    Log.d(TAG, "onReceive: intent sent to service class");
                }

            }

        }
            }


}



