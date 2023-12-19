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
    public String getUsername() { return username; }
    public int getScore() { return score; }
    public Pokemon getPlayerPokemon1() { return playerPokemon1; }
    public Pokemon getPlayerPokemon2() { return playerPokemon2; }

    public void setUsername(String username) { this.username = username; }
    public void setScore(int score) { this.score = score; }
    public void setPlayerPokemon1(Pokemon p1) { this.playerPokemon1 = p1; }
    public void setPlayerPokemon2(Pokemon p2) { this.playerPokemon2 = p2; }

    // Methods
    @Override
    public String toString() {
        return String.format("Player [Username=%s, Score=%d]", username, score);
    }
}