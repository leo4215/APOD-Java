package com.example.assignment2java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    // Starts the JavaFX application
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader openLoader = new FXMLLoader(getClass().getResource("/com/example/assignment2java/open-scene.fxml"));
        Parent openRoot = openLoader.load();
        OpenController openController = openLoader.getController();
        openController.setStage(primaryStage);
        Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("nasa-logo.png")));
        primaryStage.getIcons().add(logo);
        primaryStage.setTitle("APOD by NASA");
        primaryStage.setScene(new Scene(openRoot));
        primaryStage.show();
    }

    // Launches the Java application
    public static void main(String[] args) {
        launch(args);
    }
}
