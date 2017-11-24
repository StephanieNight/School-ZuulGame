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
public class PotionOfTeleportation implements Item {
    private Labyrinth maze;
    
    @Override
    public String getDescription() {
        return "A flask with a clear substance within it. "
                + "\nSmells like sunshine and happiness... Wonder what it does...";
    }

    @Override
    public String getName() {
        return "Potion Of Teleportation";
    }

    /**
     * transports the player to a random location on the map
     */
    @Override
    public boolean useItem(Player p) {
        int x = (int)(Math.random() * maze.getMaze().length);
        int y = (int)(Math.random() * maze.getMaze().length);
        
        Room room = maze.getMaze()[x][y];
        maze.movePlayer(p, room);
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
    
    public PotionOfTeleportation(Labyrinth maze)
    {
        this.maze = maze;
    }
 
}
