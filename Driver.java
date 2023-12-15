import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {

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

        pokemons.get(0).setStats(new Stats(100, 20, 5, 10, 6));
        System.out.println(pokemons.get(0).getStats());


    }

    public static void initPokemon(ArrayList<Pokemon> pokemons) {
        pokemons.add(new Pokemon(1, "Bulbasaur", 1, 10, "Razor leaf", "GRASS", "GRASS","POISON"));
        pokemons.add(new Pokemon(2, "Ivysaur", 5, 20, "Toxic Whip", "GRASS", "GRASS","POISON"));
        pokemons.add(new Pokemon(3, "Venusaur", 10, 30, "Evergreen GX", "GRASS", "GRASS","POISON"));
        pokemons.add(new Pokemon(4, "Charmander", 1, 10, "Fire Fang", "FIRE", "FIRE"));
        pokemons.add(new Pokemon(5, "Charmeleon", 5, 20, "Flamethrower", "FIRE", "FIRE"));
        pokemons.add(new Pokemon(6, "Charizard", 10, 30, "Raging OUT", "FIRE", "FIRE","FLYING"));
        pokemons.add(new Pokemon(7, "Squirtle", 1, 10, "Water Gun", "WATER", "WATER"));
        pokemons.add(new Pokemon(1, "Wartortle", 5, 20, "Waterfall", "WATER", "WATER"));
        pokemons.add(new Pokemon(9, "Blastoise", 10, 30, "Giant Geyser GX", "WATER", "WATER"));
        pokemons.add(new Pokemon(10, "Caterpie", 1, 10, "Gnaw", "NORMAL", "BUG"));
        pokemons.add(new Pokemon(11, "Metapod", 5, 20, "Bug Bite", "NORMAL", "BUG"));
        pokemons.add(new Pokemon(12, "Butterfree", 10, 30, "Whirlwind", "NORMAL", "BUG","FLYING"));
        pokemons.add(new Pokemon(13, "Weedle", 1, 10, "String Shot", "GRASS", "BUG","POISON"));
        pokemons.add(new Pokemon(14, "Kakuna", 5, 20, "Harden", "GRASS", "BUG","POISON"));
        pokemons.add(new Pokemon(15, "Beedrill", 10, 30, "Pin Missile", "GRASS", "BUG","POISON"));
        pokemons.add(new Pokemon(16, "Pidgey", 1, 10, "Pick Off", "NORMAL", "NORMAL","FLYING"));
        pokemons.add(new Pokemon(17, "Pidgeotto", 5, 20, "Ambush", "NORMAL", "NORMAL","FLYING"));
        pokemons.add(new Pokemon(18, "Pidgeot", 10, 30, "Strong Gust", "NORMAL", "NORMAL","FLYING"));
        pokemons.add(new Pokemon(19, "Rattata", 1, 10, "Bite", "DARK", "NORMAL"));
        pokemons.add(new Pokemon(20, "Raticate", 5, 20, "Super Fang", "NORMAL", "NORMAL"));
        pokemons.add(new Pokemon(21, "Spearow", 1, 10, "Peck", "NORMAL", "NORMAL","FLYING"));
        pokemons.add(new Pokemon(22, "Fearow", 5, 20, "Nosedive", "NORMAL", "NORMAL","FLYING"));
        pokemons.add(new Pokemon(23, "Ekans", 1, 10, "BITE", "NORMAL", "POISON"));
        pokemons.add(new Pokemon(24, "Arbok", 5, 20, "Venomous Fang", "POISON", "POISON"));
        pokemons.add(new Pokemon(25, "Pikachu", 1, 10, "Thunderbolt", "ELECTRIC", "ELECTRIC"));
        pokemons.add(new Pokemon(26, "Raichu", 5, 20, "Electro Ball", "ELECTRIC", "ELECTRIC"));
        pokemons.add(new Pokemon(27, "Sandshrew", 1, 10, "Sand Tomb", "FIGHTING", "FIGHTING"));
        pokemons.add(new Pokemon(28, "Sandslash", 5, 20, "Earthquake", "FIGHTING", "FIGHTING"));
        pokemons.add(new Pokemon(29, "Nidorina", 5, 20, "Double Kick", "POISON", "POISON"));
        pokemons.add(new Pokemon(30, "Nidoqueen", 10, 30, "Double Stomp", "POISON", "POISON","GROUND"));
    }

    public static void printStartMenu() {
        System.out.println("Welcome to Pokemon Ga-Ole!");
    }
}
