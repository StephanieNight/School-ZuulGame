/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicolai;

import maltestestpackage.Inventory;

/**
 *
 * @author nicol
 */
public class Player extends Actor{
     private Inventory inventory;
     private int lampOil;
     
     public Inventory getInventory(){
         return inventory;
     }
    
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P');
        this.inventory = new Inventory(this);
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
