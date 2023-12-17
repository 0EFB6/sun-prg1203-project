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

	public int getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(int collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	

	public String getType() {
		return type; 
	}

	public void setType(String type) {
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
	

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
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

	public int getPe() {
		return pe;
	}

	public void setPe(int pe) {
		this.pe = pe;
	}

	public String getMove() {
		return move;
	}

	public void setMove(String z_move) {
		this.move = z_move;
	}

	public String getMove_type() {
		return move_type;
	}

	public void setMove_type(String move_type) {
		this.move_type = move_type;
	}
	
	@Override
	public String toString() {
		return "pokemon [collectionNumber=" + collectionNumber + ", name=" + name + ", grade=" + grade + ", pe=" + pe
				+ ", move=" + move + ", move_type=" + move_type + ", type=" + type + ", type2=" + type2 +"]";
	}
	
	public String[] getValues () {
		String temp[] = new String[8];
		temp[0] = collectionNumber+"";
		temp[1] =name;
		temp[2] = grade+"";
		temp[3] = pe+"";
		temp[4] = move;
		temp[5] = move_type;
		temp[6]  = type;
		temp[7] = type2;
		return temp;
	}
	
	
	
}	
