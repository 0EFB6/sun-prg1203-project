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
    public String username = null;
    private JPanel panel = null;
    private JLabel userLabel = null;
    private JLabel userPokemonLabel = null;
    private JLabel userPokemon2Label = null;
    private JLabel yourPokemonHealthLabel = null;
    private JLabel yourPokemon2HealthLabel = null;
    private JLabel enemy1Label = null;
    private JLabel enemy1HealthLabel = null;
    private JLabel enemy2Label = null;
    private JLabel enemy2HealthLabel = null;
    private JRadioButton rbEnemy1;
    private JRadioButton rbEnemy2;
    private JLabel chooseEnemyLabel;
    private JLabel chooseAttackLabel = null;
    private ButtonGroup userPokemonGroup = null;
    private JRadioButton rbUserPokemon1;
    private JRadioButton rbUserPokemon2;
    private JLabel chooseyourpokemon;
    private JRadioButton rbAttack1 = null;  
    private JRadioButton rbAttack2 = null;  
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
    private boolean isEnemyChosen = true;

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
        enemy1Label.setText(" Enemy pokemon 1: " + enemy1.getName() + "  Type: " + enemy1.getType());

        enemy1HealthLabel = new JLabel();
        enemy1HealthLabel.setText(" Enemy pokemon 1 Health: " + enemy1.getHp());

        enemy2Label = new JLabel();
        enemy2Label.setText(" Enemy pokemon 2: " + enemy2.getName() + "  Type: " + enemy2.getType());

        enemy2HealthLabel = new JLabel();
        enemy2HealthLabel.setText(" Enemy pokemon 2 Health: " + enemy2.getHp());

        rbEnemy1 = new JRadioButton("Enemy 1", true);
        rbEnemy2 = new JRadioButton("Enemy 2", false);

        ButtonGroup enemyGroup = new ButtonGroup();
        enemyGroup.add(rbEnemy1);
        enemyGroup.add(rbEnemy2);

        chooseEnemyLabel = new JLabel("Choose the enemy to attack:");

        yourPokemonHealthLabel = new JLabel();
        yourPokemonHealthLabel.setText(" Your First Pokemon Health: " + selectedPokemon.getHp());

        userPokemonLabel = new JLabel();
        userPokemonLabel.setText(" Your First Pokemon: " + selectedPokemon.getName() + "  Type: " + selectedPokemon.getType());

        Pokemon[] userPokemonOptions = getRandomEnemies(pokemonCollection, selectedPokemon);
        userPokemon2 = userPokemonOptions[0];

        yourPokemon2HealthLabel = new JLabel();
        yourPokemon2HealthLabel.setText(" Your Second Pokemon Health: " + userPokemon2.getHp());

        userPokemon2Label = new JLabel();
        userPokemon2Label.setText(" Your Second Pokemon: " + userPokemon2.getName() + "  Type: " + userPokemon2.getType());

        yourPokemon = selectedPokemon;

        rbUserPokemon1 = new JRadioButton(yourPokemon.getName(), true);
        rbUserPokemon2 = new JRadioButton(userPokemon2.getName(), false);

        userPokemonGroup = new ButtonGroup();
        userPokemonGroup.add(rbUserPokemon1);
        userPokemonGroup.add(rbUserPokemon2);

        chooseyourpokemon = new JLabel();
        chooseyourpokemon.setText("Choose your pokemon: ");

        rbAttack1 = new JRadioButton("", false);
        rbAttack2 = new JRadioButton("", false);
        hideAttackOptions();  // Hide attack options initially

        chooseAttackLabel = new JLabel();
        chooseAttackLabel.setText("Choose your attack!");

        choosePokemonButton = new JButton("Choose Pokemon");
        chooseAttackButton = new JButton("Choose Attack");
        chooseAttackButton.setEnabled(false);

        
        panel = new JPanel(new GridLayout(22, 1));
        panel.add(userLabel);
        panel.add(enemy1Label);
        panel.add(enemy1HealthLabel);
        panel.add(enemy2Label);
        panel.add(enemy2HealthLabel);
        panel.add(chooseEnemyLabel);  
        panel.add(rbEnemy1);
        panel.add(rbEnemy2);
        panel.add(userPokemonLabel);
        panel.add(userPokemon2Label);
        panel.add(yourPokemonHealthLabel);
        panel.add(yourPokemon2HealthLabel);
        panel.add(chooseyourpokemon);
        panel.add(rbUserPokemon1);
        panel.add(rbUserPokemon2);
        panel.add(chooseAttackLabel);
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


    private void hideAttackOptions() {
        rbAttack1.setVisible(false);
        rbAttack2.setVisible(false);
    }

    private void showAttackOptions() {
        rbAttack1.setVisible(true);
        rbAttack2.setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        Pokemon selectedEnemy = null;

        if (isEnemyChosen) {
            if (rbEnemy1.isSelected()){
                    selectedEnemy = enemy1;
            } else if (rbEnemy2.isSelected()){
                    selectedEnemy = enemy2;
            }
        }


        if (ae.getSource() == choosePokemonButton && !isSkillChosen) {
            if (rbUserPokemon1.isSelected()) {
                chosenPokemon = yourPokemon;
            } else if (rbUserPokemon2.isSelected()) {
                chosenPokemon = userPokemon2;
            }

            rbAttack1.setText(chosenPokemon.getZMove());
            rbAttack2.setText(chosenPokemon.getMoveType());
            showAttackOptions();
            isSkillChosen = true;
            chooseAttackButton.setEnabled(true);
            choosePokemonButton.setVisible(false);
            return;
        }



        if (ae.getSource() == chooseAttackButton) {
            isAttackChosen = true;
        }

        Pokemon enemy = selectedEnemy;
        String attackInfo = "";
        String enemyAttackInfo = "";

        if (isAttackChosen) {
            if (rbAttack1.isSelected()) {
                chosenPokemon.attack(selectedEnemy, "special");
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
                chosenPokemon.attack(selectedEnemy, "normal");
                attackInfo = chosenPokemon.getLastAttackInfo();
                enemy.attack(chosenPokemon, "normal");
                enemyAttackInfo = enemy.getLastAttackInfo();
            }

            if (chosenPokemon == yourPokemon) {
                yourPokemonHealthLabel.setText(" Your First Pokemon Health: " + Math.max(chosenPokemon.getHp(), 0));
            } else if (chosenPokemon == userPokemon2) {
                yourPokemon2HealthLabel.setText(" Your Second Pokemon Health: " + Math.max(chosenPokemon.getHp(), 0));
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

            enemy1HealthLabel.setText(" Enemy 1 Health: " + Math.max(enemy1.getHp(), 0));
            enemy2HealthLabel.setText(" Enemy 2 Health: " + Math.max(enemy2.getHp(), 0));
            yourPokemonHealthLabel.setText(" Your First Pokemon Health: " + Math.max(yourPokemon.getHp(), 0));
            yourPokemon2HealthLabel.setText(" Your Second Pokemon Health: " + Math.max(userPokemon2.getHp(), 0));

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
            if (yourPokemon.getHp() <= 0 && userPokemon2.getHp() >= 0) {
                yourPokemonHealthLabel.setText("Your pokemon is dead");
                rbUserPokemon1.setVisible(false);
            }
             if (yourPokemon.getHp() >= 0 && userPokemon2.getHp() <= 0) {
                yourPokemon2HealthLabel.setText("Your second pokemon is dead");
                rbUserPokemon2.setVisible(false);
            }
            if (enemy1.getHp()<=0 && enemy2.getHp()>=0){
                enemy1HealthLabel.setText("Enemy Pokemon 1 has died");
                rbEnemy1.setVisible(false);
            }
            if (enemy1.getHp()>=0 && enemy2.getHp()<=0){
                enemy2HealthLabel.setText("Enemy Pokemon 2 has died");
                rbEnemy2.setVisible(false);
            }
            if (isSkillChosen) {
                hideAttackOptions(); 
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
