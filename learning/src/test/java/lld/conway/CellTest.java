package lld.conway;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testNealyCratedActiveAsACtive() {
        Cell cell = Cell.active();
        assertEquals(true, cell.isAlive());
    }

    @Test
    void testNealyCratedDeadAsDead() {
        Cell cell = Cell.dead();
        assertEquals(false, cell.isAlive());
    }

    @Test
    void testChangeOfStatus() {
        Cell cell = Cell.dead();
        cell.setAlive(true);
        assertEquals(true, cell.isAlive());
    }

    @Test
    void testEquality() {
        Cell c1 = Cell.dead();
        Cell c2 = Cell.dead();
        Cell c3 = Cell.active();
        assertTrue(c1.equals(c2));
        assertFalse(c1.equals(c3));
    }
}