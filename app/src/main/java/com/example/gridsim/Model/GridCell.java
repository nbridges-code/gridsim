package com.example.gridsim.Model;

import android.util.Log;

public class GridCell {
/*
    GridCell: this is the base class for anything that appears in your GridView. It is responsible
    for knowing its raw server value and its row and column, and it has
    the following responsibilities (which may each be overridden in child classes):
*/

    public int rawServerValue = 0, location = -1, row = -1, col = -1;

    public GridCell(){}

    public GridCell(int rawServerValue, int location){
        this.rawServerValue = rawServerValue;
        row = location / 16;
        col = location % 16;
        this.location = location;
    }

    public Integer getResourceID() { // returns the appropriate image resource identifier. Default: Empty
        return -1;
    }

    public String getCellType() { // returns a string description of the object type in the cell
        if(rawServerValue == 0){
            return "Empty";
        }else if(rawServerValue == 1000){
            return "Tree";
        }else if(rawServerValue > 1000 && rawServerValue < 2000){
            return "Bush";
        }else if(rawServerValue == 2002){
            return "Clover";
        }else if(rawServerValue == 2003){
            return "Mushroom";
        }else if(rawServerValue == 3000){
            return "Sunflower";
        }else if(rawServerValue >= 1000000 && rawServerValue < 2000000){
            return "Gardener";
        }else if(rawServerValue >= 2000000 && rawServerValue < 3000000){
            return "Shovel";
        }else if(rawServerValue >= 10000000 && rawServerValue < 20000000){
            return "Cart";
        }else{
            return String.valueOf(rawServerValue);
        }
    }

    public String getCellInfo() { // returns a string describing other info about the object (such as location)
        return "(row:" + row + ", col:" + col + ") at index:" + location;
    }

}
