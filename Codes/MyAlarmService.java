package com.bizfit.bizfit;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyAlarmService extends Service {

    @Override

    public void onCreate() {

    }

    public IBinder onBind(Intent intent) {

        return null;

    }

    @Override

    public void onDestroy() {

        super.onDestroy();

    }



    @Override

    public void onStart(Intent intent, int startId) {

        super.onStart(intent, startId);


    }

    @Override

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);

    }


    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);

        NotificationSender.sendNotification(this, "hei", "hei");
        User.update(this);

        return START_NOT_STICKY;
    }


}
