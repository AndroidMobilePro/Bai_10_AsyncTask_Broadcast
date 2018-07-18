package com.proteam.bai_10_asynctask_broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ExampleBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("TAG11", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Toast.makeText(context, "Toast", Toast.LENGTH_SHORT).show();
    }
}
