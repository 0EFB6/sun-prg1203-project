package Assignment;

public class BugPokemon extends Pokemon {
    // Constructor
    public BugPokemon() {
        super();
    }

    public BugPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, "BUG");
    }

    // Methods
    @Override
    public void attack(Pokemon enemy, String attackType) {
    	lastAttackInfo = getName() + " ATTACK " + enemy.getName() + " with " + getMoveType() + " move " + getZMove() + "!";

        double attackPower;
        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("fighting") || enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getSpecialAttackPower() * 0.5 - enemy.getSpecialDefensePower();
            else
                attackPower = getSpecialAttackPower() - enemy.getSpecialDefensePower();
            if (attackPower < 0)
                attackPower = 0;
            enemy.decreaseHp(attackPower);
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("fighting") || enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getAttackPower() * 0.5 - enemy.getDefensePower();
            else
                attackPower = getAttackPower() - enemy.getDefensePower();
            if (attackPower < 0)
                attackPower = 0;
            enemy.decreaseHp(attackPower);
        }
    }

    @Override
    public boolean validateAttack(Pokemon enemy, String attackType) {
        double attackPower = 0;

        if (attackType.equalsIgnoreCase("special")) {
            if (enemy.getType().equalsIgnoreCase("fighting") || enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getSpecialAttackPower() * 0.5 - enemy.getSpecialDefensePower();
            else
                attackPower = getSpecialAttackPower() - enemy.getSpecialDefensePower();
        }
        else if (attackType.equalsIgnoreCase("normal")) {
            if (enemy.getType().equalsIgnoreCase("fighting") || enemy.getType().equalsIgnoreCase("poison") || enemy.getType().equalsIgnoreCase("fire"))
                attackPower = getAttackPower() * 0.5 - enemy.getDefensePower();
            else
                attackPower = getAttackPower() - enemy.getDefensePower();
        }
        if (attackPower > 0)
            return true;
        return false;
    }
}
