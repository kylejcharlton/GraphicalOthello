package othello.view;

import othello.Constants;

import javax.swing.*;
import java.awt.*;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A JPanel to display a player's score information.
 */
public class ScorePanel extends JPanel
{
    private Color color;

    public ScorePanel (Color color)
    {
        this.color = color;
    }

    public void setColor (Color color)
    {
        this.color = color;
        repaint();
    }

    @Override
    public void paintComponent (Graphics g)
    {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(color);
        g.fillOval(0, 0, 30, 30);
    }
}
