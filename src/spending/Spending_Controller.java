package spending;

import calculator.Calculator_Controller;
import calculator.Calculator_Main;
import incoming.Incoming_Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class Spending_Controller implements Initializable {
    @FXML
    private Pane pane;
    @FXML
    private Button plus;

    private int x = 27;


    private Button button;
    private Button newButton;

    public Button getButton() {
        return button;
    }

    @FXML
    private Label spending;

    public Label getSpending() {
        return spending;
    }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resource) {
        Context.getInstance().setMainController(this);
    }

    Calculator_Controller cont = Context.getInstance().getControllerC();

    public void openIncoming(ActionEvent event) throws Exception {

        Button value = ((Button) event.getSource());
        Stage stage = (Stage) value.getScene().getWindow();

        button = ((Button) event.getSource());
        Stage newStage = new Stage();
        stage.close();
        new Incoming_Main().start(newStage);
        button = null;
    }

    public void addButton(ActionEvent event) {
        if (x == 479)
            pane.getChildren().remove(plus);

        plus.setLayoutX(x + 113);
        Button butt = new Button();
        butt.setLayoutX(x);
        butt.setLayoutY(345);
        butt.setPrefSize(70, 70);
        butt.setStyle("-fx-background-color: #F5DEB3; -fx-background-radius: 60");
        butt.setOnAction(e -> {
            try {
                openCalculator(event);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
        pane.getChildren().add(butt);
        x += 113;
    }

    public void openCalculator(ActionEvent event) throws Exception {
        //System.out.println(event.getSource());
        button = ((Button) event.getSource());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);

        new Calculator_Main().start(stage);
    }
}

