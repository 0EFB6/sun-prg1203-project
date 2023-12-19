public class PoisonPokemon extends Pokemon {
    // Constructor
    public PoisonPokemon() {
        super();
    }

    public PoisonPokemon(int collectionNumber, String name, int grade, int pe, String zMove, String moveType) {
        super(collectionNumber, name, grade, pe, zMove, moveType, PokemonType.POISON);
    }

    // Methods
    public double calculateAttackPower(Pokemon enemy, String attackType) {
        double finalAttackPower = 0;
        double attackPower = (attackType.equalsIgnoreCase("special")) ? getSpecialAttackPower() : getAttackPower();
        double defendPower = (attackType.equalsIgnoreCase("special")) ? enemy.getSpecialDefensePower() : enemy.getDefensePower();

        if (enemy.getType().equalsIgnoreCase("poison"))
            finalAttackPower = attackPower * 0.5 - defendPower;
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