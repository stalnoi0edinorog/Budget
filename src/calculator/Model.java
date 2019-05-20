package calculator;

public class Model {

    public double calculation(String output) {

        String[] listNum = output.split("[-+*/]");
        String[] listOp = output.split("[0-9]+\\.?[0-9]*");
        double result = Double.parseDouble(listNum[0]);

            for (int i = 0; i < listNum.length - 1; i++) {
                    switch (listOp[i+1]) {
                    case "-":
                        result -= Double.parseDouble(listNum[i + 1]);
                        break;
                    case "+":
                        result += Double.parseDouble(listNum[i + 1]);
                        break;
                    case "*":
                        result *=  Double.parseDouble(listNum[i + 1]);
                        break;
                    case "/":
                        result /=  Double.parseDouble(listNum[i + 1]);
                        break;
                }
            }
        return result;

    }

}
