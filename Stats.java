public class Stats {
    private double hp;
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
        setHp(hp);
        setAttackPower(attackPower);
        setSpecialAttackPower(specialAttackPower);
        setDefensePower(defensePower);
        setSpecialDefensePower(specialDefensePower);
        setSpeed(speed);
    }

    // Getters and Setters
    public double getHp() { return hp; }
    public int getAttackPower() { return attackPower; }
    public int getDefensePower() { return defensePower; }
    public int getSpecialAttackPower() { return specialAttackPower; }
    public int getSpecialDefensePower() { return specialDefensePower; }
    public int getSpeed() { return speed; }

    public void setHp(int hp) { this.hp = validateStatValue(hp); }
    public void setAttackPower(int attackPower) { this.attackPower = validateStatValue(attackPower); }
    public void setSpecialAttackPower(int specialAttackPower) { this.specialAttackPower = validateStatValue(specialAttackPower); }
    public void setDefensePower(int defensePower) { this.defensePower = validateStatValue(defensePower); }
    public void setSpecialDefensePower(int specialDefensePower) { this.specialDefensePower = validateStatValue(specialDefensePower); }
    public void setSpeed(int speed) { this.speed = validateStatValue(speed); }

    // Methods
    @Override
    public String toString() {
        return String.format("Stats [hp=%.2f, attackPower=%d, specialAttackPower=%d, defensePower=%d, specialDefensePower=%d, speed=%d]",
                hp, attackPower, specialAttackPower, defensePower, specialDefensePower, speed);
    }

    public void decreaseHp(double damage) {
        if (damage > 0)
            hp -= damage;
    }

    public void increaseHp(double heal) {
        if (heal > 0)
            hp += heal;
    }

    private int validateStatValue(int value) {
        return Math.max(value, 0);
    }
}