/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Labyrinth;
import core_engine.Message;
import core_engine.Player;
import core_engine.Room;

/**
 *
 * @author Malte
 */
public class MiniMap implements Item
{
    private Labyrinth maze;
    private Message msg;

    /**
     * This returns the description of a MiniMap object.
     * @return String
     */
    @Override
    public String getDescription() {
        return "A datailed map of the labyrinth!"
                + "\nYou can even see the monsters!";
    }

    /**
     * This returns the name of a MiniMap object.
     * @return String
     */
    @Override
    public String getName() {
        return "Map";
        
    }

    
    /**
     * Updates the whole map as if you've been everywhere and returns true.
     * @param p
     * @return true 
     */
    @Override
    public boolean useItem(Player p) {
        msg.setDescription("You memorized the entire map. Might as well throw it away now.");
        for (int i = 0; i < maze.getMaze().length; i++) {
            for (int j = 0; j < maze.getMaze()[i].length; j++) {
                maze.getMaze()[i][j].setPlayerVisisted();
            }
        }
        return true;
    }

    /**
     * This returns the type of Item a MiniMap object is.
     * @return String
     */
    @Override
    public String getType() {
        return "Consumable";
    }

    /**
     * This returns -1, which is the stat of a MiniMap object, since it
     * is non-equipable.
     * @return int: -1
     */
    @Override
    public int getStat() {
        return -1;
    }
    
    /**
     * MiniMap constructor, with a the following arguments as input:
     * @param maze: This is set as reference point to this objects
     * Labyrinth variable.
     * @param msg: This is set as reference point to this objects Message
     * variable
     */
    public MiniMap(Labyrinth maze, Message msg)
    {
        this.maze = maze;
        this.msg = msg;
    }
}
