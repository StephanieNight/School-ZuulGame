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
    public void useItem() {
        // sets the exit to unlocked;
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
