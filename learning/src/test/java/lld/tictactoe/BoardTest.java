package lld.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    Board board;

    @BeforeEach
    void init() {
        board = new Board();
    }

    @Test
    void testInitialization() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCell(i, j));
            }
        }
    }

    @Test
    void testPlaceMark() {
        boolean placed = board.placeMark(0, 0, 'X');
        assertTrue(placed);
        assertEquals('X', board.getCell(0, 0));
    }

    @Test
    void testPlaceMarkInvalid() {
        boolean placed = board.placeMark(0, 8, 'X');
        assertFalse(placed);
        assertEquals(' ', board.getCell(0, 0));
    }

    @Test
    void testIsFull() {
        assertFalse(board.isFull());
    }

    @Test
    void testIsFullTrue() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.placeMark(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }
}