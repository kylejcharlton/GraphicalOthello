package othello.view;

import othello.game.Model;

import javax.swing.*;
import java.awt.*;

import static othello.Constants.*;

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

        setBackground(BOARD_COLOR);
        setLayout(new GridLayout(ROWS, COLS));

        for (int i = 0; i < ROWS; i++)
        {
            for (int j = 0; j < COLS; j++)
            {
                this.add(new Square(i, j));
            }
        }
    }

    public void refresh()
    {
        repaint();
    }
}
