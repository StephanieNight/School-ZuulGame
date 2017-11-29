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
 * @author Malte
 */
public class PotionOfSwiftness implements Item, Serializable
{

    private Message msg;
    @Override
    public String getDescription() {
        return "A flask with a nice yellow color. "
                + "\nBear Grills would be very tempted to just gulp it down";
    }

    @Override
    public String getName() {
        return "Potion Of Swiftness";
    }

    /**
     * Lets the player move twice between monster movement. Last for a short duration.
     * sets the counter for swiftness to 10, which lets you skip monsters turn
     * every 2nd time 5 times.
     * @param p
     * @return boolean: true
     */
    @Override
    public boolean useItem(Player p) {
        p.setSwiftnessCounter(9);
        msg.setDescription("You feel extremely energetic.");
        return true;
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    /**
     * PotionOfSwiftness constructor, with a Message object as input, 
     * which is set as reference point to this objects message variable 'msg'.
     * @param msg 
     */
    public PotionOfSwiftness(Message msg)
    {
        this.msg = msg;
    }
}
