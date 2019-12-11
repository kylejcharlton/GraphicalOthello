package othello;

import othello.view.Display;

import javax.swing.*;

/**
 * @author Kyle Charlton
 * A GUI based game of Othello using Swing
 */
public class Othello
{
    /**
     * Starts a game of Othello.
     */
    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(() -> new Display());
    }
}