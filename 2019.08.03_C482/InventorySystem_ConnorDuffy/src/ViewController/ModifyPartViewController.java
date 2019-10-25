/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.InHouse;
import Model.Inventory;
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
public class ModifyPartViewController implements Initializable {
    
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
    
    @FXML private Label LabelSoruceID;
    
    static int PartIndex;
    
    public void RadioButtonInHousePressed(){
        
    }
    
    public void RadioButtonOutsourcedPressed(){
        
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
        
        //todo: add object type check here
        Part part = Inventory.lookupPart(PartIndex);
        FieldID.setText(Integer.toString(part.getId()));
        FieldName.setText(part.getName());
        FieldStock.setText(Integer.toString(part.getStock()));
        FieldPrice.setText(Double.toString(part.getPrice()));
        FieldMin.setText(Integer.toString(part.getMin()));
        FieldMax.setText(Integer.toString(part.getMax()));
        //FieldSourceID.setText(Integer.toString(part.getI)); 
    }    
    
}
