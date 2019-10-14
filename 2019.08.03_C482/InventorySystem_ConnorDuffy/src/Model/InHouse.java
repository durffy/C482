/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 * 
 * @author cjd
 */
public class InHouse extends Part{
    private int machineId;
    
    /**
     * Constructor that extends the Part constructor
     * meant to be used with the AddPart Controller Radio button selection
     * 
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machineId 
     */
    public InHouse(int id, String name, double price, int stock,
            int min, int max, int machineId) {
        super(id, name, price, stock, min, max);
        this.machineId = machineId;
    }

    public int getMachineId() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
    

}
