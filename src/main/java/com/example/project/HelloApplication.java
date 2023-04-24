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
    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        //Scene scene = new Scene( pane );
        //stg.setScene(scene);
        //return scene;
    }
    public void newScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.setScene(new Scene(pane, 800, 700));
        stg.show();
    }

    public void changeScene(Parent pane) throws IOException{
        stg.getScene().setRoot(pane);
        System.out.println("made it after changeScene method");
        //Scene scene = new Scene( pane );
        //stg.setScene(scene);
        //return scene;
    }

    /*public Scene changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        return stg.getScene();
    }*/




    public static void main(String[] args) {
        launch();
    }
}