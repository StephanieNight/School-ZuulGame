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
public class PotLid implements Item
{
    private Message msg;
    
    /**
     * This returns the description of a PotLid object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "The worn lid of a cooking pot from home.";
    }
    
    /**
     * This returns the name of a PotLid object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Lid";
        
    }
    
    /**
     * This returns false.
     * @param p
     * @return false
     */
    @Override
    public boolean useItem(Player p)
    {
        System.out.println("There's a time and place for everything, but not now.");
        return false;
    }
    
    /**
     * This returns the type of Item a PotLid object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Shield";
    }
    
    /**
     * This returns 2, which is the stat increase applied to the player,
     * when a PotLid object is equipped.
     * @return 
     */
    @Override
    public int getStat()
    {
        return 2;
    }
    
    /**
     * PotLid constructor, with a Message object as input, which is set
     * as referencepoint to this objects Message variable 'msg'.
     * @param msg 
     */
    public PotLid(Message msg)
    {
        this.msg = msg;
        
    }
}
