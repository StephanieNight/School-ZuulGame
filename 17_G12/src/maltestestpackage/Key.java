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
public class Key extends Item{
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Key()
    {
        
    }
}
