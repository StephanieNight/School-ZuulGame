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
 * @author Malte
 */
public class HealingPotion implements Item{

    private Player player;
    private Message msg;
    
    @Override
    public String getDescription() {
        return "A red potion. You feel like it might be nice to drink it!";
    }

    @Override
    public String getName() {
        return "Healing Potion";
    }
    
    /**
     * adds X to player health points up to max health points
     * @param player
     */
    @Override
    public boolean useItem(Player p) {
        System.out.println("You already feel better");
        p.setCurrentHealth(p.getCurrentHealth() + 30);
        return true;
    }

    

    @Override
    public String getType() {
        return "Consumable";
    }

    /**
     * 
     * @return all consumable items return -1 because it's not how you use them.
     */
    @Override
    public int getStat() {
        return -1;
    }
    
    
    /**
     * no-args constructor, no args needed since all information is predefined.
     */
    public HealingPotion(Message msg)
    {
        this.msg = msg;
    }
    


    
}
