package com.example.gridsim.Model;

public class SimulationGrid {
/*
    SimulationGrid: This is basically a collection that holds GridCells in array form
    for quicker access. It has the following responsibilities:
*/
    GridCell[] grid = new GridCell[256];

    public GridCell getCell(int index) { // returns the GridCell at a given linear index
        return grid[index];
    }
    public int getNumRows() { // returns the number of rows in the grid
        return 16;
    }
    public int getNumCols() { // returns the number of columns in the grid
        return 16;
    }
    public void setCell(int index, GridCell cell) { // sets the GridCell at a given linear index
        grid[index] = cell;
    }
    public int size() { // returns the linear size of the grid
        return 256;
    }

}
