package com.example.assignment2java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.Objects;

public class OpenController {

    @FXML
    private DatePicker datePicker;

    @FXML
    private Button searchBtn;

    private Stage stage;
    private LinkedList<Apod> apodList = new LinkedList<>();

    // Sets the primary stage for the controller
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Initializes the controller, and sets up action for the search button
    @FXML
    public void initialize() {
        searchBtn.setOnAction(event -> {
            LocalDate selectedDate = datePicker.getValue();
            if (selectedDate != null) {
                try {
                    String date = selectedDate.toString();
                    Apod apod = ApiConnector.getApod(date);
                    apodList.add(apod); // Adds the Apod object to the list
                    showGeneratedScene(apod);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // Initializes the controller, setting up action for the search button
    private void showGeneratedScene(Apod apod) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/assignment2java/generated-scene.fxml"));
        try {
            Scene scene = new Scene(loader.load());
            GeneratedController generatedController = loader.getController();
            generatedController.setStage(stage);
            generatedController.displayApod(apod);
            Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("nasa-logo.png")));
            stage.getIcons().add(logo);
            stage.setScene(scene);
            stage.setTitle("APOD by NASA");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
