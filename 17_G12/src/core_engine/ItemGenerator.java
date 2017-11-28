/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import core_engine.Items.HealingPotion;
import core_engine.Items.Item;
import core_engine.Items.LampOil;
import core_engine.Items.MiniMap;
import core_engine.Items.PotionOfCourage;
import core_engine.Items.PotionOfInvisibility;
import core_engine.Items.PotionOfSwiftness;
import core_engine.Items.PotionOfTeleportation;
import core_engine.Labyrinth;


/**
 * Class to generate items. Can either generate a specific or a random item.
 * @author Malte
 */
public class ItemGenerator {

    private Labyrinth maze;
    private Message msg;
  
    
    public ItemGenerator(Labyrinth maze, Message msg)
    {
        this.maze = maze;
        this.msg = msg;


    }
    
    /**
     * generates a random item
     * @return the item generated
     */
    public Item generateRandomItem()
    {

        int num = (int)(Math.random() * 7) + 1;
        return generateItem(num);
    }
    
    /**
     * generates a specific item
     * @param num an integer for the item you want.
     * @return Item corresponding to the interger given.
     */
    public Item generateItem(int num)
    {

        switch (num)
        {
            case 1:
                return new HealingPotion(msg);
  
            case 2:
                return new MiniMap(maze, msg);
                
            case 3:
                return new PotionOfCourage(msg);
               
            case 4:
                return new PotionOfInvisibility(msg);
                
            case 5:
                return new PotionOfSwiftness(msg);
                
            case 6:
                return new LampOil(msg);
                
            default:
                return new PotionOfTeleportation(maze, msg);
    
        }
    }
}
