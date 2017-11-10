/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import java.io.Serializable;
import nicolai.Player;

/**
 *
 * @author Malte
 */
public class PotionOfInvisibility implements Item, Serializable {

    
    
    @Override
    public String getDescription() {
        return "Is this flask empty? You can hear some liquid sloshing around inside";
    }

    @Override
    public String getName() {
        return "Potion of Invisibility";
    }

    
    /**
     * sets invisibility to true, allowing the player to choose if he wants to 
     * engage monsters or not.
     */
    @Override
    public void useItem(Player p) {
        //sets invisibility to true;
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    public PotionOfInvisibility()
    {
        
    }
    
}
