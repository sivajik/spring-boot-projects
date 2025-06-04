package lld.rover;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoverTest {
    Plateau plateau;

    @BeforeEach
    void setup() {
        plateau = new Plateau(5, 5);
    }

    @Test
    void testInit() {
        Position position = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getPosition().getDirection());
    }

    @Test
    void testTurnLeft() {
        Position position = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.turnLeft();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.WEST, rover.getPosition().getDirection());
    }

    @Test
    void testTurnRight() {
        Position position = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.turnRight();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.EAST, rover.getPosition().getDirection());
    }

    @Test
    void testMove() {
        Position position = new Position(1, 1, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.move();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(2, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getPosition().getDirection());
    }

    @Test
    void testMove1() {
        Position position = new Position(1, 1, Direction.SOUTH);
        Rover rover = new Rover(plateau, position);
        rover.move();
        assertEquals(1, rover.getPosition().getX());
        assertEquals(0, rover.getPosition().getY());
        assertEquals(Direction.SOUTH, rover.getPosition().getDirection());
    }

    @Test
    void testMove2() {
        Position position = new Position(1, 1, Direction.EAST);
        Rover rover = new Rover(plateau, position);
        rover.move();
        assertEquals(2, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.EAST, rover.getPosition().getDirection());
    }

    @Test
    void testMove3() {
        Position position = new Position(1, 1, Direction.WEST);
        Rover rover = new Rover(plateau, position);
        rover.move();
        assertEquals(0, rover.getPosition().getX());
        assertEquals(1, rover.getPosition().getY());
        assertEquals(Direction.WEST, rover.getPosition().getDirection());
    }

    @Test
    void testMove4() {
        Position position = new Position(5, 5, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.move();
        assertEquals(5, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getPosition().getDirection());
    }

    @Test
    void testOneCommand() {
        Position position = new Position(3, 3, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.runCommand('M');
        assertEquals(3, rover.getPosition().getX());
        assertEquals(4, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getPosition().getDirection());
    }

    @Test
    void testMoreCommand() {
        Position position = new Position(3, 3, Direction.NORTH);
        Rover rover = new Rover(plateau, position);
        rover.runMoreCommand("MM");
        assertEquals(3, rover.getPosition().getX());
        assertEquals(5, rover.getPosition().getY());
        assertEquals(Direction.NORTH, rover.getPosition().getDirection());
    }

}