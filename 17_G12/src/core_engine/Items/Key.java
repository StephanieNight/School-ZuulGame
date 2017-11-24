/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Player;

/**
 *
 * @author Malte
 */
public class Key implements Item{
@Override


public String getDescription()
{
    return "This is a key, what does it do?";
    
}


    @Override
    public String getName() {
        return "Key";
    }

    /**
     * Unlocks the door out of the dungeon letting the player win
     */
    @Override
    public boolean useItem(Player p) {
        if(p.getCurrentRoom().getExit("north").hasDoor("south"))
        {
            p.getCurrentRoom().getExit("north").getDoor("south").unLock(p);
        }
        return false;
    }

    
    /**
     * 
     * @return 
     */
    @Override
    public String getType() {
        return "Key";
    }

    @Override
    public int getStat() {
        return -1;
    }
    
    public Key()
    {
        
    }

 
}
