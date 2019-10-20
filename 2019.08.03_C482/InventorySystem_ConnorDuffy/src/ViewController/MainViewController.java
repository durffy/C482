/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.InHouse;
import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author cjd
 */
public class MainViewController implements Initializable {
    

    public static Inventory inventory;
   
      
    //Part FXIDs
    @FXML private TableView<Part> PartsTable = new TableView<>();
    @FXML private TableColumn<Part, Integer> PartId = new TableColumn<>("partId");
    @FXML private TableColumn<Part, String> PartName = new TableColumn<>("partName");
    @FXML private TableColumn<Part, Integer> PartStock = new TableColumn<>("partStock");
    @FXML private TableColumn<Part, Double> PartPrice = new TableColumn<>("partPrice");
    
    @FXML private TextField PartsSearch;
    
    
    
    //Product FXIDs
    @FXML private TableView<Product> ProductsTable;
    @FXML private TableColumn<Product, Integer> ProductId;
    @FXML private TableColumn<Product, String> ProductName;
    @FXML private TableColumn<Product, Integer> ProductStock;
    @FXML private TableColumn<Product, Double> ProductPrice;
    
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
        
     
        PartId.setCellValueFactory(new PropertyValueFactory<>("colPartId"));
        PartName.setCellValueFactory(new PropertyValueFactory<>("colPartName"));
        PartStock.setCellValueFactory(new PropertyValueFactory<>("colPartStock"));
        PartPrice.setCellValueFactory(new PropertyValueFactory<>("colPartPrice"));

        PartsTable.setItems(inventory.allParts);
        
       
        ProductId.setCellValueFactory(new PropertyValueFactory<>("colProductId"));
        ProductName.setCellValueFactory(new PropertyValueFactory<>("colProductName"));
        ProductStock.setCellValueFactory(new PropertyValueFactory<>("colProductStock"));
        ProductPrice.setCellValueFactory(new PropertyValueFactory<>("colProductPrice"));
        
        ProductsTable.setItems(inventory.allProducts);
        
        
    }
}