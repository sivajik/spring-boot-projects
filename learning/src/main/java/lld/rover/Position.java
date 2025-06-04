package lld.rover;

import lombok.Getter;

public class Position {
    @Getter
    private int x;

    @Getter
    private int y;

    @Getter
    private Direction direction;

    public Position(int i, int i1, Direction direction) {
        this.x = i;
        this.y = i1;
        this.direction = direction;
    }

    public Position withCoordinates(int i, int j) {
        return new Position(i, j, direction);
    }

    public Position withDirection(Direction direction) {
        return new Position(x, y, direction);
    }

    public String toString() {
        return x + " " + y + " " + direction.code;
    }
}
