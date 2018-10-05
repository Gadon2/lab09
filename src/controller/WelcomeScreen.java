package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeScreen {

    private Stage s;
    private String title;
    private FXMLLoader fxmlLoader;

    public WelcomeScreen(Stage s) {
        this.s = s;
        this.title = "AAA movie rental system";
        this.fxmlLoader = new FXMLLoader(getClass().getResource("../view/mainpage.fxml"));
    }

    public void start()  {
        s.setTitle(title);
        // set controller for start.fxml
        fxmlLoader.setController(new WelcomeController(s));
        try {
            // load into a Parent node called root
            Parent root = fxmlLoader.load();
            Scene sc = new Scene(root);
            s.setScene(sc);
            s.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
