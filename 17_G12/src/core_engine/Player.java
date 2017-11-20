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

/**
 *
 * @author nicol
 */
public class Player extends Actor{
   
     private int lampOil;
    
    
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, int level, int difficulty) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P', level, difficulty);
        
        getInventory().addItem(new Branch());
        getInventory().addItem(new TatteredClothes());
        getInventory().addItem(new PotLid());
        lampOil = 25 + difficulty * 25;
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
}
