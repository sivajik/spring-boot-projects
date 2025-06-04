package lld.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @Test
    void testInit() {
        Position position = new Position(1, 11, Direction.SOUTH);
        assertEquals(1, position.getX());
        assertEquals(11, position.getY());
        assertEquals(Direction.SOUTH, position.getDirection());
    }

    @Test
    void testMoveNewPos() {
        Position position = new Position(1, 11, Direction.SOUTH);
        Position newP = position.withCoordinates(2, 12);
        assertEquals(2, newP.getX());
        assertEquals(12, newP.getY());
        assertEquals(Direction.SOUTH, newP.getDirection());
    }

    @Test
    void testMoveNewDirection() {
        Position position = new Position(1, 11, Direction.NORTH);
        Position newP = position.withDirection(Direction.SOUTH);
        assertEquals(1, newP.getX());
        assertEquals(11, newP.getY());
        assertEquals(Direction.SOUTH, newP.getDirection());
    }

    @Test
    void testtoString() {
        Position position = new Position(1, 11, Direction.NORTH);
        assertEquals("1 11 N", position.toString());
    }
}