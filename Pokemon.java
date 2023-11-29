package Assignment;

public class Pokemon {
	private int collectionNumber;
    private String name;
    private int grade;
    private int pe;
	public String move;
	public enum element{
		DRAGON,
		ELECTRIC,
		POISON,
		PSYCHIC,
		FIRE,
		GHOST,
		ROCK,
		BUG,
		DARK,
		FIGHTING,
		GRASS,
		GROUND,
		STEEL,
		WATER,
		FLYING,
		ICE,
		NORMAL		
	}
	
	
	public String move_type;
	private String type;
	private String type2="None"; //As default for one element pokemon
	public Pokemon() {
	}
	
	public Pokemon(int collectionNumber, String name, int grade, int pe, String move, String move_type,
			String type) {
		super();
		this.collectionNumber = collectionNumber;
		this.name = name;
		this.grade = grade;
		this.pe = pe;
		this.move = move;
		this.move_type = move_type;
		setType(type);
	}

	public Pokemon(int collectionNumber, String name, int grade, int pe, String move, String move_type,
			String type, String type2) {
		super();
		this.collectionNumber = collectionNumber;
		this.name = name;
		this.grade = grade;
		this.pe = pe;
		this.move = move;
		this.move_type = move_type;
		setType(type);
		setType2(type2);
	}

	public final int getCollectionNumber() {
		return collectionNumber;
	}

	public final void setCollectionNumber(int collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getGrade() {
		return grade;
	}

	public final void setGrade(int grade) {
		this.grade = grade;
	}
	

	public final String getType() {
		return type; 
	}

	public final void setType(String type) {
	    // Validate that the provided type is a valid enum element
	    for (element Element : element.values()) {
	        if (Element.name().equalsIgnoreCase(type)) {
	            this.type = type;
	            return;
	        }
	    }
	    // If the provided type is not valid, you can throw an exception or handle it in another way.
	    throw new IllegalArgumentException("Error: Invalid Pokemon type for \"" + name + "\": " + type);
	}
	

	public final String getType2() {
		return type2;
	}

	public final void setType2(String type2) {
		 // Validate that the provided type is a valid enum element
	    for (element Element2 : element.values()) {
	        if (Element2.name().equalsIgnoreCase(type2)) {
	            this.type2 = type2;
	            return;
	        }
	    }
	    // If the provided type is not valid, you can throw an exception or handle it in another way.
	    throw new IllegalArgumentException("Error: Invalid second Pokemon type for \"" + name + "\": " + type2);
	}

	public final int getPe() {
		return pe;
	}

	public final void setPe(int pe) {
		this.pe = pe;
	}

	public final String getMove() {
		return move;
	}

	public final void setMove(String z_move) {
		this.move = z_move;
	}

	public final String getMove_type() {
		return move_type;
	}

	public final void setMove_type(String move_type) {
		this.move_type = move_type;
	}
	
	@Override
	public String toString() {
		return "pokemon [collectionNumber=" + collectionNumber + ", name=" + name + ", grade=" + grade + ", pe=" + pe
				+ ", move=" + move + ", move_type=" + move_type + ", type=" + type + ", type2=" + type2 +"]";
	}
	
	
	
	
	
}	
