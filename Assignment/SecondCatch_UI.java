// SecondCatch_UI.java
package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class SecondCatch_UI extends JFrame implements ActionListener {
    private String username;
    private double score;
    private JPanel panel;
    private JLabel userLabel;
    private ButtonGroup bg;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JButton catchPokemon;
    private Pokemon enemy1; // Define enemy1 here
    private Pokemon enemy2; // Define enemy2 here
    private Pokemon caughtPokemon; // New variable to store the caught Pokemon

    public SecondCatch_UI(double score, String username, Pokemon enemy1, Pokemon enemy2) {
        this.username = username;
        this.score = score;
        this.enemy1 = enemy1; // Assign values to enemy1
        this.enemy2 = enemy2; // Assign values to enemy2
        this.setTitle("Second");

        userLabel = new JLabel();
        userLabel.setText("Congratulations " + username + ", You can choose a pokemon to catch:");

        bg = new ButtonGroup();

        rb1 = new JRadioButton(enemy1.getName());
        rb2 = new JRadioButton(enemy2.getName());

        bg.add(rb1);
        bg.add(rb2);

        catchPokemon = new JButton("Catch");
        catchPokemon.addActionListener(this);

        panel = new JPanel(new GridLayout(4, 1));
        panel.add(userLabel);
        panel.add(rb1);
        panel.add(rb2);
        panel.add(catchPokemon);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // set location to middle
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == catchPokemon) {
            // Use the Catch class to determine if the catch is successful
            Catch catchAttempt = new Catch();
            boolean success = catchAttempt.isSuccess();

            if (rb1.isSelected()) {
                caughtPokemon = rb1.isSelected() && success ? enemy1 : null;
            } else if (rb2.isSelected()) {
                caughtPokemon = rb2.isSelected() && success ? enemy2 : null;
            }

            dispose();
            new Result_UI().resultWithScore(username, score, caughtPokemon, success);
        }
    }
}
