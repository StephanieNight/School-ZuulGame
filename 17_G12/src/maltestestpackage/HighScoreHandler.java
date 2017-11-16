/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import core_engine.GameEngine;
import data.SaveGameInstance;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 * class to handle highscore array and to check and add new score at the right place
 * @author Malte
 */
public class HighScoreHandler implements Serializable{
    private Score[] scores;
    
    public HighScoreHandler()
    {
        scores = new Score[10];
        fillArray();
    }
    
    /**
     * makes sure the array is not empty
     */
    public void fillArray()
    {
       scores[0] = new Score(999, GameEngine.DIFFICULTY_NAMES[4], "Maltron2000");
       scores[1] = new Score(120, GameEngine.DIFFICULTY_NAMES[3], "Hercules");
       scores[2] = new Score(75, GameEngine.DIFFICULTY_NAMES[2], "Medusa");
       scores[3] = new Score(55, GameEngine.DIFFICULTY_NAMES[2], "Beowulf");
       scores[4] = new Score(54, GameEngine.DIFFICULTY_NAMES[2], "Holgar");
       scores[5] = new Score(40, GameEngine.DIFFICULTY_NAMES[2], "Thomas");
       scores[6] = new Score(28, GameEngine.DIFFICULTY_NAMES[1], "Karsten");
       scores[7] = new Score(27, GameEngine.DIFFICULTY_NAMES[1], "Günther");
       scores[8] = new Score(12, GameEngine.DIFFICULTY_NAMES[0], "NOOB_PLAYER_1");
       scores[9] = new Score(2, GameEngine.DIFFICULTY_NAMES[0], "NOOB_PLAYER_1");
       
    }

    public Score[] getScores() {
        return scores;
    }

    /**
     * adds a score to the array if the score value is larger than the any of 
     * the other entries. The array moves all scores with lower values one up in
     * the array and places the new score where it fits.
     * @param score 
     */
    public void addScore(Score score)
    {
        for(int i = 0; i < scores.length ; i++)
        {
            if(score.compareTo(scores[i]) < 0)
            {
                for(int j = scores.length - 1; j > i; j--)
                {
                    scores[j] = scores[j - 1];
                }
                scores[i] = score;
                break;
            }
        }
        try
        {
        serializeToFile(this);
        }
         catch(Exception e)
        {
            System.out.println(e.getMessage());
        }  
    }
    
    /**
     * saves highscore using java serialization
     * @param samegame
     * @throws IOException 
     */
    public static void serializeToFile(HighScoreHandler samegame) throws IOException {
        OutputStream outStream = new FileOutputStream(GameEngine.FILENAME_HIGHSCORE_LIST);
        ObjectOutputStream fileObjectOut = new ObjectOutputStream(outStream);
        fileObjectOut.writeObject(samegame);
        fileObjectOut.close();
        outStream.close();
    }

    /**
     * loads highscore using java serialization
     * @return
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static HighScoreHandler deserializeFromFile() throws IOException, ClassNotFoundException {
        InputStream inStream = new FileInputStream(GameEngine.FILENAME_HIGHSCORE_LIST);
        ObjectInputStream fileObjectIn = new ObjectInputStream(inStream);
        HighScoreHandler sa = (HighScoreHandler) fileObjectIn.readObject();
        System.out.println(sa);
        fileObjectIn.close();
        inStream.close();        
        return sa;        
    }
    

}
