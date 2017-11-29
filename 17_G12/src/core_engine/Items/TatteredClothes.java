/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Message;
import core_engine.Player;
import java.io.Serializable;
/**
 *
 * @author simon
 */
public class TatteredClothes implements Item, Serializable{
    
    private Message msg;
    @Override
    public String getDescription(){
        return "Trusty clothes that have seen a lot of use.";
    }
    
    @Override
    public String getName(){
        return "Tattered Clothes";
    }
    
    @Override
    public boolean useItem(Player p){
        msg.setDescription("There's a time and place for everything, but not now.");
        return false;
    }
    
    @Override
    public String getType(){ //Armor adds defense value.
        return "Armor";
    }
    
    @Override
    public int getStat(){ //Added defense value amount.
        return 3;
    }  
    public TatteredClothes(Message msg){
        this.msg = msg;
    }
}
