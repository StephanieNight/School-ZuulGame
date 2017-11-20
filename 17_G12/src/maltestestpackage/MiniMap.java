/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import core_engine.Labyrinth;
import core_engine.Player;
import core_engine.Room;

/**
 *
 * @author Malte
 */
public class MiniMap implements Item{
    
    private Room[][] maze;

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
    public void useItem(Player p) {
        for (Room[] maze1 : maze) {
            for (Room maze11 : maze1) {
                maze11.isPlayerVissited();
            }
        }
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
        this.maze = maze.getMaze();
    }
}
