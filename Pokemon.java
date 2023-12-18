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
    private String type;
    private Stats stats;
    
    // Constructor
    public Pokemon() {
    }

    public Pokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType, String type) {
        this.collectionNumber = collectionNumber;
        this.name = name;
        this.grade = grade;
        this.pe = pe;
        this.zMove = zMove;
        this.moveType = moveType;
        this.type = type;
        stats = new Stats();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        for (element Element : element.values()) {
            if (Element.name().equalsIgnoreCase(type)) {
                this.type = type;
                return;
            }
        }
        throw new IllegalArgumentException("Error: Invalid Pokemon type for " + name + " with type " + type);
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    // Other Methods

    // toString
    @Override
    public String toString() {
        return String.format("Pokemon [collectionNumber=%d, name=%s, grade=%d, pe=%d, zMove=%s, moveType=%s, type=%s] with %s", collectionNumber, name, grade, pe, zMove, moveType, type, stats);
    }



    public void decreaseHp(double damage) {
        stats.decreaseHp(damage);
    }

    public int getAttackPower() {
        return stats.getAttackPower();
    }

    public int getSpecialAttackPower() {
        return stats.getSpecialAttackPower();
    }

    public int getDefensePower() {
        return stats.getDefensePower();
    }

    public int getSpecialDefensePower() {
        return stats.getSpecialDefensePower();
    }

    public void attack(Pokemon enemy, String attackType) {
        System.out.println(getName() + " ATTACK " + enemy.getName() + " with " + getMoveType() + " move " + getZMove() + "!");

        if (attackType.equalsIgnoreCase("special") && (getSpecialAttackPower() - enemy.getSpecialDefensePower()) > 0) {
            enemy.decreaseHp(getSpecialAttackPower() - enemy.getSpecialDefensePower());
        }
        else if (attackType.equalsIgnoreCase("normal") && (getSpecialAttackPower() - enemy.getSpecialDefensePower()) > 0) {
            enemy.decreaseHp(getAttackPower() - enemy.getDefensePower());
        }
    }

    public boolean validateAttack(Pokemon enemy, String attackType) {
        double attackPower = 0;

        if (attackType.equalsIgnoreCase("special") && (getSpecialAttackPower() - enemy.getSpecialDefensePower()) > 0)
            attackPower = getSpecialAttackPower() - enemy.getSpecialDefensePower();
        else if (attackType.equalsIgnoreCase("normal") && (getSpecialAttackPower() - enemy.getSpecialDefensePower()) > 0)
            attackPower = getAttackPower() - enemy.getDefensePower();
        
        if (attackPower > 0)
            return true;
        return false;
    }

    public void printEnemy(Pokemon enemy) {
        System.out.println("[OPPONENT's CURRENT HP] " + enemy.getName() + " -- " + enemy.getPokemonHp());
    }

    public void printPlayer() {
        System.out.println("[YOUR CURRENT HP] " + getName() + " -- " + getPokemonHp());
    }

    public double getPokemonHp() {
        return stats.getHp();
    }
}
