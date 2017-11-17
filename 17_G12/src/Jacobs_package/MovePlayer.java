/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Jacobs_package;

/**
 *
 * @author simon
 */

import core_engine.Labyrinth;
import core_engine.GameEngine;
import core_engine.Command;
import core_engine.CommandWord;

//currently a buggy mess, a work in progress, and how to function is undecided.
public class MovePlayer {
    
    private View view;
    
    private GameEngine engine;
    
    public boolean forward(){
        Command command = new Command(CommandWord.GO, facing.direction);
        //boolean moved = engine.goRoom(command);//goRoom() is private
        view.View(facing);
        return false;//return moved;
    }

    public boolean backward(){
        this.facing = this.facing.opposite;
        view.View(facing);
        return false;
    }
    
    public boolean left(){
        this.facing = this.facing.left;
        view.View(facing);
        return false;
    }
	
    public boolean right(){
        this.facing = this.facing.left;
        view.View(facing);
        return false;
    }
    
    
    public Labyrinth.DIR getFacing(){
        return this.facing;
    }
}
