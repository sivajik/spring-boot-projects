package lld.tictactoe;

public class Board {
    char[][] cells;

    Board() {
        this.cells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = ' ';
            }
        }
    }

    public char getCell(int i, int j) {
        return cells[i][j];
    }

    public boolean placeMark(int i, int j, char c) {
        if (!isValid(i, j)) {
            System.out.println("Given wrong coordinates");
            return false;
        }
        if (cells[i][j] == ' ') {
            cells[i][j] = c;
            return true;
        }
        return false;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < 3 && j >= 0 && j < 3;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if (cells[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
