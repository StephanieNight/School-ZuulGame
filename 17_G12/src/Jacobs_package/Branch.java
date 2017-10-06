/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jacobs_package;

import maltestestpackage.Item;

/**
 *
 * @author simon
 */
class Branch extends Item{
    
    @Override
    public String getDescription(){
        return "A large branch you found outside the dungeon.";
    }
    
    @Override
    public String getName(){
        return "Branch";
    }
    
    @Override
    public void useItem(){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){
        return "Weapon";
    }
    
    @Override
    public int getStat(){
        return 2;
    }   
}