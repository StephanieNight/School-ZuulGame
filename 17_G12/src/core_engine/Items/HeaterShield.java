/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Player;

/**
 *
 * @author simon
 */
public class HeaterShield implements Item{
    
    @Override
    public String getDescription(){
        return "A common and effective shield.";
    }
    
    @Override
    public String getName(){
        return "Heater shield";
    }
    
    @Override
    public boolean useItem(Player p){
        System.out.println("There's a time and place for everything, but not now.");
        return false;
    }
    
    @Override
    public String getType(){ //Shields add defense value.
        return "Shield";
    }
    
    @Override
    public int getStat(){ //Added defense value amount.
        return 5;
    }   
    
    public HeaterShield(){
        
    }
    
}