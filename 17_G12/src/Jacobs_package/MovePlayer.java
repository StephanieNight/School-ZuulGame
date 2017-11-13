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


//currently a buggy mess, a work in progress, and how to function is undecided.
public class MovePlayer {
    
    public Labyrinth.DIR facing = Labyrinth.DIR.S;
    
    public boolean forward1(){
        System.out.println("WIP");
        return false;
    }

    public boolean backward1(){
        System.out.println("WIP");
        return false;
    }
    
    public boolean left(){
        this.facing = this.facing.left;
        return false;
    }
	
    public boolean right(){
        this.facing = this.facing.left;
        return false;
    }
    
    
    public Labyrinth.DIR getFacing(){
        return this.facing;
    }
}
