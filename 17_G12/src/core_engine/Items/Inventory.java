/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import java.util.Scanner;
import core_engine.Room;
import core_engine.Actor;
import core_engine.Player;
/**
 * inventory to hold items
 * inventory length is determined by difficulty.
 * starting items are a branch, some tattered clothes and a pot lid.
 * @author Malte
 */



// skal måske laves til set i stedet for array
public class Inventory {
    private Item[] inventory;

    private Player player;

    private int diff;
    public Inventory( int diff)
    {

        this.diff = diff;
        inventory = new Item[8 - diff]; //inventory size based on difficulty
    }
    public void injectPlayer(Player p)
    {
        player = p;
    }
    
    public String[] getInventoryList() //shows player's inventory //TODO needs command word.
    {
        int i = 0;
        String[] invString = new String[8-diff];
        for(Item list: inventory){
            if(list == null)
            {
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
    public boolean useItem(int itemID) //TODO needs command word
    {//TODO change to void
        if(itemID > inventory.length - 1 || itemID < 0 || inventory[itemID] == null)
        {
            return false;
        }
        
        inventory[itemID].useItem(player);//activates the item's effect.

        if ("Weapon".equals(inventory[itemID].getType()) || "Shield".equals(inventory[itemID].getType()) 
            || "Armor".equals(inventory[itemID].getType())) 
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
    
    public String getItemDescription(int itemID)//TODO needs command word.
    {
        return inventory[itemID].getDescription();
    }
    
    /**
     * checks if inventory has any available space and if item type is already 
     * on the list.
     * @param item 
     */
    public boolean addItem(Item item)
    {  
        boolean equipment = false;
        if ("Weapon".equals(item.getType()) || "Shield".equals(item.getType()) 
                || "Armor".equals(item.getType()))
        {
            equipment = true;
        }
        
        boolean inventoryFull = false;
        for (int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null)
            {
                inventoryFull = false;
                break;
            }
            else
            {
                inventoryFull = true;
            }
        }
        
        if (!inventoryFull)
        {
            if(equipment)
            {
                for (int i = 0; i < inventory.length; i++) {//cycles through inventory
                    if(inventory[i] != null)
                    {
                    if(item.getType().equals(inventory[i].getType()))//checks if equipment to add is the same type as one already in inventory.
                    {
                        while(true){ //while loop ensures a valid response from player.
                            System.out.println("Do you wish to swap " + 
                                    inventory[i].getName() + " with " + item.getName() + "?");
                            System.out.println("Yes / No");
                            Scanner input = new Scanner(System.in);
                            String in = input.next().toLowerCase();
                            if(in.equals("yes")){
                                System.out.println(item.getName() + " was picked up.");
                                inventory[i] = item; //destroys current equipment and replaces with new.
                                updateStat();
                                return true;
                            }
                            if(in.equals("no")){
                                System.out.println("left the " + item.getName() + " on the ground.");
                                return false;
                            }
                            System.out.println("That is not a valid response.");
                        }
                    }
                }
                }
                //if you're not already wearing equipment of the same type, pick it up.
                for (int i = 0; i < inventory.length; i++){
                    if(inventory[i] == null){
                        System.out.println(item.getName() + " was picked up.");
                        inventory[i] = item; //adds item to first vacant spot in inventory.
                        updateStat();
                        return true;
                    }
                }
            }
            else //if consumable with non-full inventory
            {
                for (int i = 0; i < inventory.length; i++) {
                    if(inventory[i] == null){
                        inventory[i] = item; //adds item to first vacant spot in inventory.
                        return true;
                    }
                }
            }
        }
        else //if inventory is full
        {
            if(equipment)
            {
                for (int i =0; i < inventory.length; i++) {
                    if(inventory[i] != null)
                    {
                        if(item.getType().equals(inventory[i].getType()))
                        {
                            while(true){ //loop with return statements ensures a valid answer.
                                System.out.println("Do you wish to swap " + 
                                        inventory[i].getName() + " with " + item.getName() + "?");
                                System.out.println("Yes / No");
                                Scanner input = new Scanner(System.in);
                                String in = input.next().toLowerCase();
                                if(in.equals("yes")){
                                    System.out.println(item.getName() + " was picked up.");
                                    inventory[i] = item; //destroys current equipment and replaces with new.
                                    updateStat();
                                    return true;
                                }
                                if(in.equals("no")){
                                    System.out.println("left the " + item.getName() + " on the ground.");
                                    return false;
                                }
                                System.out.println("That is not a valid response.");
                            }
                        }
                    }
                }
            }
            //if consumable
            System.out.println("You're overburdened, do you want to consume or drop an item to make space?");
            System.out.println("Consume X / Drop X / no");
            String input = "no"; //TODO get player input
            if(input.equals("no")){
                System.out.println("left the" + item.getName() + " on the ground.");
                return false;
            }
            return true;//TODO
                
                
                /*Scanner input = new Scanner(System.in);//TODO call the command word for useItem and dropItem only?
                if(input.next().toLowerCase().equals("consume ")){
                    useItem(input.next());
                }*/
            
        }
        return false;//does nothing (is never reached), but compiler complains otherwise.
    }
   
    
    /**
     * Lets the player delete items.
     * @param itemID is a String matching a name of an item in the inventory array
     * You cannot drop your key as it is needed to win.
     */
    public void dropItem(int itemID)
    {
        System.out.println("You dropped your " + inventory[itemID].getName());
        player.getCurrentRoom().dropItem(inventory[itemID]);
        inventory[itemID] = null;
        
        for(;itemID < inventory.length-1; itemID++) //all items following used item are put one index lower to fill the hole.
        {
            inventory[itemID] = inventory[itemID+1];
        }
        inventory[inventory.length-1] = null; //the last item is (re)moved.
        updateStat();
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
