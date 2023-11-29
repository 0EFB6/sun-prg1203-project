package Assignment;

public class Pokemonstats {
	 private Pokemon pokemon;
	    private Stats stats;

	    public Pokemonstats(Pokemon pokemon, Stats stats) {
	        this.pokemon = pokemon;
	        this.stats = stats;
	    }

	    public Pokemon getPokemon() {
	        return pokemon;
	    }

	    public void setPokemon(Pokemon pokemon) {
	        this.pokemon = pokemon;
	    }

	    public Stats getStats() {
	        return stats;
	    }

	    public void setStats(Stats stats) {
	        this.stats = stats;
	    }

	    @Override
	    public String toString() {
	        return "PokemonStats {" +
	                 pokemon + "\n" +
	                  stats +
	                '}';
	    }
}
