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
class PotionOfCourage extends Item {

    @Override
    public String getDescription() {
        return "A flask with a distinct smell of whiskey. Why would anyone leave that here";
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
        //nothing here
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
