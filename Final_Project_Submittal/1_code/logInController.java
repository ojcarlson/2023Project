/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast

This class is controller for logIn.fxml GUI file
 */
package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class logInController {
    //creates Buttons, TextFields, Label and ImageViews
    @FXML
    private Button cancelButton;
    @FXML
    private Label wrongLogin;
    @FXML
    private ImageView inventoryImageView;
    @FXML
    private ImageView lockImageView;
    @FXML
    private TextField username;
    @FXML
    private TextField password;


    //@Override
    /*public void initialize(URL url, ResourceBundle resourceBundle){
        File inventoryFile = new File("img/inventory-stock-manufacturing-assets-goods-concept.jpg");
        Image inventoryImage = new Image(inventoryFile.toURI().toString());
        inventoryImageView.setImage(inventoryImage);

        File lockFile = new File("img/padlock-gb7fc5f0f5_1280.png");
            Image lockImage = new Image(inventoryFile.toURI().toString());
            lockImageView.setImage(lockImage);

    }*/
    //method to check if TextFields are blank and give error to user and if not blank
    //call validateLogin method
    public void loginButtonOnAction(ActionEvent event) throws SQLException, IOException {
        if (username.getText().isBlank() == false && password.getText().isBlank() == false) {
           validateLogin();
        } else{
            wrongLogin.setText("Please enter Username and Password");
        }

    }
    //Action Event to exit program when cancel button is pressed
    public void CancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
    //method to validate login
    public void validateLogin() throws SQLException, IOException {
        HelloApplication m = new HelloApplication();
        String queryUserPasword ="SELECT * FROM loginPassword WHERE login = '" + username.getText() + "' AND password = '" + password.getText() + "'";
        Connection connection = DatabaseConnection.getConnection();

        ResultSet resultSet;
        Statement qc = connection.createStatement();
        resultSet = qc.executeQuery(queryUserPasword);

        int count = 0;
        //while loop for verifying if exist
        while (resultSet.next()) {
            count++;
            String login = resultSet.getString("login");
            String password = resultSet.getString("password");
        }
        //if exists do the following
        if (count !=0) {
            ResultSet executionworked;
            executionworked = qc.executeQuery(queryUserPasword);
            wrongLogin.setText("Congratulations Password Accepted!");
            qc.close();
            connection.close();
            try {
                m.changeScene("inventory-search.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //if does not exist print out for user
        else {
            wrongLogin.setText("Please try again");
        }


    }
    }





