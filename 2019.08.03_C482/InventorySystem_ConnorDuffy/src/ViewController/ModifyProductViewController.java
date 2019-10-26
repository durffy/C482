/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import Model.Part;
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
    private Product ModProduct;
    static int ProductIndex;


    
    public void ButtonCancel(ActionEvent event) throws IOException{
                
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    public void ButtonSaveProduct(ActionEvent event) throws IOException{
        
        ModProduct.addAssociatedParts(ProductParts);
        
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    
    
    public void ButtonSearchPart(ActionEvent event) throws IOException{
        
        ObservableList<Part> parts = Inventory.lookupPart(PartSeach.getText());
        
        TablePartSearch.setItems(parts);
        
    }
    
    public void ButtonAddPart(ActionEvent event) throws IOException{
        ProductParts.add(TablePartSearch.getSelectionModel().getSelectedItem());
    }
    
    public void ButtonDeletePart(ActionEvent event) throws IOException{
        
        ProductParts.remove((ProductPart.getSelectionModel().getSelectedItem()));
        
    }
    
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ModProduct = Inventory.lookupProduct(ProductIndex);
        ProductParts.addAll(ModProduct.getAllAssociatedParts());

        ProductID.setText(Integer.toString(ModProduct.getId()));
        ProductName.setText(ModProduct.getName());
        ProductStock.setText(Integer.toString(ModProduct.getStock()));
        ProductPrice.setText(Double.toString(ModProduct.getPrice()));
        ProductMin.setText(Integer.toString(ModProduct.getMin()));
        ProductMax.setText(Integer.toString(ModProduct.getMax()));
        
        PartSearchID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        PartSearchName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        PartSearchStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        PartSearchPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        TablePartSearch.setItems(Inventory.allParts);
        
        ProductPartID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        ProductPartName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        ProductPartStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        ProductPartPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        ProductPart.setItems(ProductParts);
    }    
    
}
