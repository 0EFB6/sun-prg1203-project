public class Player {
    private String username;
    private int score;
    private Pokemon playerPokemon;

    // Constructor
    public Player() {
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
        this.playerPokemon = null;
    }

    public Player(String username, int score, Pokemon playerPokemon) {
        this.username = username;
        this.score = score;
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
        return String.format("Username: %s, Score: %d", username, score);
    }
}
