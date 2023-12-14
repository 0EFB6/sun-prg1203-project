public class Pokemon {
    private int collectionNumber;
    private String name;
    private int grade;
    private int pe;
    private String zMove;
    private String element;
    private String moveType;
    private String typeOne;
    private String typeTwo;
    
    // Constructor
    public Pokemon(int collectionNumber, String name, int grade, int pe, String zMove, String element, String moveType, String typeOne, String typeTwo) {
        this.collectionNumber = collectionNumber;
        this.name = name;
        this.grade = grade;
        this.pe = pe;
        this.zMove = zMove;
        this.element = element;
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

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
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
        this.typeOne = typeOne;
    }

    public String getTypeTwo() {
        return typeTwo;
    }

    public void setTypeTwo(String typeTwo) {
        this.typeTwo = typeTwo;
    }

    // Other Methods

    // toString
    @Override
    public String toString() {
        return String.format("Pokemon{collectionNumber=%d, name=%s, grade=%d, pe=%d, zMove=%s, element=%s, moveType=%s, typeOne=%s, typeTwo=%s}", collectionNumber, name, grade, pe, zMove, element, moveType, typeOne, typeTwo);
    }
}
