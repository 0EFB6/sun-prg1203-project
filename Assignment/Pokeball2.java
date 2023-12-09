package Assignment;
import java.util.Random;

public class Pokeball2 {
    public enum PokeballType {
        POKE_BALL,
        GREAT_BALL,
        ULTRA_BALL,
        MASTER_BALL
    }

    private PokeballType ballType;

    public Pokeball2() {
        setBallType();
    }

    public void setBallType() {
        PokeballType[] values = PokeballType.values();
        int randomIndex = new Random().nextInt(values.length);
        this.ballType = values[randomIndex];
    }

    public PokeballType getBallType() {
        return ballType;
    }

    @Override
    public String toString() {
        return "Pokeball2 [ballType=" + ballType + "]";
    }
}