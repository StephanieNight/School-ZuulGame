/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.IHighScore;
import acquaintance.ISaveGameHandler;
import acquaintance.ISavegameInstance;
import static acquaintance.IGameConstants.FILENAME_SAVEGAME;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 *
 * @author Stephanie
 */
public class SaveGameHandler implements  ISaveGameHandler{ 
    @Override
    public void saveGame(ISavegameInstance sa) throws IOException { 
        OutputStream outStream = new FileOutputStream(FILENAME_SAVEGAME);    
        ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
        fileObjectOut.writeObject(sa);
        fileObjectOut.close();
        outStream.close();
    }  
    @Override
    public ISavegameInstance loadGame() throws IOException, ClassNotFoundException {
        InputStream inStream = new FileInputStream(FILENAME_SAVEGAME);
        ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
        ISavegameInstance sa = (ISavegameInstance) fileObjectIn.readObject();
        fileObjectIn.close();
        inStream.close();         
        return sa;
    }
    
    /**
 *
 * @author Stephanie
 */
  
    @Override
    public void saveHighScore(IHighScore sa) throws IOException { 
        OutputStream outStream = new FileOutputStream(FILENAME_SAVEGAME);    
        ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
        fileObjectOut.writeObject(sa);
        fileObjectOut.close();
        outStream.close();
    }  

    @Override
    public IHighScore loadHighScore() throws IOException, ClassNotFoundException {
        InputStream inStream = new FileInputStream(FILENAME_SAVEGAME);
        ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
        IHighScore sa = (IHighScore) fileObjectIn.readObject();
        fileObjectIn.close();
        inStream.close();         
        return sa;
    }
}
