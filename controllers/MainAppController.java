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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author aya
 */
public class MainAppController implements Initializable {

    @FXML
    private ComboBox<?> groupBy;
    @FXML
    private ComboBox<?> sortBy;
    @FXML
    private CheckBox favorite;
    @FXML
    private Button addbtn;
    @FXML
    private Button statistics;
    @FXML
    private Button refresh;
    @FXML
    private ListView<?> listView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void groupByHandle(ActionEvent event) {
    }

    @FXML
    private void sortByHandle(ActionEvent event) {
    }

    @FXML
    private void favoriteHandle(ActionEvent event) {
    }

    @FXML
    private void addbtnHandle(ActionEvent event) {
    }

    @FXML
    private void statisticsHandle(ActionEvent event) {
    }

    @FXML
    private void refreshHandle(ActionEvent event) {
    }
    
}
