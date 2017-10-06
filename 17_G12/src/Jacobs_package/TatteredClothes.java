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
class TatteredClothes extends Item{
    
    @Override
    public String getDescription(){
        return "Trusty clothes that have seen a lot of use.";
    }
    
    @Override
    public String getName(){
        return "Tattered Clothes";
    }
    
    @Override
    public void useItem(){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){
        return "Armor";
    }
    
    @Override
    public int getStat(){
        return 1;
    }   
}
