public class Player {
    private String username;
    private int score;
    private Pokemon playerPokemon1;
    private Pokemon playerPokemon2;

    // Constructor
    public Player() {
    }

    public Player(String username, int score) {
        this.username = username;
        this.score = score;
        this.playerPokemon1 = null;
        this.playerPokemon2 = null;
    }

    public Player(String username, int score, Pokemon playerPokemon) {
        this.username = username;
        this.score = score;
        this.playerPokemon1 = playerPokemon;
        this.playerPokemon2 = null;
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

    public void setPlayerPokemon1(Pokemon playerPokemon1) {
        this.playerPokemon1 = playerPokemon1;
    }

    public Pokemon getPlayerPokemon1() {
        return playerPokemon1;
    }

    public void setPlayerPokemon2(Pokemon playerPokemon2) {
        this.playerPokemon2 = playerPokemon2;
    }

    public Pokemon getPlayerPokemon2() {
        return playerPokemon2;
    }

    // Other methods
    
    // toString
    @Override
    public String toString() {
        return String.format("Username: %s, Score: %d", username, score);
    }
}
