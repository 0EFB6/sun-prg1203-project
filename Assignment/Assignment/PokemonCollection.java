package Assignment;

public class PokemonCollection {
	public Pokemon[] getAllPokemon () {
		Pokemon[] pokemon = new Pokemon[31];
		pokemon[0] = new Pokemon(1, "Bulbasaur", 1, 10, "Razor leaf", "GRASS", "GRASS","POISON");
		pokemon[1] = new Pokemon(2, "Ivysaur", 5, 20, "Toxic Whip", "GRASS", "GRASS","POISON");
		pokemon[2] = new Pokemon(3, "Venusaur", 10, 30, "Evergreen GX", "GRASS", "GRASS","POISON");
		pokemon[3] = new Pokemon(4, "Charmander", 1, 10, "Fire Fang", "FIRE", "FIRE");
		pokemon[4] = new Pokemon(5, "Charmeleon", 5, 20, "Flamethrower", "FIRE", "FIRE");
		pokemon[5] = new Pokemon(6, "Charizard", 10, 30, "Raging OUT", "FIRE", "FIRE","FLYING");
		pokemon[6] = new Pokemon(7, "Squirtle", 1, 10, "Water Gun", "WATER", "WATER");
		pokemon[7] = new Pokemon(1, "Wartortle", 5, 20, "Waterfall", "WATER", "WATER");
		pokemon[8] = new Pokemon(9, "Blastoise", 10, 30, "Giant Geyser GX", "WATER", "WATER");
		pokemon[9] = new Pokemon(10, "Caterpie", 1, 10, "Gnaw", "NORMAL", "BUG");
		pokemon[10] = new Pokemon(11, "Metapod", 5, 20, "Bug Bite", "NORMAL", "BUG");
		pokemon[11] = new Pokemon(12, "Butterfree", 10, 30, "Whirlwind", "NORMAL", "BUG","FLYING");
		pokemon[12] = new Pokemon(13, "Weedle", 1, 10, "String Shot", "GRASS", "BUG","POISON");
		pokemon[13] = new Pokemon(14, "Kakuna", 5, 20, "Harden", "GRASS", "BUG","POISON");
		pokemon[14] = new Pokemon(15, "Beedrill", 10, 30, "Pin Missile", "GRASS", "BUG","POISON");
		pokemon[15] = new Pokemon(16, "Pidgey", 1, 10, "Pick Off", "NORMAL", "NORMAL","FLYING");
		pokemon[16] = new Pokemon(17, "Pidgeotto", 5, 20, "Ambush", "NORMAL", "NORMAL","FLYING");
		pokemon[17] = new Pokemon(18, "Pidgeot", 10, 30, "Strong Gust", "NORMAL", "NORMAL","FLYING");
		pokemon[18] = new Pokemon(19, "Rattata", 1, 10, "Bite", "DARK", "NORMAL");
		pokemon[19] = new Pokemon(20, "Raticate", 5, 20, "Super Fang", "NORMAL", "NORMAL");
		pokemon[20] = new Pokemon(21, "Spearow", 1, 10, "Peck", "NORMAL", "NORMAL","FLYING");
		pokemon[21] = new Pokemon(22, "Fearow", 5, 20, "Nosedive", "NORMAL", "NORMAL","FLYING");
		pokemon[22] = new Pokemon(23, "Ekans", 1, 10, "BITE", "NORMAL", "POISON");
		pokemon[23] = new Pokemon(24, "Arbok", 5, 20, "Venomous Fang", "POISON", "POISON");
		pokemon[24] = new Pokemon(25, "Pikachu", 1, 10, "Thunderbolt", "ELECTRIC", "ELECTRIC");
		pokemon[25] = new Pokemon(26, "Raichu", 5, 20, "Electro Ball", "ELECTRIC", "ELECTRIC");
		pokemon[26] = new Pokemon(27, "Sandshrew", 1, 10, "Sand Tomb", "FIGHTING", "FIGHTING");
		pokemon[27] = new Pokemon(28, "Sandslash", 5, 20, "Earthquake", "FIGHTING", "FIGHTING");
		pokemon[28] = new Pokemon(29, "Nidoran(MALE)", 1, 10, "Bite", "POISON", "POISON");
		pokemon[29] = new Pokemon(30, "Nidorina", 5, 20, "Double Kick", "POISON", "POISON");
		pokemon[30] = new Pokemon(31, "Nidoqueen", 10, 30, "Double Stomp", "POISON", "POISON","GROUND");
		
	
		return pokemon;
	}
}
