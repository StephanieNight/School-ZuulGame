/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import java.io.Serializable;
import nicolai.Player;

/**
 *
 * @author Stephanie
 */
class Door implements Serializable{
    private boolean Locked;
    public Door(boolean Locked)
    {        
        this.Locked = Locked;
    }
    public boolean unLock(Player p)
    {
        return false;                
    }

    public boolean isLocked() {
        return Locked;
    }
    
}
