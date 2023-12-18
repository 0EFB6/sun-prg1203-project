package Assignment;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Pokedex_UI extends JFrame implements ActionListener {
    final String[] COLUMN_NAMES = {"collectionNumber", "name", "grade", "pe", "zMove", "moveType", "type"};
    String[][] arr = null;
    Pokemon tempArr[] = null;
    PokemonCollection pokemonCollection = null;
    JTable table = null;
    JScrollPane sp = null;
    JButton back;
    private String username;

    Pokedex_UI(String username) {
        this.username = username; // store the username

        this.setTitle("PokeDex Frame");
        pokemonCollection = new PokemonCollection();
        arr = new String[20][7];
        tempArr = pokemonCollection.getAllPokemon();

        for (int row = 0; row < arr.length; row++) {
            arr[row] = tempArr[row].getValues();
        }

        table = new JTable(arr, COLUMN_NAMES);

        sp = new JScrollPane(table);

        // Add a "Back" button
        back = new JButton("Back");
        back.addActionListener(this);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(sp, BorderLayout.CENTER);
        panel.add(back, BorderLayout.SOUTH);

        add(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // set location to middle
        setExtendedState(JFrame.MAXIMIZED_BOTH); // set frame to full-screen
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            // Handle the action when the "Back" button is clicked
            this.dispose();
            Option_UI option = new Option_UI(username); // Pass the username to Option_UI
        }
    }
}
