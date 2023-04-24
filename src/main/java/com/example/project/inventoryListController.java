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

    @FXML
    private Button exitButton;

    @FXML
    private Button returnSearchButton;
    @FXML
    private Label wrongInfoLabel2;
    @FXML
    private Button submitButton;
    @FXML
    private Button addButton;


    @FXML
    private ListView listView;




    public void setExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void setAddButton(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
       try{
           m.newScene("add-inventory.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setReturnSearchButton (ActionEvent event) throws SQLException, IOException {
        HelloApplication m = new HelloApplication();
        try{
            m.changeScene("inventory-search.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
