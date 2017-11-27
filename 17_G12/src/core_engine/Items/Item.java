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
public interface Item
{
    /**
     * This returns the description of any subtypes of Item, which is
     * defined in each individual class that implements Item.
     * @return String
     */
    public abstract String getDescription();
    
    /**
     * This returns the name of any subtypes of Item, which is defined
     * in each individual class that implements Item.
     * @return String
     */
    public abstract String getName();
    
    
    /**
     * Executes the unique effect the item in question has.
     * Weapons, shields and armor doesn't have any use item effect and returns 
     * a message "this is not how you use said item".
     */
    public abstract boolean useItem(Player p);
    
    /**
     * This returns the type of Item.
     * @return returns the type for comparison in inventory
     */
    public abstract String getType();
    
    /**
     * This returns an int representing the stat of the Item or -1 if the item
     * is non-equipable.
     * The stat of the Item represents the increase the given item applies
     * to the player.
     * @return stat increase to the player or -1 if it's a consumable
     */
    public abstract int getStat();
}







