package main.basketball.cpsc233w22basketball;

import java.util.Date;

/**
 * main.basketball.cpsc233w22basketball.PlayerInformation object composed of the player's personal information
 * @author Saad & Vihari
 *
 */
public class PlayerInformation implements Comparable<PlayerInformation> {
    private String playerName;
    private int jerseyNo;
    private int height;
    private int weight;
    private String team;
    private Date dateOfBirth;
    private String position;

    /**
     * Public constructor for the main.basketball.cpsc233w22basketball.PlayerInformation object creation
     * @param playerName Player's name
     * @param jerseyNo Player's jersey number
     * @param height Player's height
     * @param weight Player's weight
     * @param team Player's team name
     * @param dateOfBirth Player's date of birth
     * @param position Player's playing position
     */
    public PlayerInformation(String playerName, int jerseyNo, int height, int weight, String team, Date dateOfBirth, String position){
        this.playerName = playerName;
        this.jerseyNo = jerseyNo;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
    }

    /**
     * Getter method for playerName
     * @return playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Getter method for jerseyNo
     * @return jerseyNo
     */
    public int getJerseyNo() {
        return jerseyNo;
    }

    /**
     * Getter method for height
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Getter method for weight
     * @return weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Getter method for team
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Getter method for dateOfBirth
     * @return dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Getter method for position
     * @return position
     */
    public String getPosition() {
        return position.toUpperCase();
    }

    /**
     * Overridden compareTo method to test if two players have the same name and date of birth
     */
    @Override
    public int compareTo(PlayerInformation other) {
        if(this.playerName.equals(other.playerName) && this.dateOfBirth.equals(other.dateOfBirth)) {
            return 1;
        } else {
            return 0;
        }
    }
}