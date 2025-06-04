package lld.tictactoe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;
    Board board;
    GameState gameState;

    @BeforeEach
    void init() {
        board = new Board();
        game = new Game(board);
    }

    @Test
    void testInitConfig() {
        assertEquals(GameState.GAME_IN_PROGRESS, game.getGameState());
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    void testPlayerSwitch() {
        game.makeMove(0, 0); // X
        assertEquals('O', game.getCurrentPlayer());
        game.makeMove(1, 1); //O
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    void testPlayerSwitchInvalid() {
        game.makeMove(0, 0); // X
        assertEquals('O', game.getCurrentPlayer());
        game.makeMove(0, 0); //O
        assertEquals('O', game.getCurrentPlayer());
    }

    @Test
    void testWinCol() {
        game.makeMove(0, 0); //X
        game.makeMove(0, 1); //O
        game.makeMove(0, 2); //X
        game.makeMove(1, 1); //O
        game.makeMove(1, 0); //X
        game.makeMove(1, 2); //X
        game.makeMove(2, 0); //X
        assertEquals(GameState.X_WINS, game.getGameState());
    }
}