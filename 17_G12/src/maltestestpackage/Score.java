/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

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
 private String scoreString;
 
 
 public Score(int score, String diff, String name)
 {
     this.score = score;
     this.difficulty = diff;
     this.name = name;
     this.scoreString = Integer.toString(score);
     
 }

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
        return "\t" + name  + "\t\t " + score + "\t\t " + difficulty;
    }
    
    public int getScore()
    {
        return score;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDifficulty() {
        return difficulty;
    }

    @Override
    public String getScoreString() {
        return scoreString;
    }

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
