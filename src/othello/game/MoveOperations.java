package othello.game;

import static othello.game.ValidMove.*;

/**
 * @author Kyle Charlton
 * A library that performs valid moves for a game of Othello with a Model object.
 */
public class MoveOperations
{
    /**
     * Performs a move at an indicated row and column if it is a valid move. Returns true if a move was made.
     */
    public static boolean performMove (Model model, int row, int col)
    {
        if (!validMove(model, row, col))
        {
            return false;
        }

        int[][] board = model.getBoard();

        board[row][col] = model.getCurrentPlayer();
        flipDiagonal(model, row, col);
        flipVertical(model, row, col);
        flipHorizontal(model, row, col);
        model.changeTurns();
        return true;
    }

    /**
     * Flips diagonally for each direction that would be a valid move.
     */
    private static void flipDiagonal (Model model, int row, int col)
    {
        flipDiagonalNorthWest(model, row, col);
        flipDiagonalNorthEast(model, row, col);
        flipDiagonalSouthWest(model, row, col);
        flipDiagonalSouthEast(model, row, col);
    }

    /**
     * Flips diagonally south-east if it would be a valid move.
     */
    private static void flipDiagonalSouthEast (Model model, int row, int col)
    {
        if (!validDiagonalSouthEast(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row + i;
                int tempCol = col + i;

                if (board[tempRow][tempCol] == model.getOtherPlayer())
                {
                    board[tempRow][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips diagonally south-west if it would be a valid move.
     */
    private static void flipDiagonalSouthWest (Model model, int row, int col)
    {
        if (!validDiagonalSouthWest(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row + i;
                int tempCol = col - i;

                if (board[tempRow][tempCol] == model.getOtherPlayer())
                {
                    board[tempRow][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips diagonally north-east if it would be a valid move.
     */
    private static void flipDiagonalNorthEast (Model model, int row, int col)
    {
        if (!validDiagonalNorthEast(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row - i;
                int tempCol = col + i;

                if (board[tempRow][tempCol] == model.getOtherPlayer())
                {
                    board[tempRow][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips diagonally north-west if it would be a valid move.
     */
    private static void flipDiagonalNorthWest (Model model, int row, int col)
    {
        if (!validDiagonalNorthWest(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row - i;
                int tempCol = col - i;

                if (board[tempRow][tempCol] == model.getOtherPlayer())
                {
                    board[tempRow][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips vertically for each direction that would be a valid move.
     */
    private static void flipVertical (Model model, int row, int col)
    {
        flipVerticalNorth(model, row, col);
        flipVerticalSouth(model, row, col);
    }

    /**
     * Flips vertically south if it would be a valid move.
     */
    private static void flipVerticalSouth (Model model, int row, int col)
    {
        if (!validVerticalSouth(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row + i;

                if (board[tempRow][col] == model.getOtherPlayer())
                {
                    board[tempRow][col] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips vertically north if it would be a valid move.
     */
    private static void flipVerticalNorth (Model model, int row, int col)
    {
        if (!validVerticalNorth(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempRow = row - i;

                if (board[tempRow][col] == model.getOtherPlayer())
                {
                    board[tempRow][col] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips horizontally for each direction that would be a valid move.
     */
    private static void flipHorizontal (Model model, int row, int col)
    {
        flipHorizontalEast(model, row, col);
        flipHorizontalWest(model, row, col);
    }

    /**
     * Flips horizontally west if it would be a valid move.
     */
    private static void flipHorizontalWest (Model model, int row, int col)
    {
        if (!validHorizontalWest(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempCol = col - i;

                if (board[row][tempCol] == model.getOtherPlayer())
                {
                    board[row][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }

    /**
     * Flips horizontally east if it would be a valid move.
     */
    private static void flipHorizontalEast (Model model, int row, int col)
    {
        if (!validHorizontalEast(model, row, col))
        {
            return;
        }

        int[][] board = model.getBoard();

        int i = 1;
        while (true)
        {
            try
            {
                int tempCol = col + i;

                if (board[row][tempCol] == model.getOtherPlayer())
                {
                    board[row][tempCol] = model.getCurrentPlayer();
                }
                else
                {
                    break;
                }
                i++;
            }
            catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
    }
}
