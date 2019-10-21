/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import Model.Part;
import static ViewController.MainViewController.inventory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
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
import javafx.stage.Stage;

import static Model.Inventory.getAllParts;
import static Model.Inventory.getAllProducts;
import Model.Product;

/**
 * FXML Controller class
 *
 * @author cjd
 */
public class ModifyProductViewController implements Initializable {
    
    
    @FXML private TextField PartSeach;
    @FXML private TableView<Part> TablePartSearch;
    @FXML private TableColumn<Part, Integer> PartSearchID;
    @FXML private TableColumn<Part, String> PartSearchName;
    @FXML private TableColumn<Part, Integer> PartSearchStock;
    @FXML private TableColumn<Part, Double> PartSearchPrice;
    
    @FXML private TableView<Part> ProductPart;
    @FXML private TableColumn<Part, Integer> ProductPartID;
    @FXML private TableColumn<Part, String> ProductPartName;
    @FXML private TableColumn<Part, Integer> ProductPartStock;
    @FXML private TableColumn<Part, Double> ProductPartPrice;
    
    @FXML private TextField ProductID;
    @FXML private TextField ProductName;
    @FXML private TextField ProductStock;
    @FXML private TextField ProductPrice;
    @FXML private TextField ProductMin;
    @FXML private TextField ProductMax;
    
    private ObservableList<Part> ProductParts = FXCollections.observableArrayList();
    

    
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
        Product product = getAllProducts().get(0);
        
        PartSearchID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        PartSearchName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        PartSearchStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        PartSearchPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        TablePartSearch.setItems(Inventory.allParts);
        
        ProductPartID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        ProductPartName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        ProductPartStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        ProductPartPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        ProductPart.setItems(product.getAllAssociatedParts());
    }    
    
}
