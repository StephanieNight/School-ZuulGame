/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import gameframework.Game;
import gameframework.Parser;

/**
 *
 * @author Stephanie
 */
public class GameEngine {
    private static int difficulty;  
    private Parser parser;
    public GameEngine()
    {
        parser = new Parser();
        int i = -1;
        while(i == -1)
        {
          i =parser.getDifficulty();
        }
        difficulty = i; 
    }
    public void play()
    {
        // test by stepth
        int size = (int)((1.5*difficulty)+3);
        Labyrinth lab = new Labyrinth(size);        
    }
    public static int getDifficulty()
    {
        return difficulty;
    }
    
}
