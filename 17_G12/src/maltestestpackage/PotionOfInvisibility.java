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
class PotionOfInvisibility extends Item {

    
    
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
    public void useItem() {
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
    
}
