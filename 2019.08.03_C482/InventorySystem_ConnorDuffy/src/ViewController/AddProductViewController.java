/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
public class AddProductViewController implements Initializable {
    
    @FXML private TextField PartSeach;
    
    @FXML private TableView<Part> TablePartSearch;
    @FXML private TableColumn<Part, Integer> PartSearchID;
    @FXML private TableColumn<Part, String> PartSearchName;
    @FXML private TableColumn<Part, Integer> PartSearchStock;
    @FXML private TableColumn<Part, Double> PartSearchPrice;
    
    @FXML private TableView<Part> TableProductParts;
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
    private Product NewProduct;
    
    
    public void ButtonCancel(ActionEvent event) throws IOException{

        Alert deleteProductAlert = new Alert(Alert.AlertType.CONFIRMATION);
        deleteProductAlert.setTitle("Confirmation Dialog");
        deleteProductAlert.setHeaderText("Cancel Product Creation. Your work will not be saved.");
        deleteProductAlert.setContentText("OK to continue?");

        Optional<ButtonType> result = deleteProductAlert.showAndWait();
        
        if (result.get() == ButtonType.OK){
            Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
       
        } else {
            // ... user chose CANCEL or closed the dialog
        }
        
    }
    
    public void ButtonAddProduct(ActionEvent event) throws IOException{
        
        String name = ProductName.getText();
        int id = Inventory.allProducts.size();
        int stock = Integer.parseInt(ProductStock.getText());
        double price = Double.parseDouble(ProductPrice.getText());
        int min = Integer.parseInt(ProductMin.getText());
        int max = Integer.parseInt(ProductMax.getText());
        
        //todo: Adding a product needs to have InHouse and Outsourced options
        Product p = new Product(id, name, price, stock, min, max);
        p.addAssociatedParts(ProductParts);

        Inventory.allProducts.add(p);
        
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
        
        ProductParts.remove((TableProductParts.getSelectionModel().getSelectedItem()));
        
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        PartSearchID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        PartSearchName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        PartSearchStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        PartSearchPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        TablePartSearch.setItems(Inventory.allParts);
        
        ProductPartID.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
        ProductPartName.setCellValueFactory(cellData -> cellData.getValue().getNameProperty());
        ProductPartStock.setCellValueFactory(cellData -> cellData.getValue().getStockProperty().asObject());
        ProductPartPrice.setCellValueFactory(cellData -> cellData.getValue().getPriceProperty().asObject());
        
        TableProductParts.setItems(ProductParts);
    }    
    
}
