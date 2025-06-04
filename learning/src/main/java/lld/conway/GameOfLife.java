package lld.conway;

import lombok.Getter;

public class GameOfLife {
    @Getter
    Grid grid;

    public GameOfLife(Grid grid) {
        this.grid = grid;
    }

    public void runGen(int n) {
        for (int i = 0; i < n; i++) {
            grid.evolve();
        }
    }
}
