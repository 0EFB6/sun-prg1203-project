public class FightingPokemon extends Pokemon{
    // Constructor
    public FightingPokemon() {
        super();
    }

    public FightingPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, "FIGHTING");
    }

    // Methods
    @Override
    public void attack(Pokemon enemy, String attackType) {
        System.out.println("\nPokemon " + getName() + " attacks " + enemy.getName() + " with " + getMoveType() + " move " + getZMove());

        double attackPower;
        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("normal"))
                attackPower = getSpecialAttackPower() * 2 - enemy.getSpecialDefensePower();
            else if (enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("bug"))
                attackPower = getSpecialAttackPower() * 0.5 - enemy.getSpecialDefensePower();
            else
                attackPower = getSpecialAttackPower() - enemy.getSpecialDefensePower();
            if (attackPower < 0)
                attackPower = 0;
            enemy.decreaseHp(attackPower);
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("normal"))
                attackPower = getAttackPower() * 2 - enemy.getDefensePower();
            else if (enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("bug"))
                attackPower = getAttackPower() * 0.5 - enemy.getDefensePower();
            else
                attackPower = getAttackPower() - enemy.getDefensePower();
            if (attackPower < 0)
                attackPower = 0;
            enemy.decreaseHp(attackPower);
        }
    }

    public void printEnemy(Pokemon enemy) {
        System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left");
    }

    public void printPlayer() {
        System.out.println("You have " + getHp() + " HP left");
    }
}
