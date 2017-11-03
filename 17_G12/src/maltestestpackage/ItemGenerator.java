/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import nicolai.Monster;
import nicolai.Player;

/**
 *
 * @author Malte
 */
public class ItemGenerator {

    
    
    public ItemGenerator()
    {
    }
    
    
    public Item generateItem(Player p)
    {

        int num = (int)(Math.random() * 6) + 1;
        switch (num)
        {
            case 1:
                return new HealingPotion(p);
  
            case 2:
                return new MiniMap();
                
            case 3:
                return new PotionOfCourage();
               
            case 4:
                return new PotionOfInvisibility();
                
            case 5:
                return new PotionOfSwiftness();
                
            default:
                return new PotionOfTeleportation(p);
    
        }
    }
}