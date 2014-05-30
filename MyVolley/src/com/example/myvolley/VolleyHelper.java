package com.example.myvolley;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleyHelper {
    private static RequestQueue mRequestQueue;
    private static final Object lock = new Object();
    
    /**
     * Create the Singleton of the RequestQueue.
     * @param context
     * @return RequestQueue
     * @see <a href="http://www.vagrantup.jp/entry/2013/12/07/164310">未処分利益 Volleyについて調べる(1)</a>
     */
    public static RequestQueue getRequestQueue(final Context context) {
        synchronized (lock) {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(context);
            }
            return mRequestQueue;
        }
    }
}
