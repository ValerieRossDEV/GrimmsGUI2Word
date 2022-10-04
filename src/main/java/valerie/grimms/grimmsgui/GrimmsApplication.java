package valerie.grimms.grimmsgui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

public class GrimmsApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GrimmsApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 650, 500);

        stage.setTitle("Grimm's GUI");
        stage.setScene(scene);

        stage.show();
    }

    public static void main(String[] args) throws IOException {
        launch();


    }
}