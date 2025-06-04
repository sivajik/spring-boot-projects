package lld.conway;

import lombok.Getter;

public class Grid {
    @Getter
    private int rows;

    @Getter
    private int cols;

    @Getter
    private Cell[][] cells;

    public Grid(int a, int b) {
        this.rows = a;
        this.cols = b;
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = Cell.dead();
            }
        }
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public void setCellAlive(int i, int j) {
        if (!isValid(i, j)) {
            System.out.println("invalid i, j");
        }
        cells[i][j].setAlive(true);
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }

    public void setCellDead(int i, int j) {
        if (!isValid(i, j)) {
            System.out.println("invalid i, j");
        }
        cells[i][j].setAlive(false);
    }

    public int countLiveNeighbors(int a, int b) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int nextRow = a + i;
                int nextCol = b + j;
                if (isValid(nextRow, nextCol)) {
                    if (getCell(nextRow, nextCol).isAlive()) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public Grid nextGen() {
        Grid nextGen = new Grid(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbours = countLiveNeighbors(i, j);
                Cell currCell = getCell(i, j);
                boolean nextState = false;

                if (currCell.isAlive()) {
                    if (liveNeighbours == 2 || liveNeighbours == 3) {
                        nextState = true;
                    }
                } else {
                    if (liveNeighbours == 3) {
                        nextState = true;
                    }
                }
                nextGen.cells[i][j] = nextState ? Cell.active() : Cell.dead();
            }
        }
        return nextGen;
    }

    public void evolve() {
        cells = nextGen().getCells();
    }
}
