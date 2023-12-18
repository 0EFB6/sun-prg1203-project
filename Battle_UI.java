package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Battle_UI extends JFrame implements ActionListener {
    public String username;
    private JPanel panel = null;
    private JLabel userLabel = null;
    private JLabel userPokemonLabel = null;
    private JLabel enemy1Label = null;
    private JLabel enemy2Label = null;
    private ButtonGroup bg = null;
    private JRadioButton rb1;
    private JRadioButton rb2;

    public Battle_UI(String username, String selectedPokemon) {
        this.username = username; // store the username
        this.setTitle("Battle");

        userLabel = new JLabel();
        userLabel.setText(" Hello " + username + "");



        // Get two random enemies excluding the selected Pokemon
        PokemonCollection pokemonCollection = new PokemonCollection();
        Pokemon[] enemies = getRandomEnemies(pokemonCollection, selectedPokemon);

        enemy1Label = new JLabel();
        enemy1Label.setText("Enemy 1: " + enemies[0].getName() + "  Type: " + enemies[0].getType());

        enemy2Label = new JLabel();
        enemy2Label.setText("Enemy 2: " + enemies[1].getName() + "  Type: " + enemies[1].getType());
   
        userPokemonLabel = new JLabel();
        userPokemonLabel.setText("Your Pokemon: " + selectedPokemon);
        
        
        
        panel = new JPanel(new GridLayout(4, 1));
        panel.add(userLabel);
        panel.add(enemy1Label);
        panel.add(enemy2Label);
        panel.add(userPokemonLabel);
        
        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // set location to the middle
        setVisible(true);
    }

    private Pokemon[] getRandomEnemies(PokemonCollection pokemonCollection, String selectedPokemonName) {
        Pokemon[] allPokemon = pokemonCollection.getAllPokemon();
        List<Pokemon> shuffledPokemon = new ArrayList<>(Arrays.asList(allPokemon));
        Collections.shuffle(shuffledPokemon);

        // Exclude the selected Pokemon from the list
        shuffledPokemon.removeIf(pokemon -> pokemon.getName().equals(selectedPokemonName));

        // Select the first two Pokemon as enemies
        return Arrays.copyOfRange(shuffledPokemon.toArray(new Pokemon[0]), 0, 2);
    }

    public void actionPerformed(ActionEvent ae) {
        // ... Handle other action events if needed ...
    }
}
