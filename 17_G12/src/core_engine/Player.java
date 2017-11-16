/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import Jacobs_package.Branch;
import Jacobs_package.PotLid;
import Jacobs_package.TatteredClothes;
import maltestestpackage.Inventory;

/**
 *
 * @author nicol
 */
public class Player extends Actor{
   
     private int lampOil;
    
    
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, int level) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P',level);
        
        getInventory().addItem(new Branch());
        getInventory().addItem(new TatteredClothes());
        getInventory().addItem(new PotLid());
       
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
