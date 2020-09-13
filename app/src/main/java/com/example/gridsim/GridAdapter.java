package com.example.gridsim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    public GridAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
//        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(images[i]);
        return imageView;
    }

    public Integer[] images = {
            R.drawable.dot, R.drawable.square
    };
}
