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
public class Sword implements Item{
    
    @Override
    public String getDescription(){
        return "A steel sword.";
    }
    
    @Override
    public String getName(){
        return "Sword";
    }
    
    @Override
    public void useItem(){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){ //weapons add attack value.
        return "Weapon";
    }
    
    @Override
    public int getStat(){ //Added attack value amount.
        return 7;
    }   
    
    public Sword(){
        
    }
}