package controller;


import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class WelcomeController {

    //startButton is unused.
    @FXML
    private Button startButton;

    private Stage currStage;

    public WelcomeController(Stage s) {
        currStage = s;
    }

    @FXML
    public void initialize() {
        // This function is for loading initialisation of your controller.
        // Since this example doesn't need any initialisation, I just leave it empty.
        // I deliberately put this function in every controller in order to let you know
        // that you may(should) need this function in your project.
    }

    @FXML
    public void handleStartButton() {
    	  RentScreen rs = new RentScreen(currStage);
          rs.start();
    }
}
