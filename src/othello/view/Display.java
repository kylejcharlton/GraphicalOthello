package othello.view;

import othello.game.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static othello.Constants.*;

/**
 * @author Kyle Charlton
 * The main display window of the game.
 */
public class Display implements ActionListener
{
    Model model;
    GameBoard board;

    public Display()
    {
        JFrame frame = new JFrame();
        frame.setTitle("Othello");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // The root panel contains everything
        JPanel root = new JPanel();
        root.setLayout(new BorderLayout());
        frame.setContentPane(root);

        model = new Model();
        board = new GameBoard(model, this);
        root.add(board, "Center");

        // The top portion contains the scores
        JPanel scores = new JPanel();
        root.add(scores, "North");

        // Score and indicator for the first player
        JPanel p1 = new JPanel();
        scores.add(p1, "West");

        JPanel p2 = new JPanel();
        scores.add(p2, "East");

        // The bottom portion contains the New Game button
        JButton newGame = new JButton("New Game");
        newGame.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        root.add(newGame, "South");

        board.refresh();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        model.newGame();
    }
}