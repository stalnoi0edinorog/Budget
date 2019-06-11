package spending;

import calculator.Controller;
import calculator.MainCalculator;
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


public class MainController implements Initializable {
    @FXML
    private Pane pane;
    @FXML
    private Button plus;

    private int x = 27;


    private Button button = new Button();
    public Button getButton() { return button; }

    @FXML
    private Label spending;
    public Label getSpending() { return spending; }

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resource){
        Context.getInstance().setMainController(this);
    }

    Controller cont = Context.getInstance().getController();

    public void openIncoming (ActionEvent event) throws Exception {
        button = ((Button) event.getSource());
        Stage stage = new Stage();

    }


    public void openCalculator (ActionEvent event) throws Exception {
        button = ((Button) event.getSource());
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        new MainCalculator().start(stage);
    }


    public void addButton (ActionEvent event){
        if (x == 479)
            pane.getChildren().remove(plus);

        plus.setLayoutX(x + 113);
        Button button = new Button();
        button.setLayoutX(x);
        button.setLayoutY(345);
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
        x += 113;
    }
}
