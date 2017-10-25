/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;
import static Stephie_build.GameEngine.getDifficulty;
import java.util.Scanner;
import Jacobs_package.*;
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
        for(Item list: inventory)
        {
            System.out.println(list.getName());
        }
    }
    
    
    /**
     * loops through items in inventory to find an item with a matching name.
     * @param itemName 
     * executes useItem if names matches and removes said item and shifting the 
     * rest of the items to the left.
     */
    public void useItem(String itemName) //TODO needs command word
    {
        boolean itemUsed = false;
        
        for(int i = 0; i < inventory.length; i++)//cycles through inventory
        {
            if(inventory[i].getName().toLowerCase().equals(itemName.toLowerCase()))//checks if name of item matches what the player wanted to use.
            {
                inventory[i].useItem();//activates the item's effect.
                itemUsed = true;
                if ("Weapon".equals(inventory[i].getType()) || "Shield".equals(inventory[i].getType()) 
                || "Armor".equals(inventory[i].getType())) //if the used item is equipment, instantly break out and end the method.
                {
                    break;
                }
                    
                for(;i < inventory.length; i++) //cycles through remainder of inventory after match is found.
                {
                    if(i < inventory.length - 1) //all items following used item are put one index lower to fill the hole.
                    {
                        inventory[i] = inventory[i+1];
                    }
                    else //removes the used item from inventory.
                    {
                        inventory[i] = null;
                    }
                }
                break;
            }

        }
        if(!itemUsed)
        {
            System.out.println("You have no such item!");
        }
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
    public void addItem(Item item)
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
                boolean typeMatch = false;
                for (Item inventory1 : inventory) {//cycles through inventory
                    if(item.getType().equals(inventory1.getType()))//checks if equipment to add is the same type as one already in inventory.
                    {
                        typeMatch = true;
                        System.out.println("Do you wish to swap " + 
                                inventory1.getName() + " with " + item.getName() + "?");
                        System.out.println("Yes / No");
                        Scanner input = new Scanner(System.in);
                        String in = input.next().toLowerCase();
                        if(in.equals("yes"))
                        {
                            inventory1 = item; //destroys current equipment and replaces with new.
                        }//choosing to not replace equipment (or making a typo) will destroy the picked up item. //FIX?
                        break;
                    }
                }
                if(!typeMatch){ //if you're not already wearing equipment of the same type, pick it up.
                    for (Item inventory1 : inventory){
                        if(inventory1 == null){
                        inventory1 = item; //adds item to first vacant spot in inventory.
                        break;
                        }
                    }
                }
            }
            else 
            {
                for (Item inventory1 : inventory) {
                    if(inventory1 == null)
                    {
                        inventory1 = item; //adds item to first vacant spot in inventory.
                        break;
                    }
                }
            }
        }
        
        else
        {
            if(equipment) //repeat from line 139
            {
                for (Item inventory1 : inventory) {
                    if(item.getType().equals(inventory1.getType()))
                    {
                        System.out.println("Do you wish to swap " + 
                                inventory1.getName() + " with " + item.getName() + "?");
                        System.out.println("Yes / No");
                        Scanner input = new Scanner(System.in);
                        String in = input.next().toLowerCase();
                        if(in.equals("yes"))
                        {
                            inventory1 = item;
                        }
                        break;
                    }
                }
            }
            //add option to drop or use items if inventory is full.
        }
     
        
        
    }
   
    
    /**
     * Lets the player delete items.
     * @param itemName is a String matching a name of an item in the inventory array
     * You cannot drop your key as it is needed to win.
     */
    public void dropItem(String itemName)
    {
        System.out.println("Are you sure you wish to drop " + itemName + "?");
        System.out.println("Yes / No");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.toLowerCase().equals("yes"))
        {
            if(in.toLowerCase().equals("key"))
            {
                System.out.println("You cannot drop your only key out of this place!");
                
            }
            else
            {
                for(int i = 0; i < inventory.length; i++)
                {
                    if(itemName.toLowerCase().equals(inventory[i].getName().toLowerCase()))
                    {
                        for(; i < inventory.length; i++)
                        {
                            if(i < inventory.length -1)
                            {
                                inventory[i] = inventory[i + 1];
                            }
                            else
                            {
                                inventory[i] = null;
                            }
                            break;
                        }
                    }
                }
            }
        }
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
