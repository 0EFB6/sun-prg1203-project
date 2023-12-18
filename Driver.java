import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username;
        boolean validBattle = false;

        username = login(scanner);
        
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        initPokemon(pokemons);
        initPokemonStats(pokemons);


        Player player = null;
        List<Pokemon> enemyPokemons = null;
        List<Pokemon> playerPokemons = null;
        player = new Player(username, 0, catchOneOfThreePokemon(pokemons, scanner));


        while (!validBattle)
        {
            enemyPokemons = initEnemyPokemons(pokemons, player.getPlayerPokemon1());
            playerPokemons = initPlayerPokemons(pokemons, enemyPokemons, player.getPlayerPokemon1());
            player.setPlayerPokemon2(playerPokemons.get(1));
            validBattle = validateBattle(player.getPlayerPokemon1(), player.getPlayerPokemon2(), enemyPokemons);
        }
        startBattle(player.getPlayerPokemon1(), player.getPlayerPokemon2(), enemyPokemons, scanner);
        player.setScore((int) (player.getPlayerPokemon1().getPokemonHp() + player.getPlayerPokemon2().getPokemonHp()));
        updatePlayerScore(username, player.getScore());
        scanner.close();
    }

    public static void initPokemon(ArrayList<Pokemon> pokemons) {
        pokemons.add(new FirePokemon(1, "Charmander", 1, 10, "Fire Fang", "FIRE"));
        pokemons.add(new FirePokemon(2, "Charmeleon", 5, 20, "Flamethrower", "FIRE"));
        pokemons.add(new WaterPokemon(3, "Squirtle", 1, 10, "Water Gun", "WATER"));
        pokemons.add(new WaterPokemon(4, "Wartortle", 5, 20, "Waterfall", "WATER"));
        pokemons.add(new WaterPokemon(5, "Blastoise", 10, 30, "Giant Geyser GX", "WATER"));
        pokemons.add(new BugPokemon(6, "Caterpie", 1, 10, "Gnaw", "BUG"));
        pokemons.add(new BugPokemon(7, "Metapod", 5, 20, "Bug Bite", "BUG"));
        pokemons.add(new Pokemon(8, "Rattata", 1, 10, "Bite", "NORMAL", "NORMAL"));
        pokemons.add(new Pokemon(9, "Raticate", 5, 20, "Super Fang", "NORMAL", "NORMAL"));
        pokemons.add(new PoisonPokemon(10, "Ekans", 1, 10, "BITE", "POISON"));
        pokemons.add(new PoisonPokemon(11, "Arbok", 5, 20, "Venomous Fang", "POISON"));
        pokemons.add(new ElectricPokemon(12, "Pikachu", 1, 10, "Thunderbolt", "ELECTRIC"));
        pokemons.add(new ElectricPokemon(13, "Raichu", 5, 20, "Electro Ball", "ELECTRIC"));
        pokemons.add(new FightingPokemon(14, "Sandshrew", 1, 10, "Sand Tomb", "FIGHTING"));
        pokemons.add(new FightingPokemon(15, "Sandslash", 5, 20, "Earthquake", "FIGHTING"));
        pokemons.add(new PoisonPokemon(16, "Nidorina", 5, 20, "Double Kick", "POISON"));
        pokemons.add(new FirePokemon(17, "Ninetales", 3, 30, "Flash Fire", "FIRE"));
        pokemons.add(new FirePokemon(18, "Golduck", 4,15, "Cloud Nine", "WATER"));
        pokemons.add(new WaterPokemon(19, "Mega Blastoise", 5, 20, "Hydro Pump", "WATER"));
        pokemons.add(new FightingPokemon(20, "Mankey", 5, 20, "Karate Chop", "FIGHTING"));
    }

    public static void initPokemonStats(ArrayList<Pokemon> pokemons) {
        pokemons.get(0).setStats(new Stats(15, 4, 4, 3, 3, 4));
        pokemons.get(1).setStats(new Stats(20, 4, 5, 4, 4, 5));
        pokemons.get(2).setStats(new Stats(15, 3, 3, 4, 4, 3));
        pokemons.get(3).setStats(new Stats(20, 4, 4, 5, 5, 4));
        pokemons.get(4).setStats(new Stats(25, 5, 5, 6, 7, 5));
        pokemons.get(5).setStats(new Stats(15, 2, 2, 3, 2, 3));
        pokemons.get(6).setStats(new Stats(15, 2, 2, 4, 2, 2));
        pokemons.get(7).setStats(new Stats(10, 3, 1, 2, 1, 4));
        pokemons.get(8).setStats(new Stats(10, 4, 2, 3, 3, 5));
        pokemons.get(9).setStats(new Stats(10, 3, 2, 2, 2, 3));
        pokemons.get(10).setStats(new Stats(15, 5, 3, 3, 3, 4));
        pokemons.get(11).setStats(new Stats(15, 4, 3, 3, 3, 6));
        pokemons.get(12).setStats(new Stats(20, 6, 6, 4, 5, 7));
        pokemons.get(13).setStats(new Stats(10, 4, 1, 4, 1, 2));
        pokemons.get(14).setStats(new Stats(15, 5, 2, 5, 2, 4));
        pokemons.get(15).setStats(new Stats(15, 3, 3, 3, 2, 3));
        pokemons.get(16).setStats(new Stats(25, 5, 5, 5, 6, 6));
        pokemons.get(17).setStats(new Stats(25, 5, 6, 5, 5, 5));
        pokemons.get(18).setStats(new Stats(15, 5, 7, 5, 5, 4));
        pokemons.get(19).setStats(new Stats(10, 4, 2, 2, 2, 4));
    }

    public static List<Pokemon> initEnemyPokemons (ArrayList<Pokemon> pokemons, Pokemon player) {
        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        shufflePokemons.remove(player);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> enemyPokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 2));
        return enemyPokemons;
    }

    public static List<Pokemon> initPlayerPokemons (ArrayList<Pokemon> pokemons, List<Pokemon> enemy, Pokemon player) {
        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        shufflePokemons.remove(enemy.get(0));
        shufflePokemons.remove(enemy.get(1));
        shufflePokemons.remove(player);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> playerPokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 2));
        playerPokemons.add(player);
        return playerPokemons;
    }

    public static Pokemon catchOneOfThreePokemon (ArrayList<Pokemon> pokemonList, Scanner scanner) {
        int pokemonCatch;
        boolean validInput = false;
        Pokemon playerSelected = null;

        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemonList);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> pokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 3));

        System.out.println("Catch a Pokemon!");
        System.out.printf("1. %s [%s]\n", pokemons.get(0).getName(), pokemons.get(0).getType());
        System.out.printf("2. %s [%s]\n", pokemons.get(1).getName(), pokemons.get(1).getType());
        System.out.printf("3. %s [%s]\n", pokemons.get(2).getName(), pokemons.get(2).getType());
        
        do {
            System.out.print("Enter your choice (1-3): ");
            try {
                pokemonCatch = scanner.nextInt();
                if (pokemonCatch >= 1 && pokemonCatch <= 3)
                {
                    validInput = true;
                    playerSelected = pokemons.get(pokemonCatch - 1);
                }
                else
                    System.out.println("Enter integers ranging from 1 to 3 ONLY!");
            }
            catch (Exception e) {
                System.out.println("Enter integers ranging from 1 to 3 ONLY!");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!validInput);
        clearTerminal();

        return playerSelected;
    }

    public static void  catchPokemon(List<Pokemon> enemy, Scanner scanner) {
        Catch catchPokeball = null;
        int pokemonChoice = 0;

        if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0)
        {
            do {
                try {
                    System.out.println("Select a pokemon to catch: ");
                    System.out.println("1. " + enemy.get(0).getName());
                    System.out.println("2. " + enemy.get(1).getName());
                    System.out.print("Enter your choice (1 or 2): ");
                    pokemonChoice = scanner.nextInt();
                
                    if (pokemonChoice < 1 || pokemonChoice > 2) {
                        throw new IllegalArgumentException(); // Throw an exception for invalid input
                    }
                
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear the input buffer
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    scanner.nextLine(); // Clear the input buffer
                }
            } while (pokemonChoice < 1 || pokemonChoice > 2);
        }
        else if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() > 0)
        {
            System.out.println();
            System.out.println("You may only catch one pokemon as you only defeated " + enemy.get(0).getName() + "!");
            pokemonChoice = 1;
        }
        else if (enemy.get(1).getPokemonHp() <= 0 && enemy.get(0).getPokemonHp() > 0)
        {
            System.out.println();
            System.out.println("You may only catch one pokemon as you only defeated " + enemy.get(1).getName() + "!");
            pokemonChoice = 2;
        }

        if (pokemonChoice == 1 || pokemonChoice == 2)
        {
            System.out.println();
            System.out.println("Use a Pokeball to catch " + enemy.get(pokemonChoice - 1).getName() + "!");
            System.out.println();
            System.out.println("[System is selecting a random Pokeball...]");
            System.out.println();

            int randomPokeball = new Random().nextInt(4);

            try {
                Thread.sleep(1500);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            catchPokeball = new Catch(randomPokeball + 1);
            System.out.println("Pokeball " + catchPokeball.getPokeBall().getBallType() + " selected!");
            System.out.println();
            System.out.println("[Catching in 3 ... 2 ... 1 ...]");

            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }

            catchPokeball.catchPokeball(enemy.get(pokemonChoice - 1));
        }
        else
            System.out.println("[ERROR] Fail to catch pokemon using pokeball!");

    }

    public static boolean validateBattle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy) {
        if ((playerPokemon1.validateAttack(enemy.get(0), "normal")
            || playerPokemon1.validateAttack(enemy.get(0), "special"))
            && 
            (playerPokemon1.validateAttack(enemy.get(1), "normal")
            || playerPokemon1.validateAttack(enemy.get(1), "special"))
            &&
            (playerPokemon2.validateAttack(enemy.get(0), "normal")
            || playerPokemon2.validateAttack(enemy.get(0), "special"))
            &&
            (playerPokemon2.validateAttack(enemy.get(1), "normal")
            || playerPokemon2.validateAttack(enemy.get(1), "special"))
            &&
            (enemy.get(0).validateAttack(playerPokemon1, "normal")
            || enemy.get(0).validateAttack(playerPokemon1, "special"))
            &&
            (enemy.get(1).validateAttack(playerPokemon1, "normal")
            || enemy.get(1).validateAttack(playerPokemon1, "special"))
            &&
            (enemy.get(0).validateAttack(playerPokemon2, "normal")
            || enemy.get(0).validateAttack(playerPokemon2, "special"))
            &&
            (enemy.get(1).validateAttack(playerPokemon2, "normal")
            || enemy.get(1).validateAttack(playerPokemon2, "special")))
            return true;
        return false;
    }

    public static boolean battle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy, Scanner scanner) {
        Random random = new Random();
        String attackType;

        while ((playerPokemon1.getPokemonHp() > 0 || playerPokemon2.getPokemonHp() > 0) && (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)) {
                    System.out.println();
                    System.out.println("1. " + enemy.get(0).getName() + " [HP: " + enemy.get(0).getPokemonHp() + "]");
                    System.out.println("2. " + enemy.get(1).getName() + " [HP: " + enemy.get(1).getPokemonHp() + "]");
                    System.out.print("Select an enemy to attack [1/2]: ");

                    try {
                        int choice = scanner.nextInt();
                        int choicePlayer = 0;

                        if (choice == 1 || choice == 2) {
                            Pokemon selectedEnemy = enemy.get(choice - 1);
                            if (selectedEnemy.getPokemonHp() <= 0) {
                                System.out.println();
                                System.out.println("Enemy has died. Try again.");
                                continue;
                            }

                            System.out.println();
                            System.out.println("1. " + playerPokemon1.getName() + " [HP: " + playerPokemon1.getPokemonHp() + "]");
                            System.out.println("2. " + playerPokemon2.getName() + " [HP: " + playerPokemon2.getPokemonHp() + "]");
                            System.out.print("Select a pokemon to use [1/2]: ");
                            choicePlayer = scanner.nextInt();

                            System.out.println();
                            System.out.println("1. Normal Attack [N]");
                            System.out.println("2. Special Attack [S]");
                            System.out.print("Select an attack type [N/S]: ");
                            attackType = scanner.next();

                            clearTerminal();

                            
                            if (attackType.equalsIgnoreCase("s"))
                            {
                                System.out.print("[YOU ---> ENEMY] ");
                                if (choicePlayer == 1)
                                    playerPokemon1.attack(selectedEnemy, "special");
                                else if (choicePlayer == 2)
                                    playerPokemon2.attack(selectedEnemy, "special");
                            }
                            else if (attackType.equalsIgnoreCase("n"))
                            {
                                System.out.print("[YOU ---> ENEMY] ");
                                if (choicePlayer == 1)
                                    playerPokemon1.attack(selectedEnemy, "normal");
                                else if (choicePlayer == 2)
                                    playerPokemon2.attack(selectedEnemy, "normal");
                            }
                            else
                                continue;
                            
                            // Display updated stats
                            // player.printPlayer();
                            // player.printEnemy(enemy.get(0));
                            // player.printEnemy(enemy.get(1));
                            

                            if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0)
                            {
                                System.out.println("You win! Congratulations!!! Catching pokemon in 3 ... 2 ... 1 ...");
                                try {
                                    Thread.sleep(3000);
                                }
                                catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                return true;
                            }

                            // Random enemy attacks the player
                            int randomEnemyAttack = random.nextInt(2);
                            int randomEnemyChoice = random.nextInt(2);
                            System.out.print("[ENEMY ---> YOU] ");
                            if (enemy.get(0).getPokemonHp() > 0 && enemy.get(1).getPokemonHp() > 0)
                            {
                                Pokemon randomEnemy = enemy.get(random.nextInt(2));

                                if (randomEnemyAttack == 0)
                                {
                                    if (randomEnemyChoice == 0 && playerPokemon1.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon1, "normal");
                                    else if (randomEnemyChoice == 0 && playerPokemon2.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon2, "normal");
                                    else if (randomEnemyChoice == 1 && playerPokemon1.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon1, "normal");
                                    else if (randomEnemyChoice == 1 && playerPokemon2.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon2, "normal");
                                }
                                else if (randomEnemyAttack == 1)
                                {
                                    if (randomEnemyChoice == 0 && playerPokemon1.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon1, "special");
                                    else if (randomEnemyChoice == 0 && playerPokemon2.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon2, "special");
                                    else if (randomEnemyChoice == 1 && playerPokemon1.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon1, "special");
                                    else if (randomEnemyChoice == 1 && playerPokemon2.getPokemonHp() > 0)
                                        randomEnemy.attack(playerPokemon2, "special");
                                }
                                // Display updated stats
                                System.out.println();
                                playerPokemon1.printPlayer();
                                playerPokemon2.printPlayer(); 
                                playerPokemon1.printEnemy(enemy.get(0));
                                playerPokemon1.printEnemy(enemy.get(1));
                            }
                            else if (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)
                            {
                                if (enemy.get(0).getPokemonHp() > 0)
                                {
                                    if (randomEnemyAttack == 0 && playerPokemon1.getPokemonHp() > 0)
                                        enemy.get(0).attack(playerPokemon1, "normal");
                                    else if (randomEnemyAttack == 0 && playerPokemon2.getPokemonHp() > 0)
                                        enemy.get(0).attack(playerPokemon2, "normal");
                                    else if (randomEnemyAttack == 1 && playerPokemon1.getPokemonHp() > 0)
                                        enemy.get(0).attack(playerPokemon1, "special");
                                    else if (randomEnemyAttack == 1 && playerPokemon2.getPokemonHp() > 0)
                                        enemy.get(0).attack(playerPokemon2, "special");
                                }
                                else if (enemy.get(1).getPokemonHp() > 0)
                                {
                                    if (randomEnemyAttack == 0 && playerPokemon1.getPokemonHp() > 0)
                                        enemy.get(1).attack(playerPokemon1, "normal");
                                    else if (randomEnemyAttack == 0 && playerPokemon2.getPokemonHp() > 0)
                                        enemy.get(1).attack(playerPokemon2, "normal");
                                    else if (randomEnemyAttack == 1 && playerPokemon1.getPokemonHp() > 0)
                                        enemy.get(1).attack(playerPokemon1, "special");
                                    else if (randomEnemyAttack == 1 && playerPokemon2.getPokemonHp() > 0)
                                        enemy.get(1).attack(playerPokemon2, "special");
                                }

                                // Display updated stats
                                playerPokemon1.printPlayer();
                                playerPokemon2.printPlayer();
                                playerPokemon1.printEnemy(enemy.get(0));
                                playerPokemon1.printEnemy(enemy.get(1));

                            }
                        }
                        else {
                            System.out.println("Invalid choice. Try again.\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("\nEnter integers 1 or 2 ONLY!");
                        scanner.nextLine(); // Clear the input buffer
                    }
        }

        if (playerPokemon1.getPokemonHp() <= 0 && playerPokemon2.getPokemonHp() <= 0 && enemy.get(0).getPokemonHp() > 0 && enemy.get(1).getPokemonHp() > 0)
        {
            System.out.println("You lose. Game Over! Quiting in 3 ... 2 ... 1 ...");
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return false;
        }
        
        System.out.println("You win! Congratulations!!! Catching pokemon in 3 ... 2 ... 1 ...");
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static void startBattle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy, Scanner scanner) {
        String startBattle;
        
        System.out.println("It's time for battle! Get ready!");
        System.out.println();
        System.out.println("[Your Selection 1] " + playerPokemon1.getName());
        System.out.println("[Your Selection 2] " + playerPokemon2.getName() + "\n");
        System.out.println("[Opponent 1] " + enemy.get(0).getName());
        System.out.println("[Opponent 2] " + enemy.get(1).getName() + "\n");

        do {
            System.out.print("Start battle? [Y/N]");
            startBattle = scanner.next();

            if (startBattle.equalsIgnoreCase("Y"))
            {
                clearTerminal();
                System.out.println("Battle started!\n");
                System.out.println("-------------------------------");
                System.out.println("|       Enemy Pokemon         |");
                System.out.println("-------------------------------");
                System.out.println("[ "+ enemy.get(0).getName() + " ]");
                System.out.println("zMove: " + enemy.get(0).getZMove());
                System.out.println("Type: " + enemy.get(0).getType());
                System.out.println("HP: " + enemy.get(0).getPokemonHp());
                System.out.println("Attack: " + enemy.get(0).getAttackPower());
                System.out.println("Defense: " + enemy.get(0).getDefensePower());
                System.out.println("Special Attack: " + enemy.get(0).getSpecialAttackPower());
                System.out.println("Special Defense: " + enemy.get(0).getSpecialDefensePower());
                System.out.println();

                System.out.println("[ "+ enemy.get(1).getName() + " ]");
                System.out.println("zMove: " + enemy.get(1).getZMove());
                System.out.println("Type: " + enemy.get(1).getType());
                System.out.println("HP: " + enemy.get(1).getPokemonHp());
                System.out.println("Attack: " + enemy.get(1).getAttackPower());
                System.out.println("Defense: " + enemy.get(1).getDefensePower());
                System.out.println("Special Attack: " + enemy.get(1).getSpecialAttackPower());
                System.out.println("Special Defense: " + enemy.get(1).getSpecialDefensePower());
                System.out.println();

                System.out.println("-------------------------------");
                System.out.println("|        Your Pokemon         |");
                System.out.println("-------------------------------");
                System.out.println("[ "+ playerPokemon1.getName() + " ]");
                System.out.println("zMove: " + playerPokemon1.getZMove());
                System.out.println("Type: " + playerPokemon1.getType());
                System.out.println("HP: " + playerPokemon1.getPokemonHp());
                System.out.println("Attack: " + playerPokemon1.getAttackPower());
                System.out.println("Defense: " + playerPokemon1.getDefensePower());
                System.out.println("Special Attack: " + playerPokemon1.getSpecialAttackPower());
                System.out.println("Special Defense: " + playerPokemon1.getSpecialDefensePower());
                System.out.println();

                System.out.println("[ "+ playerPokemon2.getName() + " ]");
                System.out.println("zMove: " + playerPokemon2.getZMove());
                System.out.println("Type: " + playerPokemon2.getType());
                System.out.println("HP: " + playerPokemon2.getPokemonHp());
                System.out.println("Attack: " + playerPokemon2.getAttackPower());
                System.out.println("Defense: " + playerPokemon2.getDefensePower());
                System.out.println("Special Attack: " + playerPokemon2.getSpecialAttackPower());
                System.out.println("Special Defense: " + playerPokemon2.getSpecialDefensePower());
                System.out.println("\n");

                // Battle
                boolean result = battle(playerPokemon1, playerPokemon2, enemy, scanner);
                clearTerminal();
                System.out.println("Battle ended!");

                // Catch Pokemon
                if (result)
                    catchPokemon(enemy, scanner);                
            }
            else if (startBattle.equalsIgnoreCase("N"))
                System.out.println("\nBattle cancelled! Game ended.");
            else
                System.out.println("Invalid input. Try again.");
            
        } while (!(startBattle.equalsIgnoreCase("Y") || startBattle.equalsIgnoreCase("N")));

        System.out.println();
        System.out.println("Game ended! Thank you for playing Pokemon Battle!");

        
    }

    public static String login(Scanner scanner) {
        String username;

        System.out.println("Welcome to Pokemon Battle!");
        System.out.println("Please login to continue.");
        System.out.println();
        System.out.print("Username: ");
        username = scanner.next();
        clearTerminal();
        System.out.println("[" + username + "] " + "Login successful!");
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

        List<Player> player = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");
                String existingUsername = parts[0];
                int existingScore = Integer.parseInt(parts[1]);
                player.add(new Player(existingUsername, existingScore));
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        boolean found = false;

        for (Player playerScore : player) {
            if (playerScore.getUsername().equals(username)) {
                found = true;
                if (currentScore > playerScore.getScore()) {
                    playerScore.setScore(currentScore);
                    System.out.println("Congratulations! Your new high score is: " + currentScore);
                }
                else {
                    System.out.println("Your current score " + currentScore + " is not higher than your previous high score " + playerScore.getScore() + ", thus, your high score in the leaderboard remains unchanged.");
                }
                break;
            }
        }

        if (!found) {
            player.add(new Player(username, currentScore));
            System.out.println("Congratulations! Your new high score is: " + currentScore);
        }

        // Sort the list in descending order based on scores
        player.sort(Comparator.comparingInt(Player::getScore).reversed());

        // Truncate the list to contain a maximum of 5 player's scores
        player = player.subList(0, Math.min(player.size(), 5));

        try (FileWriter writer = new FileWriter(file)) {
            for (Player playerScore : player) {
                writer.write(playerScore.getUsername() + ";" + playerScore.getScore() + "\n");
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
}
