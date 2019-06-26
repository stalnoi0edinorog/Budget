package calculator;

public class Calculation {

    double calculation(String output) {

        String[] listNumbers = output.split("[-+*/]");

        if (listNumbers.length == 1)
            return Double.parseDouble(listNumbers[0]);

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
