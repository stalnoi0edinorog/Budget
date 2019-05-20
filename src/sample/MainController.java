package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class MainController {

    @FXML
    private Button plus;
    @FXML
    private Label costs;


    public void openNewStage(ActionEvent actionEvent) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        Scene scene = new Scene(root, 320, 326);
        stage.setScene(scene);
        stage.show();

        System.out.println();
    }
}
