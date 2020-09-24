package com.example.gridsim.Model;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.Assert.*;

public class GridCellFactoryTest {

    @Test
    public void makeCell_EmptyCellInput_CreatesEmptyGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell = factory.makeCell(0, -1);
        assertEquals(cell.getCellType(), "Empty");
    }

    @Test
    public void makeCell_TreeCellInput_CreatesTreeGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell = factory.makeCell(1000, -1);
        assertEquals(cell.getCellType(), "Tree");
    }

    @Test
    public void makeCell_BushCellInput_CreatesBushGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell1 = factory.makeCell(1001, -1);
        GridCell cell2 = factory.makeCell(1999, -2);
        assertEquals(cell1.getCellType(), "Bush");
        assertEquals(cell2.getCellType(), "Bush");
    }

    @Test
    public void makeCell_PlantCellInput_CreatesPlantGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell1 = factory.makeCell(2002, -1);
        GridCell cell2 = factory.makeCell(2003, -2);
        GridCell cell3 = factory.makeCell(3000, -3);
        assertEquals(cell1.getCellType(), "Clover");
        assertEquals(cell2.getCellType(), "Mushroom");
        assertEquals(cell3.getCellType(), "Sunflower");
    }

    @Test
    public void makeCell_GardnerItemCellInput_CreatesGardnerItemGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell1a = factory.makeCell(1000000, -1); // Gardener
        GridCell cell1b = factory.makeCell(1999999, -2);
        GridCell cell2a = factory.makeCell(2000000, -3); // Shovel
        GridCell cell2b = factory.makeCell(2999999, -4);
        GridCell cell3a = factory.makeCell(10000000, -5); // Cart
        GridCell cell3b = factory.makeCell(19999999, -6);
        assertEquals(cell1a.getCellType(), "Gardener");
        assertEquals(cell1b.getCellType(), "Gardener");
        assertEquals(cell2a.getCellType(), "Shovel");
        assertEquals(cell2b.getCellType(), "Shovel");
        assertEquals(cell3a.getCellType(), "Cart");
        assertEquals(cell3b.getCellType(), "Cart");
    }

    @Test
    public void makeCell_NonsenseCellInput_CreatesEmptyGridCell() {
        GridCellFactory factory = new GridCellFactory();
        GridCell cell = factory.makeCell(-8967, -1);
        assertEquals(cell.getCellType(), "Empty");
    }
}