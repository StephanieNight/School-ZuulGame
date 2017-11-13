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
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import nicolai.Player;

/**
 * Class for tracking the score for the current game
 * @author Malte
 */
public class ScoreTracker implements Serializable {
    
    private Score score;
    private int currentScore;
    private Player player;

    
    
    public ScoreTracker(Player p)    
    {
        this.player = p;
        currentScore = (int)(Math.pow(GameEngine.getDifficulty(), 2) * 10);
        score = new Score(currentScore, GameEngine.DIFFICULTY_NAMES[GameEngine.getDifficulty() - 1], player.getName());
        
    }

    public Score getScore() {
        return score;
    }
    
    /**
     * adds points when called, used when the player kills a normal monster
     */
    public void monsterKill()
    {
        
        currentScore += GameEngine.getDifficulty() * 5;
        score.setScore(currentScore);
    }
    
    /**
     * used when the boss is killed
     */
    public void bossKill()
    {
        currentScore += GameEngine.getDifficulty() * 10;
        score.setScore(currentScore);
    }
    /**
     * subtracts points every time called, used at the end of every counting turn.
     */
    public void turnEnd()
    {
        currentScore -= 1;
        score.setScore(currentScore);
    }
    
    
}
