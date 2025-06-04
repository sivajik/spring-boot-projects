package lld.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {
    @Test
    void testInitGrid() {
        Grid grid = new Grid(3, 3);
        GameOfLife g = new GameOfLife(grid);
        assertEquals(grid, g.getGrid());
    }

    @Test
    void testGen() {
        Grid grid = new Grid(3, 3);
        grid.setCellAlive(0, 1);
        grid.setCellAlive(1, 1);
        grid.setCellAlive(2, 1);

        GameOfLife gameOfLife = new GameOfLife(grid);
        gameOfLife.runGen(1);

        assertEquals(true, gameOfLife.grid.getCell(1, 0).isAlive());
        assertEquals(true, gameOfLife.grid.getCell(1, 1).isAlive());
        assertEquals(true, gameOfLife.grid.getCell(1, 2).isAlive());
    }
}