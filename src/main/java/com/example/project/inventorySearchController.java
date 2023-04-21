package com.example.project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.xml.transform.Result;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class inventorySearchController {
    @FXML
    private Button exitButton;
    @FXML
    private Label wrongInfoLabel;
    @FXML
    private Button searchButton;
    @FXML
    private TextField buildingLocation;
    @FXML
    private TextField heci;

    private Label inventoryheader;



    @FXML
    private ScrollPane inventoryScrollPane;

    public ArrayList<inventoryObject> inventoryList;

    public void setSearchButton(ActionEvent event) throws SQLException, IOException {

        System.out.println("Button is working setSearchButton");
        if (buildingLocation.getText().isBlank() == false && heci.getText().isBlank() == false) {
            searchInventory();
        } else{
            wrongInfoLabel.setText("Not Valid Try Again!");
        }

    }
    public void searchInventory() throws SQLException {
        System.out.println("made it to searchInventory method");
        HelloApplication m = new HelloApplication();
        String queryInventory ="SELECT * FROM Inventory WHERE buildingLocation = '" + buildingLocation.getText() + "' AND heci = '" + heci.getText() + "' ";
        Connection connection = DatabaseConnection.getConnection();

        ResultSet resultSet;
        Statement qc = connection.createStatement();
        resultSet = qc.executeQuery(queryInventory);
        int count = 0;
        //while loop for verifying if exist
        inventoryList = new ArrayList<>();
        System.out.println("before while loop searchInventory");
        while (resultSet.next()) {
            System.out.println("made it to while loop in searchInventory method");
            count++;
            String buildingLocation = resultSet.getString("buildingLocation");
            String heci = resultSet.getString("heci");
            String description = resultSet.getString("description");
            Double cost = resultSet.getDouble("cost");
            Double bayLocation = resultSet.getDouble("bayLocation");
            String status = resultSet.getString("status");
            Integer quantity = resultSet.getInt("quantity");
            System.out.println("before inventoryList.add");
            inventoryList.add(new inventoryObject(buildingLocation, heci, description, cost, bayLocation, status, quantity));
            System.out.println("after inventoryList.add");
        }
        System.out.println("after while loop if");
        //if exists do the following
        if (count !=0) {
            ResultSet executionworked;
            executionworked = qc.executeQuery(queryInventory);
            wrongInfoLabel.setText("Congratulations Inventory Found!");
            qc.close();
            connection.close();
            System.out.println("made it before try");
            try {
                System.out.println("Got here at try inventorySearchController");
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inventory-list.fxml")));
                //System.out.println(root.getId());
                ListView<HBox> listView = (ListView<HBox>) root.lookup("#listView");
                ObservableList<HBox> oList = FXCollections.observableArrayList();
                for (int i = 0; i < inventoryList.size(); i++) {
                    inventoryObject thisObject = inventoryList.get(i);
                    Button listButton = new Button(thisObject.buildingLocation);
                    Button listButton2 = new Button(thisObject.heci);
                    Button listButton3 = new Button(thisObject.description);
                    Button listButton4 = new Button(Double.toString(thisObject.cost));
                    Button listButton5 = new Button(Double.toString(thisObject.bayLocation));
                    Button listButton6 = new Button(thisObject.status);
                    Button listButton7 = new Button(Integer.toString(thisObject.quantity));
                    //oList.addAll(listButton, listButton2, listButton3, listButton4, listButton5, listButton6, listButton7);
                    HBox row = new HBox(listButton, listButton2, listButton3, listButton4, listButton5, listButton6, listButton7);

                    oList.add(row);


                    System.out.println(thisObject.description);
                }
                listView.setItems(oList);
                System.out.println("Got here too");
                m.changeScene (root);
                //Scene sc = m.changeScene("inventory-list.fxml");
                System.out.println("Got here after changescene");
                //ScrollPane sp =((Group) sc.getRoot()).getChildren().getClass().getResource("inventoryScrollPane");
                //inventoryScrollPane.addEventHandler();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //if does not exist print out for user
        else {
            wrongInfoLabel.setText("Inventory not found. Try again!");
        }

    }
    public void setExitButton(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

}
