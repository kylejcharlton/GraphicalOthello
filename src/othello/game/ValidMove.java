package othello.game;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A library that consists of methods to check where valid moves are in a game of Othello in a Model object.
 */
public class ValidMove
{


    public static boolean checkValidMove(Model model, int row, int col)
    {
        return checkHorizontal(model, row, col) || checkVertical(model, row, col) || checkDiagonal(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column.
     */
    public static boolean checkDiagonal(Model model, int row, int col)
    {
        return checkDiagonalNorthWest(model, row, col) || checkDiagonalNorthEast(model, row, col)
                || checkDiagonalSouthWest(model, row, col) || checkDiagonalSouthEast(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column for
     * flipping pieces diagonally in the south-east direction.
     */
    public static boolean checkDiagonalSouthEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();

        int count = 0;
        for (int i = 1; i < Math.min(ROWS - row, COLS - col); i++)
        {
            try
            {
                if (board[row + i][col + i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row + i][col + i] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column for
     * flipping pieces diagonally in the south-west direction.
     */
    public static Boolean checkDiagonalSouthWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < Math.min(row, COLS - col); i++)
        {
            try
            {
                if (board[row - i][col + i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row - i][col + i] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column for
     * flipping pieces diagonally in the north-east direction.
     */
    public static Boolean checkDiagonalNorthEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < Math.min(ROWS - row, col); i++)
        {
            try
            {
                if (board[row - i][col + i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row - i][col + i] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column for
     * flipping pieces diagonally in the north-west direction.
     */
    public static Boolean checkDiagonalNorthWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < Math.min(row, col); i++)
        {
            try
            {
                if (board[row - i][col - i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row - i][col - i] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid vertical move that can be made at a given row and column.
     */
    public static boolean checkVertical(Model model, int row, int col)
    {
        return checkVerticalNorth(model, row, col) || checkVerticalSouth(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid vertical move that can be made at a given row and column for
     * flipping pieces in the south direction.
     */
    public static Boolean checkVerticalSouth(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < ROWS - row; i++)
        {
            try
            {
                if (board[row + i][col] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row + i][col] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid vertical move that can be made at a given row and column for
     * flipping pieces in the north direction.
     */
    public static Boolean checkVerticalNorth(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < row; i++)
        {
            try
            {
                if (board[row - i][col] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row - i][col] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid horizontal move that can be made at a given row and column.
     */
    public static boolean checkHorizontal(Model model, int row, int col)
    {
        return checkHorizontalWest(model, row, col) || checkHorizontalEast(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid horizontal move that can be made at a given row and column for
     * flipping pieces in the east direction.
     */
    public static boolean checkHorizontalEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < ROWS - row; i++)
        {
            try
            {
                if (board[row][col + i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row][col + i] == model.getCurrentPlayer() && count > 0)
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

    /**
     * Takes a model and returns whether there is a valid horizontal move that can be made at a given row and column for
     * flipping pieces in the west direction.
     */
    public static Boolean checkHorizontalWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        for (int i = 1; i < row; i++)
        {
            try
            {
                if (board[row][col - i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row][col - i] == model.getCurrentPlayer() && count > 0)
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
