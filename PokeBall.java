import java.util.Random;

public class PokeBall {
    public enum PokeballType {
        POKE_BALL, GREAT_BALL, ULTRA_BALL, MASTER_BALL
    }
    protected PokeballType ballType;

    // Constructor
    public PokeBall() {
        setBallType(0);
    }

    public PokeBall(int index) {
        setBallType(index);
    }

    // Getters and Setters
    public PokeballType getBallType() {
        return ballType;
    }

    public void setBallType(int index) {
        PokeballType[] type = PokeballType.values();
        this.ballType = type[index];
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("PokeBall [ballType=%s]", ballType);
    }
}