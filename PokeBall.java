public class PokeBall {
    private PokeballType ballType;

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

    // Methods
    @Override
    public String toString() {
        return String.format("PokeBall [ballType=%s]", ballType);
    }
}