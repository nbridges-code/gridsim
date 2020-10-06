package com.example.gridsim.Model;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class GridEventSubscriber{
    @Subscribe
    public void GridEventSubscriber(GridEvent gridEvent){
        Log.d("GridView_test", "GridEventSubscriber called");
    }

    @Override
    public void onStart(){
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop(){
        EventBus.getDefault().register(this);
        super.onStop();
    }
}
