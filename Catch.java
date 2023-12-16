public class Catch {
    private PokeBall pokeball;
    private boolean success;
    private double catchTime;

    // Constructor
    public Catch() {
        this.pokeball = null;
        this.success = false;
        this.catchTime = 0.0;
    }

    public Catch(PokeBall pokeball, boolean success, double catchTime) {
        this.pokeball = pokeball;
        this.success = success;
        this.catchTime = catchTime;
    }

    // Getters and Setters
    public void setPokeBall(PokeBall pokeball) {
        this.pokeball = pokeball;
    }

    public PokeBall getPokeBall() {
        return pokeball;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setCatchTime(double catchTime) {
        this.catchTime = catchTime;
    }

    public double getCatchTime() {
        return catchTime;
    }

    // Other methods

    // toString
    @Override
    public String toString() {
        return String.format("PokeBall: %s, Success: %s, Catch Time: %.2f", pokeball, success, catchTime);
    }
}
