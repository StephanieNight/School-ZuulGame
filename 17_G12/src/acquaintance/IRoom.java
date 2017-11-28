/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import core_engine.Actor;
import core_engine.Door;
import core_engine.Items.Inventory;
import core_engine.Items.Item;
import core_engine.Player;
/**
 *
 * @author Stephanie
 */
public interface IRoom {
    public void setIsExit(boolean isExit);
    public boolean isExit() ;
    public void setPictureID_3D(int pictureID_3D);
    public void setPictureID_MiniMap(int pictureID_MiniMap) ;
    public int getPictureID_3D();
    public int getPictureID_MiniMap() ;
    public boolean isPlayerVissited() ;
    public void setExit(String direction, IRoom neighbor) ;
    public String getShortDescription();
    public String getLongDescription();
    public IRoom getExit(String direction) ;
    public void setPlayer(Actor actor);
    public void setMonster(Actor actor); 
    public Actor getPlayer(); 
    public Actor getMonster();
    public boolean isConflict();
    public boolean hasExit(String direction);
    public boolean hasAnyExits();
    public char getMonsterMapCode();
    public String[] getExits(); 
    public void changeDescription(String desc);
    public boolean hasItems();    
    public Item[] itemList();
    public Item pickupItem(int id, Inventory inventory)  ;
    public void dropItem(Item item);
    public void setDoor(String direction) ;
    public boolean hasDoor(String direction);
    public Door getDoor(String direction);
    public void setPlayerVisisted();
    public void useItem(int id, Player p);
    public Actor getGhoust();
    public void setGhoust(Actor gaust);
    public boolean isOccupied();
              
}
