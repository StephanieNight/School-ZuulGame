/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy_framework;

import core_engine.Labyrinth;
import core_engine.Room;
import core_engine.Player;


/**
 *
 * @author simon
 */
public class View {
    
    private Player player;

    public void View(Labyrinth.Direction facing){
        int ID = 0;
        /* ID is effectively used as the first 6 digits in binary.
        1 means door exists, each 0 means it doesn't.
        111111 - each digit respectively represents a door as following:
        (next room middle door), (next room right door), (next room left door),
        (current room middle door), (current room right door), (current room left door).
        */
        Room currentRoom = player.getCurrentRoom();
        
        if(currentRoom.getExit(facing.left.direction) != null){
            ID += 0b000001;
        }
        if(currentRoom.getExit(facing.right.direction) != null){
            ID += 0b000010;
        }
        
        Room nextRoom = currentRoom.getExit(facing.direction);
        
        if(nextRoom != null){
            ID += 0b000100;
            
            if(nextRoom.getExit(facing.left.direction) != null){
                ID += 0b001000;
            }
            if(nextRoom.getExit(facing.right.direction) != null){
                ID += 0b010000;
            }
            if(nextRoom.getExit(facing.direction) != null){
                ID += 0b100000;
            }
        }
        //if((ID >> depth) % 2 == 1){} //used to read the bits. depth determines which bit from the right to read.
    }
}
