/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aya
 */
public class MenuBarController implements Initializable {

    @FXML
    private MenuBar menubar;
    @FXML
    private MenuItem exit;
    @FXML
    private ToggleGroup tg;
    @FXML
    private ToggleGroup tg2;
    @FXML
    private MenuItem about;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void exitHandle(ActionEvent event) {
        ((Stage)menubar.getScene().getWindow()).close();
    }

    @FXML
    private void aboutHandle(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION); 
        alert.setTitle("About");
        alert.setHeaderText("Phone Contact Manager");
        alert.setContentText("Version : 1.0\nDeveloper: Aya Alharazin");
        alert.showAndWait();
    }
    
}
