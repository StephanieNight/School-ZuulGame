package Stephie_build;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import maltestestpackage.Item;
import nicolai.Actor;
import nicolai.Player;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Actor player; // Copy
    private Actor monster; // Copy
    private ArrayList<Item> Items = new ArrayList<>(); 

    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    public Room(String description, Item[] items) 
    {
        this(description);
        exits = new HashMap<String, Room>();
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
    //ADDED by Steph
    public void setPlayer(Actor actor)
    {
        player = actor;         
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
    public char getMapCode() {
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
    Crap solution but needed for AI
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
}
            