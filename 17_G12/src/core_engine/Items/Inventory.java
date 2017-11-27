/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;
import core_engine.Message;
import core_engine.Player;
/**
 * inventory to hold items
 * inventory length is determined by difficulty.
 * starting items are a branch, some tattered clothes and a pot lid.
 * @author Malte
 */



// skal måske laves til set i stedet for array
public class Inventory {
    private final Item[] inventory;
    private Message msg;
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
    
    public String[] getInventoryList() //shows player's inventory
    {
        int i = 0;
        String[] invString = new String[8-diff];
        for(Item list: inventory){
            if(list == null){
                break;
            }
            invString[i] = list.getName();
            i++;
        }
        return invString;
    }
    
    
    /**
     * loops through items in inventory to find an item with a matching name.
     * @param itemID
     * executes useItem if names matches and removes said item and shifting the 
     * rest of the items to the left.
     * @return 
     * returns true if an item was used, false if item wasn't used.
     */
    public boolean useItem(int itemID)
    {
        if(itemID > inventory.length - 1 || inventory[itemID] == null)
        {
            return false;
        }
        
        inventory[itemID].useItem(player);//activates the item's effect.

        if (!"Consumable".equalsIgnoreCase(inventory[itemID].getType())) 
            {
                return false; //if the used item is equipment, item isn't used, and returns false.
            }

        for(;itemID < inventory.length-1; itemID++) //cycles through remainder of inventory.
        {
            inventory[itemID] = inventory[itemID+1]; //destroys used item and moves all items one index down.
        }
        inventory[inventory.length-1] = null; //removes last item in inventory to avoid duplicating it.7
        return true;
    }
    
    /**
     * prints the name and description of item matching input ID.
     * @param itemID 
     * @return 
     */
    
    public String getItemDescription(int itemID)
    {
        if(itemID < inventory.length && inventory[itemID] != null){
            return inventory[itemID].getDescription();
        }
        return "No item selected.";
    }
    
    /**
     * checks if inventory has any available space and if item type is already 
     * on the list.
     * @param item 
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
                        //remove item from room
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
                    inventory[i] = item; //adds item to first vacant spot in inventory.
                    return true;
                }
            }
        }
        msg.setDescription("Inventory full");
        return false;
    }
   
    
    /**
     * Lets the player delete items.
     * @param itemID is a String matching a name of an item in the inventory array
     * You cannot drop your key as it is needed to win.
     */
    public void dropItem(int itemID)
    {
        if(itemID < inventory.length && inventory[itemID] != null){
            msg.setDescription("You dropped your " + inventory[itemID].getName());
            player.getCurrentRoom().dropItem(inventory[itemID]);
            inventory[itemID] = null;

            for(;itemID < inventory.length-1; itemID++) //all items following used item are put one index lower to fill the hole.
            {
                inventory[itemID] = inventory[itemID+1];
            }
            inventory[inventory.length-1] = null; //the last item is (re)moved.
            updateStat();
        }
    }
    
    
    /**
     * updates the stats the player gets from items.
     */
    public void updateStat()
    {
        player.setWeapon(0);
        player.setArmor(0);
        player.setShield(0);
        for (int i = 0; i < inventory.length; i++)
        {
            if(inventory[i] == null)
            {
                break;
            }
            if("Weapon".equals(inventory[i].getType()))
            {
                player.setWeapon(inventory[i].getStat());
            }
            if("Armor".equals(inventory[i].getType()))
            {
                player.setArmor(inventory[i].getStat());
            }
            if("Shield".equals(inventory[i].getType()))
            {
                player.setShield(inventory[i].getStat());
            }
        }
    }
}
