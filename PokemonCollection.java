package Assignment;

import java.util.ArrayList;

public class PokemonCollection {
	Pokemon[] pokemon = new Pokemon[20];
	public Pokemon[] getAllPokemon () {

		pokemon[0] = new FirePokemon(1, "Charmander", 1, 10, "Fire Fang", "FIRE");
		pokemon[1] = new FirePokemon(2, "Charmeleon", 5, 20, "Flamethrower", "FIRE");
		pokemon[2] = new WaterPokemon(3, "Squirtle", 1, 10, "Water Gun", "WATER");
		pokemon[3] = new WaterPokemon(4, "Wartortle", 5, 20, "Waterfall", "WATER");
		pokemon[4] = new WaterPokemon(5, "Blastoise", 10, 30, "Giant Geyser GX", "WATER");
		pokemon[5] = new BugPokemon(6, "Caterpie", 1, 10, "Gnaw", "BUG");
		pokemon[6] = new BugPokemon(7, "Metapod", 5, 20, "Bug Bite", "BUG");
		pokemon[7] = new Pokemon(8, "Rattata", 1, 10, "Bite", "NORMAL", "NORMAL");
		pokemon[8] = new Pokemon(9, "Raticate", 5, 20, "Super Fang", "NORMAL", "NORMAL");
		pokemon[9] = new PoisonPokemon(10, "Ekans", 1, 10, "BITE", "POISON");
		pokemon[10] = new PoisonPokemon(11, "Arbok", 5, 20, "Venomous Fang", "POISON");
		pokemon[11] = new ElectricPokemon(12, "Pikachu", 1, 10, "Thunderbolt", "ELECTRIC");
		pokemon[12] = new ElectricPokemon(13, "Raichu", 5, 20, "Electro Ball", "ELECTRIC");
		pokemon[13] = new FightingPokemon(14, "Sandshrew", 1, 10, "Sand Tomb", "FIGHTING");
		pokemon[14] = new FightingPokemon(15, "Sandslash", 5, 20, "Earthquake", "FIGHTING");
		pokemon[15] = new PoisonPokemon(16, "Nidorina", 5, 20, "Double Kick", "POISON");
		pokemon[16] = new FirePokemon(17, "Ninetales", 3, 30, "Flash Fire", "FIRE");
		pokemon[17] = new WaterPokemon(18, "Golduck", 4,15, "Cloud Nine", "WATER");
		pokemon[18] = new WaterPokemon(19, "Mega Blastoise", 5, 20, "Hydro Pump", "WATER");
		pokemon[19] = new FightingPokemon(20, "Mankey", 5, 20, "Karate Chop", "FIGHTING");
		initPokemonStats();
	
		return pokemon;
	}
	
	 public  void initPokemonStats() {
	        pokemon[0].setStats(new Stats(15, 4, 4, 1, 2, 4));
	        pokemon[1].setStats(new Stats(20, 4, 5, 2, 3, 5));
	        pokemon[2].setStats(new Stats(15, 3, 3, 2, 3, 3));
	        pokemon[3].setStats(new Stats(20, 4, 4, 3, 4, 4));
	        pokemon[4].setStats(new Stats(25, 5, 5, 4, 6, 5));
	        pokemon[5].setStats(new Stats(15, 3, 4, 1, 2, 3));
	        pokemon[6].setStats(new Stats(15, 3, 4, 2, 2, 2));
	        pokemon[7].setStats(new Stats(10, 3, 5, 1, 1, 4));
	        pokemon[8].setStats(new Stats(10, 4, 3, 1, 2, 5));
	        pokemon[9].setStats(new Stats(10, 3, 2, 1, 2, 3));
	        pokemon[10].setStats(new Stats(15, 5, 3, 1, 3, 4));
	        pokemon[11].setStats(new Stats(15, 4, 3, 1, 3, 6));
	        pokemon[12].setStats(new Stats(20, 6, 6, 2, 4, 7));
	        pokemon[13].setStats(new Stats(10, 4, 1, 2, 1, 2));
	        pokemon[14].setStats(new Stats(15, 5, 2, 3, 2, 4));
	        pokemon[15].setStats(new Stats(15, 3, 3, 2, 2, 3));
	        pokemon[16].setStats(new Stats(25, 5, 5, 3, 5, 6));
	        pokemon[17].setStats(new Stats(25, 5, 6, 3, 4, 5));
	        pokemon[18].setStats(new Stats(15, 5, 7, 3, 4, 4));
	        pokemon[19].setStats(new Stats(10, 4, 2, 1, 2, 4));
	    }
}
