package com.example.gridsim.Model;

import android.util.Log;

import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class GridCellFactory {
    public HashMap<Integer, GardenerItem> map = new HashMap<>();

    public GridCell makeCell(int val, int location){
        if(val == 1000 || val > 1000 && val < 2000 || val == 2002 || val == 2003 || val == 3000){
            return new Plant(val, location);
        }if(val >= 1000000 && val < 2000000 || val >= 2000000 && val < 3000000 || val >= 10000000 && val < 20000000){
            // Consult hash map
            int resourceID = parseInt(Integer.toString(val).substring(1, 4));
            if(map.get(resourceID) == null){
                // Entry not found
                map.put(resourceID, new GardenerItem(val, location));
            }
            map.get(resourceID).updateLocation(location);
            return map.get(resourceID);
        }else{
            return new GridCell(0, location);
        }
    }
}
