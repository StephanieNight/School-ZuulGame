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
public class Key implements Item
{
    private Message msg;

    /**
     * This returns the description of a Key object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "This is a key, what does it do?";
    }

    /**
     * This returns the name of a Key object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Key";
    }

    /**
     * Unlocks the door out of the dungeon letting the player win.
     * @param p
     * @return false
     */
    @Override
    public boolean useItem(Player p)
    {
        if(p.getCurrentRoom().getExit("north").hasDoor("south"))
        {
            msg.setDescription("The door has been unlocked.");
            p.getCurrentRoom().getExit("north").getDoor("south").unLock(p);
        }
        else{
            msg.setDescription("There's a time and place for everything, but not now.");
        }
        return false;
    }

    
    /**
     * This returns the type of Item a Key object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Key";
    }
    
    /**
     * This returns -1, which is the stat of a Key object,
     * since it is non-equipable.
     * @return int: -1
     */
    @Override
    public int getStat()
    {
        return -1;
    }
    
    /**
     * Key constructor, with a Message object as input, which is set as
     * reference point to this objects message variable 'msg'.
     * @param msg 
     */
    public Key(Message msg)
    {
        this.msg = msg;
    }

 
}
