package com.example.gridsim;

import android.util.Log;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Poller {
    ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

    Runnable grabServerData = new Runnable(){
        public void run(){
            Log.d("Poller", "grab server data at some point");
        }
    };

    ScheduledFuture<?> periodicFuture = sch.scheduleAtFixedRate(grabServerData, 500, 500, TimeUnit.MILLISECONDS);
}