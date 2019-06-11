package spending;

import calculator.Calculator_Controller;

public class Context {
    public final static Context instance = new Context();
    public static Context getInstance(){ return instance; }

    private Spending_Controller mainController;
    public void setMainController(Spending_Controller mainController){ this.mainController = mainController; }
    public Spending_Controller getMainController(){ return mainController; }

    private Calculator_Controller controller;
    public void setControllerC(Calculator_Controller controller){ this.controller = controller; }
    public Calculator_Controller getControllerC() { return controller; }




}
