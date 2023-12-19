package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class FirstCatch_UI extends JFrame implements ActionListener {
    public String username;
    private PokemonCollection pokemonCollection = null;
    private JPanel panel = null;
    private JLabel userLabel = null;
    private JLabel description = null;
    private ButtonGroup bg = new ButtonGroup();
    private JButton submitButton = null;
    private List<Pokemon> shuffledPokemon; // Declare shuffledPokemon as a class-level variable

    public FirstCatch_UI(String username) {
        this.username = username; // store the username
        this.setTitle("Catch");

        userLabel = new JLabel();
        userLabel.setText(" Hello " + username + "");

        description = new JLabel();
        description.setText("Choose one Pokemon to catch");

        pokemonCollection = new PokemonCollection();
        shuffledPokemon = new ArrayList<>(); // Initialize shuffledPokemon

        submitButton = new JButton("Catch");
        submitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(6, 1));
        panel.add(userLabel);
        panel.add(description);
        setPokemonForBattle();
        panel.add(submitButton);
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // set location to middle
        setVisible(true);
    }

    private void setPokemonForBattle() {
        Pokemon[] allPokemon = pokemonCollection.getAllPokemon();

        // Shuffle the array to get random Pokemon
        shuffledPokemon = new ArrayList<>(Arrays.asList(allPokemon));
        Collections.shuffle(shuffledPokemon);

        for (Pokemon pokemon : shuffledPokemon.subList(0, 3)) {
            JRadioButton rb = new JRadioButton(pokemon.getName() + "  " + "Type: " + pokemon.getType());
            panel.add(rb);
            bg.add(rb);
        }
    }

    private Pokemon getPokemonFromInfo(String selectedPokemonInfo) {
        // Iterate through the shuffled Pokemon list
        for (Pokemon pokemon : shuffledPokemon) {
            // Check if the selected Pokemon info contains the Pokemon's name or type
            if (selectedPokemonInfo.toLowerCase().contains(pokemon.getName().toLowerCase())
                    || selectedPokemonInfo.toLowerCase().contains(pokemon.getType().toLowerCase())) {
                return pokemon; // Return the corresponding Pokemon object
            }
        }
        return null; // If no matching Pokemon is found, return null
    }

    public void actionPerformed(ActionEvent ae) {
        // Check which radio button is selected
        for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {

                String selectedPokemonInfo = button.getText();

                new Battle_UI(username, getPokemonFromInfo(selectedPokemonInfo));
                this.dispose();
                break;
            }
        }
    }
}
