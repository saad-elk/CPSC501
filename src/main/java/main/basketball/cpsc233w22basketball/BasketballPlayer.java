package main.basketball.cpsc233w22basketball;

/**
 * main.basketball.cpsc233w22basketball.BasketballPlayer object composed of one main.basketball.cpsc233w22basketball.PlayerInformation object and one PlayerStat object
 * @author Saad & Vihari
 */
public class BasketballPlayer implements Comparable<BasketballPlayer>{
    private PlayerInformation playerInformation;
    private PlayerStats playerStats;

    /**
     * Public constructor to create a main.basketball.cpsc233w22basketball.BasketballPlayer object
     * @param playerInformation main.basketball.cpsc233w22basketball.PlayerInformation object to store in the main.basketball.cpsc233w22basketball.BasketballPlayer object
     * @param playerStats main.basketball.cpsc233w22basketball.PlayerStats object to store in the main.basketball.cpsc233w22basketball.BasketballPlayer object
     */
    public BasketballPlayer(PlayerInformation playerInformation, PlayerStats playerStats){
        this.playerInformation = playerInformation;
        this.playerStats = playerStats;
    }

    /**
     * Gets the main.basketball.cpsc233w22basketball.PlayerInformation object
     * @return main.basketball.cpsc233w22basketball.PlayerInformation object
     */
    public PlayerInformation getPlayerInformation() {
        return playerInformation;
    }

    /**
     * Gets the main.basketball.cpsc233w22basketball.PlayerStats object
     * @return main.basketball.cpsc233w22basketball.PlayerStats object
     */
    public PlayerStats getPlayerStats() {
        return playerStats;
    }

    /**
     * Overridden compareTo method that compares player's stats based on their position
     */
    @Override
    public int compareTo(BasketballPlayer other) {
        if(this.playerInformation.getPosition().equalsIgnoreCase("SHOOTINGGUARD")) {
            if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.45) + (this.playerStats.getRebounds() * 0.15)) > (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.45) + (other.playerStats.getRebounds() * 0.15))){
                return 1;
            } else if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.45) + (this.playerStats.getRebounds() * 0.15)) < (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.45) + (other.playerStats.getRebounds() * 0.15))){
                return -1;
            } else {
                return 0;
            }
        } else if (this.playerInformation.getPosition().equalsIgnoreCase("POINTGUARD")){
            if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.33) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.33) + (this.playerStats.getAssists() * 0.33)) > (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.33) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.33) + (other.playerStats.getAssists() * 0.33))) {
                return 1;
            } else if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.33) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.33) + (this.playerStats.getAssists() * 0.33)) < (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.33) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.33) + (other.playerStats.getAssists() * 0.33))) {
                return -1;
            } else {
                return 0;
            }
        } else if (this.playerInformation.getPosition().equalsIgnoreCase("SMALLFORWARD")){
            if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.45) + (this.playerStats.getRebounds() * 0.15)) > (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.45) + (other.playerStats.getRebounds() * 0.15))) {
                return 1;
            } else if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.45) + (this.playerStats.getRebounds() * 0.15)) < (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.4) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.45) + (other.playerStats.getRebounds() * 0.15))) {
                return -1;
            } else {
                return 0;
            }
        } else if (this.playerInformation.getPosition().equalsIgnoreCase("POWERFORWARD")){
            if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.37) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.38) + (this.playerStats.getBlocks() * 0.25)) > (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.37) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.38) + (other.playerStats.getBlocks() * 0.25))) {
                return 1;
            } else if((((((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts()) + (this.playerStats.getThreePointShotMakes()/this.playerStats.getThreePointShotAttempts()) + (this.playerStats.getFreeThrowMakes()/this.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.37) + (((this.playerStats.getShotMakes() + this.playerStats.getThreePointShotMakes()*1.5+this.playerStats.getFreeThrowMakes()*0.33)*0.38) + (this.playerStats.getBlocks() * 0.25)) < (((((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts()) + (other.playerStats.getThreePointShotMakes()/other.playerStats.getThreePointShotAttempts()) + (other.playerStats.getFreeThrowMakes()/other.playerStats.getFreeThrowAttempts())) / 3) * 100) * 0.37) + (((other.playerStats.getShotMakes() + other.playerStats.getThreePointShotMakes()*1.5+other.playerStats.getFreeThrowMakes()*0.33)*0.38) + (other.playerStats.getBlocks() * 0.25))) {
                return -1;
            } else {
                return 0;
            }
        } else {
            if((this.playerStats.getBlocks()*0.25) + (this.playerStats.getSteals()*0.25) + (((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts())* 100) * 0.25) + ((this.playerStats.getShotMakes() + this.playerStats.getFreeThrowMakes() * 0.33) * 0.25) > (other.playerStats.getBlocks()*0.25) + (other.playerStats.getSteals()*0.25) + (((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts())* 100) * 0.25) + ((other.playerStats.getShotMakes() + other.playerStats.getFreeThrowMakes() * 0.33) * 0.25)) {
                return 1;
            } else if((this.playerStats.getBlocks()*0.25) + (this.playerStats.getSteals()*0.25) + (((this.playerStats.getShotMakes()/this.playerStats.getShotAttempts())* 100) * 0.25) + ((this.playerStats.getShotMakes() + this.playerStats.getFreeThrowMakes() * 0.33) * 0.25) < (other.playerStats.getBlocks()*0.25) + (other.playerStats.getSteals()*0.25) + (((other.playerStats.getShotMakes()/other.playerStats.getShotAttempts())* 100) * 0.25) + ((other.playerStats.getShotMakes() + other.playerStats.getFreeThrowMakes() * 0.33) * 0.25)) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}