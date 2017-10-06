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
class HealingPotion extends Item{

    @Override
    public String getDescription() {
        return "A red potion. You feel like it might be nice to drink it!";
    }

    @Override
    public String getName() {
        return "Healing Potion";
    }
    
    /**
     * adds X to player health points up to max health points
     */
    @Override
    public void useItem() {
        //adds hp to player character;
    }

    
     /**
      * 
      * @return 
      */
    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    /**
     * no-args constructor
     */
    public HealingPotion()
    {
        
    }
    
}
