/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import nicolai.Monster;
import nicolai.Player;

/**
 *
 * @author Stephanie
 */
public class SaveGameInstance implements Serializable {
    // then marked transient it will not be serialized.
    private Room[][] maze;
    private Player player;
    private ArrayList<Monster> monsters;
    private int difficulty;
    public SaveGameInstance()
    {
    }
    public SaveGameInstance(Room[][] Maze,Player player, ArrayList<Monster> monsters, int difficulty )
    {
      this.maze = Maze;
      this.difficulty = difficulty;
      this.monsters = monsters;
      this.player = player;
    }
    public static void serializeToFile(SaveGameInstance samegame) throws IOException {
        OutputStream outStream = new FileOutputStream(GameEngine.FILENAME_SAVEGAME);
        ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
        fileObjectOut.writeObject(samegame);
        fileObjectOut.close();
        outStream.close();
    }

    public static SaveGameInstance deserializeFromFile() throws IOException, ClassNotFoundException {
        InputStream inStream = new FileInputStream(GameEngine.FILENAME_SAVEGAME);

        ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
        SaveGameInstance sa = (SaveGameInstance) fileObjectIn.readObject();
        System.out.println(sa);
        fileObjectIn.close();
        inStream.close();        
        return sa;        
    }
    public Room[][] getMaze() {
        return maze;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }
    public int getDifficulty() {
        return difficulty;
    }

}
