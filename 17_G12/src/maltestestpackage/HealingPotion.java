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

    @Override
    public void useItem() {
        //adds hp to player character;
    }
    
}
