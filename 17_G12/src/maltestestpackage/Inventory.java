/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;
import static Benjamin.GameEngine.getDifficulty;
import java.util.Scanner;
import Jacobs_package.*;
import Stephie_build.Room;
/**
 * inventory to hold items
 * inventory length is determined by difficulty.
 * starting items are a branch, some tattered clothes and a pot lid.
 * @author Malte
 */



// skal måske laves til set i stedet for array
public class Inventory {
    private Item[] inventory;
    
    public Inventory()
    {
        inventory = new Item[8 - getDifficulty()]; //inventory size based on difficulty
        inventory[0] = new Branch();            //the three pieces of starting equipment
        inventory[1] = new TatteredClothes();
        inventory[2] = new PotLid();
        
    }
    
    public void getInventoryList() //shows player's inventory //TODO needs command word.
    {
        int i = 0;
        System.out.printf("%-5.4s  %-50.50s%n", "Slot", "Item");
        for(Item list: inventory){
            i++;
            System.out.printf("%-5.4s  %-50.50s%n", i, list.getName()); //prints in two columns
        }
    }
    
    
    /**
     * loops through items in inventory to find an item with a matching name.
     * @param itemName 
     * executes useItem if names matches and removes said item and shifting the 
     * rest of the items to the left.
     */
    public boolean useItem(int itemID) //TODO needs command word
    {
        boolean itemUsed = false;
        
        if(inventory[itemID] != null)
        {
            inventory[itemID].useItem();//activates the item's effect.
            itemUsed = true;
            
            if ("Weapon".equals(inventory[itemID].getType()) || "Shield".equals(inventory[itemID].getType()) 
                || "Armor".equals(inventory[itemID].getType())) 
                {
                    return false; //if the used item is equipment, item isn't used, and returns false.
                }
            
            for(;itemID < inventory.length-1; itemID++) //cycles through remainder of inventory.
            {
                inventory[itemID] = inventory[itemID+1]; //destroys used item and moves all items one index down.
            }
            inventory[inventory.length-1] = null; //removes last item in inventory to avoid duplicating it.
        }
        if(itemUsed){
            return true;
        }
        System.out.println("You have no such item!");
        return false;
    }
    //udkast til forkortelse af linje 62-73
    		/*inventory[i] = null; //removes the used item from inventory.
		
		for(;i+1 < inventory.length; i++) //cycles through remainder of inventory after match is found.
		{
                    inventory[i] = inventory[i+1]; //all items following the used item are put one index lower to fill the hole.
		}*/
    
    /**
     * loops through items in inventory to find an item with a matching name.
     * @param itemName 
     * prints the name and description if item name matches input name.
     */
    public void getItemDescription(String itemName)//TODO needs command word.
     {

        boolean itemUsed = false;
        for (Item inventory1 : inventory) {
            if (inventory1.getName().toLowerCase().equals(itemName.toLowerCase())) {
                System.out.println(inventory1.getName());
                System.out.println(inventory1.getDescription());
                itemUsed = true;
                break;
            }
        }
        if(!itemUsed)
        {
            System.out.println("You have no such item!");
        }
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
        
        boolean inventoryFull = true;
        for (Item inventory1 : inventory) {
            if(inventory1 == null)
            {
                inventoryFull = false;
                break;
            }
        }
        
        if (!inventoryFull)
        {
            if(equipment)
            {
                for (Item inventory1 : inventory) {//cycles through inventory
                    if(item.getType().equals(inventory1.getType()))//checks if equipment to add is the same type as one already in inventory.
                    {
                        while(true){ //while loop ensures a valid response from player.
                            System.out.println("Do you wish to swap " + 
                                    inventory1.getName() + " with " + item.getName() + "?");
                            System.out.println("Yes / No");
                            Scanner input = new Scanner(System.in);
                            String in = input.next().toLowerCase();
                            if(in.equals("yes")){
                                System.out.println(item.getName() + "was picked up.");
                                inventory1 = item; //destroys current equipment and replaces with new.
                                return true;
                            }
                            if(in.equals("no")){
                                System.out.println("left the" + item.getName() + "on the ground.");
                                return false;
                            }
                            System.out.println("That is not a valid response.");
                        }
                    }
                }
                //if you're not already wearing equipment of the same type, pick it up.
                for (Item inventory1 : inventory){
                    if(inventory1 == null){
                        System.out.println(item.getName() + "was picked up.");
                        inventory1 = item; //adds item to first vacant spot in inventory.
                        return true;
                    }
                }
            }
            else 
            {
                for (Item inventory1 : inventory) {
                    if(inventory1 == null){
                        inventory1 = item; //adds item to first vacant spot in inventory.
                        return true;
                    }
                }
            }
        }
        else
        {
            if(equipment)
            {
                for (Item inventory1 : inventory) {
                    if(item.getType().equals(inventory1.getType()))
                    {
                        while(true){
                            System.out.println("Do you wish to swap " + 
                                    inventory1.getName() + " with " + item.getName() + "?");
                            System.out.println("Yes / No");
                            Scanner input = new Scanner(System.in);
                            String in = input.next().toLowerCase();
                            if(in.equals("yes")){
                                System.out.println(item.getName() + "was picked up.");
                                inventory1 = item; //destroys current equipment and replaces with new.
                                return true;
                            }
                            if(in.equals("no")){
                                System.out.println("left the" + item.getName() + "on the ground.");
                                return false;
                            }
                            System.out.println("That is not a valid response.");
                        }
                    }
                    //if consumable
                    System.out.println("You're overburdened, do you want to consume or drop an item to make space?");
                    System.out.println("Consume X / Drop X / no");
                    String input = "no"; //get player input
                    if(input.equals("no")){
                        System.out.println("left the" + item.getName() + "on the ground.");
                        return false;
                    }
                    return true;//TODO
                    
                }
            }
            //if consumable
            System.out.println("You're overburdened, do you want to consume or drop an item to make space?");
            System.out.println("Consume X / Drop X / no");
            String input = "no"; //get player input
            if(input.equals("no")){
                System.out.println("left the" + item.getName() + "on the ground.");
                return false;
            }
            return true;//TODO
                
                
                /*Scanner input = new Scanner(System.in);//TODO call the command word for useItem and dropItem only?
                if(input.next().toLowerCase().equals("consume ")){
                    useItem(input.next());
                }*/
            
        }
        return false;//does nothing, but compiler complains otherwise.
    }
   
    
    /**
     * Lets the player delete items.
     * @param itemID is a String matching a name of an item in the inventory array
     * You cannot drop your key as it is needed to win.
     */
    public void dropItem(int itemID, Room room) //TODO make command word
    {
        System.out.println("You dropped your " + itemID);
        room.dropItem(inventory[itemID]);
        inventory[itemID] = null;
        
        for(;itemID < inventory.length-1; itemID++) //all items following used item are put one index lower to fill the hole.
        {
            inventory[itemID] = inventory[itemID+1];
        }
        inventory[inventory.length-1] = null; //the last item is (re)moved.
    }
    
    
    /**
     * updates the stats the player gets from items.
     */
    public void updateStat()
    {
        for(Item inventory1: inventory)
        {
            if("Weapon".equals(inventory1.getType()))
            {
                // player.setTotalDamage = player.getModifiedDamage + inventory1.getStat();
            }
            if("Armor".equals(inventory1.getType()))
            {
                // player.setTotalArmor = player.getModifiedArmor + inventory1.getStat();
            }
            if("Shield".equals(inventory1.getType()))
            {
                // player.setTotalShield = player.getModifiedShield + inventory1.getStat();
            }
        }
    }
}
