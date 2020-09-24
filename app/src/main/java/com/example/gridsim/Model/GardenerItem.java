package com.example.gridsim.Model;

import android.util.Log;

public class GardenerItem extends GridCell{
    private int resourceID = -1;

    public GardenerItem(int rawServerValue, int location) {
        this.rawServerValue = rawServerValue;
        row = location / 16;
        col = location % 16;
        this.location = location;
    }

    public String getCellType() { // returns a string description of the object type in the cell
        if(rawServerValue >= 1000000 && rawServerValue < 2000000){
            return "Gardener";
        }else if(rawServerValue >= 2000000 && rawServerValue < 3000000){
            return "Shovel";
        }else if(rawServerValue >= 10000000 && rawServerValue < 20000000){
            return "Cart";
        }else{
            return "INCORRECT_VALUE";
        }
    }

    public Integer getResourceID() { // returns the appropriate image resource identifier. Default: Empty
        if(resourceID != -1){
            return resourceID;
        }
        if(rawServerValue >= 1000000 && rawServerValue < 2000000){
            resourceID = Integer.parseInt(Integer.toString(rawServerValue).substring(0, 1));
        }else if(rawServerValue >= 2000000 && rawServerValue < 3000000){
            resourceID = rawServerValue % 100;
        }else if(rawServerValue >= 10000000 && rawServerValue < 20000000){
            resourceID = rawServerValue % 1000;
        }else{
            return -1;
        }

        Log.d("gridView", "ID: " + rawServerValue);
        return resourceID;
    }
}
