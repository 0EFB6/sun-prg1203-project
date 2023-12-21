import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameOperation {
    // Methods
    private static Pokemon catchOneOfThreePokemon (ArrayList<Pokemon> pokemonList, Scanner scanner) {
        int pokemonCatch;
        boolean validInput = false;
        Pokemon playerSelected = null;

        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemonList);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> pokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 3));

        System.out.println("Catch a Pokemon!");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.printf("%d. %s [%s]\n", i + 1, pokemons.get(i).getName(), pokemons.get(i).getType());
        }

        do {
            System.out.print("Enter your choice [1-3]: ");
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
                scanner.nextLine();
            }
        } while (!validInput);

        GameUtil.clearTerminal();
        return playerSelected;
    }

    private static Player initializePlayer(ArrayList<Pokemon> pokemons, Scanner scanner) {
        String username = GameUtil.login(scanner);
        Pokemon selectedPokemon = catchOneOfThreePokemon(pokemons, scanner);
        return new Player(username, 0, selectedPokemon);
    }

    private static double calculateScore(double player1Hp, double player2Hp) {
        if (player1Hp <= 0 && player2Hp <= 0)
            return -1;
        else if (player1Hp <= 0 && player2Hp > 0)
            return player2Hp;
        else if (player1Hp > 0 && player2Hp <= 0)
            return player1Hp;
        else
            return player1Hp + player2Hp;
    }

    public static void startGame(Scanner scanner) {
        List<Pokemon> enemyPokemons;
        List<Pokemon> playerPokemons;
        ArrayList<Pokemon> pokemons = GameInit.initPokemon();
        Player player = initializePlayer(pokemons, scanner);

        do {
            enemyPokemons = GameInit.initEnemyPokemons(pokemons, player.getPlayerPokemon1());
            playerPokemons = GameInit.initPlayerPokemons(pokemons, enemyPokemons, player.getPlayerPokemon1());
            player.setPlayerPokemon2(playerPokemons.get(0));
        } while (!GameValidation.validateBattle(player.getPlayerPokemon1(), player.getPlayerPokemon2(), enemyPokemons));

        startBattle(player.getPlayerPokemon1(), player.getPlayerPokemon2(), enemyPokemons, scanner);
        
        double playerPokemon1Hp = player.getPlayerPokemon1().getPokemonHp();
        double playerPokemon2Hp = player.getPlayerPokemon2().getPokemonHp();
        player.setScore((int) calculateScore(playerPokemon1Hp, playerPokemon2Hp));

        if (player.getScore() == -1)
            System.out.println("You lose. Game Over!\nYour score will not be saved!\n");
        else
            System.out.println("Your score is: " + player.getScore() + "  System is updating your score...");

        GameUtil.updatePlayerScore(player.getUsername(), player.getScore());   
    }

    public static void startBattle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy, Scanner scanner) {
        String startBattle;        
        System.out.println("It's time for battle! Get ready!\n");
        System.out.println("[Your Selection 1] " + playerPokemon1.getName());
        System.out.println("[Your Selection 2] " + playerPokemon2.getName() + "\n");
        System.out.println("[Opponent 1] " + enemy.get(0).getName());
        System.out.println("[Opponent 2] " + enemy.get(1).getName() + "\n");

        do {
            System.out.print("Start battle? [Y/N]");
            startBattle = scanner.next();

            if (startBattle.equalsIgnoreCase("Y"))
            {
                // Battle
                printBattleDetails(playerPokemon1, playerPokemon2, enemy);
                boolean result = battle(playerPokemon1, playerPokemon2, enemy, scanner);
                GameUtil.clearTerminal();
                
                if (!result)
                {
                    System.out.println("You failed to defeat any pokemon! Don't worry, extra battle may occur!");
                    GameUtil.wait(1500);
                    Random random = new Random();
                    int extraBattle = random.nextInt(2);
                    if (extraBattle == 1)
                    {
                        System.out.println("Extra battle occured! Starting in 3 ... 2 ... 1 ...");
                        GameUtil.wait(3000);
                        playerPokemon1.increaseHp(6);
                        playerPokemon2.increaseHp(6);
                        result = battle(playerPokemon1, playerPokemon2, enemy, scanner);
                    }
                    else
                    {
                        System.out.println("No extra battle occured! So sad...");
                        GameUtil.wait(2000);
                    }
                }
                System.out.println("Battle ended!");

                // Catch Pokemon
                if (result)
                    catchPokemon(enemy, scanner);                
            }
            else if (startBattle.equalsIgnoreCase("N"))
            {
                System.out.println("\nBattle cancelled! Game ended.");
                System.exit(0);
            }
            else
                System.out.println("Invalid input. Try again.");
            
        } while (!(startBattle.equalsIgnoreCase("Y") || startBattle.equalsIgnoreCase("N")));

        System.out.println("\nGame ended! Thank you for playing Pokemon Battle!");
    }

    public static void printBattleDetails(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy) {
        GameUtil.clearTerminal();
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
    }

    public static boolean battle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy, Scanner scanner) {
        Random random = new Random();
        String attackType;
        int choicePlayer = 0;

        while ((playerPokemon1.getPokemonHp() > 0 || playerPokemon2.getPokemonHp() > 0) && (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)) {
                int choice = getEnemyChoice(scanner, enemy);
                
                Pokemon selectedEnemy = enemy.get(choice - 1);
                if (isEnemyDead(selectedEnemy))
                    continue;
                
                choicePlayer = getPlayerPokemonChoice(scanner, playerPokemon1, playerPokemon2);
                attackType = getAttackType(scanner);

                if (isPlayerPokemonDead(choicePlayer, playerPokemon1, playerPokemon2))
                    continue;
                if (attackType.equalsIgnoreCase("s"))
                    attackEnemy(playerPokemon1, playerPokemon2, selectedEnemy, choicePlayer, "special"); // Attack enemy with special attack
                else if (attackType.equalsIgnoreCase("n"))
                    attackEnemy(playerPokemon1, playerPokemon2, selectedEnemy, choicePlayer, "normal"); // Attack enemy with normal attack
                else
                    continue;
                
                if (handleVictory(enemy)) // Detect if all enemies are defeated and handle victory
                    return true;                    
                enemyAttackPlayer(random, playerPokemon1, playerPokemon2, enemy); // Random enemy attacks the player
        }

        if (handlePlayerDefeat(playerPokemon1, playerPokemon2, enemy))
            return false;
        handleVictory();
        return true;
    }

    public static void  catchPokemon(List<Pokemon> enemy, Scanner scanner) {
        Catch catchPokeball = null;
        int pokemonChoice = 0;

        if (isBothPokemonDefeated(enemy))
        {
            do {
                try {
                    System.out.println("Select a pokemon to catch: ");
                    System.out.println("1. " + enemy.get(0).getName());
                    System.out.println("2. " + enemy.get(1).getName());
                    System.out.print("Enter your choice (1 or 2): ");
                    pokemonChoice = scanner.nextInt();
                
                    if (pokemonChoice < 1 || pokemonChoice > 2)
                        throw new IllegalArgumentException();                
                }
                catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine();
                }
                catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice. Please enter 1 or 2.");
                    scanner.nextLine();
                }
            } while (pokemonChoice < 1 || pokemonChoice > 2);
        }
        else if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() > 0)
        {
            printDefeatedPokemonMessage(enemy.get(0));
            pokemonChoice = 1;
        }
        else if (enemy.get(1).getPokemonHp() <= 0 && enemy.get(0).getPokemonHp() > 0)
        {
            printDefeatedPokemonMessage(enemy.get(1));
            pokemonChoice = 2;
        }

        if (pokemonChoice == 1 || pokemonChoice == 2)
        {
            System.out.println();
            System.out.println("Use a Pokeball to catch " + enemy.get(pokemonChoice - 1).getName() + "!\n");
            System.out.println("[System is selecting a random Pokeball...]\n");

            GameUtil.wait(1500);
            catchPokeball = new Catch((new Random().nextInt(4)) + 1);
            System.out.println("Pokeball " + catchPokeball.getPokeBall().getBallType() + " selected!\n");
            System.out.println("[Catching in 3 ... 2 ... 1 ...]");
            GameUtil.wait(3000);
            catchPokeball.catchPokeball(enemy.get(pokemonChoice - 1));
        }
        else
            System.out.println("[ERROR] Fail to catch pokemon using pokeball!");
    }

    private static boolean isBothPokemonDefeated(List<Pokemon> enemy) {
        return enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0;
    }

    private static boolean isEnemyDead(Pokemon selectedEnemy) {
        if (selectedEnemy.getPokemonHp() <= 0) {
            System.out.println("\nEnemy has died. Try again.");
            return true;
        }
        return false;
    }

    private static boolean isPlayerPokemonDead(int choicePlayer, Pokemon playerPokemon1, Pokemon playerPokemon2) {
        if ((choicePlayer == 1 && playerPokemon1.getPokemonHp() <= 0) || (choicePlayer == 2 && playerPokemon2.getPokemonHp() <= 0)) {
            System.out.println("Your pokemon has died. Try again.");
            return true;
        }
        return false;
    }

    private static boolean isPokemonsAlive(Pokemon pokemon)
    {
        return pokemon.getPokemonHp() > 0;
    }

    private static void displayStatsInfo(Pokemon one, Pokemon two, List<Pokemon> enemy)
    {
        System.out.println();
        one.printPlayer();
        two.printPlayer();
        System.out.println();
        one.printEnemy(enemy.get(0));
        one.printEnemy(enemy.get(1));
    }

    private static void printDefeatedPokemonMessage(Pokemon pokemon) {
        System.out.println();
        System.out.println("You may only catch one pokemon as you only defeated " + pokemon.getName() + "!");
    }

    private static int getEnemyChoice(Scanner scanner, List<Pokemon> enemy) {
        System.out.println();
        System.out.println("1. " + enemy.get(0).getName() + " [" + enemy.get(0).getPokemonHp() + "]");
        System.out.println("2. " + enemy.get(1).getName() + " [" + enemy.get(1).getPokemonHp() + "]");
        System.out.print("Select an enemy to attack [1/2]: ");
        try {
            int choice = scanner.nextInt();
            if (choice != 1 && choice != 2) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                return getEnemyChoice(scanner, enemy);
            }
            return choice;
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            return getEnemyChoice(scanner, enemy);
        }
    }

    private static int getPlayerPokemonChoice(Scanner scanner, Pokemon playerPokemon1, Pokemon playerPokemon2)
    {
        System.out.println();
        System.out.println("1. " + playerPokemon1.getName() + " [HP: " + playerPokemon1.getPokemonHp() + "]");
        System.out.println("2. " + playerPokemon2.getName() + " [HP: " + playerPokemon2.getPokemonHp() + "]");
        System.out.print("Select a pokemon to use [1/2]: ");
        try {
            int choicePlayer = scanner.nextInt();
            if (choicePlayer != 1 && choicePlayer != 2) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                return getPlayerPokemonChoice(scanner, playerPokemon1, playerPokemon2);
            }
            return choicePlayer;
        }
        catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            scanner.next();
            return getPlayerPokemonChoice(scanner, playerPokemon1, playerPokemon2);
        }
    }

    private static String getAttackType(Scanner scanner)
    {
        System.out.println();
        System.out.println("1. Normal Attack [N]");
        System.out.println("2. Special Attack [S]");
        System.out.print("Select an attack type [N/S]: ");
        String attackType = scanner.next();
        GameUtil.clearTerminal();
        return attackType;
    }

    private static void attackEnemy(Pokemon playerPokemon1, Pokemon playerPokemon2, Pokemon selectedEnemy, int choicePlayer, String attackType)
    {
        System.out.print("[YOU ---> ENEMY] ");
        if (choicePlayer == 1)
            playerPokemon1.attack(selectedEnemy, "special");
        else if (choicePlayer == 2)
            playerPokemon2.attack(selectedEnemy, "special");
    }

    private static void enemyAttackPlayer(Random random, Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy)
    {
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
            displayStatsInfo(playerPokemon1, playerPokemon2, enemy);
        }
        else if (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)
        {
            if (enemy.get(0).getPokemonHp() > 0)
            {
                if (randomEnemyAttack == 0 && isPokemonsAlive(playerPokemon1))
                    enemy.get(0).attack(playerPokemon1, "normal");
                else if (randomEnemyAttack == 0 && isPokemonsAlive(playerPokemon2))
                    enemy.get(0).attack(playerPokemon2, "normal");
                else if (randomEnemyAttack == 1 && isPokemonsAlive(playerPokemon1))
                    enemy.get(0).attack(playerPokemon1, "special");
                else if (randomEnemyAttack == 1 && isPokemonsAlive(playerPokemon2))
                    enemy.get(0).attack(playerPokemon2, "special");
            }
            else if (enemy.get(1).getPokemonHp() > 0)
            {
                if (randomEnemyAttack == 0 && isPokemonsAlive(playerPokemon1))
                    enemy.get(1).attack(playerPokemon1, "normal");
                else if (randomEnemyAttack == 0 && isPokemonsAlive(playerPokemon2))
                    enemy.get(1).attack(playerPokemon2, "normal");
                else if (randomEnemyAttack == 1 && isPokemonsAlive(playerPokemon1))
                    enemy.get(1).attack(playerPokemon1, "special");
                else if (randomEnemyAttack == 1 && isPokemonsAlive(playerPokemon2))
                    enemy.get(1).attack(playerPokemon2, "special");
            }
            displayStatsInfo(playerPokemon1, playerPokemon2, enemy);
        }
    }

    private static void handleVictory()
    {
            GameUtil.clearTerminal();
            System.out.println("You win! Congratulations!!! Catching pokemon in 3 ... 2 ... 1 ...");
            GameUtil.wait(3000);
    }
    
    private static boolean handleVictory(List<Pokemon> enemy)
    {
        if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0)
        {
            GameUtil.clearTerminal();
            System.out.println("You win! Congratulations!!! Catching pokemon in 3 ... 2 ... 1 ...");
            GameUtil.wait(3000);
            return true;
        }
        return false;
    }

    private static boolean handlePlayerDefeat(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy)
    {
        if (playerPokemon1.getPokemonHp() <= 0 && playerPokemon2.getPokemonHp() <= 0 && (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0))
        {
            GameUtil.clearTerminal();
            System.out.println("You lose. Game Over!");
            GameUtil.wait(1500);
            return true;
        }
        return false;
    }
}