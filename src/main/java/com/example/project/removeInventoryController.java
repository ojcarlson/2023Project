/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast

This class is Controller for remove-inventory.fxml GUI
 */
package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class removeInventoryController {

    //creates Buttons, labels and TextFields
    @FXML
    private Button submit2Button;

    @FXML
    private Button exit2Button;

    @FXML
    private Button goBackButton2;

    @FXML
    private Label buildingLocation2Label;

    @FXML
    private TextField buildingLocation2TextField;



    @FXML
    private TextField heci2TextField;

    @FXML
    private Label heci2Label;

    @FXML
    private TextField bayLocation2TextField;

    @FXML
    private Label bayLocation2Label;

    @FXML
    private TextField status2TextField;

    @FXML
    private Label status2Label;


    @FXML
    private Label information2Label;

    //Action Event that looks to see if TextFields are empty and informs the user with error
    //if not empty calls removeInventory method.
    public void setSubmit2Button(ActionEvent event) throws SQLException, IOException {
        System.out.println("removeInventory Controller 1");
        if (buildingLocation2TextField.getText().isBlank() == false && heci2TextField.getText().isBlank() == false && status2TextField.getText().isBlank() == false && bayLocation2TextField.getText().isBlank() == false) {
            removeInventory();
        } else {
            information2Label.setText("Not Valid Try Again!");
        }
    }

    //method to remove Inventory
    public void removeInventory() throws SQLException {
        //HelloApplication m = new HelloApplication();
        System.out.println("removeInventory Controller 2");
        Connection connection = DatabaseConnection.getConnection();
        System.out.println("removeInventory Controller 2.5");
        Statement qc3 = connection.createStatement();
        System.out.println("removeInventory Controller 3");
       //ResultSet resultSet2 = qc3.executeQuery("SELECT * FROM Inventory WHERE buildingLocation = '" + buildingLocation2TextField.getText() + "' AND heci = '" + heci2TextField.getText() + "' AND bayLocation = '" + bayLocation2TextField.getText() + "' AND status = " + status2TextField.getText() + ")" );
        ResultSet resultSet2 = qc3.executeQuery("SELECT * FROM Inventory WHERE buildingLocation = '" + buildingLocation2TextField.getText() +"' " + "AND heci = '" + heci2TextField.getText() + "' "+ "AND bayLocation = '" + bayLocation2TextField.getText()  + "' "+ "AND status = '" + status2TextField.getText() +"'  " );
        System.out.println("removeInventory Controller 4");
        //String deleteInventory =("DELETE FROM Inventory WHERE( buildingLocation = '"+ buildingLocation2TextField.getText() + "' AND heci = '" + heci2TextField.getText() + "' AND status = '" + status2TextField.getText() + "' AND bayLocation = " + bayLocation2TextField.getText() + ")" );
        //information2Label.setText("Success Delete Inventory!");

        //ResultSet resultSet2;

        //Statement qc2 = connection.createStatement();

        //resultSet2 = qc2.executeQuery(deleteInventory);
        int code;
        String title;
        int count = 0;

        //while loop for verifying if exist
         while (resultSet2.next()) {

            count++;
            String buildingLocation = resultSet2.getString("buildingLocation");
            String heci = resultSet2.getString("heci");
            String description = resultSet2.getString("description");
            Double cost = resultSet2.getDouble("cost");
            Double bayLocation = resultSet2.getDouble("bayLocation");
            String status = resultSet2.getString("status");
            int quantity = resultSet2.getInt("quantity");
        }

        //if exists do the following
        if (count !=0) {

            boolean executionworked;

            //ResultSet executionworked;
            executionworked = qc3.execute("DELETE FROM Inventory WHERE buildingLocation = '"+ buildingLocation2TextField.getText() + "' AND heci = '" + heci2TextField.getText() + "' AND bayLocation = '" + bayLocation2TextField.getText() + "' AND status = '" + status2TextField.getText() + "' " );

            //executionworked = qc2.executeQuery(deleteInventory);
            information2Label.setText("Congratulations Inventory Removed!");
            qc3.close();
            connection.close();

        }
        //if does not exist print out for user
        else {

            information2Label.setText("Inventory not found. Try again!");
        }
    }
    //Action Event to Go Back to Search Inventory Window
    public void setGoBackButton2 (ActionEvent event) throws SQLException, IOException {
        HelloApplication m = new HelloApplication();
        try{
            m.changeScene("inventory-search.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Action Event to exit program when exit Button is pressed
    public void setExit2Button(ActionEvent event) {
        Stage stage = (Stage) exit2Button.getScene().getWindow();
        stage.close();
    }

}
