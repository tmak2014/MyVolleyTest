package com.example.myvolley;

import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "Volley Test";
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView1);

        Button jsonObjectRequest = (Button) findViewById(R.id.jsonObjectRequest);
        jsonObjectRequest.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonObjectRequest(getApplicationContext());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopVolley();
    }

    private void jsonObjectRequest(Context context) {
        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        if (mQueue == null) mQueue = VolleyHelper.getRequestQueue(getApplicationContext());
        JsonObjectRequest req = new JsonObjectRequest(Method.GET, url, null, new Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "response : " + response.toString());
            }
        }, new ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, "ErrorListener");
            }
            
        });
        mQueue.add(req);
        mQueue.start();
        return;
    }
    

    private void stopVolley() {
        if (mQueue != null) {
            mQueue.stop();
        }
        return;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
