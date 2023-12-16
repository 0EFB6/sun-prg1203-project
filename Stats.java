public class Stats {
    private int hp;
    private int attackPower;
    private int specialAttackPower;
    private int defensePower;
    private int specialDefensePower;
    private int speed;

    // Constructor
    public Stats() {
        hp = 0;
        attackPower = 0;
        specialAttackPower = 0;
        defensePower = 0;
        specialDefensePower = 0;
        speed = 0;
    }

    public Stats(int hp, int attackPower, int specialAttackPower, int defensePower, int specialDefensePower, int speed) {
        this.hp = hp;
        this.attackPower = attackPower;
        this.specialAttackPower = specialAttackPower;
        this.defensePower = defensePower;
        this.specialDefensePower = specialDefensePower;
        this.speed = speed;
    }

    // Getters and Setters
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getSpecialAttackPower() {
        return specialAttackPower;
    }

    public void setSpecialAttackPower(int specialAttackPower) {
        this.specialAttackPower = specialAttackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getSpecialDefensePower() {
        return specialDefensePower;
    }

    public void setSpecialDefensePower(int specialDefensePower) {
        this.specialDefensePower = specialDefensePower;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("Stats [hp=%d, attackPower=%d, specialAttackPower=%d, defensePower=%d, specialDefensePower=%d, speed=%d]",
                hp, attackPower, specialAttackPower, defensePower, specialDefensePower, speed);
    }

    public void decreaseHp(int damage) {
        hp -= damage;
    }

    public void increaseHp(int heal) {
        hp += heal;
    }    
}
