package core_engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashMap;
import core_engine.Items.Inventory;
import core_engine.Items.Item;

/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private HashMap<String, Door> doors;
    private Actor player; // Copy
    private Actor monster; // Copy
    private Actor ghoust; // Copy
    private ArrayList<Item> lootList;
    private int pictureID_3D;
    private int pictureID_MiniMap;
    private boolean playerVissited;
    private boolean isExit;

    public void setIsExit(boolean isExit) {
        this.isExit = isExit;
    }

    public boolean isExit() {
        return isExit;
    }
    
    public void setPictureID_3D(int pictureID_3D) {
        this.pictureID_3D = pictureID_3D;
    }
    public void setPictureID_MiniMap(int pictureID_MiniMap) {
        this.pictureID_MiniMap = pictureID_MiniMap;
    }
    public int getPictureID_3D() {
        return pictureID_3D;
    }
    public int getPictureID_MiniMap() {
        return pictureID_MiniMap;
    }
    public boolean isPlayerVissited() {
        return playerVissited;
    }

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        doors = new HashMap<String, Door>();
        lootList = new ArrayList<>();
        this.pictureID_3D=0;
        this.pictureID_MiniMap =0;
        this.playerVissited = false;
    }
    public Room(String description, Item[] items) 
    {
        this(description);
        Collections.addAll(lootList, items);
    }
    public Room(String description, Item item)
    {
        this(description);
        lootList.add(item);
    }
    
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }
    /**
     * 
     * Gets the description of the Room
     * @return Description
     */
    public String getShortDescription()
    {
        return description;
    }
    /**
     * Gets a formated string with the description of the room and it's exists
     * @return Long Decription of the room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }
    /**
     * a string with all the exits of the room
     * @return Exists  
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    /**
     * 
     * @param direction you want to go in, North, South, West and east
     * @return Room at the Exit
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    public void setPlayer(Actor actor)
    {
        player = actor;  
        playerVissited = true;
    }
    public void setMonster(Actor actor)
    {
        monster = actor;         
    }
    public Actor getPlayer()
    {
        return player;
    }
    public Actor getMonster()
    {
        
        return monster;
    }
    public boolean isConflict()
    {
        return(player !=null && monster != null);
    }
    public boolean hasExit(String direction)
    {
        return exits.containsKey(direction);
    }
    public boolean hasAnyExits()
    {
        return !exits.isEmpty();
    }
    public char getMonsterMapCode() {
        if(isConflict())
        {
            return 'C';
        }
       else if (this.player !=null)
            return player.getMapCode();
       else if(this.monster != null)
           return monster.getMapCode();
       else 
        return ' ';
    }
    /* 
    *
    */
    public String[] getExits()
    {
        Set<String> keys = exits.keySet();
        int i =0;
        String[] e = new String[keys.size()];
        for(String s : keys)
        {
            e[i] = s;
            i++;
        }
        return e;    
    }
    public void changeDescription(String desc)
    {
        this.description = desc;
    }
    
    public boolean hasItems(){
        return (lootList.size() > 0);
    }    
    public Item[] itemList() {
        Item itemList[] = new Item[lootList.size()];
        return lootList.toArray(itemList);
    }    
    public Item pickupItem(int id, Inventory inventory) {
        Item returnItem = lootList.get(id);
        if(inventory.addItem(returnItem)){
            lootList.remove(id);
        }
        return returnItem;
    }    
    public void dropItem(Item item) {
        lootList.add(item);
    }
    public void setDoor(String direction) 
    {
        doors.put(direction,new Door(true));
    }
    public boolean hasDoor(String direction)
    {        
        return doors.containsKey(direction);
    }
    public Door getDoor(String direction)
    {
        if(hasDoor(direction))
        {
            return doors.get(direction);
            
        }
        return null;        
    }    
    public void setPlayerVisisted()
    {
        playerVissited = true;
    }
    public void useItem(int id, Player p)
    {
        if(itemList()[id].useItem(p))
        {
            lootList.remove(id);
        }
    }

    public Actor getGhoust() {
        return ghoust;
    }
    public void setGhoust(Actor gaust) {
        this.ghoust = gaust;
    }
    public boolean isOccupied()
    {
        boolean o = (ghoust !=null || monster != null);                
        return o;
    }
}
            