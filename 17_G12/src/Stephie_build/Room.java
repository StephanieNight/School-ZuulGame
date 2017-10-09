package Stephie_build;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import maltestestpackage.Item;
import nicolai.Actor;


/**
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private Actor occupamnt; //ADDED by Steph
    private ArrayList<Item> Items = new ArrayList<>();           
    public Room(String description) 
    {
        this.description = description;
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
    public void setOccupant(Actor a)
    {
        occupamnt = a;
    }
    public Actor getOccupant()
    {
        return occupamnt;
    }
    public boolean hasExit(String direction)
    {
        return exits.containsKey(direction);
    }
    public boolean hasAnyExits()
    {
        return !exits.isEmpty();
    }
}
            

