/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Stephanie
 */
public interface ISaveGameHandler {
    public ISavegameInstance loadGame() throws IOException, ClassNotFoundException;
    public void saveGame(ISavegameInstance sa)throws IOException;   
    public IHighScore loadHighScore() throws IOException, ClassNotFoundException;
    public void saveHighScore(IHighScore sa)throws IOException; 
}
