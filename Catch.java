import java.util.Random;

public class Catch {
    private PokeBall pokeball;
    private int successRate;

    // Constructor
    public Catch() {
        this.pokeball = null;
        this.successRate = 0;
    }

    public Catch(PokeBall pokeball, int successRate) {
        this.pokeball = pokeball;
        this.successRate = successRate;
    }

    // Getters and Setters
    public void setPokeBall(PokeBall pokeball) {
        this.pokeball = pokeball;
    }

    public PokeBall getPokeBall() {
        return pokeball;
    }

    public void setSuccess(int successRate) {
        this.successRate = successRate;
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

        if (randomNum <= successRate) {
            System.out.println("You caught " + pokemon.getName() + "!");
            return true;
        }
        else
            System.out.println("You failed to catch " + pokemon.getName() + "!");
        return false;
    }
}
