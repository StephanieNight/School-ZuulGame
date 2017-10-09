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
public class PlateArmor extends Item{
    
    @Override
    public String getDescription(){
        return "Heavy armor made to withstand attacks.";
    }
    
    @Override
    public String getName(){
        return "Plate armor";
    }
    
    @Override
    public void useItem(){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){ //Armor adds defense value.
        return "Armor";
    }
    
    @Override
    public int getStat(){ //Added defense value amount.
        return 5;
    }   
    
    public PlateArmor(){
        
    }
}