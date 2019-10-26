/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.InHouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    
    @FXML private Label LabelSourceID;
    
    static int PartIndex;
    private Part ModPart;
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
    
    public void ButtonSave(ActionEvent event) throws IOException{
        //TODO: add method call, object reference, and logic
        
        ModPart.setName(FieldName.getText());
        ModPart.setStock(Integer.parseInt(FieldStock.getText()));
        ModPart.setPrice(Double.parseDouble(FieldPrice.getText()));
        ModPart.setMin(Integer.parseInt(FieldMin.getText()));
        ModPart.setMax(Integer.parseInt(FieldMax.getText()));
        
        if(ModPart instanceof InHouse){
            ((InHouse) ModPart).setMachineId(Integer.parseInt(FieldSourceID.getText()));
        }if(ModPart instanceof Outsourced){
            ((Outsourced) ModPart).setCompanyName(FieldSourceID.getText());
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
        
        ModPart = Inventory.lookupPart(PartIndex);
        FieldID.setText(Integer.toString(ModPart.getId()));
        FieldName.setText(ModPart.getName());
        FieldStock.setText(Integer.toString(ModPart.getStock()));
        FieldPrice.setText(Double.toString(ModPart.getPrice()));
        FieldMin.setText(Integer.toString(ModPart.getMin()));
        FieldMax.setText(Integer.toString(ModPart.getMax()));
        
        if(ModPart instanceof InHouse){
            FieldSourceID.setText(Integer.toString(((InHouse) ModPart).getMachineId()));
            LabelSourceID.setText("Machine ID");
            InHouse = true;
        }if(ModPart instanceof Outsourced){
            FieldSourceID.setText(((Outsourced) ModPart).getCompanyName());
            LabelSourceID.setText("Source ID");
            InHouse = false;
        } 
        
    }    
    
}
