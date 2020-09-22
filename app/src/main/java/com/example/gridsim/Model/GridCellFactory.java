package com.example.gridsim.Model;

public class GridCellFactory {
    public GridCell makeCell(int val){
        return new GridCell(val); // returns the appropriate GridCell for the value given
    }
}
