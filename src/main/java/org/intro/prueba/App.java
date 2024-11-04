package org.intro.prueba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static Stage stage;

    @Override
    public void start(Stage stage) {
        App.stage = stage;
        loadFXML("main-view.fxml", "Main", 640, 480);
    }

    private static void loadFXML(String view, String title, int width, int height) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(view));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}