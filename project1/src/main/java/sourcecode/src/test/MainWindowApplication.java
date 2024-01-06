package sourcecode.src.test;

import sourcecode.src.screen.controller.MainWindowController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class MainWindowApplication extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // Print the URL of the FXML resource
            //System.out.println(System.getProperty("java.class.path"));
            System.out.println("Current Working Directory: " + System.getProperty("user.dir"));
            System.out.println(getClass().getResource("sourcecode/src/screen/fxml/mainWindow.fxml"));

            // Load the FXML resource
            URL resourceUrl = getClass().getClassLoader().getResource("sourcecode/src/screen/fxml/mainWindow.fxml");


            if (resourceUrl != null) {
                System.out.println("FXML resource found: " + resourceUrl);

                // Uncomment and use this code once the resource is found
//                FXMLLoader mainLoader = new FXMLLoader(resourceUrl);
//                MainWindowController mainController = new MainWindowController();
//                mainLoader.setController(mainController);
//                Scene scene = new Scene(mainLoader.load());
//                stage.setTitle("Tree View Visualizer");
//                stage.setScene(scene);
//                stage.show();
            } else {
                System.out.println("FXML resource not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
