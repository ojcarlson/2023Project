package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class addInventoryController {
    @FXML
    private Button submitButton4;

    @FXML
    private Button exitButton4;

    @FXML
    private Button goBackButton4;

    @FXML
    private TextField buildingLocationTextField4;
    @FXML
    private Label buildingLocationLabel4;

    @FXML
    private Label heciLabel4;

    @FXML
    private TextField heciTextField4;

    @FXML
    private Label descriptionLabel4;
    @FXML
    private TextField descriptionTextField4;

    @FXML
    private Label costLabel4;

    @FXML
    private TextField costTextField4;

    @FXML
    private Label bayLocationLabel4;

    @FXML
    private TextField bayLocationTextField4;

    @FXML
    private Label statusLabel4;

    @FXML
    private TextField statusTextField4;
    @FXML
    private Label quantityLabel4;

    @FXML
    private TextField quantityTextField4;

    @FXML
    private Label information4Label;

    public void setSubmitButton4(ActionEvent event) throws SQLException, IOException {
        System.out.println("Button is working addInventoryController");
        if (buildingLocationTextField4.getText().isBlank() == false && heciTextField4.getText().isBlank() == false && descriptionTextField4.getText().isBlank() == false && costTextField4.getText().isBlank() == false && bayLocationTextField4.getText().isBlank() == false && statusTextField4.getText().isBlank() == false && quantityTextField4.getText().isBlank() == false) {
            addInventory();
        } else {
            information4Label.setText("Not Valid Try Again!");
        }
    }

    public void addInventory() throws SQLException {
        System.out.println("made it to addInventory method");
        Connection connection = DatabaseConnection.getConnection();
        //HelloApplication m = new HelloApplication();
        System.out.println("made it to before String addInventory in addInventory method");
        Statement st2 = connection.createStatement();
        st2.execute("INSERT INTO Inventory (buildingLocation, heci, description, cost, bayLocation, status, quantity) VALUES ( '"+ buildingLocationTextField4.getText() + "', '" + heciTextField4.getText() + "', '" + descriptionTextField4.getText() + "', " + costTextField4.getText() + ", " + bayLocationTextField4.getText() + ", '" + statusTextField4.getText() + "', " + quantityTextField4.getText() + ")" );

        //String addInventory = ("INSERT INTO Inventory (buildingLocation, heci, description, cost, bayLocation, status, quantity) VALUES ( '"+ buildingLocationTextField4.getText() + "', '" + heciTextField4.getText() + "', '" + descriptionTextField4.getText() + "', " + costTextField4.getText() + ", " + bayLocationTextField4.getText() + ", '" + statusTextField4.getText() + "', " + quantityTextField4.getText() + ")" );
        System.out.println("made it to after String addInventory in addInventory method");

        //ResultSet resultSet;
        //Statement qc = connection.createStatement();
        //ResultSet executionworked;
        //resultSet = qc.executeQuery(addInventory);
        //executionworked = qc.executeQuery(addInventory);
        information4Label.setText("Congratulations Inventory Added!");
        //qc.close();
        st2.close();
        connection.close();
    }

    public void setGoBackButton4 (ActionEvent event) throws SQLException, IOException {
        HelloApplication m = new HelloApplication();
        try{
            m.changeScene("inventory-search.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setExitButton4(ActionEvent event) {
        Stage stage = (Stage) exitButton4.getScene().getWindow();
        stage.close();
    }







}
