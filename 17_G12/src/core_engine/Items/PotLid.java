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
public class PotLid implements Item{

    @Override
    public String getDescription(){
        return "The worn lid of a cooking pot from home.";
    }
    
    @Override
    public String getName(){
        return "Lid";
    }
    
    @Override
    public void useItem(Player p){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){ //Shields add defense value.
        return "Shield";
    }
    
    @Override
    public int getStat(){ //Added defense value amount.
        return 2;
    }   
    
    public PotLid(){
        
    }
}
