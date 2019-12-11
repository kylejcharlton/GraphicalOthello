package othello.game;

import static othello.game.ValidMove.*;

/**
 * @author Kyle Charlton
 * A library that performs valid moves for a game of Othello with a Model object.
 */
public class MoveOperations
{
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


    private static void flipDiagonal (Model model, int row, int col)
    {
        flipDiagonalNorthWest(model, row, col);
        flipDiagonalNorthEast(model, row, col);
        flipDiagonalSouthWest(model, row, col);
        flipDiagonalSouthEast(model, row, col);
    }

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

    private static void flipVertical (Model model, int row, int col)
    {
        flipVerticalNorth(model, row, col);
        flipVerticalSouth(model, row, col);
    }

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

    private static void flipHorizontal (Model model, int row, int col)
    {
        flipHorizontalEast(model, row, col);
        flipHorizontalWest(model, row, col);
    }

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
