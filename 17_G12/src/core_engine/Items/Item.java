/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Player;

/**
 * Abstract super class for all item classes
 * getDescription, getName and getType is the same in all item classes and returns 
 * a string with description, name or type of said item.
 * @author Malte
 */
public interface Item {
    public abstract String getDescription();
    public abstract String getName();
    
    
    /**
     * Executes the unique effect the item in question has.
     * Weapons, shields and armor doesn't have any use item effect and returns 
     * a message "this is not how you use said item".
     */
    public abstract boolean useItem(Player p);
    /**
     * 
     * @return returns the type for comparison in inventory
     */
    public abstract String getType();
    
    /**
     * 
     * @return the increase the given item applies or -1 if it's a consumable item
     */
    public abstract int getStat();
}







