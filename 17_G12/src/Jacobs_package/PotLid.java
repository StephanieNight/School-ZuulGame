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
class PotLid extends Item{

    @Override
    public String getDescription(){
        return "The worn lid of a cooking pot from home.";
    }
    
    @Override
    public String getName(){
        return "Lid";
    }
    
    @Override
    public void useItem(){
        System.out.println("There's a time and place for everything, but not now.");
    }
    
    @Override
    public String getType(){
        return "Shield";
    }
    
    @Override
    public int getStat(){
        return 2;
    }   
    
}