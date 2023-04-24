package com.example.project;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
import java.util.Scanner;

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
        } else {
            wrongInfoLabel.setText("Not Valid Try Again!");
        }

    }

    public void searchInventory() throws SQLException {

        HelloApplication m = new HelloApplication();
        String queryInventory = "SELECT * FROM Inventory WHERE buildingLocation = '" + buildingLocation.getText() + "' AND heci = '" + heci.getText() + "' ";
        Connection connection = DatabaseConnection.getConnection();

        ResultSet resultSet;
        Statement qc = connection.createStatement();
        resultSet = qc.executeQuery(queryInventory);
        int count = 0;
        //while loop for verifying if exist
        inventoryList = new ArrayList<>();

        while (resultSet.next()) {
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

        }
        System.out.println("after while loop if");
        //if exists do the following
        if (count != 0) {
            ResultSet executionworked;
            executionworked = qc.executeQuery(queryInventory);
            wrongInfoLabel.setText("Congratulations Inventory Found!");
            qc.close();
            connection.close();

            try {
                Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inventory-list.fxml")));
                ListView<HBox> listView = (ListView<HBox>) root.lookup("#listView");
                ObservableList<HBox> oList = FXCollections.observableArrayList();
                for (int i = 0; i < inventoryList.size(); i++) {
                    inventoryObject thisObject = inventoryList.get(i);
                    Label listLabel = new Label(thisObject.buildingLocation + "         ");
                    Label listLabel2 = new Label(thisObject.heci + "         ");
                    Label listLabel3 = new Label(thisObject.description + "         ");
                    Label listLabel4 = new Label(Double.toString(thisObject.cost) + "         ");
                    Label listLabel5 = new Label(Double.toString(thisObject.bayLocation) + "         ");
                    TextField statusTextField6 = new TextField(thisObject.status );
                    TextField quantityTextField7 = new TextField(Integer.toString(thisObject.quantity));
                    Button removeButton1 = new Button("Delete");
                    Button chgButton = new Button("Change");
                    statusTextField6.setMaxSize(80.0, 80.0);
                    quantityTextField7.setMaxSize(30.0, 30.0);
                    HBox row = new HBox(listLabel, listLabel2, listLabel3, listLabel4, listLabel5, statusTextField6, quantityTextField7, removeButton1, chgButton);
                    removeButton1.setOnAction(event -> {
                        try {
                            removeInventory(thisObject.buildingLocation, thisObject.heci, thisObject.bayLocation, thisObject.status);
                            oList.remove(row);
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    chgButton.setOnAction(event -> {
                        try {
                            String testChange = quantityTextField7.getText();
                            String newStatus = statusTextField6.getText();
                            changeInventoryQty(thisObject.buildingLocation, thisObject.heci, thisObject.bayLocation, newStatus, Integer.parseInt(testChange));
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    oList.add(row);
                }
                listView.setItems(oList);
                m.changeScene(root);

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

    public void removeInventory(String buildingLocation, String heci, double bayLocation, String status) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        Statement qc3 = connection.createStatement();
        qc3.execute("DELETE FROM Inventory WHERE buildingLocation = '" + buildingLocation + "' AND heci = '" + heci + "' AND bayLocation = '" + bayLocation + "' AND status = '" + status + "' ");
        qc3.close();
        connection.close();
    }

    public static void changeInventoryQty(String buildingLocation, String heci, double bayLocation, String status, int quantity) throws SQLException {
        //makes connection to mySQL database mydatabase
        System.out.println("Action 4");
        Connection connection = DatabaseConnection.getConnection();
        Statement qc4 = connection.createStatement();
        System.out.println("Action 5");
        //qc4.execute("UPDATE Inventory SET status = '" + status + "', quantity = '" + quantity + "' WHERE buildingLocation = '" + buildingLocation + "' , heci = '" + heci + "' , bayLocation = '" + bayLocation + "' , status = '" + status + "' , quantity = '" + quantity + "' ");

        qc4.execute ("UPDATE Inventory SET quantity = '" + quantity + "'  WHERE  buildingLocation = '" + buildingLocation + "'  " +
                "AND heci = '" + heci + "'  AND  bayLocation = '" + bayLocation + "' ");

        qc4.execute ("UPDATE Inventory SET status = '" + status + "' WHERE  buildingLocation = '" + buildingLocation + "'  " +
                "AND heci = '" + heci + "'  AND  bayLocation = '" + bayLocation + "' ");

        System.out.println("Action 6");
        qc4.close();
        connection.close();

    }
}


