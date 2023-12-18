import java.util.Random;

public class Catch {
    private PokeBall pokeball;
    private int pokeballType;
    private int successRate;

    // Constructor
    public Catch() {
        this.pokeball = null;
        this.pokeballType = 0;
        this.successRate = 0;
    }

    public Catch(int pokeballType) {
        setPokeBall(new PokeBall(pokeballType - 1));
        setPokeballType(pokeballType);
        setSuccess(pokeballType);
    }

    // Getters and Setters
    public void setPokeBall(PokeBall pokeball) {
        this.pokeball = pokeball;
    }

    public PokeBall getPokeBall() {
        return pokeball;
    }

    public void setPokeballType(int pokeballType) {
        this.pokeballType = pokeballType;
    }

    public int getPokeballType() {
        return pokeballType;
    }

    public void setSuccess(int pokellballType) {
        this.successRate = 25 * pokellballType;
    }

    public int isSuccess() {
        return successRate;
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("PokeBall: %s, Success Rate: %d", pokeball, successRate);
    }

    public boolean catchPokeball(Pokemon pokemon) {
        Random random = new Random();
        int randomNum = random.nextInt(100);

        System.out.println();
        if (randomNum <= successRate) {
            System.out.println("Yay! You caught " + pokemon.getName() + "!");
            return true;
        }
        else
            System.out.println("You failed to catch " + pokemon.getName() + "! Better luck next time!");
        return false;
    }
}
