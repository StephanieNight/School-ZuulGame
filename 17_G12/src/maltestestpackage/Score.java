/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import java.io.Serializable;

/**
 * data type for scores used in highscore
 * @author Malte
 */
public class Score implements Comparable<Score>, Serializable {
 private String name;
 private String diff;
 private int score;
 
 public Score(int score, String diff, String name)
 {
     this.score = score;
     this.diff = diff;
     this.name = name;
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
        return "" + name + " " + diff + " " + score;
    }

    /**
     * compare operator to compare one Score object with another
     * @param score 
     * @return returns 1 if the current score is bigger than the score it is compared to
     * returns 0 if the two scores are the same and -1 if the current score is
     * the lesser of the two
     */
    @Override
    public int compareTo(Score score) 
    {
        if (score.getScore() > this.score)
        {
            return 1;
        }
        else if (score.getScore() == this.score)
        {
            return 0;
        } 
        else
        {
            return -1;
        }
    }
    
    public int getScore()
    {
        return score;
    }
    
}
