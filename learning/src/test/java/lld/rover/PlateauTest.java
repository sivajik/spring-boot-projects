package lld.rover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlateauTest {

    @Test
    void testInitPlateauConfig() {
        Plateau p = new Plateau(5, 51);
        assertEquals(5, p.getWidth());
        assertEquals(51, p.getHeight());
    }

    @Test
    void testIsValidCoorg() {
        Plateau p = new Plateau(5, 5);
        assertTrue(p.isValid(2, 2));
        assertTrue(p.isValid(5,5));
        assertFalse(p.isValid(5, 50));
    }
}