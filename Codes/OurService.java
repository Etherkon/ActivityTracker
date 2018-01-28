package com.bizfit.bizfit;


import android.app.IntentService;
import android.content.Intent;

public class OurService extends IntentService {
	
    public static PauseableThread thread;


    public OurService() {
        super("OurService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        long endTime = System.currentTimeMillis() + 5*1000;
        while (System.currentTimeMillis() < endTime) {
            synchronized (this) {
                try {
                    wait(endTime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        super.onStartCommand(intent, flags, startId);
        if(thread==null){
            thread=new PauseableThread(1000);
            thread.start();
        }else if(thread!=null&&!thread.isAlive()){
            thread=new PauseableThread(1000);
            thread.start();
        }
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
