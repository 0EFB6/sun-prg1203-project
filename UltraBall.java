public class UltraBall extends PokeBall{
    public UltraBall(){
        super(2);
    }

    @Override
    public String toString(){
        return String.format("UltraBall [ballType=%s]", ballType);
    }
}