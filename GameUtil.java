import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GameUtil {
    // Methods
    public static String login(Scanner scanner) {
        String username;

        System.out.println("Welcome to Pokemon Battle!");
        System.out.println("Please enter username to continue.");
        System.out.println();
        System.out.print("Username: ");
        username = scanner.next();
        clearTerminal();
        System.out.println("[" + username + "] " + "Successfully recorded your username!");
        System.out.println();
        return username;
    }

    public static void updatePlayerScore(String username, int currentScore) {
        File file = new File("playerScoreList.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        List<Player> player = readPlayerScoresFromFile(file);
        List<Player> leaderboard = updatePlayerScoreInList(player, username, currentScore);
        writePlayerScoresToFile(file, leaderboard);
    }

    private static List<Player> readPlayerScoresFromFile(File file) {
        List<Player> playerList = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");
                playerList.add(new Player(parts[0], Integer.parseInt(parts[1])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return playerList;
    }

    private static List<Player> updatePlayerScoreInList(List<Player> playerList, String username, int currentScore) {
        boolean found = false;

        for (Player player : playerList) {
            if (player.getUsername().equals(username)) {
                found = true;
                if (currentScore > player.getScore()) {
                    player.setScore(currentScore);
                    System.out.println("Congratulations! You break your own record. Your new high score is: " + currentScore);
                }
                else
                    System.out.println("Your current score " + currentScore + " is not higher than your previous high score " + player.getScore() + ", thus, your high score in the leaderboard remains unchanged.");
                break;
            }
        }

        if (!found) {
            playerList.add(new Player(username, currentScore));
            System.out.println("Congratulations! Your new score is: " + currentScore);
        }
        playerList.sort(Comparator.comparingInt(Player::getScore).reversed());
        playerList = playerList.subList(0, Math.min(playerList.size(), 5));
        return playerList;
    }

    private static void writePlayerScoresToFile(File file, List<Player> playerList) {
        try (FileWriter writer = new FileWriter(file)) {
            for (Player player : playerList) {
                writer.write(player.getUsername() + ";" + player.getScore() + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearTerminal() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void listAllPokemons() {
        ArrayList<Pokemon> pokemons = GameInit.initPokemon();
        for (Pokemon pokemon : pokemons) {
            pokemon.printPokemonInfo();
        }
        System.out.println("\n===========================END OF LIST==========================");
    }

    public static void viewLeaderboard() {
        File file = new File("playerScoreList.txt");
    
        if (!file.exists()) {
            System.out.println("No leaderboard exists yet.");
            return;
        }
        System.out.println("Leaderboard\n==============================");
        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");
                System.out.printf("%-20s | %-10s%n", parts[0], parts[1]);
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("================================");
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}