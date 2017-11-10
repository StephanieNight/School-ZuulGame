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
public class MiniMap implements Item, Serializable{

    @Override
    public String getDescription() {
        return "A datailed map of the labyrinth!"
                + "\nYou can even see the monsters!";
    }

    @Override
    public String getName() {
        return "Map";
    }

    
    /**
     * Updates the whole map as if you've been everywhere.
     */
    @Override
    public void useItem(Player p) {
        //sets all room to visited
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    
    public MiniMap()
    {
        
    }
}
