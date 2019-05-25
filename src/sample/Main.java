package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) { Application.launch(); }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(root, 258, 453);
        stage.setScene(scene);
        scene.getStylesheets().add(Main.class.getResource("Styles.css").toExternalForm());
        stage.show();
    }
}
