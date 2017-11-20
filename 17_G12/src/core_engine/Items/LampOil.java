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
public class LampOil implements Item{

    @Override
    public String getDescription() {
        return "Oil to fuel your Oil lamp.";
    }

    @Override
    public String getName() {
        return "Lamp Oil";
    }

    @Override
    public void useItem(Player p) {
        p.addLampOil();
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    
    public LampOil()
    {
        
    }
}
