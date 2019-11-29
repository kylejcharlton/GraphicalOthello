package othello;

import othello.view.Display;

import javax.swing.SwingUtilities;

/**
 * @author Kyle Charlton
 * A GUI based game of Othello using Swing
 */
public class Othello
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Display());
    }
}