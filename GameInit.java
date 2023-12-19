import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameInit {
    // Methods
    public static ArrayList<Pokemon> initPokemon() {
        ArrayList<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new FirePokemon(1, "Charmander", 1, 10, "Fire Fang", "FIRE"));
        pokemons.add(new FirePokemon(2, "Charmeleon", 5, 20, "Flamethrower", "FIRE"));
        pokemons.add(new WaterPokemon(3, "Squirtle", 1, 10, "Water Gun", "WATER"));
        pokemons.add(new WaterPokemon(4, "Wartortle", 5, 20, "Waterfall", "WATER"));
        pokemons.add(new WaterPokemon(5, "Blastoise", 10, 30, "Giant Geyser GX", "WATER"));
        pokemons.add(new BugPokemon(6, "Caterpie", 1, 10, "Gnaw", "BUG"));
        pokemons.add(new BugPokemon(7, "Metapod", 5, 20, "Bug Bite", "BUG"));
        pokemons.add(new Pokemon(8, "Rattata", 1, 10, "Bite", "NORMAL", PokemonType.NORMAL));
        pokemons.add(new Pokemon(9, "Raticate", 5, 20, "Super Fang", "NORMAL", PokemonType.NORMAL));
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
        initPokemonStats(pokemons);
        return pokemons;
    }

    public static void initPokemonStats(ArrayList<Pokemon> pokemons) {
        pokemons.get(0).setStats(new Stats(15, 4, 4, 2, 3, 4));
        pokemons.get(1).setStats(new Stats(20, 4, 5, 3, 4, 5));
        pokemons.get(2).setStats(new Stats(15, 3, 3, 3, 4, 3));
        pokemons.get(3).setStats(new Stats(20, 4, 4, 4, 5, 4));
        pokemons.get(4).setStats(new Stats(25, 5, 5, 5, 7, 5));
        pokemons.get(5).setStats(new Stats(15, 3, 4, 2, 2, 3));
        pokemons.get(6).setStats(new Stats(15, 3, 4, 3, 2, 2));
        pokemons.get(7).setStats(new Stats(10, 3, 5, 1, 1, 4));
        pokemons.get(8).setStats(new Stats(10, 4, 3, 2, 3, 5));
        pokemons.get(9).setStats(new Stats(10, 3, 2, 1, 2, 3));
        pokemons.get(10).setStats(new Stats(15, 5, 3, 2, 3, 4));
        pokemons.get(11).setStats(new Stats(15, 4, 3, 2, 3, 6));
        pokemons.get(12).setStats(new Stats(20, 6, 6, 3, 5, 7));
        pokemons.get(13).setStats(new Stats(10, 4, 1, 3, 1, 2));
        pokemons.get(14).setStats(new Stats(15, 5, 2, 4, 2, 4));
        pokemons.get(15).setStats(new Stats(15, 3, 3, 3, 2, 3));
        pokemons.get(16).setStats(new Stats(25, 5, 5, 4, 6, 6));
        pokemons.get(17).setStats(new Stats(25, 5, 6, 4, 5, 5));
        pokemons.get(18).setStats(new Stats(15, 5, 7, 4, 5, 4));
        pokemons.get(19).setStats(new Stats(10, 4, 2, 2, 2, 4));
    }

    public static List<Pokemon> initEnemyPokemons (ArrayList<Pokemon> pokemons, Pokemon player) {
        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        shufflePokemons.remove(player);
        Collections.shuffle(shufflePokemons);
        return shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 2));
    }

    public static List<Pokemon> initPlayerPokemons (ArrayList<Pokemon> pokemons, List<Pokemon> enemy, Pokemon player) {
        ArrayList<Pokemon> shufflePokemons = new ArrayList<>(pokemons);
        shufflePokemons.remove(enemy.get(0));
        shufflePokemons.remove(enemy.get(1));
        shufflePokemons.remove(player);
        Collections.shuffle(shufflePokemons);
        return shufflePokemons.subList(0, Math.min(shufflePokemons.size(), 1));
    }
}