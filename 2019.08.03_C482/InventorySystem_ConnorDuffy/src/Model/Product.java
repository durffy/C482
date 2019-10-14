/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.ObservableList;

/**
 *
 * @author cjd
 */
public class Product {
    private ObservableList<Part> associatedParts;
    private int id,
            stock,
            min,
            max;
    private String name;
    private double price;

    public Product(int id, String name, double price, int stock, int min, int max) {
        this.id = id;
        this.stock = stock;
        this.min = min;
        this.max = max;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    

    public ObservableList<Part> getAllAssociatedParts() {
        return associatedParts;
    }

    public void addAssociatedParts(Part part) {
        this.associatedParts.add(part);
    }
    
    public void deleteAssociatedParts(Part associatedPart) {
        this.associatedParts.remove(associatedParts);
    }
}
