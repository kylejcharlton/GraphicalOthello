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
    PlayerIndicator p1Indicator;
    PlayerIndicator p2Indicator;

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
        scores.setBackground(BACKGROUND_COLOR);
        scores.setPreferredSize(new Dimension(root.getWidth(), 46));

        // Score and indicator for the first player
        JPanel whiteInfo = new JPanel();
        whiteInfo.setBackground(BACKGROUND_COLOR);
        scores.add(whiteInfo, "West");
        whiteScore = new JLabel("" + model.getTotalWhite());
        whiteScore.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        whiteScore.setForeground(Color.WHITE);
        whiteInfo.add(whiteScore);
        p1Indicator = new PlayerIndicator(Color.WHITE);
        whiteInfo.add(p1Indicator);

        // Score and indicator for the second player
        JPanel blackInfo = new JPanel();
        blackInfo.setBackground(BACKGROUND_COLOR);
        scores.add(blackInfo, "East");
        p2Indicator = new PlayerIndicator(Color.BLACK);
        blackInfo.add(p2Indicator);
        blackScore = new JLabel("" + model.getTotalBlack());
        blackScore.setFont(new Font("SansSerif", Font.BOLD, FONT_SIZE));
        blackScore.setForeground(Color.BLACK);
        blackInfo.add(blackScore);

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
        // Start a new game if the new game button is pressed
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

    /**
     * Changes the player indicator to show it is White's turn
     */
    public void setWhiteIndicator ()
    {
        p1Indicator.setColor(Color.WHITE);
        p2Indicator.setColor(BACKGROUND_COLOR);
    }

    /**
     * Changes the player indicator to show it is Black's turn
     */
    public void setBlackIndicator ()
    {
        p2Indicator.setColor(Color.BLACK);
        p1Indicator.setColor(BACKGROUND_COLOR);
    }
}