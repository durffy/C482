/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Optional;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

/**
 *
 * @author cjd
 */
public class Product {
    private ObservableList<Part> associatedParts = FXCollections.observableArrayList();
    private IntegerProperty id,
            stock,
            min,
            max;
    private StringProperty name;
    private DoubleProperty price;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = new SimpleIntegerProperty();
        this.id.set(id);
        
        this.name = new SimpleStringProperty();
        this.name.set(name);
        
        this.stock = new SimpleIntegerProperty();
        this.stock.set(stock);
        
        this.min = new SimpleIntegerProperty();
        this.min.set(min);
        
        this.max = new SimpleIntegerProperty();
        this.max.set(max);
        
        this.price = new SimpleDoubleProperty();
        this.price.set(price);
    }

    public Product() {
        //To change body of generated methods, choose Tools | Templates.
    }

    public IntegerProperty getIdProperty(){
        return id;
    }
    
    public StringProperty getNameProperty(){
       return name;
    }
    
    public IntegerProperty getStockProperty(){
        return stock;
    }
    
    public IntegerProperty getMinProperty(){
        return min;
    }
    
    public IntegerProperty getMaxProperty(){
        return max;
    }
    
    public DoubleProperty getPriceProperty(){
        return price;
    }
    
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public int getStock() {
        return stock.get();
    }

    public void setStock(int stock) {
        this.stock.set(stock);
    }

    public int getMin() {
        return min.get();
    }

    public void setMin(int min) {
        this.min.set(min);
    }

    public int getMax() {
        return max.get();
    }

    public void setMax(int max) {
        this.max.set(max);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public double getPrice() {
        return price.get();
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
    

    public ObservableList<Part> getAllAssociatedParts() {
        return this.associatedParts;
    }

    /**
     * Adds parts to the Associated parts list if they do not already exist
     * in the Associated Parts list
     * 
     * @param parts an ObservableList<Part>
     */
    public void addAssociatedParts(ObservableList<Part> parts) {
        for(Part part : parts){
            if(!this.associatedParts.contains(part)){
                this.associatedParts.add(part);
            }
        }
    }
    
    public void deleteAssociatedParts(Part associatedPart) {
        
        this.associatedParts.remove(associatedPart); 
 
    }

    public void setProductParts(ObservableList<Part> parts) {
        this.associatedParts = parts;
    }
    
    public boolean checkValidProduct(String name, double price, int stock, int min, int max, ObservableList<Part> ProductParts){
        
        boolean issue = false;
        double partsPrice = 0;
        
        //check if product cost is more than parts cost
        for(Part p: ProductParts){
            partsPrice += p.getPrice();
            
        }

        if(partsPrice > price){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Pricing issue Parts Price cost more than Product.\n\rSuggested Price: " + partsPrice);
            alert.showAndWait();
            
            issue = true;
            
        }
        
        //check if min is more than max
        if(min > max){
            

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Min must be below the Max limit");
            alert.showAndWait();
            
            issue = true;
        }
        
        //check if stock is less than min
        if(stock < min){
            

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Stock must be equal or above the min limit");
            alert.showAndWait();
            
            issue = true;
            
        }
        
        //check if stock is more than max       
        if(stock > max){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Stock must be equal or below the max limit");
            alert.showAndWait();
            
            issue = true;
        }
        
        //check if parts exist for the product
        if(ProductParts.isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Products must be associated with one part");
            alert.showAndWait();
            
            issue = true;
            
        }
        
        //check if product has a name
        if((name.isEmpty())){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Product must have a Name");
            alert.showAndWait();
            
            issue = true;
        }
        
        return issue;
        
    }
    
}
