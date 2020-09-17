package com.example.gridsim.Model;

public class GardenerItem extends GridCell{
    private int resourceID = -1;

    public String getCellType() { // returns a string description of the object type in the cell
        if(rawServerValue >= 1000000 && rawServerValue < 2000000){
            return "Gardener";
        }else if(rawServerValue >= 2000000 && rawServerValue < 3000000){
            return "Shovel";
        }else if(rawServerValue >= 10000000 && rawServerValue < 20000000){
            return "Clover";
        }else{
            return "INCORRECT_VALUE";
        }
    }

    public Integer getResourceID() { // returns the appropriate image resource identifier. Default: Empty
        if(resourceID != -1){
            return resourceID;
        }
        if(rawServerValue >= 1000000 && rawServerValue < 2000000){
            resourceID = rawServerValue % 1000;
        }else if(rawServerValue >= 2000000 && rawServerValue < 3000000){
            resourceID = rawServerValue % 1000;
        }else if(rawServerValue >= 10000000 && rawServerValue < 20000000){
            resourceID = rawServerValue % 10000;
        }else{
            return -1;
        }
        return resourceID;
    }
}
