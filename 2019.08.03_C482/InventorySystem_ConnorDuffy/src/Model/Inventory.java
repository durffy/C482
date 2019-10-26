
package Model;

import Model.InHouse;
import Model.Outsourced;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author cjd
 */
public class Inventory {
    
    public static ObservableList<Part> allParts = FXCollections.observableArrayList();
    public static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    
    /**
     * Adds a new part to the ObservableList allParts to create new items in 
     * the parts inventory
     * 
     * @param newPart the Part to be added to the allParts list
     */
    public static void addPart(InHouse newPart){
        allParts.add(newPart);
    }
    
    public static void addPart(Outsourced newPart){
        allParts.add(newPart);
    }
    
    
    
    /**
     * Searches for the int partId via the index of the ObservableList allParts
     * and Returns the elements from the ObservableList for review of the 
     * current information of a part.
     * 
     * @param partID int the part id to search in the observable list
     * @return returns the element from the ObservableList allParts
     */
    public static Part lookupPart(int partID){
        return allParts.get(partID);
    }
    
    
    /**
     * Searches the ObservableList allParts by a parts name to return the 
     * elements of the list to review the current information of a part.
     * 
     * @param partName the part name provided as a string
     * @return returns the part element from the ObservableList allParts
     */
    public static ObservableList<Part> lookupPart(String partName){
        ObservableList<Part> result = FXCollections.observableArrayList();
        for (Part part : allParts) {
            if (part.getName().contains(partName)){
                result.add(part);
            }
        }
        return result;
    }
    
    
    /**
     * Updates the part in the ObservableList allParts in order to correct or
     * update inventory parts by utilizing the index of the part in the ObservableList
     * and the new Part information via the selectPart
     * 
     * @param index the index of the part to modify
     * @param selectedPart the part information that is being updated
     */
    public static void updatePart(int index, Part selectedPart){
        //TODO: may need to add an option to delete the 'old part'
        allParts.set(index, selectedPart);
    }
    
    /**
     * Deletes the part in the ObservableList allParts from the 
     * input of the Part selectedPart
     * 
     * @param selectedPart the Part object to delete from the ObservableList allParts
     */
    public static void deletePart(Part selectedPart){
                
        boolean relationship_exists = false;
        
        for(Product p : Inventory.allProducts){
            if(p.associatedParts.contains(selectedPart)){
                relationship_exists = true;
            }
        }
        
        if(!relationship_exists){
            selectedPart.setName("Deleted");
            selectedPart.setMax(0);
            selectedPart.setMin(0);
            selectedPart.setPrice(0.0);
            selectedPart.setStock(0);

            allParts.set(selectedPart.getId(), selectedPart);
        }else if(relationship_exists){
            //TODO: alerts here
        }
        
    }
    
    /**
     * Returns the ObservableList of all parts in the allParts ObservableList
     * 
     * @return returns the allParts ObservableList
     */
    public static ObservableList<Part> getAllParts(){
        return allParts;
    }
    
    
    /**
     * Adds a new product from the incoming Product (newProduct) to the
     * ObservableList allProducts
     * 
     * @param newProduct input of the new Product being created
     */
    public static void addProduct(Product newProduct){
        allProducts.add(newProduct);
    }
    
    
    /**
     * Searches for the int product Id via the index of the ObservableList 
     * allProducts returning the element of the ObservableList
     * 
     * @param productId the product Id for the index of the ObservableList allProducts 
     * @return returns the ObservableList Product element by the index of the productId
     */
    public static Product lookupProduct(int productId){
        return allProducts.get(productId);
    }
    
    
    /**
     * Searches for the name of a product in the ObservableList allProducts 
     * returning the elements of the matching products for review of the 
     * products
     * 
     * @param productName input of the String for the product Name
     * @return returns an ObservableList for the elements in the allProducts list
     */
    public static ObservableList<Product> lookupProduct(String productName){
        ObservableList<Product> result = FXCollections.observableArrayList();
        for (Product product : allProducts) {
            if (product.getName().contains(productName)){
                result.add(product);
            }
        }
        return result;
    }

    
    /**
     * Updates the products in the ObservableList allProducts in order to 
     * correct or update inventory products by utilizing the index of the part
     * in the ObservableList and the new Product information via the 
     * selectedProduct
     * 
     * @param index the index of the Product in the allProducts ObservableList
     * @param selectedProduct the new Product information
     */
    public void updateProduct(int index, Product selectedProduct){
        allProducts.add(index, selectedProduct);
    }
    
    /**
     * Deletes the input object of the selected Product from the 
     * observableList allProducts
     * 
     * @param selectedProduct in inputed Product to delete
     */
    public static void deleteProduct(Product selectedProduct){
        selectedProduct.setName("Deleted");
        selectedProduct.setMax(0);
        selectedProduct.setMin(0);
        selectedProduct.setPrice(0.0);
        selectedProduct.setStock(0);
        
        allProducts.set(selectedProduct.getId(), selectedProduct);
    }
    
    /**
     * Returns all of the products from the ObservableList all products for 
     * review 
     * 
     * @return returns the ObservableList allProducts
     */
    public static ObservableList<Product> getAllProducts(){
        return allProducts;
    }
    
}
