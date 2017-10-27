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
public class HealingPotion implements Item{

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
        System.out.println("You already feel better");
        //player.setCurrentHealth(player.getCurrentHealth + 30);
    }

    

    @Override
    public String getType() {
        return "Consumable";
    }

    /**
     * 
     * @return all consumable items return -1 because it's not how you use them.
     */
    @Override
    public int getStat() {
        return -1;
    }
    
    
    /**
     * no-args constructor, no args needed since all information is predefined.
     */
    public HealingPotion()
    {
        
    }
    
}
