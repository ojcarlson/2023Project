/*
Olaf Carlson
ocarlson@iu.edu
Spring 2023 Project
Indiana University Southeast
 */
package com.example.project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LogIn {
    @FXML
    private Button button;
    @FXML
    Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    public void userLogin(ActionEvent event) throws IOException {
        checkLogin();
    }
    private void checkLogin() throws IOException {
        if(username.getText().toString().equals("javacoding") && password.getText().toString().equals("")) {
            wrongLogin.setText("Success!!");

            //m.changeScene("inventory-search.fxml");
        } else if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data!");
        }
        else {
            wrongLogin.setText("Wrong username or password!");
        }

    }


}
