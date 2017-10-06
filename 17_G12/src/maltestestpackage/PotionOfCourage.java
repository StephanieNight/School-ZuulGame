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
        return "PotionOfCourage";
    }

    @Override
    public void useItem() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
