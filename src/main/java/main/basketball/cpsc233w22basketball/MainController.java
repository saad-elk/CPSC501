package main.basketball.cpsc233w22basketball;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainController {
    private static final int TO_PERCENTAGE = 100;

    public AnchorPane displayID;

    @FXML
    private ChoiceBox<String> allDisplayOptions;

    @FXML
    private ChoiceBox<String> allPlayers;

    @FXML
    private ChoiceBox<String> allStats;

    @FXML
    private TextArea displayTextArea;

    @FXML
    private TextArea editPlayerTextArea;

    @FXML
    private TextField editedStat;

    @FXML
    private TextField newPlayerDateOfBirth;

    @FXML
    private TextField newPlayerFirstName;

    @FXML
    private TextField newPlayerHeight;

    @FXML
    private TextField newPlayerJeresyNo;

    @FXML
    private TextField newPlayerLastName;

    @FXML
    private TextField newPlayerPosition;

    @FXML
    private TextField newPlayerTeamName;

    @FXML
    private TextField newPlayerWeight;

    @FXML
    private Label statusBar;

    @FXML
    private TextArea teamDurantTextArea;

    @FXML
    private TextArea teamLebronTextArea;

    @FXML
    private MenuItem about;

    @FXML
    private MenuItem quit;

    @FXML
    private MenuItem load;

    @FXML
    private MenuItem save;

    @FXML
    void displayAbout(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("Message");
        alert.setContentText("""
                Authors: Saad Elkadri & Vihari Vadlamudi
                
                Emails: 
                saad.elkadri@ucalgary.ca
                vihari.vadlamudi@ucalgary.ca
                
                Version: v1.0
                This is a stat tracker for your favourite all star basketball players!.
                """);
        alert.show();
    }

    @FXML
    void quitProgram(ActionEvent event) {
        Platform.exit();
        System.out.print("You have successfully quit All-Star Basketball Stat Tracker!");
    }

    @FXML
    void loadPlayers(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(new File("."));
            File basketballFile = fileChooser.showOpenDialog(new Stage());
            fileReader(basketballFile);
            statusBar.setTextFill(Color.GREEN);
            statusBar.setText("File successfully loaded!");
        } catch (Exception e){
            statusBar.setTextFill(Color.RED);
            statusBar.setText("Invalid file chosen!");
        }
    }




    private ArrayList<BasketballPlayer> playersArray = new ArrayList<>();

    //Store stat options
    private ObservableList<String> statOptions = FXCollections.observableArrayList();

    //Store display options
    private ObservableList<String> displayOptions = FXCollections.observableArrayList();

    //Store players
    private ObservableList<String> players = FXCollections.observableArrayList();

    //Store players
    private ObservableList<String> uniquePlayers = FXCollections.observableArrayList();

    /**
     * Loads all stat options when the GUI is initialized.
     */
    private void loadStatOptions() {
        statOptions.addAll("Shot attempts", "Shot makes", "3-point shot attempts", "3-point shot makes" ,"Free throw attempts",
                "Free throw makes", "Assists", "Rebounds", "Blocks", "Steals");
        allStats.getItems().addAll(statOptions);
    }

    /**
     * Loads all display options when the GUI is initialized.
     */
    private void loadDisplayOptions() {
        displayOptions.addAll("All players' information", "All players' stats", "Unique player stats", "Top 10 scorers", "Top 10 most efficient players",
	                    "Best 3pt shooting line up (Top 3 SGs, PGs and SFs)", "Best recommended overall line up");
        allDisplayOptions.getItems().addAll(displayOptions);
    }

    /**
     * Loads all players when the GUI is initialized.
     */
    private void loadPlayers() {
//        BasketballPlayer b = new BasketballPlayer(new PlayerInformation("saad elkadri", 2, 2, 2, "Lebron", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1990"), "Center"), new PlayerStats(2,2,2,2,2,2,2,2,2,2));
//        playersArray.add(b);
//
//        BasketballPlayer l = new BasketballPlayer(new PlayerInformation("Mark Mattews", 2, 2, 2, "Lebron", new SimpleDateFormat("dd/MM/yyyy").parse("11/11/1990"), "Center"), new PlayerStats(2,2,2,2,2,2,2,2,2,2));
//        playersArray.add(l);
        //allPlayers.getItems().clear();
        players.clear();
        for(BasketballPlayer player : playersArray){
            players.add(player.getPlayerInformation().getPlayerName().toUpperCase());
        }
        allPlayers.getItems().addAll(players);
    }

    /**
     * Loads all players when the GUI is initialized.
     */
    private void loadUniquePlayers() {
        uniquePlayers.clear();
        for(BasketballPlayer player : playersArray){
            uniquePlayers.add(player.getPlayerInformation().getPlayerName().toUpperCase());
        }

        ChoiceBox<String> playersToView = new ChoiceBox<>(FXCollections.observableArrayList(uniquePlayers));
        playersToView.setLayoutX(106);
        playersToView.setLayoutY(120);
        playersToView.prefWidth(150);
        playersToView.setOnAction(event -> {
            for (BasketballPlayer player : playersArray){
                if (player.getPlayerInformation().getPlayerName().equalsIgnoreCase(playersToView.getValue())){
                    PlayerStats playerStats = player.getPlayerStats();
                    displayTextArea.setText(String.format("""
                        Player Name - %s
                        Shot Attempts - %d
                        Shot Makes - %d
                        3-Point Shot Attempts - %d
                        3-Point Shot Makes - %d
                        Free Throw Attempts - %d
                        Free Throw Makes - %d
                        Assists - %d
                        Rebounds - %d
                        Blocks - %d
                        Steals - %d""", player.getPlayerInformation().getPlayerName().toUpperCase(), playerStats.getShotAttempts(), playerStats.getShotMakes(), playerStats.getThreePointShotAttempts(),
                            playerStats.getThreePointShotMakes(), playerStats.getFreeThrowAttempts(), playerStats.getFreeThrowMakes(), playerStats.getAssists(), playerStats.getRebounds(), playerStats.getBlocks(), playerStats.getSteals()));
                }
            }
        });
        displayID.getChildren().add(playersToView);


        Label label = new Label("Select Player");
        label.setLayoutX(14);
        label.setLayoutY(123);
        displayID.getChildren().add(label);
    }

    /**
     * Loads all Team Members when the GUI is initialized.
     */
    private void loadTeamMembers() {
        if (playersArray.size() > 0) {
            for (BasketballPlayer basketballPlayer : playersArray) {
                if (basketballPlayer.getPlayerInformation().getTeam().equalsIgnoreCase("LEBRON")) {
                    teamLebronTextArea.appendText(basketballPlayer.getPlayerInformation().getPlayerName().toUpperCase() + "\n");
                } else {
                    teamDurantTextArea.appendText(basketballPlayer.getPlayerInformation().getPlayerName().toUpperCase() + "\n");
                }
            }
        }
    }

    /**
     * Loads all text prompts when the GUI is initialized.
     */
    private void loadTextPrompts(){
        editedStat.setPromptText("Stat number to add");
        newPlayerFirstName.setPromptText("Player's First Name");
        newPlayerLastName.setPromptText("Player's Last Name");
        newPlayerJeresyNo.setPromptText("Player's Jersey No");
        newPlayerHeight.setPromptText("Player's Height (cm)");
        newPlayerWeight.setPromptText("Player's Weight (kg)");
        newPlayerTeamName.setPromptText("Lebron or Durant");
        newPlayerDateOfBirth.setPromptText("DOB (DD/MM/YYYY)");
        newPlayerPosition.setPromptText("Player's position");
    }

    /**
     * Setup the window state
     */
    @FXML
    public void initialize() {
        loadDisplayOptions();
        loadStatOptions();
        loadPlayers();
        loadTeamMembers();
        loadTextPrompts();
    }

    public void displayStats(ActionEvent actionEvent) {
        String playerToEdit = allPlayers.getValue();

        BasketballPlayer playerToOutput = playersArray.get(0);
        if (playersArray.size() > 1){
            for (BasketballPlayer basketballPlayer : playersArray) {
                if (basketballPlayer.getPlayerInformation().getPlayerName().equalsIgnoreCase(playerToEdit)) {
                    playerToOutput = basketballPlayer;
                }
            }
        }
        PlayerStats playerStats = playerToOutput.getPlayerStats();
        editPlayerTextArea.setText(String.format("""
                        Player Name - %s
                        Shot Attempts - %d
                        Shot Makes - %d
                        3-Point Shot Attempts - %d
                        3-Point Shot Makes - %d
                        Free Throw Attempts - %d
                        Free Throw Makes - %d
                        Assists - %d
                        Rebounds - %d
                        Blocks - %d
                        Steals - %d""", playerToOutput.getPlayerInformation().getPlayerName().toUpperCase(), playerStats.getShotAttempts(), playerStats.getShotMakes(), playerStats.getThreePointShotAttempts(),
                playerStats.getThreePointShotMakes(), playerStats.getFreeThrowAttempts(), playerStats.getFreeThrowMakes(), playerStats.getAssists(), playerStats.getRebounds(), playerStats.getBlocks(), playerStats.getSteals()));
    }

    @FXML
    void confirmStatChange(MouseEvent event) {
        String playerToEdit = allPlayers.getValue();
        String statToEdit = allStats.getValue();
        int newStat;

        if (playerToEdit == null || playerToEdit.equals("")){
            statusBar.setTextFill(Color.RED);
            statusBar.setText("Please select a player to edit!");
            return;
        }

        BasketballPlayer playerToOutput = playersArray.get(0);
        try {
            newStat = Integer.parseInt(editedStat.getText().strip());
            if (newStat <= 0){
                statusBar.setTextFill(Color.RED);
                statusBar.setText("The stat value you entered must be more than 0!");
                return;
            }
        } catch (NumberFormatException e){
            statusBar.setTextFill(Color.RED);
            statusBar.setText("The stat being edited must only include integer values!");
            return;
        }
        if (playersArray.size() > 1){
            for (BasketballPlayer basketballPlayer : playersArray) {
                if (basketballPlayer.getPlayerInformation().getPlayerName().equalsIgnoreCase(playerToEdit)) {
                    playerToOutput = basketballPlayer;
                }
            }
        }
        PlayerStats playerStats = playerToOutput.getPlayerStats();
        statusBar.setTextFill(Color.GREEN);

        if (statToEdit == null){
            statusBar.setTextFill(Color.RED);
            statusBar.setText("Please select a stat to edit!");
            return;
        } else if (statToEdit.equals("Shot attempts")){
            playerStats.addShotAttempts(newStat);
            statusBar.setText(String.format("%s's shot attempts have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Shot makes")){
            playerStats.addShotMakes(newStat);
            statusBar.setText(String.format("%s's shot makes have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("3-point shot attempts")){
            playerStats.addThreePointShotAttempts(newStat);
            statusBar.setText(String.format("%s's 3-point shot attempts have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("3-point shot makes")){
            playerStats.addThreePointShotMakes(newStat);
            statusBar.setText(String.format("%s's 3-point shot makes have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Free throw attempts")){
            playerStats.addFreeThrowAttempts(newStat);
            statusBar.setText(String.format("%s's free throw attempts have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Free throw makes")){
            playerStats.addFreeThrowMakes(newStat);
            statusBar.setText(String.format("%s's free throw makes have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Assists")){
            playerStats.addAssists(newStat);
            statusBar.setText(String.format("%s's assists have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Rebounds")){
            playerStats.addRebounds(newStat);
            statusBar.setText(String.format("%s's rebounds have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Blocks")){
            playerStats.addBlocks(newStat);
            statusBar.setText(String.format("%s's blocks have been successfully changed!", playerToEdit));
        } else if (statToEdit.equals("Steals")){
            playerStats.addSteals(newStat);
            statusBar.setText(String.format("%s's steals have been successfully changed!", playerToEdit));
        }
        editPlayerTextArea.setText(String.format("""
                        Player Name - %s
                        Shot Attempts - %d
                        Shot Makes - %d
                        3-Point Shot Attempts - %d
                        3-Point Shot Makes - %d
                        Free Throw Attempts - %d
                        Free Throw Makes - %d
                        Assists - %d
                        Rebounds - %d
                        Blocks - %d
                        Steals - %d""", playerToOutput.getPlayerInformation().getPlayerName().toUpperCase(), playerStats.getShotAttempts(), playerStats.getShotMakes(), playerStats.getThreePointShotAttempts(),
                playerStats.getThreePointShotMakes(), playerStats.getFreeThrowAttempts(), playerStats.getFreeThrowMakes(), playerStats.getAssists(), playerStats.getRebounds(), playerStats.getBlocks(), playerStats.getSteals()));
    }

    @FXML
    void displayInfo(ActionEvent event) {
        String optionSelected = allDisplayOptions.getValue();
        if (displayID.getChildren().size() == 6){
            displayID.getChildren().remove(4);
            displayID.getChildren().remove(4);
        }
        if (optionSelected == null){
            statusBar.setTextFill(Color.RED);
            statusBar.setText("Please select a display option to output!");
        } else if (optionSelected.equals("All players' information")) {
            displayTextArea.setText(String.format("%-10s %-15s %-15s %-10s %-12s %-12s %-10s %-15s %-15s\n", "PLAYER NO", "FIRST NAME", "LAST NAME", "JERSEY NO", "HEIGHT (cm)", "WEIGHT (kg)", "TEAM NAME", "DATE OF BIRTH", "POSITION"));

            //For loop to obtain and print all players' information and assign a player number based off position in array list.
            for(int playerInfo = 0; playerInfo < playersArray.size(); playerInfo++) {
                PlayerInformation currentPlayerInfo = playersArray.get(playerInfo).getPlayerInformation();

                displayTextArea.appendText(String.format("%-10d %-15s %-15s %-10d %-12d %-12d %-10s %-15s %-15s\n", playerInfo + 1, currentPlayerInfo.getPlayerName().split(" ")[0], currentPlayerInfo.getPlayerName().split(" ")[1],
                        currentPlayerInfo.getJerseyNo(), currentPlayerInfo.getHeight(), currentPlayerInfo.getWeight(), currentPlayerInfo.getTeam(), currentPlayerInfo.getDateOfBirth().getDate() + "/" + (currentPlayerInfo.getDateOfBirth().getMonth()+1) + "/" + (currentPlayerInfo.getDateOfBirth().getYear()+1900), currentPlayerInfo.getPosition()));
            }
        } else if (optionSelected.equals("All players' stats")){
            displayTextArea.setText(String.format("%-20s %-15s %-15s %-23s %-22s %-23s %-22s %-14s %-14s %-14s %-14s\n", "PLAYER NAME", "SHOT ATTEMPTS", "SHOT MAKES", "3-POINT SHOT ATTEMPTS", "3-POINT SHOT MAKES",
                    "FREE THROW ATTEMPTS", "FREE THROW MAKES", "ASSISTS", "REBOUNDS", "BLOCKS", "STEALS"));

            //Loops through all values in HashMap to assign a player name to an integer array of stats.
            for(int playerStats = 0; playerStats < playersArray.size(); playerStats++) {
                String currentPlayerName = playersArray.get(playerStats).getPlayerInformation().getPlayerName();
                PlayerStats currentPlayerStats = playersArray.get(playerStats).getPlayerStats();

                displayTextArea.appendText(String.format("%-25s %-15d %-18d %-20d %-24d %-22d %-18d %-15d %-14d %-13d %-13d\n", currentPlayerName, currentPlayerStats.getShotAttempts(), currentPlayerStats.getShotMakes(), currentPlayerStats.getThreePointShotAttempts(),
                        currentPlayerStats.getThreePointShotMakes(), currentPlayerStats.getFreeThrowAttempts(), currentPlayerStats.getFreeThrowMakes(), currentPlayerStats.getAssists(), currentPlayerStats.getRebounds(),
                        currentPlayerStats.getBlocks(), currentPlayerStats.getSteals()));
            }
        } else if (optionSelected.equals("Unique player stats")){
          /**  for(BasketballPlayer player : playersArray){
                uniquePlayers.add(player.getPlayerInformation().getPlayerName().toUpperCase());
            }
            ChoiceBox<String> playersToView = new ChoiceBox<>(FXCollections.observableArrayList(uniquePlayers));
            playersToView.setLayoutX(106);
            playersToView.setLayoutY(120);
            playersToView.prefWidth(150);
            displayID.getChildren().add(playersToView);*/
          loadUniquePlayers();
        } else if (optionSelected.equals("Top 10 scorers")){
            ArrayList<BasketballPlayer> allPlayersStats = new ArrayList<>(playersArray);

            displayTextArea.setText(String.format("TOP SCORERS:\n %-20s %-15s %-15s %-23s %-22s %-23s %-22s %-14s %-14s %-14s %-14s\n", "PLAYER NAME", "SHOT ATTEMPTS", "SHOT MAKES", "3-POINT SHOT ATTEMPTS", "3-POINT SHOT MAKES",
                    "FREE THROW ATTEMPTS", "FREE THROW MAKES", "ASSISTS", "REBOUNDS", "BLOCKS", "STEALS"));
            //Loops through newly created ArrayList 10 times and finds the highest scoring player after every iteration, and sets the
            //player's stats to 0 to ensure they aren't added multiple times to the top 10 scorers list.
            for(int iteration = 0; iteration < 10 && iteration <= allPlayersStats.size(); iteration++) {
                BasketballPlayer highestScorer = allPlayersStats.get(0);

                for(int bestPlayer = 1; bestPlayer < allPlayersStats.size(); bestPlayer++) {
                    if(allPlayersStats.get(bestPlayer).getPlayerStats().getTotalShotMakes() > highestScorer.getPlayerStats().getTotalShotMakes() ) {
                        highestScorer = allPlayersStats.get(bestPlayer);
                    }
                }
                for(int player = 0; player < allPlayersStats.size(); player++) {
                    if(allPlayersStats.get(player).getPlayerInformation().compareTo(highestScorer.getPlayerInformation()) > 0) {
                        allPlayersStats.remove(player);
                    }
                }
                displayTextArea.appendText(String.format("%-25s %-15d %-18d %-20d %-24d %-22d %-18d %-15d %-14d %-13d %-13d\n", highestScorer.getPlayerInformation().getPlayerName(), highestScorer.getPlayerStats().getShotAttempts(), highestScorer.getPlayerStats().getShotMakes(), highestScorer.getPlayerStats().getThreePointShotAttempts(),
                        highestScorer.getPlayerStats().getThreePointShotMakes(), highestScorer.getPlayerStats().getFreeThrowAttempts(), highestScorer.getPlayerStats().getFreeThrowMakes(), highestScorer.getPlayerStats().getAssists(), highestScorer.getPlayerStats().getRebounds(), highestScorer.getPlayerStats().getBlocks(), highestScorer.getPlayerStats().getSteals()));
            }
        } else if (optionSelected.equals("Top 10 most efficient players")){
            ArrayList<BasketballPlayer> allPlayersShootingPercentage = new ArrayList<>(playersArray);

            displayTextArea.setText(String.format("TOP SHOOTING PERCENTAGES:\n %-20s %-25s %-30s %-30s %-30s\n", "PLAYER NAME", "SHOT PERCENTAGE (%)", "3-POINT SHOT PERCENTAGE (%)", "FREE THROW PERCENTAGE (%)", "OVERALL SHOOTING PERCENTAGE (%)"));

            //Iterates 10 times to find the top 10 most efficient players in the allPlayersShootingPercentage ArrayList based off shooting percentage for every player and adds
            //them to topTenShootingPercentage ArrayList, and sets the player's stats to 0 to ensure they aren't added multiple times to the top 10 shooting percentage list.
            for(int iteration = 0; iteration < 10 && iteration <= allPlayersShootingPercentage.size() ; iteration++) {
                BasketballPlayer bestShooter = allPlayersShootingPercentage.get(0);

                for(int bestPlayer = 0; bestPlayer < allPlayersShootingPercentage.size(); bestPlayer++) {
                    if(allPlayersShootingPercentage.get(bestPlayer).getPlayerStats().getOverallShootingPercentage() > bestShooter.getPlayerStats().getOverallShootingPercentage()){
                        bestShooter = allPlayersShootingPercentage.get(bestPlayer);
                    }
                }

                for(int playerToReset = 0; playerToReset < allPlayersShootingPercentage.size(); playerToReset++) {
                    if(allPlayersShootingPercentage.get(playerToReset).getPlayerInformation().getPlayerName().equalsIgnoreCase(bestShooter.getPlayerInformation().getPlayerName())) {
                        allPlayersShootingPercentage.remove(playerToReset);
                    }
                }
                displayTextArea.appendText(String.format("%-25s %-30.2f %-30.2f %-30.2f %-30.2f\n", bestShooter.getPlayerInformation().getPlayerName(), (bestShooter.getPlayerStats().getShotMakes()/(double)bestShooter.getPlayerStats().getShotAttempts()) * TO_PERCENTAGE, (bestShooter.getPlayerStats().getThreePointShotMakes()/(double)bestShooter.getPlayerStats().getThreePointShotAttempts()) * TO_PERCENTAGE,
                        (bestShooter.getPlayerStats().getFreeThrowMakes()/(double)bestShooter.getPlayerStats().getFreeThrowAttempts()) * TO_PERCENTAGE, bestShooter.getPlayerStats().getOverallShootingPercentage() * TO_PERCENTAGE));

            }
        } else if (optionSelected.equals("Best 3pt shooting line up (Top 3 SGs, PGs and SFs)")){
            ArrayList<BasketballPlayer> allThreePointShooters = new ArrayList<>();

            for(int playerToFind = 0; playerToFind < playersArray.size(); playerToFind++) {
                if((playersArray.get(playerToFind).getPlayerInformation().getPosition().equalsIgnoreCase("SHOOTINGGUARD") || playersArray.get(playerToFind).getPlayerInformation().getPosition().equalsIgnoreCase("POINTGUARD") || playersArray.get(playerToFind).getPlayerInformation().getPosition().equalsIgnoreCase("SMALLFORWARD"))) {
                    allThreePointShooters.add(playersArray.get(playerToFind));
                }
            }

            displayTextArea.setText(String.format("Best 3pt shooters (Top 3 from SGs, PGs and SFs)\n %-20s %-25s %-25s \n", "PLAYER NAME", "3PT SHOOTING PERCENTAGE", "PLAYING POSITION"));
            for (int iteration = 0; iteration < 5  && iteration < allThreePointShooters.size(); iteration++) {
                BasketballPlayer bestShooter = findBestPlayer(allThreePointShooters);
                displayTextArea.appendText(String.format("%-21s %-25.2f %-25s \n", bestShooter.getPlayerInformation().getPlayerName(), (bestShooter.getPlayerStats().getThreePointShotMakes()/(double)bestShooter.getPlayerStats().getThreePointShotAttempts()) * TO_PERCENTAGE, bestShooter.getPlayerInformation().getPosition()));
                for (int playerToFind = 0; playerToFind < allThreePointShooters.size(); playerToFind++) {
                    if (allThreePointShooters.get(playerToFind).getPlayerInformation().getPlayerName().equalsIgnoreCase(bestShooter.getPlayerInformation().getPlayerName())) {
                        allThreePointShooters.remove(playerToFind);
                    }
                }
            }
        } else if (optionSelected.equals("Best recommended overall line up")){
            ArrayList<BasketballPlayer> bestTeamLineup = new ArrayList<>(),
                    shootingGuards = new ArrayList<>(),
                    pointGuards = new ArrayList<>(),
                    smallForwards = new ArrayList<>(),
                    powerForwards = new ArrayList<>(),
                    centers = new ArrayList<>();


            //Loops through all values in the ArrayList, for every value found in the ArrayList, we add various stats depending on the player's
            //playing position, then we respectively add them to an ArrayList based off position.
            for(int i = 0; i < playersArray.size(); i++) {
                String playerPosition = playersArray.get(i).getPlayerInformation().getPosition();
                if(playerPosition.equalsIgnoreCase("SHOOTINGGUARD")) {
                    shootingGuards.add(playersArray.get(i));
                } else if(playerPosition.equalsIgnoreCase("POINTGUARD")) {
                    pointGuards.add(playersArray.get(i));
                } else if(playerPosition.equalsIgnoreCase("SMALLFORWARD")) {
                    smallForwards.add(playersArray.get(i));
                } else if(playerPosition.equalsIgnoreCase("POWERFORWARD")) {
                    powerForwards.add(playersArray.get(i));
                } else {
                    centers.add(playersArray.get(i));
                }
            }

            BasketballPlayer bestPlayer = shootingGuards.get(0);
            for(int i = 1; i < shootingGuards.size(); i++) {
                if(shootingGuards.get(i).compareTo(bestPlayer) > 0) {
                    bestPlayer = shootingGuards.get(i);
                }
            }
            bestTeamLineup.add(bestPlayer);

            bestPlayer = pointGuards.get(0);
            for(int i = 1; i < pointGuards.size(); i++) {
                if(pointGuards.get(i).compareTo(bestPlayer) > 0) {
                    bestPlayer = pointGuards.get(i);
                }
            }
            bestTeamLineup.add(bestPlayer);

            bestPlayer = smallForwards.get(0);
            for(int i = 1; i < smallForwards.size(); i++) {
                if(smallForwards.get(i).compareTo(bestPlayer) > 0) {
                    bestPlayer = smallForwards.get(i);
                }
            }
            bestTeamLineup.add(bestPlayer);

            bestPlayer = powerForwards.get(0);
            for(int i = 1; i < powerForwards.size(); i++) {
                if(powerForwards.get(i).compareTo(bestPlayer) > 0) {
                    bestPlayer = powerForwards.get(i);
                }
            }
            bestTeamLineup.add(bestPlayer);

            bestPlayer = centers.get(0);
            for(int i = 1; i < centers.size(); i++) {
                if(centers.get(i).compareTo(bestPlayer) > 0) {
                    bestPlayer = centers.get(i);
                }
            }
            bestTeamLineup.add(bestPlayer);

            displayTextArea.setText(String.format("BEST RECOMMENDED OVERALL LINEUP ACROSS BOTH TEAMS:\n %-20s %-20s \n", "PLAYER NAME", "PLAYING POSITION"));
            for (int playerInfo = 0; playerInfo < bestTeamLineup.size(); playerInfo++) {
                displayTextArea.appendText(String.format("%-21s %-20s \n", bestTeamLineup.get(playerInfo).getPlayerInformation().getPlayerName(), bestTeamLineup.get(playerInfo).getPlayerInformation().getPosition()));
            }
        }
    }

    @FXML
    void addPlayer(MouseEvent event) {
        String firstName = newPlayerFirstName.getText().strip();
        String lastName = newPlayerLastName.getText().strip();
        int jerseyNumber;
        int height;
        int weight;
        String teamName = newPlayerTeamName.getText().strip();
        Date dateOfBirth;
        String position = newPlayerPosition.getText().strip();
        boolean validData;

        validData = validateName(firstName);
        if(!validData) {
            statusBar.setTextFill(Color.RED);
            statusBar.setText("The new player's first name must only include alphabetical characters, please try again!\n");
            return;
        }
        firstName = firstName.toUpperCase();

        validData = validateName(lastName);
        if(!validData) {
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's last name must only include alphabetical characters, please try again!\n", firstName));
            return;
        }
        lastName = lastName.toUpperCase();

        try {
            jerseyNumber = Integer.parseInt(newPlayerJeresyNo.getText().strip());
        } catch (NumberFormatException e){
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's jersey number must only include integer values, please try again!\n", firstName));
            return;
        }

        try {
            height = Integer.parseInt(newPlayerHeight.getText().strip());
        } catch (NumberFormatException e){
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's height must only include integer values, please try again!\n", firstName));
            return;
        }


        try {
            weight = Integer.parseInt(newPlayerWeight.getText().strip());
        } catch (NumberFormatException e){
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's weight must only include integer values, please try again!\n", firstName));
            return;
        }

        if(!teamName.equalsIgnoreCase("LEBRON") && !teamName.equalsIgnoreCase("DURANT")) {
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's team name is incorrect, please try again!\n", firstName));
            return;
        }

        try {
            dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(newPlayerDateOfBirth.getText().strip());
        } catch (ParseException e) {
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's date of birth must match the format DD/MM/YYYY, please try again!\n", firstName));
            return;
        }

        if(!position.equalsIgnoreCase("POINTGUARD") && !position.equalsIgnoreCase("SHOOTINGGUARD") && !position.equalsIgnoreCase("SMALLFORWARD") && !position.equalsIgnoreCase("POWERFORWARD") && !position.equalsIgnoreCase("CENTER")) {
            statusBar.setTextFill(Color.RED);
            statusBar.setText(String.format("%s's position must be one of: pointguard, shootingguard, smallforward, powerforward or center, please try again!\n", firstName));
            return;
        }

        BasketballPlayer newPlayer = new BasketballPlayer(new PlayerInformation(firstName + " " + lastName, jerseyNumber, height, weight, teamName, dateOfBirth, position), new PlayerStats(0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

        boolean playerFound = false;
        for (BasketballPlayer basketballPlayer : playersArray) {
            if (basketballPlayer.getPlayerInformation().compareTo(newPlayer.getPlayerInformation()) == 0) {
                statusBar.setTextFill(Color.RED);
                statusBar.setText(String.format("%s %s already exists in the player list and could not be added as a new All-Star Basketball Player!\n", firstName, lastName));
                playerFound = true;
            }
        }
        if(!playerFound) {
            playersArray.add(newPlayer);
            statusBar.setTextFill(Color.GREEN);
            if (teamName.equalsIgnoreCase("Lebron")){
                teamLebronTextArea.appendText(firstName + " " + lastName);
            } else{
                teamDurantTextArea.appendText(firstName + " " + lastName);
            }
            newPlayerFirstName.clear();
            newPlayerLastName.clear();
            newPlayerJeresyNo.clear();
            newPlayerHeight.clear();
            newPlayerWeight.clear();
            newPlayerDateOfBirth.clear();
            newPlayerTeamName.clear();
            newPlayerPosition.clear();
            //loadUniquePlayers();
            loadPlayers();
            statusBar.setText(String.format("%s %s has been successfully added as a new All-Star Basketball Player!\n", firstName, lastName));
        }
    }

    /**
     * validateName loops through all the characters in a string to find the values stored at every index
     * @param name String variable to be searched
     * @return True if the string only contains Letters within the alphabet, False otherwise.
     */
    private static boolean validateName(String name) {
        if(name.equals("")) {
            return false;
        }
        char[] firstNameArray = name.toCharArray();
        for(char character: firstNameArray) {
            if(!Character.isLetter(character)) {
                return false;
            }
        }
        return true;
    }

    /**
     * findBestPlayer function loops through an ArrayList of Basketball Players to find the player with the highest overall stats (ie: best shooting percentage,
     * most rebounds, best small forward, etc)
     * @param players ArrayList containing basketball players
     * @return BasketballPlayer object containing the best player found.
     */
    private static BasketballPlayer findBestPlayer(ArrayList<BasketballPlayer> players) {
        BasketballPlayer bestPlayer = null;
        if (players.size() == 1) {
            bestPlayer = players.get(0);
        } else {
            bestPlayer = players.get(0);
            if(players.size() != 1) {
                for(int i = 1; i < players.size(); i++) {
                    if(players.get(i).getPlayerStats().getThreePointShotMakes()/(double)players.get(i).getPlayerStats().getThreePointShotAttempts()  > bestPlayer.getPlayerStats().getThreePointShotMakes()/(double)bestPlayer.getPlayerStats().getThreePointShotAttempts()) {
                        bestPlayer = players.get(i);
                    }
                }
            }
        }
        return bestPlayer;
    }

    /**
     * FileReader reads in all Basketball Players from the file specified by the user
     * @param basketballFile File for data be read from
     * @return ArrayList of all the Basketball Players read from the file
     * @throws ParseException Whenever the player's date of birth cannot be parsed.
     */
    public static ArrayList<BasketballPlayer> fileReader(File basketballFile) throws ParseException {
        Scanner worldReader = null;
        ArrayList<BasketballPlayer> playersArray = new ArrayList<>();
        try {
            worldReader = new Scanner(basketballFile);
            while (worldReader.hasNextLine()) {
                String line = worldReader.nextLine();
                String[] lineInfo = line.split(",");
                String playerName = String.valueOf(lineInfo[0]);
                int jerseyNo = Integer.parseInt(lineInfo[1]);
                int height = Integer.parseInt(lineInfo[2]);
                int weight = Integer.parseInt(lineInfo[3]);
                String team = String.valueOf(lineInfo[4]);
                Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(lineInfo[5]));
                String position = String.valueOf(lineInfo[6]);
                int shotAttempts = Integer.parseInt(lineInfo[7]);
                int shotMakes = Integer.parseInt(lineInfo[8]);
                int threePointShotAttempts = Integer.parseInt(lineInfo[9]);
                int threePointShotMakes = Integer.parseInt(lineInfo[10]);
                int freeThrowAttempts = Integer.parseInt(lineInfo[11]);
                int freeThrowMakes = Integer.parseInt(lineInfo[12]);
                int assists = Integer.parseInt(lineInfo[13]);
                int blocks = Integer.parseInt(lineInfo[14]);
                int steals = Integer.parseInt(lineInfo[15]);
                int rebounds = Integer.parseInt(lineInfo[16]);

                PlayerInformation playerInfo = new PlayerInformation(playerName, jerseyNo, height, weight, team, dateOfBirth, position);
                PlayerStats playerStats = new PlayerStats(shotAttempts, shotMakes, threePointShotAttempts, threePointShotMakes, freeThrowAttempts, freeThrowMakes, assists, steals, blocks, rebounds);
                BasketballPlayer basketballPlayer = new BasketballPlayer(playerInfo, playerStats);

                playersArray.add(basketballPlayer);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + basketballFile.getAbsolutePath());
        }
        return playersArray;
    }

    /**
     * FileWriter writes all the current Basketball Players to the file specified by the user
     * @param allPlayers ArrayList of all the Basketball Players
     * @param file File for data be written to
     */
    public static void fileWriter(ArrayList<BasketballPlayer> allPlayers, File file) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(file);
        } catch(FileNotFoundException e) {
            System.err.println("Could not find file: " + file.getAbsolutePath());
        }

        for (int i = 0; i < allPlayers.size(); i++) {
            PlayerInformation onePlayerInfo = allPlayers.get(i).getPlayerInformation();
            PlayerStats onePlayerStats = allPlayers.get(i).getPlayerStats();
            printWriter.write(onePlayerInfo.getPlayerName() + ",");
            printWriter.write(onePlayerInfo.getJerseyNo() + ",");
            printWriter.write(onePlayerInfo.getHeight() + ",");
            printWriter.write(onePlayerInfo.getWeight() + ",");
            printWriter.write(onePlayerInfo.getTeam() + ",");
            printWriter.write(onePlayerInfo.getDateOfBirth().getDate() + "/" + (onePlayerInfo.getDateOfBirth().getMonth()+1) + "/" + (onePlayerInfo.getDateOfBirth().getYear()+1900) + ",");
            printWriter.write(onePlayerInfo.getPosition() + ",");
            printWriter.write(onePlayerStats.getShotAttempts() + ",");
            printWriter.write(onePlayerStats.getShotMakes() + ",");
            printWriter.write(onePlayerStats.getThreePointShotAttempts() + ",");
            printWriter.write(onePlayerStats.getThreePointShotMakes() + ",");
            printWriter.write(onePlayerStats.getFreeThrowAttempts() + ",");
            printWriter.write(onePlayerStats.getFreeThrowMakes() + ",");
            printWriter.write(onePlayerStats.getAssists() + ",");
            printWriter.write(onePlayerStats.getBlocks() + ",");
            printWriter.write(onePlayerStats.getSteals() + ",");
            printWriter.write(onePlayerStats.getRebounds() + "\n");
        }
        printWriter.close();
    }
}
