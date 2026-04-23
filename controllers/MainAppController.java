/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
        contactNumber.setText(contactsMap.size()+" contacts");
        listView.getItems().addAll(contactsMap.values());
            }    

    @FXML
    private void groupByHandle(ActionEvent event) {
        if(!groupBy.getValue().isBlank() && groupBy.getValue() != null){
            
            sortBy.setValue("");
            favorite.setSelected(false);
            listView.getItems().clear();
            if(groupBy.getValue().equalsIgnoreCase("relationship")){
                contactsMap.values().stream()
                    .collect(Collectors.groupingBy(contact->contact.getRelationship()))
                        .forEach((relationship,stream) ->{
                            listView.getItems().add(Contact.createHeader(relationship));
                            stream.forEach(contact->listView.getItems().add(contact));
                        });
            }else if(groupBy.getValue().equalsIgnoreCase("firstname")){
                contactsMap.values().stream()
                    .collect(Collectors.groupingBy(contact->contact.getName().split(" ")[0]))
                        .forEach((firstname,stream) ->{
                            listView.getItems().add(Contact.createHeader(firstname));
                            stream.forEach(contact->listView.getItems().add(contact));
                        });
            }
        }
    }

    @FXML
    private void sortByHandle(ActionEvent event) {
        if(!sortBy.getValue().isBlank() && sortBy.getValue() !=null){
            listView.getItems().clear();
            groupBy.setValue("");
            favorite.setSelected(false);
            contactsMap.values()
                    .stream()
                    .sorted(Comparator.comparing(contact->contact.getName()))
                    .forEach(contact->listView.getItems().add(contact));
        }
    }

    @FXML
    private void favoriteHandle(ActionEvent event) {
        listView.getItems().clear();
        groupBy.setValue("");
        sortBy.setValue("");
        if(favorite.isSelected()){
            contactsMap.values().stream()
                    .filter(contact->contact.getFavorite())
                    .forEach(e->listView.getItems().add(e));
        }else{
            listView.getItems().addAll(contactsMap.values());
        }
        
    }



    
   

    
    
}
