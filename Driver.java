import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // PokeBall pb1 = new PokeBall("Wilson");
        // System.out.println(pb1);

        // Catch c1 = new Catch(pb1, true, 10.1);
        // System.out.println(c1);

        printStartMenu();
        
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        initPokemon(pokemons);
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon);
        }

        PokeBall pokeBall = new PokeBall();
        System.out.println(pokeBall);

        GreatBall greatBall = new GreatBall();
        System.out.println(greatBall);

        UltraBall ultraBall = new UltraBall();
        System.out.println(ultraBall);

        MasterBall masterBall = new MasterBall();
        System.out.println(masterBall);


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
        // System.out.println(pokemons.get(0).getStats());

        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getStats());
        }



        System.out.println("\n==========================================================================================================");
        System.out.println("==========================================================================================================\n");

        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        Collections.shuffle(shufflePokemons);
        // Select the first 3 elements after shuffling
        List<Pokemon> selectedPokemons = shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 3));
        // Display selected elements
        for (Pokemon elem : selectedPokemons) {
            System.out.println("Selected element: " + elem);
        }


        System.out.println("Catch a Pokemon!");
        System.out.printf("1. %s [%d]\n", selectedPokemons.get(0).getName(), selectedPokemons.get(0).getCollectionNumber());
        System.out.printf("2. %s [%d]\n", selectedPokemons.get(1).getName(), selectedPokemons.get(1).getCollectionNumber());
        System.out.printf("3. %s [%d]\n", selectedPokemons.get(2).getName(), selectedPokemons.get(2).getCollectionNumber());

        int pokemonCatch;
        boolean validInput = false;
        Pokemon playerSelected = null;
        do {
            System.out.print("Enter your choice (1-3): ");
            try {
                pokemonCatch = scanner.nextInt();
                if (pokemonCatch >= 1 && pokemonCatch <= 3)
                {
                    validInput = true;
                    playerSelected = selectedPokemons.get(pokemonCatch - 1);
                    selectedPokemons.remove(pokemonCatch - 1);
                }
                else
                    System.out.println("Enter integers ranging from 1 to 3 ONLY!");
            }
            catch (Exception e) {
                System.out.println("Enter integers ranging from 1 to 3 ONLY!");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (!validInput);

        System.out.println("You have selected " + playerSelected.getName() + "!");
        for (Pokemon elem : selectedPokemons) {
            System.out.println("Selected element: " + elem);
        }
        
        System.out.println("It's time for battle! Get ready!");
        System.out.println("You have selected " + playerSelected.getName() + "!");
        System.out.println("Your first opponent is " + selectedPokemons.get(0).getName() + "!");
        System.out.println("Your second opponent is " + selectedPokemons.get(1).getName() + "!");

        String startBattle;
        do {
            System.out.print("Start battle? [Y/N]");
            startBattle = scanner.next();
            if (startBattle.equalsIgnoreCase("Y")) {
                System.out.println("Battle started!");
                System.out.println("First opponent: " + selectedPokemons.get(0));
                System.out.println("Second opponent is " + selectedPokemons.get(1));
                System.out.println("\nYour Pokemon: " + playerSelected);

                // Battle here

                System.out.println("Battle ended!");
                System.out.println("You have won the battle!");
                System.out.println("Use a Pokeball to catch " + selectedPokemons.get(0).getName() + "!");
                System.out.print("Select a pokeball? [Y/N]");
                String selectPokeball = scanner.next();
                if (selectPokeball.equalsIgnoreCase("Y")) {
                    System.out.println("Select a pokeball: ");
                    System.out.println("1. Pokeball");
                    System.out.println("2. Greatball");
                    System.out.println("3. Ultraball");
                    System.out.println("4. Masterball");

                    Catch catchPokeball = null;
                    int pokeballChoice;
                    boolean validInput2 = false;
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
                                        catchPokeball = new Catch(new PokeBall(), 50);

                                        break;
                                    case 3:
                                        System.out.println("You have selected Ultraball!");
                                        catchPokeball = new Catch(new PokeBall(), 75);
                                        break;
                                    case 4:
                                        System.out.println("You have selected Masterball!");
                                        catchPokeball = new Catch(new PokeBall(), 100);
                                        break;
                                }
                                catchPokeball.catchPokeball(selectedPokemons.get(0));
                            }
                            else
                                System.out.println("Enter integers ranging from 1 to 4 ONLY!");
                        }
                        catch (Exception e) {
                            System.out.println("Enter integers ranging from 1 to 4 ONLY!");
                            scanner.nextLine(); // Clear the input buffer
                        }
                    } while (!validInput2);

                    
                    
                }
                else if (selectPokeball.equalsIgnoreCase("N")) {
                    System.out.println("You have cancelled the battle!");
                }

                
            }
            else if (startBattle.equalsIgnoreCase("N")) {
                System.out.println("Battle cancelled! Game ended.");
            }               
            
        } while (!(startBattle.equalsIgnoreCase("Y") || startBattle.equalsIgnoreCase("N")));

        

        FirePokemon firePokemon = new FirePokemon(1, "Charmander", 1, 10, "Fire Fang", "FIRE");
        firePokemon.setStats(new Stats(15, 2, 3, 3, 3, 4));
        System.out.println(selectedPokemons.get(random.nextInt(2)));
        System.out.println(firePokemon);
        firePokemon.attack(selectedPokemons.get(random.nextInt(2)), "special");


        Pokemon temporaryEnemy = selectedPokemons.get(random.nextInt(2));
        System.out.println(temporaryEnemy);
        temporaryEnemy.attack(firePokemon, "special");

        System.out.println(selectedPokemons.get(0));
        System.out.println(selectedPokemons.get(1));
        System.out.println(firePokemon);

        
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

    public static void printStartMenu() {
        System.out.println("Welcome to Pokemon Ga-Ole!");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");


    }
}
