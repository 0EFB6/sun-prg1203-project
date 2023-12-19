// Battle_UI.java
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
    private JLabel userPokemon2Label = null;
    private JLabel yourPokemonHealthLabel = null;
    private JLabel enemy1Label = null;
    private JLabel enemy1HealthLabel = null;
    private JLabel enemy2Label = null;
    private JLabel enemy2HealthLabel = null;
    private ButtonGroup userPokemonGroup = null;
    private JRadioButton rbUserPokemon1;
    private JRadioButton rbUserPokemon2;
    private JRadioButton rbAttack1;  // Unique JRadioButton for attack 1
    private JRadioButton rbAttack2;  // Unique JRadioButton for attack 2
    private JButton choosePokemonButton = null;
    private JButton chooseAttackButton = null;
    private Pokemon yourPokemon = null;
    private Pokemon userPokemon2 = null;
    private Pokemon chosenPokemon = null;
    private Pokemon enemy1 = null;
    private Pokemon enemy2 = null;
    private JLabel battleinfo = null;
    private JLabel enemyattackInfo = null;
    private double Score = 0;
    private boolean isSkillChosen = false;
    private boolean isAttackChosen = false;

    public Battle_UI(String username, Pokemon selectedPokemon) {
        this.username = username;
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

        enemy1HealthLabel = new JLabel();
        enemy1HealthLabel.setText("Enemy 1 Health: " + enemy1.getHp());

        enemy2Label = new JLabel();
        enemy2Label.setText("Enemy 2: " + enemy2.getName() + "  Type: " + enemy2.getType());

        enemy2HealthLabel = new JLabel();
        enemy2HealthLabel.setText("Enemy 2 Health: " + enemy2.getHp());

        yourPokemonHealthLabel = new JLabel();
        yourPokemonHealthLabel.setText("Your Pokemon Health: " + selectedPokemon.getHp());

        userPokemonLabel = new JLabel();
        userPokemonLabel.setText("Your Pokemon: " + selectedPokemon.getName());

        Pokemon[] userPokemonOptions = getRandomEnemies(pokemonCollection, selectedPokemon);
        userPokemon2 = userPokemonOptions[0];

        userPokemon2Label = new JLabel();
        userPokemon2Label.setText("Your Second Pokemon: " + userPokemon2.getName() + "  Type: " + userPokemon2.getType()
                + "  Health: " + userPokemon2.getHp());

        yourPokemon = selectedPokemon;

        rbUserPokemon1 = new JRadioButton(yourPokemon.getName(), true);
        rbUserPokemon2 = new JRadioButton(userPokemon2.getName(), false);

        userPokemonGroup = new ButtonGroup();
        userPokemonGroup.add(rbUserPokemon1);
        userPokemonGroup.add(rbUserPokemon2);

        rbAttack1 = new JRadioButton("", false);
        rbAttack2 = new JRadioButton("", false);
        hideAttackOptions();  // Hide attack options initially

        choosePokemonButton = new JButton("Choose Pokemon");
        chooseAttackButton = new JButton("Choose Attack");
        chooseAttackButton.setEnabled(false);

        panel = new JPanel(new GridLayout(16, 1));
        panel.add(userLabel);
        panel.add(enemy1Label);
        panel.add(enemy1HealthLabel);
        panel.add(enemy2Label);
        panel.add(enemy2HealthLabel);
        panel.add(userPokemonLabel);
        panel.add(rbUserPokemon1);
        panel.add(rbUserPokemon2);
        panel.add(yourPokemonHealthLabel);
        panel.add(userPokemon2Label);
        panel.add(rbAttack1);
        panel.add(rbAttack2);
        panel.add(choosePokemonButton);
        panel.add(chooseAttackButton);

        add(panel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choosePokemonButton.addActionListener(this);
        chooseAttackButton.addActionListener(this);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Pokemon[] getRandomEnemies(PokemonCollection pokemonCollection, Pokemon selectedPokemon) {
        Pokemon[] allPokemon = pokemonCollection.getAllPokemon();
        List<Pokemon> shuffledPokemon = new ArrayList<>(Arrays.asList(allPokemon));
        Collections.shuffle(shuffledPokemon);

        if (selectedPokemon != null) {
            shuffledPokemon.removeIf(pokemon -> pokemon.getName().equals(selectedPokemon.getName()));
        }

        return Arrays.copyOfRange(shuffledPokemon.toArray(new Pokemon[0]), 0, 2);
    }

    private Pokemon chooseEnemy() {
        if (enemy1.getHp() > 0) {
            return enemy1;
        } else if (enemy2.getHp() > 0) {
            return enemy2;
        } else {
            return null; // Both enemies defeated
        }
    }

    private void hideAttackOptions() {
        rbAttack1.setVisible(false);
        rbAttack2.setVisible(false);
    }

    private void showAttackOptions() {
        rbAttack1.setVisible(true);
        rbAttack2.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == choosePokemonButton && !isSkillChosen) {
            if (rbUserPokemon1.isSelected()) {
                chosenPokemon = yourPokemon;
            } else if (rbUserPokemon2.isSelected()) {
                chosenPokemon = userPokemon2;
            }

            rbAttack1.setText(chosenPokemon.getZMove());
            rbAttack2.setText(chosenPokemon.getMoveType());
            showAttackOptions();  // Show attack options after choosing a Pokemon
            isSkillChosen = true;
            chooseAttackButton.setEnabled(true);
            choosePokemonButton.setVisible(false);
            return;
        }

        if (ae.getSource() == chooseAttackButton) {
            isAttackChosen = true;
        }

        Pokemon enemy = chooseEnemy();
        String attackInfo = "";
        String enemyAttackInfo = "";

        if (isAttackChosen) {
            if (rbAttack1.isSelected()) {
                chosenPokemon.attack(enemy, "special");
                attackInfo = chosenPokemon.getLastAttackInfo();
                if (enemy.getHp() <= 0) {
                    // Check if the enemy is defeated after the special move
                    enemy1HealthLabel.setText("Enemy 1 Health: 0 (Defeated)");
                    enemy = enemy2;
                    enemy2HealthLabel.setVisible(true);
                } else {
                    enemy.attack(chosenPokemon, "normal");
                    enemyAttackInfo = enemy.getLastAttackInfo();
                }
            } else if (rbAttack2.isSelected()) {
                chosenPokemon.attack(enemy, "normal");
                attackInfo = chosenPokemon.getLastAttackInfo();
                enemy.attack(chosenPokemon, "normal");
                enemyAttackInfo = enemy.getLastAttackInfo();
            }

            if (battleinfo != null) {
                panel.remove(battleinfo);
            }

            battleinfo = new JLabel(attackInfo);
            panel.add(battleinfo);

            if (enemyattackInfo != null) {
                panel.remove(enemyattackInfo);
            }

            enemyattackInfo = new JLabel(enemyAttackInfo);
            panel.add(enemyattackInfo);

            enemy1HealthLabel.setText("Enemy 1 Health: " + Math.max(enemy1.getHp(), 0));
            enemy2HealthLabel.setText("Enemy 2 Health: " + Math.max(enemy2.getHp(), 0));
            yourPokemonHealthLabel.setText("Your Pokemon Health: " + Math.max(chosenPokemon.getHp(), 0));

            if (enemy1.getHp() <= 0 && enemy2.getHp() <= 0) {
                dispose();
                Score = yourPokemon.getHp() + userPokemon2.getHp();
                new SecondCatch_UI(Score, username, enemy1, enemy2);
            } else if (enemy1.getHp() <= 0) {
                enemy1HealthLabel.setText("Enemy 1 Health: 0 (Defeated)");
                enemy = enemy2;
                enemy2HealthLabel.setVisible(true);
            }

            if (yourPokemon.getHp() <= 0 && userPokemon2.getHp() <= 0) {
                dispose();
                new Result_UI().result(username);
            }

            if (isSkillChosen) {
                hideAttackOptions();  // Hide attack options after an attack
                chooseAttackButton.setEnabled(false);
                isAttackChosen = false;
                isSkillChosen = false;
                rbAttack1.setText("");
                rbAttack2.setText("");
                rbAttack1.setSelected(false);
                rbAttack2.setSelected(false);
                userPokemonGroup.clearSelection();
                choosePokemonButton.setVisible(true);
            }
        }

        panel.revalidate();
        panel.repaint();
    }
}
