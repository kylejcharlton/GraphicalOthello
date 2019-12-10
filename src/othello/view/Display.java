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
    JLabel whiteScore;
    JLabel blackScore;

    public Display ()
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
        scores.setBackground(Color.LIGHT_GRAY);

        // Score and indicator for the first player
        JPanel p1 = new JPanel();
        p1.setBackground(Color.LIGHT_GRAY);
        scores.add(p1, "West");
        whiteScore = new JLabel("" + model.getTotalWhite());
        whiteScore.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        whiteScore.setForeground(Color.WHITE);
        p1.add(whiteScore);
        p1.add(new ScorePanel(Color.WHITE));

        // Score and indicator for the second player
        JPanel p2 = new JPanel();
        p2.setBackground(Color.LIGHT_GRAY);
        scores.add(p2, "East");
        p2.add(new ScorePanel(Color.BLACK));
        blackScore = new JLabel("" + model.getTotalBlack());
        blackScore.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        blackScore.setForeground(Color.BLACK);
        p2.add(blackScore);

        // The bottom portion contains the New Game button
        JButton newGame = new JButton("New Game");
        newGame.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        root.add(newGame, "South");
        newGame.addActionListener(this);

        board.refresh();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
        model.newGame();
        board.refresh();
    }

    /**
     * Sets the number of white pieces on the board
     */
    public void setWhiteCount (int num)
    {
        whiteScore.setText("" + num);
    }

    /**
     * Sets the number of black pieces on the board
     */
    public void setBlackCount (int num)
    {
        blackScore.setText("" + num);
    }
}