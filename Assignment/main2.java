package Assignment;

public class main2 {
	public static void main(String agrs[]) {
	Pokemon pokemon1 = new Pokemon(1, "Bulbasaur", 1, 10, "Razor leaf", "GRASS", "GRASS","POISON");
	Stats mystats = new Stats(3,4,3,4,3);
	
	 Pokemonstats pokemonStats = new Pokemonstats(pokemon1, mystats);
	 
	 System.out.println("\nPokemonStats Details:");
     System.out.println(pokemonStats);
	}
}
