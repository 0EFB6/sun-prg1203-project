public class Battle {
    private String stage;
    private int collection_number;
    private double battleTime;

    // Constructor
    public Battle() {
    }
    
    public Battle(String stage, int collection_number, double battleTime) {
        this.stage = stage;
        this.collection_number = collection_number;
        this.battleTime = battleTime;
    }
    
    // Getters and Setters
    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getCollection_number() {
        return collection_number;
    }

    public void setCollection_number(int collection_number) {
        this.collection_number = collection_number;
    }

    public double getBattleTime() {
        return battleTime;
    }

    public void setBattleTime(double battleTime) {
        this.battleTime = battleTime;
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("Battle{stage='%s', collection_number=%d, battleTime=%.2f}", stage, collection_number, battleTime);
    }
}
