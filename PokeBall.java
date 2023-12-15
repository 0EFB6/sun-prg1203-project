import java.util.Random;

public class PokeBall {
    public enum PokeballType {
        POKE_BALL, GREAT_BALL, ULTRA_BALL, MASTER_BALL
    }
    private PokeballType ballType;

    // Constructor
    public PokeBall() {
        setBallType();
    }

    // Getters and Setters
    public PokeballType getBallType() {
        return ballType;
    }

    public void setBallType() {
        PokeballType[] type = PokeballType.values();
        this.ballType = type[new Random().nextInt(type.length)];
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("PokeBall [ballType=%s]", ballType);
    }
}