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
        System.out.println("Pokemon " + getName() + " attacks " + enemy.getName() + " with " + getMoveType() + " move " + getZMove());

        double attackPower;
        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("normal"))
                attackPower = getSpecialAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("bug"))
                attackPower = getSpecialAttackPower() * 0.5;
            else
                attackPower = getSpecialAttackPower();

            enemy.decreaseHp(attackPower);
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("normal"))
                attackPower = getAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("bug"))
                attackPower = getAttackPower() * 0.5;
            else
                attackPower = getAttackPower();
            enemy.decreaseHp(attackPower);
        }

        System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left");
        System.out.println("You have " + getHp() + " HP left");
    }
}
