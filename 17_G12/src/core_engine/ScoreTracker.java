/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import core_engine.GameEngine;
import acquaintance.IGameConstants;
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
import core_engine.Player;

/**
 * Class for tracking the score for the current game
 * @author Malte
 */
public class ScoreTracker implements Serializable {
    
    private Score score;
    private int currentScore;
    private Player player;
    private int diff;

    
    /**
     * set up the score tracker with the player and the difficulty
     * @param p player to be traced
     * @param diff game difficulty.
     */
    public ScoreTracker(Player p, int diff)    
    {
        this.player = p;
        
        currentScore = (int)(Math.pow(diff,2)) * 10;
        score = new Score(currentScore, IGameConstants.DIFFICULTY_NAMES[diff - 1], player.getName());


    }
    /**
     * gets the current score
     * @return score
     */
    public Score getScore() {
        return score;
    }    
    /**
     * adds points when called, used when the player kills a normal monster
     */
    public void monsterKill() {
        
        currentScore += diff * 5;
        score.setScore(currentScore);
    }    
    /**
     * used when the boss is killed
     */
    public void bossKill() {
        currentScore += diff * 10;
        score.setScore(currentScore);
    }
    /**
     * subtracts points every time called, used at the end of every counting turn.
     */
    public void turnEnd() {
        currentScore -= 1;
        score.setScore(currentScore);
    }    
}
