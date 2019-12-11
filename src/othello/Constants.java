package othello;

import java.awt.*;

/**
 * @author Kyle Charlton
 * The constants that all other classes can reference to.
 */
public class Constants
{
    /**
     * The width of the main window when started.
     */
    public static final int WIDTH = 600;

    /**
     * The height of the main window when started.
     */
    public static final int HEIGHT = 600;

    /**
     * A set font size to use for consistency.
     */
    public static final int FONT_SIZE = 18;

    /**
     * The amount of rows to use with Othello.
     */
    public static final int ROWS = 8;

    /**
     * The amount of columns to use with Othello.
     */
    public static final int COLS = 8;

    /**
     * The size of each game piece relative to each board square.
     */
    public static final double PIECE_RATIO = 0.75;

    /**
     * The color of the game board.
     */
    public static final Color BOARD_COLOR = new Color(39, 119, 20);

    /**
     * The color to represent a possible move.
     */
    public static final Color POSSIBLE_MOVE_COLOR = new Color(255, 255, 0, 125);

    /**
     * The background color of the score panel.
     */
    public static final Color BACKGROUND_COLOR = Color.LIGHT_GRAY;

    /**
     * Used to represent empty from the model's board
     */
    public static final int EMPTY = 0;

    /**
     * Used to represent white from the model's board
     */
    public static final int WHITE = 1;

    /**
     * Used to represent black from the model's board
     */
    public static final int BLACK = 2;

    /**
     * Used to represent a valid move from the model's board
     */
    public static final int VALID_MOVE = 3;
}
