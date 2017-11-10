/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import Stephie_build.GameEngine;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Malte
 */
public class ScoreTracker {
    
    private int score;
    private String fileName;
    private String filePath;
    private File saveFile;
    private Score[] highScore;

    
    
    public ScoreTracker()    
    {
    score = (int)(Math.pow(GameEngine.getDifficulty(), 2) * 10);
    highScore = new Score[10];
    }
    
    
    public int getScore()
    {
        return score;
    }
    
    public void monsterKill()
    {
        score += GameEngine.getDifficulty() * 5;
    }
    
    public void bossKill()
    {
        score += GameEngine.getDifficulty() * 10;
    }
    
    public void turnEnd()
    {
        score -= 1;
    }
    
    public void saveScore()
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        boolean success = false;
        
        
        try
        {
 
    
            fw = new FileWriter(saveFile.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
        } catch (IOException ex) {
            Logger.getLogger(ScoreTracker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

	if (bw != null){
            bw.close();
        }

	if (fw != null){
            fw.close();
        }
	} catch (IOException e) {
            }
        }
     
    }
    
    public void loadHighScore()
    {
        filePath = System.getProperty("user.dir") + "/HighScore";
        fileName = filePath + "/HighScore.txt";
        
        
        boolean success = false;
        saveFile = new File(fileName);
        if(!saveFile.exists())
        {
        try
        {
            saveFile.createNewFile();  
            success = true;
        
        }
        catch(IOException e)
        {   
        }
        if(!success)
            try{
        {
            new File(filePath).mkdir();
            saveFile.createNewFile();
        }
        }
        catch(IOException e)
        {

        }
 
    }

}
    
    private void highScoreParser()
    {
        String name;
        String scoreL;
        String diff;
        
        
        try
        {
        Scanner input = new Scanner(saveFile);
        for(Score s: highScore)
        {
            s = new Score(input.nextInt(),input.next(), input.nextLine());
        }
        }
        catch(FileNotFoundException e)
        { 
        }
        
        

        
        
        
    }
    
}
