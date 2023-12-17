public class Player {
    private String username;
    private int score;
    private int disksInserted;
    private Pokemon playerPokemon;

    // Constructor
    public Player() {
    }

    public Player(String username, int score, int disksInserted, Pokemon playerPokemon) {
        this.username = username;
        this.score = score;
        this.disksInserted = disksInserted;
        this.playerPokemon = playerPokemon;
    }
    
    // Getters and Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setDisksInserted(int disksInserted) {
        this.disksInserted = disksInserted;
    }

    public int getDisksInserted() {
        return disksInserted;
    }

    public void setPlayerPokemon(Pokemon playerPokemon) {
        this.playerPokemon = playerPokemon;
    }

    public Pokemon getPlayerPokemon() {
        return playerPokemon;
    }

    // Other methods
    
    // toString
    @Override
    public String toString() {
        return String.format("Username: %s, Score: %d, Disks Inserted: %d", username, score, disksInserted);
    }
}
