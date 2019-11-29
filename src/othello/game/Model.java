package othello.game;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * The model behind the classic game of Othello.
 */
public class Model
{
    private int[][] board;

    public Model()
    {
        if (ROWS % 2 == 1 || COLS % 2 == 1)
        {
            throw new IllegalArgumentException("Board must have an even amount of rows and columns.");
        }

        newGame();
    }

    public void newGame()
    {
        board = new int[ROWS][COLS];
        board[(ROWS / 2) - 1][(COLS / 2) - 1] = WHITE;
        board[ROWS / 2][COLS / 2] = WHITE;
        board[(ROWS / 2) - 1][COLS / 2] = BLACK;
        board[ROWS / 2][(COLS / 2) - 1] = BLACK;
    }

    public int[][] getBoard()
    {
        return board;
    }
}
