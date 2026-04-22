/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.Contact;

/**
 * FXML Controller class
 *
 * @author aya
 */
public class MainAppController implements Initializable {

    @FXML
    private ComboBox<String> groupBy;
    @FXML
    private ComboBox<String> sortBy;
    @FXML
    private CheckBox favorite;
    @FXML
    private Button addbtn;
    @FXML
    private Button statistics;
    @FXML
    private Button refresh;
    @FXML
    private ListView<Contact> listView;
    @FXML
    private Label contactNumber;
    Map<Integer, Contact> contactsMap = null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        groupBy.getItems().addAll("relationship","firstname");
        sortBy.getItems().addAll("fullname");
        try {
            contactsMap =
                    Files.lines(Paths.get("src/data/contacts.csv"))
                            .skip(1) // skip header
                            .map(line -> line.split(","))
                            .map(data -> new Contact(
                                    Integer.parseInt(data[0]),
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4],
                                    Boolean.parseBoolean(data[5])
                            ))
                            .collect(Collectors.toMap(
                                    Contact::getId, // key
                                    c -> c           // value
                            ));
        } catch (IOException ex) {
            System.getLogger(MainAppController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        
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
    private void addbtnHandle(ActionEvent event) throws IOException {
        Parent p1 = FXMLLoader.load(getClass().getResource("../views/MenuBar.fxml"));
        Parent p2 = FXMLLoader.load(getClass().getResource("../views/AddView.fxml"));
        BorderPane root = new BorderPane();

        root.setTop(p1);     // MenuBar
        root.setCenter(p2);  // Main UI 

        Scene scene2 = new Scene(root);
        Stage stage = (Stage)addbtn.getScene().getWindow();
        stage.setScene(scene2);
        stage.setTitle("Phone contact Manager");
        stage.show();
        
    }

    @FXML
    private void statisticsHandle(ActionEvent event) {
        System.out.println(contactsMap);
    }

    @FXML
    private void refreshHandle(ActionEvent event) {
    }
    
}
