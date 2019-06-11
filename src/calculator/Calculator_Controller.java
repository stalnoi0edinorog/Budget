package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import spending.Context;
import spending.Spending_Controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static java.lang.Math.round;


public class Calculator_Controller implements Initializable {

    public Text output;
    private Calculator_Calculation model = new Calculator_Calculation();
    private boolean check = false;

    @Override
    @FXML
    public void initialize(URL location, ResourceBundle resource){
        Context.getInstance().setControllerC(this);
    }

    Spending_Controller mainCont = Context.getInstance().getMainController();

    public void delete() {
        if(!output.getText().isEmpty())
            output.setText(output.getText().substring(0, output.getText().length() - 1)); }

    public void clickNum(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
       if (output.getText().matches("[0-9]+\\.?[0-9]*[*\\-+/][0-9]+\\.?[0-9]*")) {
           check = true;
       }
    }

    public void clickOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (output.getText().isEmpty())
            return;

        if (isOperator(output.getText().charAt(output.getText().length() - 1))) {
            delete();
            output.setText(output.getText() + value);
            return;
        }
        if (check){
            output.setText(model.calculation(output.getText()) + value);
            check = false;
      } else { output.setText(output.getText() + value); }
    }

    @FXML
    void  clickOk(ActionEvent event){
        Button value = ((Button) event.getSource());
        Stage stage = (Stage) value.getScene().getWindow();

        if (output.getText().isEmpty()) {
            stage.close();
            return;
        }

        if (isOperator(output.getText().charAt(output.getText().length() - 1)) &&
                !isOperator(output.getText().charAt(output.getText().length() - 2)) ){
            output.setText(output.getText().substring(0, output.getText().length() - 1));
        }

        Label costs = mainCont.getSpending();
        Button button = mainCont.getButton();
        double newCosts;

        String textCosts = costs.getText();
        int oldCosts = Integer.parseInt(textCosts.substring(0, textCosts.length() - 2));

        String textButt = mainCont.getButton().getText();
        int oldTextButt;

        if (output.getText().matches("[0-9]+\\.?[0-9]*")){
            newCosts = Double.parseDouble(output.getText());
            if (costs.getText().equals("0 \u20BD")) { // В расходы
                costs.setText(round(newCosts) + " " + "\u20BD");
            } else{
                costs.setText(round(oldCosts + newCosts) + " " + "\u20BD");
            }
            if (button.getText().equals("")){ // В кнопки
                button.setText(round(newCosts) + " " + "\u20BD");
            } else {
                oldTextButt = Integer.parseInt(textButt.substring(0, textButt.length() - 2));
                button.setText(round(oldTextButt + newCosts) + " " + "\u20BD");
            }
        }
       else {
            if (costs.getText().equals("0 \u20BD")) { //В расходы
               costs.setText(round(model.calculation(output.getText())) + " " + "\u20BD");
            } else {
                 costs.setText(round(oldCosts + model.calculation(output.getText())) + " " + "\u20BD");
            }
            if (button.getText().equals("")) { //В кнопки
               button.setText(round(model.calculation(output.getText())) + " " + "\u20BD");
            } else {
                oldTextButt = Integer.parseInt(textButt.substring(0, textButt.length() - 2));
                button.setText(round(oldTextButt + model.calculation(output.getText())) + " " + "\u20BD");
            }
        }
        stage.close();
    }

    public boolean isOperator(char ch){
        ArrayList<Character> list = new ArrayList<>() ;
        list.add('+');
        list.add('-');
        list.add('*');
        list.add('/');

        if (list.contains(ch)){
            return true;
        }
        return false;
    }
}
