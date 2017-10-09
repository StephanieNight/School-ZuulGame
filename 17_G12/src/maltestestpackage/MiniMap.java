/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

/**
 *
 * @author Malte
 */
public class MiniMap extends Item{

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
    public void useItem() {
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
    
}
