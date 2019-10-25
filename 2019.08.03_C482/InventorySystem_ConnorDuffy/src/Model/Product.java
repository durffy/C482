/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author cjd
 */
public class Product {
    public static ObservableList<Part> associatedParts = FXCollections.observableArrayList();
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
        return associatedParts;
    }

    public static void addAssociatedParts(ObservableList<Part> parts) {
        for(Part part : parts){
            if(!associatedParts.contains(part)){
                associatedParts.add(part);
            }
        }
    }
    
    public static void deleteAssociatedParts(Part associatedPart) {
        associatedParts.remove(associatedPart);
    }
}
