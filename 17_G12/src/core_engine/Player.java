/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import core_engine.Items.Branch;
import core_engine.Items.PotLid;
import core_engine.Items.TatteredClothes;
import core_engine.Items.Inventory;
import core_engine.Items.Item;

/**
 * the Player class extending Actor, used for the player to hold items and player specific methods
 * @author nicol
 */
public class Player extends Actor{
    ;
     private int lampOil;
     private Inventory inventory;
    
    /**
     * the constructor for the Player class, initiates an inventory for the player, 
     * adding starting items and sets the time available by adding lampOil.
     * @param name the player name
     * @param defaultHealthpoint starting health points before adding extra from levels
     * @param defaultDefense starting defense before adding extra from levels and armor / shield
     * @param DefaultDamgeOutput starting damage done before adding extra from levels and weapon
     * @param level starts at 1
     * @param difficulty the current difficulty, needed for the inventory.
     * @param msg the message class shared by all classes.
     */
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, int level, int difficulty, Message msg) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P', level, difficulty, msg);
        this.inventory = new Inventory(difficulty, msg);
        getInventory().injectPlayer(this);
        addItem(new Branch(msg));
        addItem(new TatteredClothes(msg));
        addItem(new PotLid(msg));
        lampOil = 25 + difficulty * 25;
        inventory.updateStat();
    }  
    
    /**
     * the time available measured in oil for a lamp.
     * @return integer value of lampOil
     */
    public int getLampOil(){
        return lampOil;
    }
    /**
     * adds 20 to current lampOil when called.
     */
    public void addLampOil(){
        lampOil +=20;
   }
    /**
     * subtracts 1 from current lampOil when called.
     */
    public void useLampOil(){
        lampOil -= 1;
    }
    /**
     * used to access the players inventory.
     * @return inventory
     */
    public Inventory getInventory()
    {
        return inventory;
    }
    
    /**
     * an easy access to the method in inventory class
     * @param item the item that should be added to the inventory ArrayList
     * @return true if the item is successfully added
     */
    public boolean addItem(Item item)
    {
        return inventory.addItem(item);
        
    }
}
