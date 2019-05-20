package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;



public class Controller {

    public Text output;
    private Model model = new Model();


    public void delete() { output.setText(""); }

    public void clickNum(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
    }

    public void clickOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            output.setText(output.getText() + value);
        } else {
            output.setText(String.valueOf(model.calculation(String.valueOf(output.getText()))));
        }
    }
}
