package lld.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DirectionTest {
    @Test
    void testTurnLeft() {
        assertEquals(Direction.NORTH, Direction.EAST.turnLeft());
        assertEquals(Direction.SOUTH, Direction.WEST.turnLeft());
        assertEquals(Direction.WEST, Direction.NORTH.turnLeft());
        assertEquals(Direction.EAST, Direction.SOUTH.turnLeft());
    }

    @Test
    void testTurnRight() {
        assertEquals(Direction.SOUTH, Direction.EAST.turnRight());
        assertEquals(Direction.NORTH, Direction.WEST.turnRight());
        assertEquals(Direction.EAST, Direction.NORTH.turnRight());
        assertEquals(Direction.WEST, Direction.SOUTH.turnRight());
    }

}