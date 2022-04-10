package main.basketball.cpsc233w22basketball;

/**
 * main.basketball.cpsc233w22basketball.PlayerStats Object consisting of the player's playing stats
 * @author Saad & Vihari
 *
 */
public class PlayerStats {
    private int shotAttempts;
    private int shotMakes;
    private int threePointShotAttempts;
    private int threePointShotMakes;
    private int freeThrowAttempts;
    private int freeThrowMakes;
    private int assists;
    private int blocks;
    private int steals;
    private int rebounds;

    /**
     * Public constructor for the main.basketball.cpsc233w22basketball.PlayerStats object
     * @param shotAttempts Player's Shot Attempts
     * @param shotMakes Player's Shot Makes
     * @param threePointShotAttempts Player's three point shot attempts
     * @param threePointShotMakes Player's three point shot makes
     * @param freeThrowAttempts Player's free throw attempts
     * @param freeThrowMakes Player's free throw makes
     * @param assists Player's assists
     * @param blocks Player's blocks
     * @param steals Player's steals
     * @param rebounds Player's rebounds
     */
    public PlayerStats(int shotAttempts, int shotMakes, int threePointShotAttempts, int threePointShotMakes, int freeThrowAttempts, int freeThrowMakes, int assists, int blocks, int steals, int rebounds) {
        this.shotAttempts = shotAttempts;
        this.shotMakes = shotMakes;
        this.threePointShotAttempts = threePointShotAttempts;
        this.threePointShotMakes = threePointShotMakes;
        this.freeThrowAttempts = freeThrowAttempts;
        this.freeThrowMakes = freeThrowMakes;
        this.assists = assists;
        this.blocks = blocks;
        this.steals = steals;
        this.rebounds = rebounds;
    }

    /**
     * Class function to return the overall shooting percentage.
     * @return overall shooting percentage
     */
    public double getOverallShootingPercentage() {
        return ((shotMakes/(double)shotAttempts) + (threePointShotMakes/(double)threePointShotAttempts) + (freeThrowMakes/(double)freeThrowAttempts)) / 3.0;
    }

    /**
     * Class function that adds all shot makes
     * @return total shot makes
     */
    public int getTotalShotMakes() {
        return shotMakes + threePointShotMakes + freeThrowMakes;
    }

    /**
     * Getter function for shotAttempts
     * @return shotAttempts
     */
    public int getShotAttempts() {
        return shotAttempts;
    }

    /**
     * Mutator function for adding shotAttempts
     */
    public void addShotAttempts(int shotAttempts) {
        this.shotAttempts = shotAttempts + getShotAttempts();
    }

    /**
     * Getter function for shotMakes
     * @return shotMakes
     */
    public int getShotMakes() {
        return shotMakes;
    }

    /**
     * Mutator function for adding shotMakes
     */
    public void addShotMakes(int shotMakes) {
        this.shotMakes = shotMakes + getShotMakes();
    }

    /**
     * Getter function for threePointShotAttempts
     * @return threePointShotAttempts
     */
    public int getThreePointShotAttempts() {
        return threePointShotAttempts;
    }

    /**
     * Mutator function for adding threePointShotAttempts
     */
    public void addThreePointShotAttempts(int threePointShotAttempts) {
        this.threePointShotAttempts = threePointShotAttempts + getThreePointShotAttempts();
    }

    /**
     * Getter function for threePointShotMakes
     * @return threePointShotMakes
     */
    public int getThreePointShotMakes() {
        return threePointShotMakes;
    }

    /**
     * Mutator function for adding threePointShotMakes
     */
    public void addThreePointShotMakes(int threePointShotMakes) {
        this.threePointShotMakes = threePointShotMakes + getThreePointShotMakes();
    }

    /**
     * Getter function for freeThrowAttempts
     * @return freeThrowAttempts
     */
    public int getFreeThrowAttempts() {
        return freeThrowAttempts;
    }

    /**
     * Mutator function for adding freeThrowAttempts
     */
    public void addFreeThrowAttempts(int freeThrowAttempts) {
        this.freeThrowAttempts = freeThrowAttempts + getFreeThrowAttempts();
    }

    /**
     * Getter function for freeThrowMakes
     * @return freeThrowMakes
     */
    public int getFreeThrowMakes() {
        return freeThrowMakes;
    }

    /**
     * Mutator function for adding freeThrowMakes
     */
    public void addFreeThrowMakes(int freeThrowMakes) {
        this.freeThrowMakes = freeThrowMakes + getFreeThrowMakes();
    }

    /**
     * Getter function for assists
     * @return assists
     */
    public int getAssists() {
        return assists;
    }

    /**
     * Mutator function for adding assists
     */
    public void addAssists(int assists) {
        this.assists = assists + getAssists();
    }

    /**
     * Getter function for blocks
     * @return blocks
     */
    public int getBlocks() {
        return blocks;
    }

    /**
     * Mutator function for adding blocks
     */
    public void addBlocks(int blocks) {
        this.blocks = blocks + getBlocks();
    }

    /**
     * Getter function for steals
     * @return steals
     */
    public int getSteals() {
        return steals;
    }

    /**
     * Mutator function for adding steals
     */
    public void addSteals(int steals) {
        this.steals = steals + getSteals();
    }

    /**
     * Getter function for rebounds
     * @return rebounds
     */
    public int getRebounds() {
        return rebounds;
    }

    /**
     * Mutator function for adding rebounds
     */
    public void addRebounds(int rebounds) {
        this.rebounds = rebounds + getRebounds();
    }
}