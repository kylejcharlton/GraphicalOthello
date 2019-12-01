package othello.view;

import javax.swing.*;
import java.awt.*;

import static othello.Constants.*;

public class ScorePanel extends JPanel
{
    private Color color;
    private String text;

    public ScorePanel (String s, Color color)
    {
        text = s;
        this.color = color;
    }

    public void setText (String s)
    {
        this.text = s;
        repaint();
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
        g.setColor(BOARD_COLOR);
        g.fillRect(0, 0, 10, getHeight());
        g.setColor(color);
        g.fillOval(0, 0, 10, getHeight());
    }
}
