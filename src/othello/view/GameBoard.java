package othello.view;

import othello.game.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * A JPanel that holds a whole game board.
 */
public class GameBoard extends JPanel implements MouseListener
{
    Model model;
    Display display;

    public GameBoard (Model model, Display display)
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

    public void refresh ()
    {
        int[][] board = model.getBoard();

        Component[] squares = getComponents();
        for (Component c : squares)
        {
            Square s = (Square) c;
            int occupant = board[s.getRow()][s.getCol()];

            // Color each space according to what the model says
            if (occupant == WHITE)
            {
                s.setColor(Color.WHITE);
            }
            else if (occupant == BLACK)
            {
                s.setColor(Color.BLACK);
            }
            else if (occupant == VALID_MOVE)
            {
                s.setColor(POSSIBLE_MOVE_COLOR);
            }
            else
            {
                s.setColor(BOARD_COLOR);
            }
        }

        // Update player piece count
        display.setWhiteCount(model.getTotalWhite());
        display.setBlackCount(model.getTotalBlack());

        // Display whose turn it is
        if (model.getCurrentPlayer() == WHITE)
        {
            display.setWhiteIndicator();
        }
        else
        {
            display.setBlackIndicator();
        }

        repaint();
    }

    @Override
    public void mouseClicked (MouseEvent e)
    {
        // Allow moves to be made if the game isn't over yet
        if (!model.isGameOver())
        {
            Square s = (Square) e.getSource();

            // Remember whose turn it was before a move is made
            int previousTurn = model.getCurrentPlayer();

            boolean movePerformed = model.moveTo(s.getRow(), s.getCol());
            refresh();

            // Display a dialog if the game is over stating who won
            if (model.isGameOver())
            {
                if (model.getTotalWhite() > model.getTotalBlack())
                {
                    JOptionPane.showMessageDialog(this, "White wins!");
                }
                else if (model.getTotalBlack() > model.getTotalWhite())
                {
                    JOptionPane.showMessageDialog(this, "Black wins!");
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "It's a tie!");
                }
            }
            else
            {
                // Notify the players if it is the previous player's turn again
                if (previousTurn == model.getCurrentPlayer() && movePerformed)
                {
                    if (model.getCurrentPlayer() == WHITE)
                    {
                        JOptionPane.showMessageDialog(this, "Black had no valid moves. It is white's turn again.");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "White had no valid moves. It is black's turn again.");
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed (MouseEvent e)
    {
        // Deliberately ignoring
    }

    @Override
    public void mouseReleased (MouseEvent e)
    {
        // Deliberately ignoring
    }

    @Override
    public void mouseEntered (MouseEvent e)
    {
        // Deliberately ignoring
    }

    @Override
    public void mouseExited (MouseEvent e)
    {
        // Deliberately ignoring
    }
}
