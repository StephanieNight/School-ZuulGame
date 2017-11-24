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
public class Shield implements Item {

    @Override
    public String getDescription() {
        return "A aweinspirering shield that makes you wonder if anyone can hit you while using it"; 
    }

    @Override
    public String getName() {
        return "Shield";
    }

    @Override
    public boolean useItem(Player p) {
        return false;
    }

    @Override
    public String getType() {
        return "Shield";
    }

    @Override
    public int getStat() {
        return 10;
    }
    
}
