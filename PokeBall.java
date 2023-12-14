public class PokeBall {
    private String ballType;

    // Constructor
    public PokeBall() {
    }

    public PokeBall(String ballType) {
        this.ballType = ballType;
    }

    // Getters and Setters
    public String getBallType() {
        return ballType;
    }

    public void setBallType(String ballType) {
        this.ballType = ballType;
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("PokeBall [ballType=%s]", ballType);
    }
}