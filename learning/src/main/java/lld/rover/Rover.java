package lld.rover;

import lombok.Getter;

public class Rover {
    @Getter
    private Plateau plateau;

    @Getter
    private Position position;

    public Rover(Plateau plateau, Position position) {
        this.plateau = plateau;
        this.position = position;
    }

    public void turnLeft() {
        this.position = position.withDirection(position.getDirection().turnLeft());
    }

    public void turnRight() {
        this.position = position.withDirection(position.getDirection().turnRight());
    }

    public void move() {
        int newX = position.getX();
        int newY = position.getY();
        switch (position.getDirection()) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case WEST:
                newX--;
                break;
        }

        if (plateau.isValid(newX, newY)) {
            position = position.withCoordinates(newX, newY);
        }
    }

    public void runCommand(char m) {
        switch (m) {
            case 'L':
                turnLeft();
                break;
            case 'R':
                turnRight();
                break;
            case 'M':
                move();
                break;
        }
    }

    public void runMoreCommand(String mm) {
        for (char c : mm.toCharArray()) {
            runCommand(c);
        }
    }
}
