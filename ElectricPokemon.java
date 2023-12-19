public class ElectricPokemon extends Pokemon {
    // Constructor
    public ElectricPokemon() {
        super();
    }

    public ElectricPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, PokemonType.ELECTRIC);
    }

    // Methods
    @Override
    public double calculateAttackPower(Pokemon enemy, String attackType) {
        double finalAttackPower = 0;
        double attackPower = (attackType.equalsIgnoreCase("special")) ? getSpecialAttackPower() : getAttackPower();
        double defendPower = (attackType.equalsIgnoreCase("special")) ? enemy.getSpecialDefensePower() : enemy.getDefensePower();

        if (enemy.getType().equalsIgnoreCase("electric"))
            finalAttackPower = attackPower * 0.5 - defendPower;
        else if (enemy.getType().equalsIgnoreCase("water"))
            finalAttackPower = attackPower * 2 - defendPower;
        else
            finalAttackPower = attackPower - defendPower;
        return Math.max(finalAttackPower, 0);
    }

    @Override
    public void attack(Pokemon enemy, String attackType) {
        System.out.println(getName() + " ATTACK " + enemy.getName() + " with " + getMoveType() + " move " + getZMove() + "!");
        enemy.decreaseHp(calculateAttackPower(enemy, attackType));
    }

    @Override
    public boolean validateAttack(Pokemon enemy, String attackType) {
        return calculateAttackPower(enemy, attackType) > 0;
    }
}
