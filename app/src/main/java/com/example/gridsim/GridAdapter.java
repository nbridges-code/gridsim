package com.example.gridsim;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.gridsim.Model.GridCell;
import com.example.gridsim.Model.SimulationGrid;

import org.json.JSONObject;

public class GridAdapter extends BaseAdapter {
    private Context mContext;
    public int stateArray[] = new int[256];
    public SimulationGrid copy;

    public int getStateArrayValue(int index) {
        return stateArray[index];
    }

    public void refreshStateArray(int[] array){
        System.arraycopy(array, 0, stateArray, 0, 256);
    }

    public void copySimulationGrid(SimulationGrid grid){
        copy = grid;
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
        if(copy == null || copy.getCell(i) == null){
            imageView.setImageResource(images[0]);
            return imageView;
        }
        switch (copy.getCell(i).getCellType()) {
            case "Bush":
                imageView.setImageResource(images[1]);
                break;
            case "Clover":
                imageView.setImageResource(images[2]);
                break;
            case "Gardener":
                imageView.setImageResource(images[3]);
                break;
            case "Cart":
                imageView.setImageResource(images[4]);
                break;
            case "Mushroom":
                imageView.setImageResource(images[5]);
                break;
            case "Shovel":
                imageView.setImageResource(images[6]);
                break;
            case "Sunflower":
                imageView.setImageResource(images[7]);
                break;
            case "Tree":
                imageView.setImageResource(images[8]);
                break;
            default:
                imageView.setImageResource(images[0]);
                break;
        }
        return imageView;

/*      Milestone 2
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(50, 50));
        if(stateArray[i] == 0) {
            imageView.setImageResource(images[0]);
        }else{
            imageView.setImageResource(images[1]);
        }
        return imageView;
*/
    }

    public Integer[] images = {
            R.drawable.blank, R.drawable.bushes, R.drawable.clover, R.drawable.gardender_icon, R.drawable.golfcart_icon, R.drawable.mushroom, R.drawable.shovel_icon, R.drawable.sunflower, R.drawable.tree
    };
}
