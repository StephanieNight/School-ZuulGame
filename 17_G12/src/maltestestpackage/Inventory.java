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
public class Inventory {
    private Item[] inventory;
    
    public Inventory()
    {
        inventory = new Item[8 - getDifficulty()];
        inventory[0] = new Branch();
        inventory[1] = new TatteredClothes();
        inventory[2] = new PotLid();
        
    }
    
    public void getInventoryList()
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
    public void useItem(String itemName)
    {
        boolean itemUsed = false;
        
        for(int i = 0; i < inventory.length; i++)
        {
            if(inventory[i].getName().toLowerCase().equals(itemName.toLowerCase()))
            {
                inventory[i].useItem();
                itemUsed = true;
                if ("Weapon".equals(inventory[i].getType()) || "Shield".equals(inventory[i].getType()) 
                || "Armor".equals(inventory[i].getType()))
                {
                    break;
                }
                    
                for(;i < inventory .length; i++)
            {
                if(i < inventory.length - 1)
                {
                    inventory[i] = inventory[i+1];
                }
                else
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
    
    
    /**
     * loops through items in inventory to find an item with a matching name.
     * @param itemName 
     * prints the name and description if item name matches input name.
     */
    public void getItemDescription(String itemName)
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
            }
        }
        
        if (!inventoryFull)
        {
            if(equipment)
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
            else 
            {
                for (Item inventory1 : inventory) {
                    if(inventory1 == null)
                    {
                        inventory1 = item;
                        break;
                    }
                }
            }
        }
        
             if (inventoryFull)
        {
            if(equipment)
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
