package com.example.gridsim.Model;

public class Plant extends GridCell {

    public Plant(int rawServerValue, int location) {
        this.rawServerValue = rawServerValue;
        row = location / 16;
        col = location % 16;
        this.location = location;
    }

    public String getCellType() { // returns a string description of the object type in the cell
        if(rawServerValue == 1000){
            return "Tree";
        }else if(rawServerValue > 1000 && rawServerValue < 2000){
            return "Bush";
        }else if(rawServerValue == 2002){
            return "Clover";
        }else if(rawServerValue == 2003){
            return "Mushroom";
        }else if(rawServerValue == 3000){
            return "Sunflower";
        }else{
            return "INCORRECT_VALUE";
        }
    }
}
