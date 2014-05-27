package com.example.myvolley;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class ImageAdapter extends ArrayAdapter<String> {
    private RequestQueue mQueue;
    private ImageLoader mImageLoader;

    public ImageAdapter(Context context, List<String> objects) {
        super(context, 0, objects);
        mQueue = Volley.newRequestQueue(getContext());
        mImageLoader = new ImageLoader(mQueue, new BitmapCache());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String url = getItem(position);
        ImageView imageView;
        
        if (convertView != null) {
            imageView = (ImageView)convertView;
        } else {
            imageView = new ImageView(getContext());
        }
        
        ImageListener listener = ImageLoader.getImageListener(imageView, 
                android.R.drawable.ic_menu_rotate, //読み込み中画像
                android.R.drawable.ic_menu_delete);//読み込み失敗画像
        mImageLoader.get(url, listener);
        
        return imageView;
    }

}
