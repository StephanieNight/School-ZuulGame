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
    private ScoreTracker scoretracker;
    /**
     * Creates a empty savegame instance
     */
    public SaveGameInstance()
    {
    }
    /**
     * crates a savegame instance with all data is needed to save this version of the game
     * @param Maze the maze with all it data, a bi directional Array of rooms
     * @param player the player with inventory health etc.
     * @param monsters list of monsters.
     * @param difficulty the games difficulty.
     */
    public SaveGameInstance(Room[][] Maze,Player player,ArrayList<Monster> monsters,
            int difficulty, ScoreTracker scoretracker )
    {
      this.maze = Maze;
      this.difficulty = difficulty;
      this.monsters = monsters;
      this.player = player;
      this.scoretracker = scoretracker;
    }    
    /**
     * Gets the maze
     * @return a  bi directional array of rooms represending the maze
     */
    public Room[][] getMaze() {
        return maze;
    }
    /**
     * gets the player 
     * @return player
     */
    public Actor getPlayer() {
        return player;
    }
    /**
     * gets the list of monsters
     * @return a Arraylist of monsters.
     */
    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    /**
     * gets the difficulty 
     * @return int of the difficulty.
     */
    public int getDifficulty() {
        return difficulty;
    }

    public ScoreTracker getScoretracker() {
        return scoretracker;
    }    
}
