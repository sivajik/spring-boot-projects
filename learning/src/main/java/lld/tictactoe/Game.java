package lld.tictactoe;

import lombok.Getter;

public class Game {
    @Getter
    private Board board;

    @Getter
    private GameState gameState;

    @Getter
    private char currentPlayer;

    public Game(Board board) {
        this.currentPlayer = 'X';
        this.gameState = GameState.GAME_IN_PROGRESS;
        this.board = board;
    }

    public boolean makeMove(int i, int j) {
        if (GameState.GAME_IN_PROGRESS != gameState) {
            System.out.println("game is nt in progress so cant cont");
            return false;
        }
        if (board.placeMark(i, j, currentPlayer)) {
            updateState();
            if (GameState.GAME_IN_PROGRESS == gameState) {
                switchPlayer();
            }
            return true;
        }
        return false;
    }

    private void updateState() {
        if (checkWin()) {
            gameState = currentPlayer == 'X' ? GameState.X_WINS : GameState.O_WINS;
        } else if (board.isFull()) {
            gameState = GameState.DRAW;
        } else {
            gameState = GameState.GAME_IN_PROGRESS;
        }

    }

    private boolean checkWin() {
        char mark = currentPlayer;

        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0) == mark && board.getCell(i, 1) == mark && board.getCell(i, 2) == mark) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {
            if (board.getCell(0, j) == mark && board.getCell(1, j) == mark && board.getCell(2, j) == mark) {
                return true;
            }
        }

        if (board.getCell(0, 0) == mark && board.getCell(1, 1) == mark && board.getCell(2, 2) == mark)
            return true;

        if (board.getCell(0, 2) == mark && board.getCell(1, 1) == mark && board.getCell(2, 0) == mark)
            return true;

        return false;
    }

    private void switchPlayer() {
        currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
    }


}
