package com.example.gridsim.Model;

import android.util.Log;

public class GridCellFactory {
    public GridCell makeCell(int val, int location){
        if(val == 1000 || val > 1000 && val < 2000 || val == 2002 || val == 2003 || val == 3000){
            return new Plant(val, location);
        }if(val >= 1000000 && val < 2000000 || val >= 2000000 && val < 3000000 || val >= 10000000 && val < 20000000){
            return new GardenerItem(val, location);
        }else{
            return new GridCell(0, location);
        }
    }
}
