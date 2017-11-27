/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Message;
import core_engine.Player;

/**
 * lets you add extra time to your game.
 * @author Malte
 */
public class LampOil implements Item
{
    private Message msg;
    
    /**
     * This returns the description of a LampOil object.
     * @return String
     */
    @Override
    public String getDescription() 
    {
        return "Oil to fuel your Oil lamp.";
        
    }

    /**
     * This returns the name of a LampOil object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Lamp Oil";
    }

    /**
     * Calls the method 'addLampOil() on the argument Player object,
     * to add extra time to the player. After that the method returns true.
     * @param p the current player.
     * @return true
     */
    @Override
    public boolean useItem(Player p)
    {
        p.addLampOil();
        return true;
    }

    /**
     * This returns the type of Item a LampOil object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Consumable";
    }

    /**
     * This returns -1, which is the stat of a LampOil object, since it is
     * non-equipable.
     * @return int: -1
     */
    @Override
    public int getStat()
    {
        return -1;
    }
    
    /**
     * LampOil constructor, with a Message object as input, which is set as
     * referencepoint to this objects message variable 'msg'.
     * @param msg 
     */
    public LampOil(Message msg)
    {
        this.msg = msg;
    }
}
