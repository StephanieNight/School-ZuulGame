/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;
import core_engine.Message;
import core_engine.Player;
import java.io.Serializable;

/**
 * inventory to hold items
 * inventory length is determined by difficulty.
 * starting items are a branch, some tattered clothes and a pot lid.
 * @author Malte
 */


public class Inventory implements Serializable{
    private final Item[] inventory;
    private final Message msg;
    private Player player;
    private final int diff;
    
    public Inventory( int diff, Message msg)
    {
        this.msg = msg;
        this.diff = diff;
        inventory = new Item[8 - diff]; //inventory size based on difficulty
    }
    public void injectPlayer(Player p)
    {
        player = p;
    }
    
    /**
     * 
     * @return the String[] of the player's item's names.
     */
    public String[] getInventoryList()
    {
        int i = 0;
        String[] invString = new String[8-diff];//length of string is the same as length of inventory.
        for(Item list: inventory){
            if(list == null){//stops when inventory is out of items to look at.
                break;
            }
            invString[i] = list.getName();//places the names of inventory into the String[].
            i++;
        }
        return invString;
    }
    
    
    /**
     * activates the effect of a selected item.
     * @param itemID determines which item to use.
     * executes useItem if names matches and removes said item and shifting the 
     * rest of the items back a slot.
     * @return true if the used item was consumable, false if item wasn't.
     */
    public boolean useItem(int itemID)
    {
        if(inventory[itemID] == null)
        {
            msg.setDescription("No item selected.");
            return false;
        }
        
        inventory[itemID].useItem(player);//activates the item's effect.

        if (!"Consumable".equalsIgnoreCase(inventory[itemID].getType())) 
            {
                return false; //if the used item not consumable, item isn't used, and returns false.
            }

        for(;itemID < inventory.length-1; itemID++) //cycles through remainder of inventory.
        {
            inventory[itemID] = inventory[itemID+1]; //destroys used item and moves all items one index down.
        }
        inventory[inventory.length-1] = null; //removes last item in inventory to avoid duplicating it.
        return true;
    }
    
    /**
     * Gets the description of item matching input ID.
     * @param itemID 
     * @return The description of item matching input ID.
     */
    public String getItemDescription(int itemID)
    {
        if(inventory[itemID] != null)
        {
            return inventory[itemID].getDescription();
        }
        return "No item selected.";
    }
    
    /**
     * checks if inventory has any available space and if equipment type 
     * is already on the list.
     * @param item the item that wants to be added.
     * @return returns true if item was succesfully added, otherwise false.
     */
    public boolean addItem(Item item)
    {  
        if ("Weapon".equals(item.getType()) ||"Shield".equals(item.getType())
                || "Armor".equals(item.getType()))//checks if item is equipment.
        {
            for (int i = 0; i < inventory.length; i++)//cycles through inventory
            {
                if(inventory[i] != null)
                {
                    if(item.getType().equals(inventory[i].getType()))//checks if equipment to add is the same type as one already in inventory.
                    {
                        msg.setDescription("Picked up " + item.getName() + " and dropped your " + inventory[i].getName());
                        player.getCurrentRoom().dropItem(inventory[i]); //drops current equipment
                        inventory[i] = item; //replaces equipment with new.
                        updateStat();
                        return true;
                    }
                }
                else//if you're not already wearing same type of equipment and inventory is not full, pick it up.
                {
                    msg.setDescription(item.getName() + " was picked up.");
                    inventory[i] = item; //adds item to first vacant spot in inventory.
                    updateStat();
                    return true;
                }
            }
        }
        //if not equipment and inventory is not full.
        if(inventory[inventory.length - 1] == null){
            for (int i = 0; i < inventory.length; i++) {
                if(inventory[i] == null){
                    msg.setDescription(item.getName() + " was picked up.");
                    inventory[i] = item; //adds item to first vacant spot in inventory.
                    return true;
                }
            }
        }
        msg.setDescription("Inventory full");
        return false;
    }
   
    
    /**
     * Lets the player delete items from inventory.
     * @param itemID is a String matching a name of an item in the inventory array
     * 
     */
    public void dropItem(int itemID)
    {
        if(inventory[itemID] != null){
            msg.setDescription("You dropped your " + inventory[itemID].getName());
            player.getCurrentRoom().dropItem(inventory[itemID]);
            inventory[itemID] = null;

            for(;itemID < inventory.length-1; itemID++) 
            {//all items following used item are put one index lower to fill the hole.
                inventory[itemID] = inventory[itemID+1];
            }
            inventory[inventory.length-1] = null; //the last item is (re)moved.
            updateStat();
        }
        else{
            msg.setDescription("No item selected.");
        }
    }
    
    
    /**
     * updates the stats the player gets from equipment.
     */
    public void updateStat()
    {
        player.setWeapon(0);//sets all equipment values to 0 in case no equipment of appropriate type is worn.
        player.setArmor(0);
        player.setShield(0);
        for (Item inventory1 : inventory) {
            if (inventory1 == null) {
                break;
            }//sets the stat for each appropriate equipment type(if in inventory).
            if ("Weapon".equals(inventory1.getType())) {
                player.setWeapon(inventory1.getStat());
            }
            if ("Armor".equals(inventory1.getType())) {
                player.setArmor(inventory1.getStat());
            }
            if ("Shield".equals(inventory1.getType())) {
                player.setShield(inventory1.getStat());
            }
        }
    }
}
