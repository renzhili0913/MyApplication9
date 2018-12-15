package com.example.week03_04.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.week03_04.LoginActivity;

import cn.jpush.android.api.JPushInterface;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (intent.getAction().equals("cn.jpush.android.intent.NOTIFICATION_OPENED")){
            Intent intent1 = new Intent(context,LoginActivity.class);
            //获取推送的消息并传到下一个activity
            intent1.putExtra("name",bundle.getString(JPushInterface.EXTRA_ALERT));
           // Log.i("TAG","-----------------"+bundle.getString(JPushInterface.EXTRA_ALERT));
            intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
            context.startActivity(intent1);
        }
    }
}
