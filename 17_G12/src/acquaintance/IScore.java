/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import javafx.beans.property.StringProperty;
import maltestestpackage.Score;

/**
 *
 * @author Malte
 */
public interface IScore {
    public abstract String toString();
    public abstract int getScore();
    public abstract void setScore(int score);
    public abstract String getName();
    public abstract String getDifficulty();
    public abstract String getScoreString();
}
