package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainController {
    @FXML
    private Pane pane;
    @FXML
    private Button plus;
    @FXML
    private Button costs;

    private int x = 13;

    public MainController() {
    }


    public void openCalculator (ActionEvent event) throws Exception {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("calculator.fxml"));
        Scene scene = new Scene(root, 258, 326);
        stage.setScene(scene);
        stage.show();

        System.out.println();
    }

    public void addButton (ActionEvent event) {
        if (x != 261) {
            TextField text = new TextField();
            text.setLayoutX(x - 7);
            text.setMinHeight(3);
            text.setPrefSize(65, 10);
            text.setLayoutY(342);

            pane.getChildren().add(text);

            plus.setLayoutX(x + 62);
            Button button = new Button();
            button.setLayoutX(x);
            button.setLayoutY(355);
            button.setPrefSize(45, 45);
            button.setStyle("-fx-background-radius: 60");

            pane.getChildren().add(button);
            x += 62;
        }
        else {
            pane.getChildren().remove(plus);
        }

    }
}
