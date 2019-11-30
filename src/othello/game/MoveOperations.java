package othello.game;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A library that performs valid moves for a game of Othello with a Model object.
 */
public class MoveOperations
{
    public static void performMove(Model model, int row, int col)
    {
        // Probably unnecessary -
        // calculateValidMoves(model);

        int[][] board = model.getBoard();
        if (board[row][col] != VALID_MOVE)
        {
            return;
        }

        flipDiagonal(model, row, col);
        flipVertical(model, row, col);
        flipHorizontal(model, row, col);
        model.changeTurns();
    }

    private static void flipDiagonal(Model model, int row, int col)
    {
        flipDiagonalNorthWest(model, row, col);
        flipDiagonalNorthEast(model, row, col);
        flipDiagonalSouthWest(model, row, col);
        flipDiagonalSouthEast(model, row, col);
    }

    private static void flipDiagonalSouthEast(Model model, int row, int col)
    {
    }

    private static void flipDiagonalSouthWest(Model model, int row, int col)
    {
    }

    private static void flipDiagonalNorthEast(Model model, int row, int col)
    {
    }

    private static void flipDiagonalNorthWest(Model model, int row, int col)
    {
    }

    private static void flipVertical(Model model, int row, int col)
    {
        flipVerticalNorth(model, row, col);
        flipVerticalSouth(model, row, col);
    }

    private static void flipVerticalSouth(Model model, int row, int col)
    {
    }

    private static void flipVerticalNorth(Model model, int row, int col)
    {
    }

    private static void flipHorizontal(Model model, int row, int col)
    {
        flipHorizontalNorth(model, row, col);
        flipHorizontalSouth(model, row, col);
    }

    private static void flipHorizontalSouth(Model model, int row, int col)
    {
    }

    private static void flipHorizontalNorth(Model model, int row, int col)
    {
    }
}
