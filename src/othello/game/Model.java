package othello.game;

import static othello.Constants.*;
import static othello.game.ValidMove.*;
import static othello.game.MoveOperations.*;

/**
 * @author Kyle Charlton
 * The model behind the classic game Othello.
 */
public class Model
{
    private int[][] board;
    private int currentPlayer;
    private int otherPlayer;

    /**
     * Sets up a board of Othello and starts a new game.
     */
    public Model()
    {
        if (ROWS % 2 == 1 || COLS % 2 == 1)
        {
            throw new IllegalArgumentException("Board must have an even amount of rows and columns.");
        }

        newGame();
    }

    /**
     * Starts a new game of Othello.
     */
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

    /**
     * Performs a move at a specified row and column if it is a valid move for the current player.
     */
    public void moveTo(int row, int col)
    {
        if (board[row][col] != VALID_MOVE)
        {
            return;
        }

        performMove(this, row, col);
    }

    /**
     * Calculates all valid moves from the model's current board, and modifies the model's board to show accordingly.
     * If there is any possible direction that can be flipped according to Othello's rules, then the given row and
     * column is a valid move.
     */
    private static void calculateValidMoves(Model model)
    {
        int[][] board = model.getBoard();
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (board[i][j] != WHITE && board[i][j] != BLACK)
                {
                    if (checkValidMove(model, i, j))
                    {
                        board[i][j] = VALID_MOVE;
                    } else if (board[i][j] == VALID_MOVE)
                    {
                        board[i][j] = EMPTY;
                    }
                }
            }
        }
    }

    /**
     * Changes whose turn it currently is and other necessary operations when changing turns.
     */
    public void changeTurns()
    {
        int temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;

        calculateValidMoves(this);
    }

    /**
     * Returns the game board.
     */
    public int[][] getBoard()
    {
        return board;
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
