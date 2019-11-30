package othello.game;

import static othello.Constants.*;
import static othello.game.ValidMove.*;

/**
 * @author Kyle Charlton
 * The model behind the classic game of Othello.
 */
public class Model
{
    private int[][] board;
    private int currentPlayer;
    private int otherPlayer;

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

        currentPlayer = WHITE;
        otherPlayer = BLACK;

        calculateValidMoves(this);
    }

    public int[][] getBoard()
    {
        return board;
    }

    public void moveTo(int row, int col)
    {
        if (board[row][col] != 3)
        {
            return;
        }

        board[row][col] = currentPlayer;
        flipHorizontal(row, col);
        flipVertical(row, col);
        flipDiagonal(row, col);

        changeTurns();
    }


    private void flipDiagonal(int row, int col)
    {
        if (board[row][col] != 3)
        {
            return;
        }

        // TODO: DO diagonal flipping in all four directions

    }

    private void flipVertical(int row, int col)
    {
        if (board[row][col] != 3)
        {
            return;
        }

        // Flip vertical going up
        for (int i = 0; i < row; i++)
        {
            if (board[row - i][col] != currentPlayer)
            {
                board[row - i][col] = currentPlayer;
            } else
            {
                break;
            }
        }

        // Flip vertical going down
        for (int i = 0; i < ROWS - row; i++)
        {
            if (board[row + i][col] != currentPlayer)
            {
                board[row + i][col] = currentPlayer;
            } else
            {
                break;
            }
        }
    }

    private void flipHorizontal(int row, int col)
    {
        if (board[row][col] != 3)
        {
            return;
        }

        // Flip horizontal going left
        for (int i = 0; i < col; i++)
        {
            if (board[row][col - i] != currentPlayer)
            {
                board[row][col - i] = currentPlayer;
            } else
            {
                break;
            }
        }

        // Flip horizontal going right
        for (int i = 0; i < COLS - col; i++)
        {
            if (board[row][col + i] != currentPlayer)
            {
                board[row][col + i] = currentPlayer;
            } else
            {
                break;
            }
        }
    }

    /**
     * Changes whose turn it currently is and other necessary operations when changing turns.
     */
    private void changeTurns()
    {
        int temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;

        calculateValidMoves(this);
    }

    /**
     * Returns whose turn it is.
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * Returns whose turn is up next.
     */
    public int getOtherPlayer()
    {
        return otherPlayer;
    }
}
