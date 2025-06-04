package lld.rover;

public enum Direction {
    EAST('E') {
        @Override
        Direction turnLeft() {
            return NORTH;
        }

        @Override
        Direction turnRight() {
            return SOUTH;
        }
    },
    WEST('W') {
        @Override
        Direction turnLeft() {
            return SOUTH;
        }

        @Override
        Direction turnRight() {
            return NORTH;
        }
    },
    SOUTH('S') {
        @Override
        Direction turnLeft() {
            return EAST;
        }

        @Override
        Direction turnRight() {
            return WEST;
        }
    },
    NORTH('N') {
        @Override
        Direction turnLeft() {
            return WEST;
        }

        @Override
        Direction turnRight() {
            return EAST;
        }
    };

    public char code;

    abstract Direction turnLeft();
    abstract Direction turnRight();

    Direction(char n) {
        this.code = n;
    }
}
