/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

/**
 *
 * @author Malte
 */
public class Score implements Comparable<Score> {
 private String name;
 private String diff;
 private int score;
 
 public Score(int score, String diff, String name)
 {
     this.score = score;
     this.diff = diff;
     this.name = name;
 }
    
 @Override
    public String toString()
    {
        return "" + name + " " + diff + " " + score;
    }

    @Override
    public int compareTo(Score o) 
    {
        if (o.getScore() > score)
        {
            return 1;
        }
        else if (o.getScore() == score)
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
    
     public String save()
    {
        return score + " " + diff + " " + name;
    }
}
