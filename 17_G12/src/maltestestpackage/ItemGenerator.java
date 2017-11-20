/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import core_engine.Labyrinth;


/**
 *
 * @author Malte
 */
public class ItemGenerator {

    Labyrinth maze;
    
    public ItemGenerator(Labyrinth maze)
    {
        this.maze = maze;
    }
    
    
    public Item generateRandomItem()
    {

        int num = (int)(Math.random() * 6) + 1;
        return generateItem(num);
    }
    
    public Item generateItem(int num)
    {

        switch (num)
        {
            case 1:
                return new HealingPotion();
  
            case 2:
                return new MiniMap(maze);
                
            case 3:
                return new PotionOfCourage();
               
            case 4:
                return new PotionOfInvisibility();
                
            case 5:
                return new PotionOfSwiftness();
                
            default:
                return new PotionOfTeleportation();
    
        }
    }
}
