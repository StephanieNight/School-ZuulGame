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
    
    /**
     * This returns the description of a HealingPotion object.
     * @return String
     */
    @Override
    public String getDescription() {
        return "A red potion. You feel like it might be nice to drink it!";
    }

    /**
     * This returns the name of a HealingPotion object.
     * @return String
     */
    @Override
    public String getName() {
        return "Healing Potion";
    }
    
    /**
     * Adds 30 health points to the argument player object.
     * @param p
     * @return true
     */
    @Override
    public boolean useItem(Player p) {
        msg.setDescription("You already feel better");
        p.setCurrentHealth(p.getCurrentHealth() + 30);
        return true;
    }

    /**
     * This returns the type of Item a HealingPotion is.
     * @return String
     */
    @Override
    public String getType() {
        return "Consumable";
    }

    /**
     * This returns -1, which is the stat of a HealingPotion object,
     * since it is non-equipable.
     * @return int: -1
     */
    @Override
    public int getStat() {
        return -1;
    }
    
    
    /**
     * HealingPotion constructer, with a Message object as input, which
     * is set as referencepoint to this objects message variable 'msg'.
     */
    public HealingPotion(Message msg)
    {
        this.msg = msg;
    }
    
}
