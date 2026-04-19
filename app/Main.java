/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.Main to edit this template
 */
package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author aya
 */
public class Main extends Application{
    public static void main(String [] args){
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent p1 = FXMLLoader.load(getClass().getResource("../views/MenuBar.fxml"));
        Parent p2 = FXMLLoader.load(getClass().getResource("../views/MainApp.fxml"));

        BorderPane root = new BorderPane();

        root.setTop(p1);     // MenuBar
        root.setCenter(p2);  // Main UI 

        Scene s = new Scene(root);
        stage.setScene(s);
        stage.setTitle("Phone contact Manager");
        stage.show();


    }
    
    
}
