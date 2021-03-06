package othello.view;

import javax.swing.*;
import java.awt.*;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A JPanel where each individual square that displays a game piece.
 */
public class Square extends JPanel
{
    private int row;
    private int col;
    private Color color;

    /**
     * Creates a square containing what row and column it belongs to.
     */
    public Square (int row, int col)
    {
        this.row = row;
        this.col = col;
        this.color = BOARD_COLOR;
    }

    /**
     * Returns the row of the Square
     */
    public int getRow ()
    {
        return row;
    }

    /**
     * Returns the column of the Square
     */
    public int getCol ()
    {
        return col;
    }

    /**
     * Sets the color of the game piece
     */
    public void setColor (Color color)
    {
        this.color = color;
        repaint();
    }

    /**
     * Draws what this square looks like.
     */
    @Override
    public void paintComponent (Graphics g)
    {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(BOARD_COLOR);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, getWidth(), getHeight());
        g.setColor(color);
        int xPadding = (int) (getWidth() - getWidth() * PIECE_RATIO) / 2;
        int yPadding = (int) (getHeight() - getHeight() * PIECE_RATIO) / 2;
        g.fillOval(xPadding, yPadding, (int) (getWidth() * PIECE_RATIO), (int) (getHeight() * PIECE_RATIO));
    }
}
