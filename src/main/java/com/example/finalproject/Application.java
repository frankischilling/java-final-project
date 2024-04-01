package com.example.finalproject;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        /* Load the FXML file */
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("view.fxml"));
        /* Create the scene */
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        /* Set the stage title */
        stage.setTitle("Inventory Management System");
        /* Set the scene */
        stage.setScene(scene);
        /* Show the stage */
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}