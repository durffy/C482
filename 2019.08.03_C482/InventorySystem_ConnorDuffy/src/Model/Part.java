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
import javafx.scene.control.Alert;

/**
 *
 * @author cjd
 */
public abstract class Part {
    
    private IntegerProperty id,
            stock,
            min,
            max;
    private StringProperty name;
    private DoubleProperty price;

    public Part(int id, String name, double price, int stock, int min, int max) {
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
    
    public boolean checkValidPart(int min, int max, int stock){
        
        boolean issue = false;
        
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
        
        return issue;
        
    }
    
}


