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
public class PotionOfCourage implements Item
{
    private Message msg;
    
    /**
     * This returns the description of a PotionOfCourage object.
     * @return String
     */
    @Override
    public String getDescription()
    {
        return "A flask with a distinct smell of whiskey. "
                + "\nWhy would anyone leave that here";
    }

    /**
     * This returns the name of a PotionOfCourage object.
     * @return String
     */
    @Override
    public String getName()
    {
        return "Potion Of Courage";
    }

    /**
     * This method uses the method 'setXp(int)' to add experience to the
     * argument player object:
     * @param p - Player Object
     * After that the method 'updateLevel()' is used on the argument player
     * object, to update the players level. after that this method returns true.
     * @return true
     */
    @Override
    public boolean useItem(Player p)
    {
        msg.setDescription("Feels good to drink some liquid courage!");
        p.setXp(p.getXp() + 2);
        p.updateLevel();  
        p.setCurrentHealth(p.getCurrentHealth() + 15);
        return true;
    }

    /**
     * This returns the type of Item a PotionOfCourage object is.
     * @return String
     */
    @Override
    public String getType()
    {
        return "Consumable";
    }

    /**
     * This returns -1, which is the stat of a PotionOfCourage object,
     * since it is non-equipable.
     * @return 
     */
    @Override
    public int getStat()
    {
        return -1;
    }
    
    /**
     * PotionOfCourage constructor, with a Message object as input, which is
     * set as referencepoint to this objects message variable 'msg'.
     * @param msg 
     */
    public PotionOfCourage(Message msg)
    {
        this.msg = msg;
    }
}
