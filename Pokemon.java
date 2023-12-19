public class Pokemon {
    private int collectionNumber;
    private String name;
    private int grade;
    private int pe;
    private PokemonType type;
    private String zMove;
    private String moveType;
    private Stats stats;
    
    // Constructor
    public Pokemon() {
    }

    public Pokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType, PokemonType type) {
        this.collectionNumber = collectionNumber;
        this.name = name;
        this.grade = grade;
        this.pe = pe;
        this.zMove = zMove;
        this.moveType = moveType;
        setType(type);
        stats = new Stats();
    }

    // Getters and Setters
    public int getCollectionNumber() { return collectionNumber; }
    public String getName() { return name; }
    public int getGrade() { return grade; }
    public int getPe() { return pe; }
    public String getType() { return type.toString(); }
    public String getZMove() { return zMove; }
    public String getMoveType() { return moveType; }
    public Stats getStats() { return stats; }


    public void setCollectionNumber(int collectionNumber) { this.collectionNumber = collectionNumber; }
    public void setName(String name) { this.name = name; }
    public void setGrade(int grade) { this.grade = Math.max(grade, 0); }
    public void setPe(int pe) { this.pe = Math.max(pe, 0); }
    public void setType(PokemonType type) { this.type = type; }
    public void setZMove(String zMove) { this.zMove = zMove; }
    public void setMoveType(String moveType) { this.moveType = moveType; }
    public void setStats(Stats stats) { this.stats = stats; }

    // Other Methods
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

    public void printEnemy(Pokemon enemy) {
        System.out.println("[OPPONENT's CURRENT HP] " + enemy.getName() + " -- " + enemy.getPokemonHp());
    }

    public void printPlayer() {
        System.out.println("[YOUR CURRENT HP] " + getName() + " -- " + getPokemonHp());
    }

    public double getPokemonHp() {
        return stats.getHp();
    }

    public void attack(Pokemon enemy, String attackType) {
        System.out.println(getName() + " ATTACK " + enemy.getName() + " with " + getMoveType() + " move " + getZMove() + "!");
        enemy.decreaseHp(calculateAttackPower(enemy, attackType));
    }

    public double calculateAttackPower(Pokemon enemy, String attackType) {
        double attackPower = (attackType.equalsIgnoreCase("special")) ? getSpecialAttackPower() : getAttackPower();
        double defendPower = (attackType.equalsIgnoreCase("special")) ? enemy.getSpecialDefensePower() : enemy.getDefensePower();
        return Math.max(attackPower - defendPower, 0);
    }

    public boolean validateAttack(Pokemon enemy, String attackType) {        
        return calculateAttackPower(enemy, attackType) > 0;
    }
}