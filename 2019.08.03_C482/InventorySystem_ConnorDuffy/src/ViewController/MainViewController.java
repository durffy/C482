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
public class MainViewController implements Initializable {

    //Part FXIDs
    @FXML private TableView Parts;
    @FXML private TableColumn PartId;
    @FXML private TableColumn PartName;
    @FXML private TableColumn PartStock;
    @FXML private TableColumn PartPrice;
    
    @FXML private TextField PartsSearch;
    
    
    
    //Product FXIDs
    @FXML private TableView Products;
    @FXML private TableColumn ProductId;
    @FXML private TableColumn ProductName;
    @FXML private TableColumn ProductStock;
    @FXML private TableColumn ProductPrice;
    
    @FXML private TextField ProductsSearch;
    
    
    
    
    
    
    
    /*
    
    NOTE: The following Methods are for Part Event Handling
    
    */
    public void ButtonSearchParts(ActionEvent event){
        //TODO
        
    }
    
    public void ButtonAddPart(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/AddPartView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show(); 
    }
    
    public void ButtonModifyPart(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/ModifyPartView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void ButtonDeletePart(ActionEvent event){
        //TODO
    }
    
    
    
    
    
    
    
    /*
    
    NOTE: The following Methods are for Product Event Handling
    
    */ 
    public void ButtonSearchProducts(ActionEvent event){
        //TODO
    }
    
    public void ButtonAddProduct(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/AddProductView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    public void ButtonModifyProduct(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/ModifyProductView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    public void ButtonDeleteProduct(ActionEvent event){
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
