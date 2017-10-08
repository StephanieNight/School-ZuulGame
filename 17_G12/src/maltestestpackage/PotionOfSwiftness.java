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
class PotionOfSwiftness extends Item{

    @Override
    public String getDescription() {
        return "A flask with a nice yellow color. Bear Grills would be pleased very tempted to just gulp it down";
    }

    @Override
    public String getName() {
        return "Potion Of Swiftness";
    }

    /**
     * Lets the player move twice between monster movement. Last for a short duration.
     */
    @Override
    public void useItem() {
        //
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
