/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.ISavegameInstance;
import java.io.Serializable;
import java.util.ArrayList;



/**
 *
 * @author Stephanie
 */
public class SaveGameInstance implements ISavegameInstance, Serializable {
    // then marked transient it will not be serialized.
    private Room[][] maze;
    private Player player;
    private ArrayList<Monster> monsters;
    private int difficulty;
    public SaveGameInstance()
    {
    }
    public SaveGameInstance(Room[][] Maze,Player player,ArrayList<Monster> monsters, int difficulty )
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
    
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    
    public int getDifficulty() {
        return difficulty;
    }
}
