package spending;

import calculator.Calculator_Main;
import incoming.Incoming_Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Categories;

import java.util.*;


public class Spending_Controller  {
    @FXML
    private Pane pane;
    @FXML
    private Button plus;
    @FXML
    private Button spending;
    @FXML
    private Button products;
    @FXML
    private Button transport;
    @FXML
    private Button housing;
    @FXML
    private Button health;
    @FXML
    private Button cafe;
    @FXML
    private Button leisure;
    @FXML
    private Button clothes;
    @FXML
    private Button presents;
    @FXML
    private Button internet;
    @FXML
    private Text productsT;
    @FXML
    private Text transportT;
    @FXML
    private Text housingT;
    @FXML
    private Text healthT;
    @FXML
    private Text cafeT;
    @FXML
    private Text leisureT;
    @FXML
    private Text clothesT;
    @FXML
    private Text presentsT;
    @FXML
    private Text internetT;


    private int x = 27;
    private int checkStat = 0;

    public static int checkWindow = 0;
    public static Button currentButt;

    public void initialize(){
        spending.textProperty().bindBidirectional(Categories.spending.textProperty());
        products.textProperty().bindBidirectional(Categories.products.textProperty());
        transport.textProperty().bindBidirectional(Categories.transport.textProperty());
        housing.textProperty().bindBidirectional(Categories.housing.textProperty());
        health.textProperty().bindBidirectional(Categories.health.textProperty());
        cafe.textProperty().bindBidirectional(Categories.cafe.textProperty());
        leisure.textProperty().bindBidirectional(Categories.leisure.textProperty());
        clothes.textProperty().bindBidirectional(Categories.clothes.textProperty());
        presents.textProperty().bindBidirectional(Categories.presents.textProperty());
        internet.textProperty().bindBidirectional(Categories.internet.textProperty());
    }



    public void openIncoming(ActionEvent event) throws Exception {
        Button value = ((Button) event.getSource());
        Stage stage = (Stage) value.getScene().getWindow();
        checkWindow = 1;

        Stage newStage = new Stage();
        stage.close();
        new Incoming_Main().start(newStage);
    }

    public void addButton(ActionEvent event) {
        if (x == 479)
            pane.getChildren().remove(plus);

        plus.setLayoutX(x + 113);
        Button newButt = new Button();
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

        newButt.setLayoutX(x);
        newLabel.setLayoutX(x + 9);
        newButt.setLayoutY(434);
        newLabel.setLayoutY(414);
        newLabel.setFont(new Font("System Italic", 16));
        newButt.setPrefSize(70, 70);
        newButt.setStyle("-fx-background-color: #F5DEB3; -fx-background-radius: 60");
       /* newButt.setOnAction(e -> {
            try {
                openCalculator(event);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });*/
        x += 113;

        pane.getChildren().add(newButt);
        pane.getChildren().add(newLabel);
    }

    public void openCalculator(ActionEvent event) throws Exception {
        currentButt = ((Button) event.getSource());

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        new Calculator_Main().start(stage);
    }

    public void openStatictics(ActionEvent event) throws Exception {
        List<Button> list = new ArrayList<>(Arrays.asList(products, transport, housing, health, cafe, leisure, clothes, presents, internet));
        List<Button> sortedList = new ArrayList<>();
        for (Button elem: list){
            if (!elem.getText().isEmpty())
                sortedList.add(elem);
            if (elem.getText().isEmpty()){
                elem.setText("0");
                sortedList.add(elem);
            }
        }

        sortedList.sort((b1, b2) -> (int) (Long.parseLong(b1.getText()) - Long.parseLong(b2.getText())));

        if (checkStat == 1){
            Button value = ((Button) event.getSource());
            Stage stage = (Stage) value.getScene().getWindow();

            Stage newStage = new Stage();
            stage.close();
            new Spending_Main().start(newStage);
            checkStat = 0;
        }

        double x,y;
        double x0 = 252;
        double y0 = 198;
        double radius = 150;
        Circle circle = new Circle(x0, y0, radius);
        double angle = -1.5;

        for (Button element: sortedList){
            x = x0 + circle.getRadius() * Math.cos(angle);
            y = y0 + circle.getRadius() * Math.sin(angle);
            element.setLayoutX(x);
            element.setLayoutY(y);
            angle += 0.7;
        }

        productsT.setLayoutX(products.getLayoutX() + 4);
        transportT.setLayoutX(transport.getLayoutX() + 4);
        housingT.setLayoutX(housing.getLayoutX() + 4);
        healthT.setLayoutX(health.getLayoutX() + 4);
        cafeT.setLayoutX(cafe.getLayoutX() + 4);
        leisureT.setLayoutX(leisure.getLayoutX() + 4);
        clothesT.setLayoutX(clothes.getLayoutX() + 4);
        presentsT.setLayoutX(presents.getLayoutX() + 4);
        internetT.setLayoutX(internet.getLayoutX() + 4);

        productsT.setLayoutY(products.getLayoutY() - 5);
        transportT.setLayoutY(transport.getLayoutY() - 5);
        housingT.setLayoutY(housing.getLayoutY() - 5);
        healthT.setLayoutY(health.getLayoutY() - 5);
        cafeT.setLayoutY(cafe.getLayoutY() - 5);
        leisureT.setLayoutY(leisure.getLayoutY() - 5);
        clothesT.setLayoutY(clothes.getLayoutY() - 5);
        presentsT.setLayoutY(presents.getLayoutY() - 5);
        internetT.setLayoutY(internet.getLayoutY() - 5);

        checkStat = 1;
    }
}

