package Assignment;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Battle_UI extends JFrame implements ActionListener {
    public String username;
    private JPanel panel = null;
    private JLabel userLabel = null;
    private JLabel userPokemonLabel = null;
    private JLabel yourPokemonHealthLabel = null;  // Added health label for your Pokemon
    private JLabel enemy1Label = null;
    private JLabel enemy1HealthLabel = null;  // Added health label for enemy 1
    private JLabel enemy2Label = null;
    private JLabel enemy2HealthLabel = null;  // Added health label for enemy 2
    private ButtonGroup bg = null;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JButton choose = null;
    private Pokemon yourPokemon = null;
    private Pokemon enemy1 = null;
    private Pokemon enemy2 = null;
    private JLabel battleinfo = null;
    private JLabel enemyattackInfo = null;

    // Modify the constructor to take a Pokemon object instead of a string
    public Battle_UI(String username, Pokemon selectedPokemon) {
        this.username = username; // store the username
        this.setTitle("Battle");

        userLabel = new JLabel();
        userLabel.setText(" Hello " + username + "");

        // Get two random enemies excluding the selected Pokemon
        PokemonCollection pokemonCollection = new PokemonCollection();
        Pokemon[] enemies = getRandomEnemies(pokemonCollection, selectedPokemon);

        enemy1 = enemies[0];
        enemy2 = enemies[1];

        enemy1Label = new JLabel();
        enemy1Label.setText("Enemy 1: " + enemy1.getName() + "  Type: " + enemy1.getType());

        enemy1HealthLabel = new JLabel();  // Initialize health label for enemy 1
        enemy1HealthLabel.setText("Enemy 1 Health: " + enemy1.getHp());

        enemy2Label = new JLabel();
        enemy2Label.setText("Enemy 2: " + enemy2.getName() + "  Type: " + enemy2.getType());

        enemy2HealthLabel = new JLabel();  // Initialize health label for enemy 2
        enemy2HealthLabel.setText("Enemy 2 Health: " + enemy2.getHp());

        yourPokemonHealthLabel = new JLabel();  // Initialize health label for your Pokemon
        yourPokemonHealthLabel.setText("Your Pokemon Health: " + selectedPokemon.getHp());

        userPokemonLabel = new JLabel();
        userPokemonLabel.setText("Your Pokemon: " + selectedPokemon.getName());

        yourPokemon = selectedPokemon; // Store the selected Pokemon in yourPokemon

        rb1 = new JRadioButton(yourPokemon.getZMove(), true);
        rb2 = new JRadioButton(yourPokemon.getMoveType(), false);

        bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);

        choose = new JButton("CHOOSE");

        panel = new JPanel(new GridLayout(12, 1));
        panel.add(userLabel);
        panel.add(enemy1Label);
        panel.add(enemy1HealthLabel);
        panel.add(enemy2Label);
        panel.add(enemy2HealthLabel);
        panel.add(userPokemonLabel);
        panel.add(yourPokemonHealthLabel);
        panel.add(rb1);
        panel.add(rb2);
        panel.add(choose);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choose.addActionListener(this);
        // Set the size and visibility
        setSize(400, 400);
        setLocationRelativeTo(null); // set location to the middle
        setVisible(true);
    }

    private Pokemon[] getRandomEnemies(PokemonCollection pokemonCollection, Pokemon selectedPokemon) {
        Pokemon[] allPokemon = pokemonCollection.getAllPokemon();
        List<Pokemon> shuffledPokemon = new ArrayList<>(Arrays.asList(allPokemon));
        Collections.shuffle(shuffledPokemon);

        // Exclude the selected Pokemon from the list (if it's not null)
        if (selectedPokemon != null) {
            shuffledPokemon.removeIf(pokemon -> pokemon.getName().equals(selectedPokemon.getName()));
        }

        // Select the first two Pokemon as enemies
        return Arrays.copyOfRange(shuffledPokemon.toArray(new Pokemon[0]), 0, 2);
    }

    private Pokemon chooseEnemy() {
        // Logic to choose an enemy based on health
        return enemy1.getHp() > 0 ? enemy1 : enemy2;
    }

    public void actionPerformed(ActionEvent ae) {
        Pokemon enemy = chooseEnemy();
        String attackInfo = "";
        String enemyAttackInfo = "";

        if (rb1.isSelected()) {
            yourPokemon.attack(enemy, "special");
            attackInfo = yourPokemon.getLastAttackInfo();
            enemy.attack(yourPokemon, "normal");
            enemyAttackInfo = enemy.getLastAttackInfo();

        } else if (rb2.isSelected()) {
            yourPokemon.attack(enemy, "normal");
            attackInfo = yourPokemon.getLastAttackInfo();
            enemy.attack(yourPokemon, "normal");
            enemyAttackInfo = enemy.getLastAttackInfo();
        }

        // Remove the existing battleinfo label from the panel
        if (battleinfo != null) {
            panel.remove(battleinfo);
        }

        // Create a new battleinfo label with the updated text
        battleinfo = new JLabel(attackInfo);

        // Add the new battleinfo label to the panel
        panel.add(battleinfo);

        // Remove the existing enemyAttackInfo label from the panel
        if (enemyattackInfo != null) {
            panel.remove(enemyattackInfo);
        }

        // Create a new enemyAttackInfo label with the updated text
        enemyattackInfo = new JLabel(enemyAttackInfo);

        // Add the new enemyAttackInfo label to the panel
        panel.add(enemyattackInfo);

        // Update health labels after each attack
        enemy1HealthLabel.setText("Enemy 1 Health: " + Math.max(enemy1.getHp(), 0));
        enemy2HealthLabel.setText("Enemy 2 Health: " + Math.max(enemy2.getHp(), 0));
        yourPokemonHealthLabel.setText("Your Pokemon Health: " + Math.max(yourPokemon.getHp(), 0));

        // Check if both enemies are defeated
        if (enemy1.getHp() <= 0 && enemy2.getHp() <= 0) {
            // Both enemies defeated, move to the Result_UI
            dispose(); // Dispose the current Battle_UI frame
            new Result_UI("You defeated both enemies!");
        } else if (enemy1.getHp() <= 0) {
            // Reset health label for enemy 1
            enemy1HealthLabel.setText("Enemy 1 Health: 0 (Defeated)");

            // Update enemy to the second one
            enemy = enemy2;
            // Ensure the health label for enemy 2 is displayed
            enemy2HealthLabel.setVisible(true);
        }

        // Check if your Pokemon is defeated
        if (yourPokemon.getHp() <= 0) {
            // Your Pokemon defeated, move to the Result_UI with "Fail" message
            dispose(); // Dispose the current Battle_UI frame
            new Result_UI("Fail");
        }

        // Revalidate and repaint the panel to refresh the UI
        panel.revalidate();
        panel.repaint();
    }

}
