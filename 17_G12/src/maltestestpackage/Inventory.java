/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;
import Stephie_build.GameEngine;
import static Stephie_build.GameEngine.getDifficulty;
/**
 *
 * @author Malte
 */
public class Inventory {
    private Item[] inventory;
    
    public Inventory()
    {
        this.inventory = new Item[7 - getDifficulty()];
    }
    
    
    
    
    
}
