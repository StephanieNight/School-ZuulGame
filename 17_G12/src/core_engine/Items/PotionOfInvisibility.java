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
public class PotionOfInvisibility implements Item
{

    private Message msg;
    
    @Override
    public String getDescription()
    {
        return "Is this flask empty? You can hear some liquid sloshing around inside";
    }

    @Override
    public String getName()
    {
        return "Potion of Invisibility";
    }

    
    /**
     * sets invisibility to true, allowing the player to choose if he wants to 
     * engage monsters or not.
     * @param p
     * @return boolean: true 
     */
    @Override
    public boolean useItem(Player p)
    {
        p.setInvis(5);
        return true;
    }

    @Override
    public String getType()
    {
        return "Consumable";
    }

    @Override
    public int getStat()
    {
        return -1;
    }
    
    /**
     * PotionOfInvisibility constructor, with a Message object as input, 
     * which is set as reference point to this objects message variable 'msg'.
     * @param msg
     */
    public PotionOfInvisibility(Message msg)
    {
        this.msg = msg;
    }
}
