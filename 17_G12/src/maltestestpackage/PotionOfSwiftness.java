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
public class PotionOfSwiftness extends Item{

    @Override
    public String getDescription() {
        return "A flask with a nice yellow color. Bear Grills would be very tempted to just gulp it down";
    }

    @Override
    public String getName() {
        return "Potion Of Swiftness";
    }

    /**
     * Lets the player move twice between monster movement. Last for a short duration.
     * sets the counter for swiftness to 10, which lets you skip monsters turn
     * every 2nd time 5 times.
     */
    @Override
    public void useItem() {
        //setSwiftnessCounter(10);
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
