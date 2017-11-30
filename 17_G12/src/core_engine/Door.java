/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import java.io.Serializable;

/**
 * a door to block the players path to victory.
 * @author Stephanie
 */
public class Door implements Serializable{
    private boolean locked; // IS locked
    /**
     * contructor to create a door it is posible to state if the door is locked
     * by default or not
     * @param Locked is the door locked
     */
    public Door(boolean Locked) {        
        this.locked = Locked;
    }
    /**
     * unluckeds the door
     */
    public void unLock() {
        locked = false;         
    }
    /** 
     * checks if the door is locked
     * @return if the door i locked
     */
    public boolean isLocked() {
        return locked;
    }
    
}
