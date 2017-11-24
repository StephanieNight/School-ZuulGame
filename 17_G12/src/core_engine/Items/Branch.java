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
public class Branch implements Item{
    private Message msg;
    
    @Override
    public String getDescription(){
        return "A large branch you found outside the dungeon.";
    }
    
    @Override
    public String getName(){
        return "Branch";
    }
    
    @Override
    public boolean useItem(Player p){
        System.out.println("There's a time and place for everything, but not now.");
        return false;
    }
    
    @Override
    public String getType(){ //weapons add attack value.
        return "Weapon";
    }
    
    @Override
    public int getStat(){ //Added attack value amount.
        return 5;
    }
    
    public Branch(Message message){
        msg = message;
    }
    
}