package incoming;

import calculator.Calculator_Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import spending.Spending_Main;

public class Incoming_Controller {
    @FXML
    private Button plus;
    @FXML
    private Pane pane;

    private Button button = new Button();
    private int x = 121;


    public void openCalculator(ActionEvent event) throws Exception {
        button = ((Button) event.getSource());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        new Calculator_Main().start(stage);
    }

    public void openSpending(ActionEvent event) throws Exception{
        Button value = ((Button) event.getSource());
        Stage stage = (Stage) value.getScene().getWindow();

        button = ((Button) event.getSource());
        Stage newStage = new Stage();
        stage.close();
        new Spending_Main().start(newStage);
    }
    public void addButton(ActionEvent event) { // Нужно поправить
        if (x < 582) {
            if (x == 497) {
                plus.setLayoutY(160);
                plus.setLayoutX(27);
            } else {
                plus.setLayoutX(x + 94);
            }

            Button button = new Button();
            button.setLayoutX(x);
            button.setLayoutY(70);
            //button.setLayoutY(160);
            button.setPrefSize(70, 70);
            button.setStyle("-fx-background-color: #F5DEB3; -fx-background-radius: 60");
            button.setOnAction(e -> {
                try {
                    openCalculator(event);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });

            pane.getChildren().add(button);
            x += 94;
            System.out.println(x);
        }
    }
}


