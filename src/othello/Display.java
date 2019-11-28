package othello;

import javax.swing.*;

/**
 * @author Kyle Charlton
 * <p>
 * The display
 */
public class Display
{
    public Display()
    {
        // Set the title that appears at the top of the window
        JFrame frame = new JFrame();
        frame.setTitle("Othello");

        // Cause the application to end when the windows is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}