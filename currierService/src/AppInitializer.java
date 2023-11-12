import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class AppInitializer extends Application {

    @Override
    public void start(Stage primaryStage) throws  IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/lk/ijse/tootGarment/view/WelcomePageForm.fxml"))));
        primaryStage.setTitle("Welcome");
        primaryStage.show();
    }



}
