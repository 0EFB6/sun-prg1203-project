public class WaterPokemon extends Pokemon {
    // Constructor
    public WaterPokemon() {
        super();
    }

    public WaterPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, "WATER");
    }

    // Methods
    @Override
    public void attack(Pokemon enemy, String attackType) {
        System.out.println("Pokemon " + getName() + " attacks " + enemy.getName() + " with " + getMoveType() + " move " + getZMove());

        double attackPower;
        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getSpecialAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("water"))
                attackPower = getSpecialAttackPower() * 0.5;
            else
                attackPower = getSpecialAttackPower();

            enemy.decreaseHp(attackPower);
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("water"))
                attackPower = getAttackPower() * 0.5;
            else
                attackPower = getAttackPower();
            enemy.decreaseHp(attackPower);
        }

        System.out.println("Enemy " + enemy.getName() + " has " + enemy.getHp() + " HP left");
        System.out.println("You have " + getHp() + " HP left");
    }
}
