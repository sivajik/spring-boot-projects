package lld.conway;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Cell {
    private boolean isAlive;

    Cell(boolean alive) {
        this.isAlive = alive;
    }

    public static Cell active() {
        return new Cell(true);
    }

    public static Cell dead() {
        return new Cell(false);
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean b) {
        this.isAlive = b;
    }
}
