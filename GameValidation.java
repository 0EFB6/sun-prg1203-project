import java.util.List;

public class GameValidation {
    public static boolean validateBattle(Pokemon playerPokemon1, Pokemon playerPokemon2, List<Pokemon> enemy) {
        return (validatePlayerAttacks(playerPokemon1, enemy) &&
            validatePlayerAttacks(playerPokemon2, enemy) &&
            validateEnemyAttacks(enemy.get(0), playerPokemon1) &&
            validateEnemyAttacks(enemy.get(1), playerPokemon1) &&
            validateEnemyAttacks(enemy.get(0), playerPokemon2) &&
            validateEnemyAttacks(enemy.get(1), playerPokemon2));
    }

    private static boolean validatePlayerAttacks(Pokemon playerPokemon, List<Pokemon> enemy) {
        return (playerPokemon.validateAttack(enemy.get(0), "normal") ||
                playerPokemon.validateAttack(enemy.get(0), "special")) &&
               (playerPokemon.validateAttack(enemy.get(1), "normal") ||
                playerPokemon.validateAttack(enemy.get(1), "special"));
    }

    private static boolean validateEnemyAttacks(Pokemon enemyPokemon, Pokemon playerPokemon) {
        return (enemyPokemon.validateAttack(playerPokemon, "normal") ||
                enemyPokemon.validateAttack(playerPokemon, "special"));
    }
}