package Assignment;

public class Player {
    private String username;
    private int score;
    private int disksInserted;

    // Constructor
    public Player() {
    }

    public Player(String username, int score, int disksInserted) {
        this.username = username;
        this.score = score;
        this.disksInserted = disksInserted;
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

    // Other methods
    
    // toString
    @Override
    public String toString() {
        return String.format("Username: %s, Score: %d, Disks Inserted: %d", username, score, disksInserted);
    }
}
