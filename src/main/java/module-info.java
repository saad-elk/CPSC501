module main.basketball.cpsc233w22basketball {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.basketball.cpsc233w22basketball to javafx.fxml;
    exports main.basketball.cpsc233w22basketball;
}