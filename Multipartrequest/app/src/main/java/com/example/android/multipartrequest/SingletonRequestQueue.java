package com.example.android.multipartrequest;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by root on 21/1/18.
 * Only one instance of the RequestQueue will be present throughtout the Application.
 * Make sure you pass the Application Context while creating an instance using getInstance()
 */

public class SingletonRequestQueue {

    public static SingletonRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context appContext;

    private SingletonRequestQueue(Context context){
        appContext = context;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized SingletonRequestQueue getInstance(Context context){
        if(mInstance==null) {
            mInstance = new SingletonRequestQueue(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue(){
        if(mRequestQueue==null){
            mRequestQueue = new Volley().newRequestQueue(appContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> request){
        getRequestQueue().add(request);
    }

}
