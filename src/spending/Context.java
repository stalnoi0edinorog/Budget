package spending;

import calculator.Controller;

public class Context {
    public final static Context instance = new Context();
    public static Context getInstance(){ return instance; }

    private  MainController mainController;
    public void setMainController(MainController mainController){ this.mainController = mainController; }
    public MainController getMainController(){ return mainController; }

    private Controller controller;
    public void setController(Controller controller){ this.controller = controller; }
    public Controller getController() { return controller; }




}
