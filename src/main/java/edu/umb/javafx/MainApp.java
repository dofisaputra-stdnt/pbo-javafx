package edu.umb.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("panelutama.fxml"));
//        Scene scene = new Scene(fxmlLoader.load());
//        stage.setTitle("Panel Utama");
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("user.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Form User");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
