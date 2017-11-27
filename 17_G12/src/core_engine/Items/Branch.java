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
public class Branch implements Item
{
    private Message msg;
    
    /**
     * This returns the description of a Branch object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "A large branch you found outside the dungeon.";
    }
    
    /**
     * This returns the name of a Branch object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Branch";
    }
    
    /**
     * This writes a String to the System console output and returns false.
     * @param p
     * @return false
     */
    @Override
    public boolean useItem(Player p)
    {
        msg.setDescription("There's a time and place for everything, but not now.");
        return false;
    }
    
    /**
     * This returns the type of Item a Branch object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Weapon";
    }
    
    /**
     * This returns 5, which is the stat increase applied to the player,
     * when a Branch object is used.
     * @return int: 5
     */
    @Override
    public int getStat()
    {
        return 5;
    }
    
    /**
     * Branch constructor, with a Message object as input, which is set
     * as referencepoint to this objects message variable 'msg'.
     * @param message 
     */
    public Branch(Message message)
    {
        msg = message;
    }
    
}