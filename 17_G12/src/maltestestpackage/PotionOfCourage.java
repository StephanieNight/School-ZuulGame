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
public class PotionOfCourage extends Item {

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
     * no effect so far
     */
    @Override
    public void useItem() {
        System.out.println("Feels good to drink some liquid courage!");
        
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
