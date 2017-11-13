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

import Stephie_build.Labyrinth;
import Stephie_build.GameEngine;
import gameframework.Command;
import gameframework.CommandWord;

//currently a buggy mess, a work in progress, and how to function is undecided.
public class MovePlayer {
    
    private View view;
    public Labyrinth.DIR facing = Labyrinth.DIR.S;
    private GameEngine engine;
    
    public boolean forward(){
        Command command = new Command(CommandWord.GO, facing.direction);
        //boolean moved = engine.goRoom(command);//goRoom() is private
        view.View(facing);
        return false;//return moved;
    }

    public boolean backward(){
        Command command = new Command(CommandWord.GO, facing.opposite.direction);
        //boolean moved = engine.goRoom(command);
        view.View(facing);
        return false;//return moved;
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
