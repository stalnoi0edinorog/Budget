package incoming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Incoming_Main extends Application {
    public static void main(String[] args) { Application.launch(); }

    @Override
    public void start( Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("incoming.fxml"));

        Scene scene = new Scene(root, 582, 456);

        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
