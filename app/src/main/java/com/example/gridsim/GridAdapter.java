package com.example.gridsim;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import org.json.JSONObject;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    public int stateArray[] = new int[256];

    public int getStateArrayValue(int index) {
        return stateArray[index];
    }

    public void setStateArrayValue(int index, int value){
        stateArray[index] = value;
    }

    public GridAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return 256;
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
        if(stateArray[i] == 0) {
            imageView.setImageResource(images[0]);
        }else{
            imageView.setImageResource(images[1]);
        }
        return imageView;
    }

    public Integer[] images = {
            R.drawable.square, R.drawable.dot
    };
}
