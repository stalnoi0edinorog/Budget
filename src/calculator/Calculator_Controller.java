package calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Categories;
import static spending.Spending_Controller.checkWindow;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.round;

public class Calculator_Controller {
    @FXML
    public Text output;

    private Calculation model = new Calculation();
    private boolean check = false;
    private Button category = Categories.getCategoryButton();

    public void delete() {
        if(!output.getText().isEmpty())
            output.setText(output.getText().substring(0, output.getText().length() - 1)); }

    public void clickNum(ActionEvent event) {
        String value = ((Button)event.getSource()).getText();
        output.setText(output.getText() + value);
        String text = output.getText();

        if (text.equals(".") || text.length() > 1 && text.charAt(text.length() - 1) == text.charAt(text.length() - 2)
                && text.charAt(text.length() - 1) == '.')
            delete();

       if (text.matches("[0-9]+\\.?[0-9]*[*\\-+/][0-9]+\\.?[0-9]*")) {
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
      } else
          output.setText(output.getText() + value);
    }

        @FXML
        public void  clickOk(ActionEvent event) {
            Button butt = ((Button) event.getSource());
            Stage stage = (Stage) butt.getScene().getWindow();
            String text = output.getText();

            if (output.getText().isEmpty()) {
                stage.close();
                return;
            }
            if (isOperator(text.charAt(output.getText().length() - 1)) && isOperator(text.charAt(output.getText().length() - 2)))
                delete();

            long result = round(model.calculation(text));

            if (category.getText().isEmpty())
                category.setText(String.valueOf(result));
            else
                category.setText(String.valueOf(Long.parseLong(category.getText()) + result));

            switch (checkWindow){
                case 0: {
                    if (Categories.spending.getText().isEmpty()) {
                        Categories.spending.setText(String.valueOf(result));
                        stage.close();
                        break;
                    }
                    Categories.spending.setText(String.valueOf(Long.parseLong(Categories.spending.getText()) + result));
                    break;
                }
                case 1: {
                    if (Categories.incoming.getText().isEmpty()) {
                        Categories.incoming.setText(String.valueOf(result));
                        stage.close();
                        break;
                    }
                    Categories.incoming.setText(String.valueOf(Long.parseLong(Categories.incoming.getText()) + result));
                    break;
                }
            }
            stage.close();
        }

        private boolean isOperator(char ch){
        List list = Arrays.asList('+', '-', '*', '/');
            return list.contains(ch);
        }
}



