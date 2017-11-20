/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Player;

/**
 *
 * @author Malte
 */
public class PotionOfCourage implements Item {

    @Override
    public String getDescription() {
        return "A flask with a distinct smell of whiskey. "
                + "\nWhy would anyone leave that here";
    }


    @Override
    public String getName() {
        return "Potion Of Courage";
    }

    /**
     * lets you gain a level.
     */
    @Override
    public void useItem(Player p) {
        System.out.println("Feels good to drink some liquid courage!");
        p.setXp(p.getXp() + 2);
        p.updateLevel();  
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    public PotionOfCourage()
    {
        
    }
}
