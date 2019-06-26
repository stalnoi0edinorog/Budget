package model;

import javafx.scene.control.Button;

import static spending.Spending_Controller.currentButt;

public class Categories {
    public static Button spending = new Button();
    public static Button incoming = new Button();

    public static Button products = new Button();
    public static Button transport = new Button();
    public static Button housing = new Button();
    public static Button health = new Button();
    public static Button cafe = new Button();
    public static Button leisure = new Button();
    public static Button clothes = new Button();
    public static Button presents = new Button();
    public static Button internet = new Button();
    public static Button salary = new Button();

    public static Button getCategoryButton() {
        String currentB = currentButt.getId();
        switch (currentB){
            case "products": return products;
            case "transport": return transport;
            case "housing": return housing;
            case "health": return health;
            case "cafe": return cafe;
            case "leisure": return leisure;
            case "clothes": return clothes;
            case "presents": return presents;
            case "internet": return internet;
            case "salary": return salary;
        } return null;
    }
}
