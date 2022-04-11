package main.basketball.cpsc233w22basketball;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("basketball.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("All-Star Basketball Stat Tracker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws ParseException {
        if (args.length == 1) {
            File file = new File(args[0]);
            if (file.exists() && file.canRead() && file.isFile()) {
                MainController.fileReader(file);
            } else {
                System.out.println("File could not be read, existing players have not been read!");
            }
        } else if (args.length > 1) {
            System.out.println("Exiting program, too many arguments have been inputted.");
            System.exit(0);
        }
        launch();
    }
}