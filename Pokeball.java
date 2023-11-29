package Assignment;

public class Pokeball {
    public enum Type {
        POKE_BALL,
        GREAT_BALL,
        ULTRA_BALL,
        MASTER_BALL
    }

    private String type;

    



	public final void setType(String type) {
		this.type = type;
		}

    public final String getType() {
		return type;
	}
    
	// Method to use the PokeBall
    public void use() {
        System.out.println("Used a " + type + "!");
      //additional logic
    }
}
