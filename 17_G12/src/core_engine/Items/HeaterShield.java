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
public class HeaterShield implements Item
{

    private Message msg;
    
    /**
     * This returns the description of a HeaterShield object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "A aweinspirering shield that makes you wonder if anyone can hit you while using it"; 
    }

    /**
     * This returns the name of a HeaterShield object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Shield";
    }

    /**
     * This returns false.
     * @param p
     * @return false
     */
    @Override
    public boolean useItem(Player p)
    {
        return false;
    }

    /**
     * This returns the type of Item a HeaterShield object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Shield";
    }

    /**
     * This returns 10, which is the stat increase applied to the player,
     * when a HeaterShield object is equipped.
     * @return int: 10
     */
    @Override
    public int getStat()
    {
        return 10;
    }
    
    /**
     * HeaterShield constructor, with a Message object as input, which is
     * set as referencepoint to this objects Message variable 'msg'.
     * @param msg 
     */
    public HeaterShield(Message msg)
    {
        this.msg = msg;
    }
    
}
