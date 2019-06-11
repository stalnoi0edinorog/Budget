package incoming;

import calculator.MainCalculator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControllerIncoming {
    @FXML
    private Button plus;
    @FXML
    private Pane pane;

    private Button button = new Button();
    private int x = 121;


    public void openCalculator (ActionEvent event) throws Exception {
        button = ((Button) event.getSource());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        new MainCalculator().start(stage);
    }

    public void addButton (ActionEvent event){ // Нужно поправить
        /** if (x == 497) {
            plus.setLayoutY(160);
            plus.setLayoutX(27);
            x = 27;
        } else
            plus.setLayoutX(x + 94);

        Button button = new Button();
        button.setLayoutX(x);
        if (x < 498)
            button.setLayoutY(70);
         else
             button.setLayoutY(160);
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
    }**/
}
}

