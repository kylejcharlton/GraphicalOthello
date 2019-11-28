package othello;

import javax.swing.SwingUtilities;

/**
 * @author Kyle Charlton
 * <p>
 * A GUI based game of Othello using Swing
 */
public class Othello
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> new Display());
    }
}