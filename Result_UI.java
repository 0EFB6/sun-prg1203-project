// Result_UI.java
package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Result_UI extends JFrame {
    private JPanel panel = null;
    private JLabel resultLabel = null;
    private JLabel userLabel = null;

    public Result_UI() {
        setTitle("Result");
        panel = new JPanel(new GridLayout(5, 1));
        resultLabel = new JLabel();
        panel.add(resultLabel);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void result(String username) {
        setTitle("Result - Lose");
        userLabel = new JLabel();
        userLabel.setText("Hello " + username + "! Your score is zero. Better luck next time!");
        panel.add(userLabel);
        resultLabel.setText("You lose.");

        repaint();
    }

    public void resultWithScore(String username, double score, Pokemon caught, boolean success, Pokeball pokeball) {
        setTitle("Result - Win");
        userLabel = new JLabel();
        userLabel.setText("Hello " + username + "! Your score is: " + score);
        panel.add(userLabel);

        if (success) {
            resultLabel.setText("Congratulations! You caught a " + caught.getName() + " with a " + pokeball.getBallType() + "!");
        } else {
            resultLabel.setText("Oops! You failed to catch the Pokemon using" + pokeball.getBallType());
        }

        repaint();
    }
}
