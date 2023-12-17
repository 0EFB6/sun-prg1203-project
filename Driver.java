import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        initPokemon(pokemons);
        initPokemonStats(pokemons);
        Player player = new Player("Player", 0, 0, catchOneOfThreePokemon(pokemons, scanner));
        List<Pokemon> enemyPokemons = initEnemyPokemons(pokemons, player.getPlayerPokemon());
        startBattle(player.getPlayerPokemon(), enemyPokemons, scanner);

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
    }

    public static List<Pokemon> initEnemyPokemons (ArrayList<Pokemon> pokemons, Pokemon player) {
        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        shufflePokemons.remove(player);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> enemyPokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 2));
        return enemyPokemons;
    }

    public static Pokemon catchOneOfThreePokemon (ArrayList<Pokemon> pokemonList, Scanner scanner) {
        int pokemonCatch;
        boolean validInput = false;
        Pokemon playerSelected = null;

        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemonList);
        Collections.shuffle(shufflePokemons);
        List<Pokemon> pokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 3));

        System.out.println("Catch a Pokemon!");
        System.out.printf("1. %s [%d]\n", pokemons.get(0).getName(), pokemons.get(0).getCollectionNumber());
        System.out.printf("2. %s [%d]\n", pokemons.get(1).getName(), pokemons.get(1).getCollectionNumber());
        System.out.printf("3. %s [%d]\n", pokemons.get(2).getName(), pokemons.get(2).getCollectionNumber());
        
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

        return playerSelected;
    }

    public static boolean battle(Pokemon player, List<Pokemon> enemy, Scanner scanner) {
        Random random = new Random();
        String attackType;

        while (player.getPokemonHp() > 0 && (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)) {
                    System.out.println("\nYour Pokemon: " + player.getName());
                    System.out.println("Choose an enemy to attack:");
                    System.out.println("1. " + enemy.get(0).getName() + " (HP: " +       enemy.get(0).getPokemonHp() + ")");
                    System.out.println("2. " + enemy.get(1).getName() + " (HP: " +       enemy.get(1).getPokemonHp() + ")");
                    System.out.print("Enter your choice (1 or 2): ");

                    try {
                        int choice = scanner.nextInt();

                        if (choice == 1 || choice == 2) {
                            Pokemon selectedEnemy = enemy.get(choice - 1);
                            if (selectedEnemy.getPokemonHp() <= 0) {
                                System.out.println("Enemy has died. Try again.\n");
                                continue;
                            }

                            System.out.println();
                            System.out.println("1. Normal Attack [N]");
                            System.out.println("2. Special Attack [S]");
                            System.out.print("Enter your attack type [N/S]: ");
                            attackType = scanner.next();

                            if (attackType.equalsIgnoreCase("s"))
                                player.attack(selectedEnemy, "special");
                            else if (attackType.equalsIgnoreCase("n"))
                                player.attack(selectedEnemy, "normal");
                            else
                                continue;

                            // Display updated stats
                            player.printPlayer();
                            player.printEnemy(enemy.get(0));
                            player.printEnemy(enemy.get(1));
                            System.out.println("\n");

                            if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0)
                            {
                                System.out.println("You win haha! Congratulations!!!");
                                return true;
                            }

                            // Random enemy attacks the player
                            if (enemy.get(0).getPokemonHp() > 0 && enemy.get(1).getPokemonHp() > 0)
                            {
                                Pokemon randomEnemy = enemy.get(random.nextInt(2));

                                randomEnemy.attack(player, "special");

                                // Display updated stats
                                player.printPlayer();
                                player.printEnemy(enemy.get(0));
                                player.printEnemy(enemy.get(1));
                            }
                            else if (enemy.get(0).getPokemonHp() > 0 || enemy.get(1).getPokemonHp() > 0)
                            {
                                if (enemy.get(0).getPokemonHp() > 0)
                                    enemy.get(0).attack(player, "special");
                                else if (enemy.get(1).getPokemonHp() > 0)
                                    enemy.get(1).attack(player, "special");

                                // Display updated stats
                                player.printPlayer();
                                player.printEnemy(enemy.get(0));
                                player.printEnemy(enemy.get(1));
                            }
                        }
                        else {
                            System.out.println("Invalid choice. Try again.\n");
                        }
                    }
                    catch (Exception e) {
                        System.out.println("Enter integers 1 or 2 ONLY!");
                        scanner.nextLine(); // Clear the input buffer
                    }
        }

        if (player.getPokemonHp() <= 0 && enemy.get(0).getPokemonHp() > 0 && enemy.get(1).getPokemonHp() > 0)
        {
            System.out.println("You lose. Game Over!");
            return false;
        }
        
        System.out.println("You win! Congratulations!!!");
        return true;
    }

    public static void  catchPokemon(List<Pokemon> enemy, Scanner scanner) {
        Catch catchPokeball = null;
        int pokeballChoice = 0;
        int pokemonChoice = 0;
        boolean validInput2 = false;

        if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() <= 0)
        {
            System.out.println("Select a pokemon to catch: ");
            System.out.println("1. " + enemy.get(0).getName());
            System.out.println("2. " + enemy.get(1).getName());
            System.out.print("Enter your choice (1 or 2): ");
            pokemonChoice = scanner.nextInt();
        }
        else if (enemy.get(0).getPokemonHp() <= 0 && enemy.get(1).getPokemonHp() > 0)
            pokemonChoice = 1;
        else if (enemy.get(1).getPokemonHp() <= 0 && enemy.get(0).getPokemonHp() > 0)
            pokemonChoice = 2;
        System.out.println();
        System.out.println("Use a Pokeball to catch " + enemy.get(pokemonChoice - 1).getName() + "!");
        System.out.println();
        System.out.println("Select a pokeball: ");
        System.out.println("1. Pokeball");
        System.out.println("2. Greatball");
        System.out.println("3. Ultraball");
        System.out.println("4. Masterball");
        
        do {
            System.out.print("Enter your choice (1-4): ");
            try {
                pokeballChoice = scanner.nextInt();
                if (pokeballChoice >= 1 && pokeballChoice <= 4)
                {
                    validInput2 = true;
                    
                    switch (pokeballChoice) {
                        case 1:
                            System.out.println("You have selected Pokeball!");
                            catchPokeball = new Catch(new PokeBall(), 25);
                            break;
                        case 2:
                            System.out.println("You have selected Greatball!");
                            catchPokeball = new Catch(new GreatBall(), 50);
                            break;
                        case 3:
                            System.out.println("You have selected Ultraball!");
                            catchPokeball = new Catch(new UltraBall(), 75);
                            break;
                        case 4:
                            System.out.println("You have selected Masterball!");
                            catchPokeball = new Catch(new MasterBall(), 100);
                            break;
                    }
                    System.out.println();
                    catchPokeball.catchPokeball(enemy.get(pokemonChoice - 1));
                }
                else
                    System.out.println("Enter integers ranging from 1 to 4 ONLY!");
            }
            catch (Exception e) {
                System.out.println("Enter integers ranging from 1 to 4 ONLY!" + e);
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!validInput2);



    }

    public static void startBattle(Pokemon player, List<Pokemon> enemy, Scanner scanner) {
        String startBattle;
        
        System.out.println("\nIt's time for battle! Get ready!");
        System.out.println("You have selected " + player.getName() + "!");
        System.out.println("Your first opponent is " + enemy.get(0).getName() + "!");
        System.out.println("Your second opponent is " + enemy.get(1).getName() + "!");

        do {
            System.out.print("Start battle? [Y/N]");
            startBattle = scanner.next();

            if (startBattle.equalsIgnoreCase("Y"))
            {
                System.out.println();
                System.out.println("Battle started!");
                System.out.println("First opponent is " + enemy.get(0));
                System.out.println("Second opponent is " + enemy.get(1));
                System.out.println("\nYour " + player);

                // Battle
                boolean result = battle(player, enemy, scanner);
                System.out.println("Battle ended!");

                // Catch Pokemon
                if (result)
                    catchPokemon(enemy, scanner);                
            }
            else if (startBattle.equalsIgnoreCase("N"))
                System.out.println("Battle cancelled! Game ended.");
            
        } while (!(startBattle.equalsIgnoreCase("Y") || startBattle.equalsIgnoreCase("N")));
    }
}
