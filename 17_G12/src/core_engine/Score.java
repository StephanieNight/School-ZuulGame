/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.IScore;
import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * data type for scores used in highscore
 * @author Malte
 */
public class Score implements IScore, Serializable, Comparable<Score> {
 private String name;
 private String difficulty;
 private int score;

 
 /**
  * The constructer used to make new Score objects. 
  * @param score is the start value the score has.
  * @param diff is the difficulty name.
  * @param name is the player name.
  */
 public Score(int score, String diff, String name)
 {
     this.score = score;
     this.difficulty = diff;
     this.name = name;
    
     
 }
/**
 * Method to set the score value
 * @param score the interget value of the current score.
 */
    public void setScore(int score) {
        this.score = score;
    }
    
   
    /**
     * returns a string with name, difficulty and score
     * @return 
     */
    @Override
    public String toString()
    {
        return "" + name  + " " + score + " " + difficulty;
    }
    
    /**
     * Method to get the score value
     * @return the integer value of the score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * the method to get the name
     * @return name of player
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * The method to get the difficulty in String format
     * @return the name of the associated difficulty
     */
    @Override
    public String getDifficulty() {
        return difficulty;
    }

    /**
     * The method to get the score value in string format
     * @return the score value in a String
     */
    @Override
    public String getScoreString() {
        return Integer.toString(score);
    }

    /**
     * The method from Comparable interface
     * @param o the score you want to compare to
     * @return an integer value: 1 if this score is larger than the other, 
     * 0 if they're even and -1 if this score is smaller than the other.
     */
    @Override
    public int compareTo(Score o) {
        if(o.getScore() < score)
        {
            return -1;
        }
        else if(o.getScore() == score)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }

   

    

  
    


    
}
