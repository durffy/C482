/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cjd
 */
public class ModifyProductViewController implements Initializable {

    
    @FXML private TextField PartSeach;
    @FXML private TableView TablePartSearch;
    @FXML private TableColumn PartSearchID;
    @FXML private TableColumn PartSearchName;
    @FXML private TableColumn PartSearchStock;
    @FXML private TableColumn PartSearchPrice;
    
    @FXML private TableView ProductPart;
    @FXML private TableColumn ProductPartID;
    @FXML private TableColumn ProductPartName;
    @FXML private TableColumn ProductPartStock;
    @FXML private TableColumn ProductPartPrice;
    
    @FXML private TextField ProductID;
    @FXML private TextField ProductName;
    @FXML private TextField ProductStock;
    @FXML private TextField ProductPrice;
    @FXML private TextField ProductMin;
    @FXML private TextField ProductMax;
    
    
    
    
    
    
    
    
    public void ButtonCancel(ActionEvent event) throws IOException{
                
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    public void ButtonSaveProduct(ActionEvent event) throws IOException{
        //TODO: add method call, object reference, and logic
                        
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    
    
    
    
    
    public void ButtonSearchPart(ActionEvent event) throws IOException{
        //TODO
    }
    
    public void ButtonAddPart(ActionEvent event) throws IOException{
        //TODO
    }
    
    public void ButtonDeletePart(ActionEvent event) throws IOException{
        //TODO
    }
    
    
    
    
    
    
    
    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
