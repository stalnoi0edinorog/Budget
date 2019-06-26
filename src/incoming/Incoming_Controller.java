package incoming;

import calculator.Calculator_Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import spending.Spending_Main;
import model.Categories;
import static spending.Spending_Controller.currentButt;
import static spending.Spending_Controller.checkWindow;

public class Incoming_Controller {
    @FXML
    private Button incomingButt;
    @FXML
    private Button plus;
    @FXML
    private Pane pane;
    @FXML
    private Button salary;

    private int x = 121;

    public void initialize(){
        salary.textProperty().bind(Categories.salary.textProperty());
        incomingButt.textProperty().bind(Categories.incoming.textProperty());
    }

    public void openCalculator(ActionEvent event) throws Exception {
        currentButt = (Button) event.getSource();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        new Calculator_Main().start(stage);
    }

    public void openSpending(ActionEvent event) throws Exception{
        Button value = ((Button) event.getSource());
        Stage stage = (Stage) value.getScene().getWindow();
        checkWindow = 0;

        Stage newStage = new Stage();
        stage.close();
        new Spending_Main().start(newStage);
    }
    public void addButton(ActionEvent event) {
        if (x < 582) {
            if (x == 497) {
                pane.getChildren().remove(plus);
            } else {
                plus.setLayoutX(x + 94);
            }

            TextField textField = new TextField();
            Button textOk = new Button("✓");
            Label newLabel = new Label();
            Stage stage = new Stage();
            Pane root = new Pane();

            textField.setLayoutX(1);
            textField.setLayoutY(3);
            textOk.setLayoutX(152);
            textOk.setLayoutY(3);
            textOk.setOnAction(event1 ->{
                newLabel.setText(textField.getText());
                stage.close();
            });

            root.getChildren().add(textField);
            root.getChildren().add(textOk);

            Scene scene = new Scene(root, 181, 30);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setY(300);
            stage.setX(590);
            stage.show();

            Button button = new Button();
            newLabel.setLayoutX(x + 9);
            button.setLayoutX(x);
            newLabel.setLayoutY(165);
            newLabel.setFont(new Font("System Italic", 16));
            button.setLayoutY(193);
            button.setPrefSize(70, 70);
            button.setStyle("-fx-background-color: #F5DEB3; -fx-background-radius: 60");
            /**button.setOnAction(e -> {
                try {
                    openCalculator(event);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            });**/
            pane.getChildren().add(button);
            pane.getChildren().add(newLabel);
            x += 94;
        }
    }
}


