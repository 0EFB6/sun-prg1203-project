package Assignment;

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
		
	
		return pokemon;
	}
	
	public Pokemon[] getAllStats () {
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
		return pokemon;
	}
}
