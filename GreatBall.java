public class GreatBall extends PokeBall {
    public GreatBall() {
        super(1);

    }

    @Override
    public String toString() {
        return String.format("GreatBall [ballType=%s]", ballType);
    }
}