package com.example.assignment2java;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class GeneratedController {

    @FXML
    private Text title;

    @FXML
    private Text date;

    @FXML
    private ImageView image;

    @FXML
    private Text explanation;

    @FXML
    private Button resetBtn;

    private Stage stage;

    // Sets the primary stage for the controller.
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Displays the details of the APOD
    public void displayApod(Apod apod) {
        title.setText(apod.getTitle());
        date.setText(apod.getDate());
        explanation.setText(apod.getExplanation());
        Image apodImage = new Image(apod.getUrl());
        image.setImage(apodImage);
    }

    // Initializes the controller, and sets up action for the reset button
    @FXML
    private void initialize() {
        resetBtn.setOnAction(event -> {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("/com/example/assignment2java/open-scene.fxml"));
                Scene scene = new Scene(loader.load());
                OpenController openController = loader.getController();
                openController.setStage(stage);
                openController.initialize();
                Image logo = new Image(Objects.requireNonNull(getClass().getResourceAsStream("nasa-logo.png")));
                stage.getIcons().add(logo);
                stage.setScene(scene);
                stage.setTitle("APOD by NASA");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}