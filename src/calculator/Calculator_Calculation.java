package calculator;

public class Calculator_Calculation {

    public double calculation(String output) {

        String[] listNumbers = output.split("[-+*/]");
        String operator = output.split("[0-9]+\\.?[0-9]*")[1];
        double result = Double.parseDouble(listNumbers[0]);

        switch (operator) {
            case "-":
                result -= Double.parseDouble(listNumbers[1]);
                break;
            case "+":
                result += Double.parseDouble(listNumbers[1]);
                break;
            case "*":
                result *=  Double.parseDouble(listNumbers[1]);
                break;
            case "/":
                result /=  Double.parseDouble(listNumbers[1]);
                break;
        }

        return result;

    }

}
