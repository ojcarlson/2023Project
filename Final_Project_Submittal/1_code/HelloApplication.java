/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast

This is main class to run Inventory Application
 */
package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        //sets stage and size
        stg = primaryStage;
        //primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("logIn.fxml"));
        //Connection connection = DatabaseConnection.getConnection();
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("logIn.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        primaryStage.setTitle("Inventory");
        primaryStage.setScene(new Scene(root, 800, 800));
        primaryStage.show();

    }
    //this method is called to changeScene
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        //Scene scene = new Scene( pane );
        //stg.setScene(scene);
        //return scene;
    }
    //called to change scene
    public void newScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane, 800, 700));
        stg.show();
    }
    //method called to change scene
    public void changeScene(Parent pane) throws IOException{
        stg.getScene().setRoot(pane);

    }





    public static void main(String[] args) {
        launch();
    }
}