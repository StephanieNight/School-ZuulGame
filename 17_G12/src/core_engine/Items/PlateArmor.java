/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Message;
import core_engine.Player;
import java.io.Serializable;

/**
 *
 * @author simon
 */
public class PlateArmor implements Item, Serializable
{
    private Message msg;
    
    /**
     * This returns the description of a PlateArmor object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "Heavy armor made to withstand attacks.";
    }
    
    /**
     * This returns the name of a PlateArmor object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Plate armor";
       
    }
    
    /**
     * This returns false.
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
     * This returns the type of Item a PlateArmor object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Armor";
    }
    
    /**
     * This returns 10, which is the stat increase applied to the player,
     * when a PlateArmor object is equipped.
     * @return int: 10
     */
    @Override
    public int getStat()
    {
        return 10;
    }   
    
    /**
     * PlateArmor constructor, with a Message object as input, which is set
     * as reference point to this objects Message variable 'msg'.
     * @param msg 
     */
    public PlateArmor(Message msg){
        this.msg = msg;
    }
}