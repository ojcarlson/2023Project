/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast

This class controls the inventory-list.fxml GUI
 */
package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class inventoryListController {
//creates Buttons, Labels and ListView
    @FXML
    private Button exitButton;

    @FXML
    private Button returnSearchButton;
    @FXML
    private Label wrongInfoLabel2;

    @FXML
    private Button addButton;


    @FXML
    private ListView listView;



//method to set ActionEvent for Exit button to exit Application
    public void setExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    //method to set ActionEvent for Add button to changeScene to Add Inventory Window
    public void setAddButton(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
       try{
           m.newScene("add-inventory.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //method to set ActionEvent for ReturnSearch button to changeScene to Search Inventory Window

    public void setReturnSearchButton (ActionEvent event) throws SQLException, IOException {
        HelloApplication m = new HelloApplication();
        try{
            m.changeScene("inventory-search.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
