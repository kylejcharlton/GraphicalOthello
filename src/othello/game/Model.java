package othello.game;

import static othello.Constants.*;

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

        calculateValidMoves();
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

    private void changeTurns()
    {
        int temp = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = temp;

        calculateValidMoves();
    }

    /**
     * Returns whose turn it is
     */
    public int getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * Pre-calculate all valid moves from the current board
     */
    private void calculateValidMoves()
    {
        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                if (board[i][j] != WHITE && board[i][j] != BLACK)
                {
                    if (checkHorizontal(i, j) || checkVertical(i, j) || checkDiagonal(i, j))
                    {
                        board[i][j] = POSSIBLE_MOVE;
                    } else if (board[i][j] == POSSIBLE_MOVE)
                    {
                        board[i][j] = EMPTY;
                    }
                }
            }
        }
    }

    private boolean checkDiagonal(int row, int col)
    {
        return false;
    }

    private boolean checkVertical(int row, int col)
    {

        // Check up
        int count = 0;
        for (int i = 1; i < row; i++)
        {
            try
            {
                if (board[row - i][col] == otherPlayer)
                {
                    count++;
                } else if (board[row - i][col] == currentPlayer && count > 0)
                {
                    return true;
                } else
                {
                    break;
                }
            } catch (IndexOutOfBoundsException e)
            {
                break;
            }

        }

        // Check down
        count = 0;
        for (int i = 1; i < ROWS - row; i++)
        {
            try
            {
                if (board[row + i][col] == otherPlayer)
                {
                    count++;
                } else if (board[row + i][col] == currentPlayer && count > 0)
                {
                    return true;
                } else
                {
                    break;
                }
            } catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }

        return false;
    }

    private boolean checkHorizontal(int row, int col)
    {
        // Check left
        int count = 0;
        for (int i = 1; i < row; i++)
        {
            try
            {
                if (board[row][col - i] == otherPlayer)
                {
                    count++;
                } else if (board[row][col - i] == currentPlayer && count > 0)
                {
                    return true;
                } else
                {
                    break;
                }
            } catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }

        // Check right
        count = 0;
        for (int i = 1; i < ROWS - row; i++)
        {
            try
            {
                if (board[row][col + i] == otherPlayer)
                {
                    count++;
                } else if (board[row][col + i] == currentPlayer && count > 0)
                {
                    return true;
                } else
                {
                    break;
                }
            } catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }

        return false;
    }
}
