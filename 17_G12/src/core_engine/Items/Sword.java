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
public class Sword implements Item{
    
    private Message msg;
    @Override
    public String getDescription(){
        return "A steel sword.";
    }
    
    @Override
    public String getName(){
        return "Sword";
    }
    
    @Override
    public boolean useItem(Player p){
        msg.setDescription("There's a time and place for everything, but not now.");
        return false;
    }
    
    @Override
    public String getType(){ //weapons add attack value.
        return "Weapon";
    }
    
    @Override
    public int getStat(){ //Added attack value amount.
        return 17;
    }   
    
    public Sword(Message msg){
        this.msg = msg;
    }
}