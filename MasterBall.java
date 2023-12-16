public class MasterBall extends PokeBall {
    public MasterBall() {
        super(3);
    }

    @Override
    public String toString() {
        return String.format("MasterBall [ballType=%s]", ballType);
    }
}