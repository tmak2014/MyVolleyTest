package com.example.myvolley;

import org.json.JSONObject;

import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String TAG = "Volley Test";
	private RequestQueue mQueue;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mQueue = Volley.newRequestQueue(getApplicationContext());
        
        Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String responceTime = requestVolley();
                Toast.makeText(MainActivity.this, "Volley Request finished : " + responceTime , Toast.LENGTH_SHORT).show();
            }
        });
    }

    //TODO What do I to do?
    private String requestVolley() {
        long currentTimeMillis = System.currentTimeMillis();
        String url = "http://www.google.com/uds/GnewsSearch?q=Obama&v=1.0";
        mQueue.add(new JsonObjectRequest(Method.GET, url, null,
                new Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "response : " + response.toString());
                    }
                }, null));
        mQueue.start();
        return Long.toString(System.currentTimeMillis() - currentTimeMillis);
    }


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
