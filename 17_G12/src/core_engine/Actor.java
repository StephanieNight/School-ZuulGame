
package core_engine;

import java.io.Serializable;

/**
 * the main Class for all actors in the game. 
 * this defines all commoncode that is not specific from monster and players 
 * and bosses, thir constans and so on. 
 * the class is abstract so that it only can be used to build spe
 * @author nicol
 */
public abstract class Actor implements Serializable
{
    private Message message;
    private final int DEFAULT_HEALTH_POINTS; 
    private final int DEFAULT_DEFENSE;
    private final String NAME;
    private final int DEFAULT_DAMGE_OUTPUT;
    private final char MAP_CODE;
    private Room currentRoom;
    private int maximumHealthPoint;
    private int currentHealth;
    private int level;
    private int diff;
    private int xp;
    private int weapon = 0;
    private int armor = 0;
    private int shield = 0;
    private Labyrinth.Direction facing;
    private int swiftnessCounter = 1;
    private int invisible = 0;
    /**
     * the default construktor for all actors this sets up all default values 
     * what direction it is looking, South is locked at this moment.
     * @param name Name of the actor
     * @param defaultHealthpoint default or start healtpoints
     * @param defaultDefense default or start defencepoints
     * @param DefaultDamgeOutput default or start damage the actor does to others
     * @param mapCode the charakter value the actor is represented with on a map.
     * @param level start level modifier
     */
    public Actor(String name,int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput, char mapCode, int level, int diff, Message message){
        this.NAME = name;
        this.DEFAULT_HEALTH_POINTS = defaultHealthpoint;
        this.DEFAULT_DEFENSE = defaultDefense;
        this.DEFAULT_DAMGE_OUTPUT = defaultDefense;
        this.MAP_CODE = mapCode;
        this.currentHealth = getModufiedHealthPoint();
        this.message = message;
        this.facing = Labyrinth.Direction.S;        
        this.level = level;
    }
    /**
     * 
     * @return the messege oblekt.
     */
    public Message getMessage() {
        return message;
    }
    /**
     * in this metode you can set the level 
     * @param level new level.
     */
    public void setLevel(int level) {
        this.level = level;
    }
    /**
     *  in this metode you can set the Xp
     * @param xp new xp that the actor should have
     */
    public void setXp(int xp) {
        this.xp = xp;
    }
    /**
     * set the current room of the actor this allow for quick refrance of where
     * the actor is at all time and what goes on in that room.
     * @param currentRoom the room the actor is standing in.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    /**
     * overides the current health of the actor as long as it is not larger then
     * the maxium health, if it is then set health to max.
     * @param currentHealth new health value
     */
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
        if (this.currentHealth > maximumHealthPoint){
            this.currentHealth = maximumHealthPoint;
        }
    }
    /**
     * in this metode you get the modified heathPoint back the modified 
     * HeahtPoint is the DefaultHealthPoint + (the level * 10) therefore the 
     * higher the level the higher the healthpoint is there value 10 can be
     * modified this is just an eksample
     * @return new health point.
     */
    public int getModufiedHealthPoint() {
        return maximumHealthPoint = DEFAULT_HEALTH_POINTS+(level*10);
    }
    /**
     * in this metode you get the modified defense back the modified defense
     * is the defaltdefense + (the level * 5) therefore the higher the level
     * the higher the defense is there value 5 can be modified this is just
     * an eksample
     * @return modified defence
     */
    public int getModifiedDefense(){
        return DEFAULT_DEFENSE+(level*5) + shield + armor;
    }  
    /**
     * gets the name of the actor.
     * @return name of actor 
     */
    public String getName() {
        return NAME;
    }
    /**
     * in this metode you get the modified damgeOutout back the modified 
     * damgeOut is the defaltDamgeOutput + (the level * 5) therefore the higher 
     * the level the higher the damg is there value 5 can be modified this is 
     * just an eksample
     * @return 
     */
    public int getModifiedDamgeOutput() {
        return DEFAULT_DAMGE_OUTPUT+(level*5) + weapon;
    }
    /**
     * get the level as  funtion of xp
     * @return return the level
     */
    public int getLevel() {
        return level = 1+(xp/2);
    }  
    /**
     * get the actors current xp
     * @return actors xp
     */
    public int getXp() {
        return xp;
    }
    /**
     * gets the actors mapcode
     * @return map code.
     */
    public char getMapCode() {
        return MAP_CODE;
    }
    /**
     * gets the actor current room 
     * @return the actor current room
     */    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    /**
     * gets actors current health
     * @return the actor curent health
     */
    public int getCurrentHealth() {
        return currentHealth;
    }
    /** 
     * updates the actors level
     * for each level up the actor will reseave a health bost calculated from 
     * the level and default health.
     */
    public void updateLevel(){
        maximumHealthPoint = getModufiedHealthPoint();
    }
    /**
     * 
     * @param weapon 
     */
   
    public void setWeapon(int weapon){
        this.weapon = weapon;
    }
    public void setArmor(int armor){
        this.armor = armor;
    }
    public void setShield(int shield){
        this.shield = shield;
    }
    /**
     * gets the direction Enum the actor is looking ing
     * @return a Enum representation of North south east and west.
     */
    public Labyrinth.Direction getFacing(){
        return this.facing;
    }
    /**
     * set the actors direction. represented in north south east and west.
     * @param facing the new direction for the actor
     */
    public void setFacing(Labyrinth.Direction facing){
        this.facing = facing;
    }    
    /**
     * return true if the actor can skip a turn based on the walue of shiftness 
     * counteren, this will slowly decreass per chec
     * @return boolean false or true depending on the swiftness counter 
     * if it is a odd numnber it will return true
     */
    public boolean isSwiftness() {
        int check = swiftnessCounter;
        
        if(check %2 == 1)
        {
            if(swiftnessCounter > 1)
            {
                swiftnessCounter--;
            }
            return false;
        }
        else
        {
            swiftnessCounter--;
            return true;
        }
    } 
    /**
     * sets the swiftness counter to a new value
     * @param counter new counter value.
     */
    public void setSwiftnessCounter(int counter) {
        swiftnessCounter += counter;
    }
    /**
     * checks if invisible counter is greater then 0
     * @return return true if invisibility is not 0
     */
    public boolean isInvis() {
        if(invisible > 0)
        {
            invisible--;
            return true;
        }
        return false;
    }
    /**
     * sets ivisibility coutnter to a new value 
     * @param counter new invisability counter. 
     */
    public void setInvis(int counter) {
        this.invisible += counter;
    }
}

