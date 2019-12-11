package othello.view;

import othello.Constants;

import javax.swing.*;
import java.awt.*;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A JPanel to display an indicator of whose turn it is.
 */
public class PlayerIndicator extends JPanel
{
    /**
     * The color of this indicator
     */
    private Color color;

    /** Create a new player indicator of a specified color */
    public PlayerIndicator (Color color)
    {
        this.color = color;
        setBackground(BACKGROUND_COLOR);
        setPreferredSize(new Dimension(30, 30));
    }

    /** Sets the color of this indicator */
    public void setColor (Color color)
    {
        this.color = color;
        repaint();
    }

    /** Draws what the indicator looks like */
    @Override
    public void paintComponent (Graphics g)
    {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, getHeight(), getHeight());
        g.setColor(color);
        g.fillOval(0, 0, 30, 30);
    }
}
