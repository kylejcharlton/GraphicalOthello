package othello.game;

/**
 * @author Kyle Charlton
 * A library that consists of methods to check where valid moves are in a game of Othello in a Model object.
 */
public class ValidMove
{
    /**
     * Takes a model and returns if there is a valid move that can be made ar a given row and column.
     */
    public static boolean validMove(Model model, int row, int col)
    {
        return validHorizontal(model, row, col) || validVertical(model, row, col) || validDiagonal(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column.
     */
    public static boolean validDiagonal(Model model, int row, int col)
    {
        return validDiagonalNorthWest(model, row, col) || validDiagonalNorthEast(model, row, col)
                || validDiagonalSouthWest(model, row, col) || validDiagonalSouthEast(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid diagonal move that can be made at a given row and column for
     * flipping pieces diagonally in the south-east direction.
     */
    public static boolean validDiagonalSouthEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();

        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static Boolean validDiagonalSouthWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
        {
            try
            {
                if (board[row + i][col - i] == model.getOtherPlayer())
                {
                    count++;
                } else if (board[row + i][col - i] == model.getCurrentPlayer() && count > 0)
                {
                    return true;
                } else
                {
                    break;
                }
                i++;
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
    public static Boolean validDiagonalNorthEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static Boolean validDiagonalNorthWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static boolean validVertical(Model model, int row, int col)
    {
        return validVerticalNorth(model, row, col) || validVerticalSouth(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid vertical move that can be made at a given row and column for
     * flipping pieces in the south direction.
     */
    public static Boolean validVerticalSouth(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static Boolean validVerticalNorth(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static boolean validHorizontal(Model model, int row, int col)
    {
        return validHorizontalWest(model, row, col) || validHorizontalEast(model, row, col);
    }

    /**
     * Takes a model and returns whether there is a valid horizontal move that can be made at a given row and column for
     * flipping pieces in the east direction.
     */
    public static boolean validHorizontalEast(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
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
    public static Boolean validHorizontalWest(Model model, int row, int col)
    {
        int[][] board = model.getBoard();
        int count = 0;
        int i = 1;
        while (true)
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
                i++;
            } catch (IndexOutOfBoundsException e)
            {
                break;
            }
        }
        return false;
    }
}
