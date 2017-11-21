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
 *
 * @author nicol
 */
public class Player extends Actor{
   
     private int lampOil;
     private Inventory inventory;
    
    
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, int level, int difficulty) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P', level, difficulty);
        this.inventory = new Inventory(difficulty);
        getInventory().injectPlayer(this);
        addItem(new Branch());
        addItem(new TatteredClothes());
        addItem(new PotLid());
        lampOil = 25 + difficulty * 25;
        inventory.updateStat();
    }  
    public int getLampOil(){
        return lampOil;
    }
    public void addLampOil(){
        lampOil +=20;
   }
    public void useLampOil(){
        lampOil -= 1;
    }
    public Inventory getInventory()
    {
        return inventory;
    }
    
    public boolean addItem(Item item)
    {
        return inventory.addItem(item);
        
    }
}
