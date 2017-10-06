
package gameframework;

/**
 *
 * @author nicol
 */
public class Actor 
{
 private int healthPoint;
 private int defense;
 private String name;
 private int defaultDamgeOutput;
 private int modifiedDamgeOutput;
 private int level;
 private int xp;
 private int totalXp;
 Actor(){
     
 }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefaultDamgeOutput(int defaultDamgeOutput) {
        this.defaultDamgeOutput = defaultDamgeOutput;
    }

    public void setModifiedDamgeOutput(int modifiedDamgeOutput) {
        this.modifiedDamgeOutput = modifiedDamgeOutput;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setTotalXp(int totalXp) {
        this.totalXp = totalXp;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public int getDefense() {
        return defense;
    }

    public String getName() {
        return name;
    }

    public int getDefaultDamgeOutput() {
        return defaultDamgeOutput;
    }

    public int getModifiedDamgeOutput() {
        return modifiedDamgeOutput;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getTotalXp() {
        return totalXp;
    }
 
}

