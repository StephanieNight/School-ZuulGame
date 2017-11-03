
package nicolai;

import Stephie_build.Room;


/**
 *
 * @author nicol
 */
public abstract class Actor 
{
    private final int DEFAULT_HEALTH_POINTS; 
    private final int DEFAULT_DEFENSE;
    private final String NAME;
    private final int DEFAULT_DAMGE_OUTPUT;
    private final char MAP_CODE;
    private Room currentRoom;
    private int maximumHealthPoint;
    private int currentHealth;
    private int modifiedDefense;
    private int modifiedDamgeOutput;
    private int level =1;
    private int xp;
    private int totalXp;
    //in this constructor can you set a name, the defaultDefense and
    // the DefaultDamgeOutput 
    public Actor(String name,int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, char mapCode){
        this.NAME = name;
        this.DEFAULT_HEALTH_POINTS = defaultHealthpoint;
        this.DEFAULT_DEFENSE = defaultDefense;
        this.DEFAULT_DAMGE_OUTPUT = defaultDefense;
        this.MAP_CODE=mapCode;
        this.currentHealth = DEFAULT_HEALTH_POINTS;
    }
    //  in this metode you can set the level 
    public void setLevel(int level) {
        this.level = level;
    }
    // in this metode you can set the Xp
    public void setXp(int xp) {
        this.xp = xp;
    }
    // in this metode you can set the totalXp
    public void setTotalXp(int totalXp) {
        this.totalXp = totalXp;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (currentHealth < maximumHealthPoint){
            currentHealth=maximumHealthPoint;
        }
    }
    public int getDefaultHealthPoint() {
        return DEFAULT_HEALTH_POINTS;
    }
    // in this metode you get the modified heathPoint back
    // the modified HeahtPoint is the DefaultHealthPoint + (the level * 10)
    // therefore the higher the level the higher the healthpoint is
    // there value 10 can be modified this is just an eksample
    public int getModufiedHealthPoint() {
        return maximumHealthPoint = DEFAULT_HEALTH_POINTS+(level*10);
    }
    public int getDefaultDefense() {
        return DEFAULT_DEFENSE;
    }
    // in this metode you get the modified defense back
    // the modified defense is the defaltdefense + (the level * 5)
    // therefore the higher the level the higher the defense is
    // there value 5 can be modified this is just an eksample
    public int getModifiedDefense() {
        return modifiedDefense = DEFAULT_DEFENSE+(level*5);
    }    
    public String getName() {
        return NAME;
    }
    public int getDefaultDamgeOutput() {
        return DEFAULT_DAMGE_OUTPUT;
    }
     // in this metode you get the modified damgeOutout back
    // the modified damgeOut is the defaltDamgeOutput + (the level * 5)
    // therefore the higher the level the higher the damg is
    // there value 5 can be modified this is just an eksample
    public int getModifiedDamgeOutput() {
        return modifiedDamgeOutput = DEFAULT_DAMGE_OUTPUT+(level*5);
    }
    public int getLevel() {
        return level = 1+(xp/2);
    }  
    public int getXp() {
        return xp;
    }
    public int getTotalXp() {
        return totalXp =totalXp + xp;
    }
    public char getMapCode() {
        return MAP_CODE;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public int getCurrentHealth() {
        return currentHealth;
    }
    public void updateLevel(){
        getModufiedHealthPoint();
    }
    
}

