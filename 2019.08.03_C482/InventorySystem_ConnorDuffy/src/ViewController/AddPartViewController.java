/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import Model.InHouse;
import Model.Outsourced;
import Model.Part;
import Model.Part;

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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author cjd
 */
public class AddPartViewController implements Initializable {

    @FXML private ToggleGroup RadioBtnToggleGroup;
    @FXML private RadioButton RadioBtnInHouse;
    @FXML private RadioButton RadioBtnOutSourced;
    
    @FXML private TextField FieldID;
    @FXML private TextField FieldName;
    @FXML private TextField FieldStock;
    @FXML private TextField FieldPrice;
    @FXML private TextField FieldMin;
    @FXML private TextField FieldMax;
    @FXML private TextField FieldSourceID;
    
    @FXML private Label LabelSourceID;

    private boolean InHouse = true;
    
    public void RadioButtonInHousePressed(){
        LabelSourceID.setText("Machine Id");
        InHouse = true;
    }
    
    public void RadioButtonOutsourcedPressed(){
        LabelSourceID.setText("Company Name");
        InHouse = false;
    }
    
    public void ButtonCancel(ActionEvent event) throws IOException{
                
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }
    
    public void ButtonAdd(ActionEvent event) throws IOException{
        //TODO: add method call, object reference, and logic
        
        String name = FieldName.getText();
        int id = Integer.parseInt(FieldID.getText());
        int stock = Integer.parseInt(FieldStock.getText());
        double price = Double.parseDouble(FieldPrice.getText());
        int min = Integer.parseInt(FieldMin.getText());
        int max = Integer.parseInt(FieldMax.getText());
        String sourceId = FieldSourceID.getText();
        
        if(InHouse){
            int sid = Integer.parseInt(sourceId);
            Part p = new InHouse(id, name, price, stock, min, max, sid);
            Inventory.allParts.add(p);
        }else if(!InHouse){
            
            Part p = new Outsourced(id, name, price, stock, min, max, sourceId);
            Inventory.allParts.add(p);
        }
                
        Parent root = FXMLLoader.load(getClass().getResource("/ViewController/MainView.fxml"));
        Scene scene = new Scene(root);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
        
    }



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        LabelSourceID.setText("Machine Id");
    }    
    
}
