public class Pokemon {
    private int collectionNumber;
    private String name;
    private int grade;
    private int pe;
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
    private String zMove;
    private String moveType;
    private String typeOne;
    private String typeTwo;
    
    // Constructor
    public Pokemon() {
    }

    public Pokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType, String typeOne) {
        this.collectionNumber = collectionNumber;
        this.name = name;
        this.grade = grade;
        this.pe = pe;
        this.zMove = zMove;
        this.moveType = moveType;
        this.typeOne = typeOne;
    }

    public Pokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType, String typeOne, String typeTwo) {
        this.collectionNumber = collectionNumber;
        this.name = name;
        this.grade = grade;
        this.pe = pe;
        this.zMove = zMove;
        this.moveType = moveType;
        this.typeOne = typeOne;
        this.typeTwo = typeTwo;
    }
    
    // Getters and Setters
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

    public int getPe() {
        return pe;
    }

    public void setPe(int pe) {
        this.pe = pe;
    }

    public String getZMove() {
        return zMove;
    }

    public void setZMove(String zMove) {
        this.zMove = zMove;
    }

    public String getMoveType() {
        return moveType;
    }

    public void setMoveType(String moveType) {
        this.moveType = moveType;
    }

    public String getTypeOne() {
        return typeOne;
    }

    public void setTypeOne(String typeOne) {
        for (element Element : element.values()) {
            if (Element.name().equalsIgnoreCase(typeOne)) {
                this.typeOne = typeOne;
                return;
            }
        }
        throw new IllegalArgumentException("Error: Invalid Pokemon type for " + name + " with type " + typeOne);
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        for (element Element : element.values()) {
            if (Element.name().equalsIgnoreCase(typeTwo)) {
                this.typeTwo = typeTwo;
                return;
            }
        }
        throw new IllegalArgumentException("Error: Invalid Pokemon type for " + name + " with type " + typeTwo);
    }

    // Other Methods

    // toString
    @Override
    public String toString() {
        return String.format("Pokemon [collectionNumber=%d, name=%s, grade=%d, pe=%d, zMove=%s, moveType=%s, typeOne=%s, typeTwo=%s]", collectionNumber, name, grade, pe, zMove, moveType, typeOne, typeTwo);
    }
}
