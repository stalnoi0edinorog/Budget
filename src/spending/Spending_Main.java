package spending;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Spending_Main extends Application {

    public static void main(String[] args) { Application.launch(); }

    @Override
    public void start( Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("spending.fxml"));

        Scene scene = new Scene(root, 582, 456);

        primaryStage.setScene(scene);

        //scene.getStylesheets().add(Main.class.getResource("Styles.css").toExternalForm());
        primaryStage.show();
    }
}
