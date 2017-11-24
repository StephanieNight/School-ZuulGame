/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine.Items;

import core_engine.Labyrinth;
import core_engine.Player;
import core_engine.Room;

/**
 *
 * @author Malte
 */
public class MiniMap implements Item{
    
    private Labyrinth maze;

    @Override
    public String getDescription() {
        return "A datailed map of the labyrinth!"
                + "\nYou can even see the monsters!";
    }

    @Override
    public String getName() {
        return "Map";
        
    }

    
    /**
     * Updates the whole map as if you've been everywhere.
     * @param p
     */
    @Override
    public boolean useItem(Player p) {
        for (int i = 0; i < maze.getMaze().length; i++) {
            for (int j = 0; j < maze.getMaze()[i].length; j++) {
                maze.getMaze()[i][j].setPlayerVisisted();
            }
        }
        return true;
    }

    @Override
    public String getType() {
        return "Consumable";
    }

    @Override
    public int getStat() {
        return -1;
    }
    
    public MiniMap(Labyrinth maze)
    {
        this.maze = maze;
    }
}
