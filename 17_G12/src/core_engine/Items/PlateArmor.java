/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Message;
import core_engine.Player;

/**
 *
 * @author simon
 */
public class PlateArmor implements Item{
    private Message msg;
    
    @Override
    public String getDescription(){
        return "Heavy armor made to withstand attacks.";
    }
    
    @Override
    public String getName(){
        return "Plate armor";
       
    }
    
    @Override
    public boolean useItem(Player p){
        System.out.println("There's a time and place for everything, but not now.");
         return false;
    }
    
    @Override
    public String getType(){ //Armor adds defense value.
        return "Armor";
    }
    
    @Override
    public int getStat(){ //Added defense value amount.
        return 10;
    }   
    
    public PlateArmor(Message msg){
        this.msg = msg;
    }
}