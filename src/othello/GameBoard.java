package othello;

import javax.swing.*;

/**
 * @author Kyle Charlton
 * A JPanel that holds a whole game board.
 */
public class GameBoard extends JPanel
{
    Model model;
    Display display;

    public GameBoard(Model model, Display display)
    {
        this.model = model;
        this.display = display;
    }

    public void refresh()
    {
        repaint();
    }
}
