package com.example.gridsim;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.gridsim.Model.SimGridFacade;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Poller {
    private static final String TAG = "gridView";
    private static final String url = "http://stman1.cs.unh.edu:6191/games";
    private static Poller _poller;
    RequestQueue queue;

    public static Poller getInstance(Context c){
        if(_poller == null){
            _poller = new Poller(c);
        }
        return _poller;
    }

    private Poller(Context context){
        queue = Volley.newRequestQueue(context);
    }

    ScheduledThreadPoolExecutor sch = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(5);

    Runnable grabServerData = new Runnable(){
        public void run(){
            JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {

                            // Post here
                            EventBus.getDefault().post(response);
                            // facade.setUsingJSON(response);

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e(TAG, "VolleyError");
                }
            });
            queue.add(request);
            Log.d(TAG, "Response Received");
        }
    };

    ScheduledFuture<?> periodicFuture = sch.scheduleAtFixedRate(grabServerData, 500, 500, TimeUnit.MILLISECONDS);
}