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


        pokemons.get(0).setStats(new Stats(3, 4, 4, 3, 3, 4));
        pokemons.get(1).setStats(new Stats(4, 4, 5, 4, 4, 5));
        pokemons.get(2).setStats(new Stats(3, 3, 3, 4, 4, 3));
        pokemons.get(3).setStats(new Stats(4, 4, 4, 5, 5, 4));
        pokemons.get(4).setStats(new Stats(5, 5, 5, 6, 7, 5));
        pokemons.get(5).setStats(new Stats(3, 2, 2, 3, 2, 3));
        pokemons.get(6).setStats(new Stats(3, 2, 2, 4, 2, 2));
        pokemons.get(7).setStats(new Stats(2, 3, 1, 2, 1, 4));
        pokemons.get(8).setStats(new Stats(2, 4, 2, 3, 3, 5));
        pokemons.get(9).setStats(new Stats(2, 3, 2, 2, 2, 3));
        pokemons.get(10).setStats(new Stats(3, 5, 3, 3, 3, 4));
        pokemons.get(11).setStats(new Stats(3, 4, 3, 3, 3, 6));
        pokemons.get(12).setStats(new Stats(4, 6, 6, 4, 5, 7));
        pokemons.get(13).setStats(new Stats(2, 4, 1, 4, 1, 2));
        pokemons.get(14).setStats(new Stats(3, 5, 2, 5, 2, 4));
        pokemons.get(15).setStats(new Stats(3, 3, 3, 3, 2, 3));
        System.out.println(pokemons.get(0).getStats());



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
                    PokeBall pokeball = null;
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
                                        pokeball = new PokeBall();
                                        break;
                                    case 2:
                                        System.out.println("You have selected Greatball!");
                                        pokeball = new GreatBall();
                                        break;
                                    case 3:
                                        System.out.println("You have selected Ultraball!");
                                        pokeball = new UltraBall();
                                        break;
                                    case 4:
                                        System.out.println("You have selected Masterball!");
                                        pokeball = new MasterBall();
                                        break;
                                }
                                System.out.println("You have caught " + selectedPokemons.get(0).getName() + " using " + pokeball.getBallType() + "!");
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
        







    }

    public static void initPokemon(ArrayList<Pokemon> pokemons) {

        pokemons.add(new Pokemon(1, "Charmander", 1, 10, "Fire Fang", "FIRE", "FIRE"));
        pokemons.add(new Pokemon(2, "Charmeleon", 5, 20, "Flamethrower", "FIRE", "FIRE"));
        pokemons.add(new Pokemon(3, "Squirtle", 1, 10, "Water Gun", "WATER", "WATER"));
        pokemons.add(new Pokemon(4, "Wartortle", 5, 20, "Waterfall", "WATER", "WATER"));
        pokemons.add(new Pokemon(5, "Blastoise", 10, 30, "Giant Geyser GX", "WATER", "WATER"));
        pokemons.add(new Pokemon(6, "Caterpie", 1, 10, "Gnaw", "BUG", "BUG"));
        pokemons.add(new Pokemon(7, "Metapod", 5, 20, "Bug Bite", "BUG", "BUG"));
        pokemons.add(new Pokemon(8, "Rattata", 1, 10, "Bite", "NORMAL", "NORMAL"));
        pokemons.add(new Pokemon(9, "Raticate", 5, 20, "Super Fang", "NORMAL", "NORMAL"));
        pokemons.add(new Pokemon(10, "Ekans", 1, 10, "BITE", "POISON", "POISON"));
        pokemons.add(new Pokemon(11, "Arbok", 5, 20, "Venomous Fang", "POISON", "POISON"));
        pokemons.add(new Pokemon(12, "Pikachu", 1, 10, "Thunderbolt", "ELECTRIC", "ELECTRIC"));
        pokemons.add(new Pokemon(13, "Raichu", 5, 20, "Electro Ball", "ELECTRIC", "ELECTRIC"));
        pokemons.add(new Pokemon(14, "Sandshrew", 1, 10, "Sand Tomb", "FIGHTING", "FIGHTING"));
        pokemons.add(new Pokemon(15, "Sandslash", 5, 20, "Earthquake", "FIGHTING", "FIGHTING"));
        pokemons.add(new Pokemon(16, "Nidorina", 5, 20, "Double Kick", "POISON", "POISON"));


        
    }

    public static void printStartMenu() {
        System.out.println("Welcome to Pokemon Ga-Ole!");
        System.out.println("1. Start Game");
        System.out.println("2. Exit");


    }
}
