package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.IOException;

public class inventoryListController {

    @FXML
    private Button exitButton;
    @FXML
    private Label wrongInfoLabel;
    @FXML
    private Button submitButton;
    @FXML
    private Button addButton;
    @FXML
    private Button removeButton;

    @FXML
    private ListView listView;




    public void setExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    public void setAddButton(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
       try{
           m.changeScene("add-inventory.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void setRemoveButton(ActionEvent event) throws IOException {
        HelloApplication m = new HelloApplication();
        try{
        m.changeScene("remove-inventory.fxml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
