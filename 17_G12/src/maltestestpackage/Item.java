/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

/**
 * Abstract super class for all item classes
 * getDescription and getName is the same in all item classes and returns 
 * a string with either description or name of said item.
 * @author Malte
 */
public abstract class Item {
    public abstract String getDescription();
    public abstract String getName();
    public abstract void useItem();
    public abstract String getType();
    public abstract int getStat();
}







