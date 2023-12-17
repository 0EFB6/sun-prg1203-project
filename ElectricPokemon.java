public class ElectricPokemon extends Pokemon {
    // Constructor
    public ElectricPokemon() {
        super();
    }

    public ElectricPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, "ELCTRIC");
    }

    // Methods
    @Override
    public void attack(Pokemon enemy, String attackType) {
        System.out.println("\nPokemon " + getName() + " attacks " + enemy.getName() + " with " + getMoveType() + " move " + getZMove());

        double attackPower;
        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("water"))
                attackPower = getSpecialAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("electric"))
                attackPower = getSpecialAttackPower() * 0.5;
            else
                attackPower = getSpecialAttackPower();

            enemy.decreaseHp(attackPower);
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("water"))
                attackPower = getAttackPower() * 2;
            else if (enemy.getType().equalsIgnoreCase("electric"))
                attackPower = getAttackPower() * 0.5;
            else
                attackPower = getAttackPower();
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