package othello.view;

import othello.game.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A JPanel that holds a whole game board.
 */
public class GameBoard extends JPanel implements MouseListener
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
                Square s = new Square(i, j);
                s.addMouseListener(this);
                this.add(s);
            }
        }
    }

    public void refresh()
    {
        int[][] board = model.getBoard();

        Component[] squares = getComponents();
        for (Component c : squares)
        {
            Square s = (Square) c;
            int currentColor = board[s.getRow()][s.getCol()];

            if (currentColor == WHITE)
            {
                s.setColor(Color.WHITE);
            } else if (currentColor == BLACK)
            {
                s.setColor(Color.BLACK);
            } else
            {
                s.setColor(BOARD_COLOR);
            }
        }

        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Square s = (Square) e.getSource();
        refresh();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }
}
