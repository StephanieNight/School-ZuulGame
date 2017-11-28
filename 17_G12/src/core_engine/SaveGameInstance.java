/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.IActor;
import acquaintance.IRoom;
import acquaintance.ISavegameInstance;
import java.io.Serializable;



/**
 *
 * @author Stephanie
 */
public class SaveGameInstance implements ISavegameInstance, Serializable {
    // then marked transient it will not be serialized.
    private Room[][] maze;
    private Player player;
    private Monster[] monsters;
    private int difficulty;
    public SaveGameInstance()
    {
    }
    public SaveGameInstance(Room[][] Maze,Player player,Monster[] monsters, int difficulty )
    {
      this.maze = Maze;
      this.difficulty = difficulty;
      this.monsters = monsters;
      this.player = player;
    }    
    public Room[][] getMaze() {
        return maze;
    }
 
    public Actor getPlayer() {
        return player;
    }
    
    public Monster[] getMonsters() {
        return monsters;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
}
