package lld.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    @Test
    void testInitGridAsAllDeadCells() {
        Grid grid = new Grid(5, 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertEquals(false, grid.getCell(i, j).isAlive());
            }
        }
    }

    @Test
    void testSetCellAsAlive() {
        Grid grid = new Grid(5, 5);
        grid.setCellAlive(1,1);
        assertEquals(true, grid.getCell(1,1).isAlive());
    }

    @Test
    void testSetCellAsDead() {
        Grid grid = new Grid(5, 5);
        grid.setCellDead(1,1);
        assertEquals(false, grid.getCell(1,1).isAlive());
    }

    @Test
    void testCountNeighbor() {
        Grid grid = new Grid(3, 3);
        grid.setCellAlive(0,0);
        assertEquals(1, grid.countLiveNeighbors(1,1));
    }

    @Test
    void testNextGen() {
        Grid grid = new Grid(3, 3);
        grid.setCellAlive(0,0);
        Grid newGrid = grid.nextGen();
        assertEquals(false, newGrid.getCell(0, 0).isAlive());
    }
}