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
    
    //facing 0=north, 1=east, 2=south, 3=west
    
    public Labyrinth.DIR facing = Labyrinth.DIR.S;
    
    
    /*
    public boolean forward(){
            (CommandWord.GO, facing);
        
        if (this.facing == 1){
            command = new Command(CommandWord.GO, e);
        }
        if (this.facing == 2){
            command = new Command(CommandWord.GO, s);
        }
        if (this.facing ==3 ){
            command = new Command(CommandWord.GO, w);
        }
        System.out.println("You hit a wall.");
        return false;
    }

    public boolean backward(){
        if (this.facing == 0){
            command = new Command(CommandWord.GO, s);
        }
        if (this.facing == 1){
            command = new Command(CommandWord.GO, w);
        }
        if (this.facing == 2){
            command = new Command(CommandWord.GO, n);
        }
        if (this.facing == 3){
            command = new Command(CommandWord.GO, e);
        }
        System.out.println("You hit a wall.");
        return false;
    }

    public boolean left(){
        if (this.facing == 0){
                this.facing = 3;
        }
        else{
                this.facing--;
        }
        return false;
    }
	
    public boolean right(){
        if (this.facing == 3){
                this.facing = 0;
        }
        else{
                this.facing++;
        }
        return false;
    }
    
    
    
    //suggest changing CommandWord.GO to parse 0,1,2,3 instead of n,e,s,w
    public boolean forward1(){
        command = Command(CommandWord.GO, String.valueOf(facing))
        return goRoom();
    }

    public boolean backward1(){
        return goRoom(Command(CommandWord.GO, String.valueOf(facing)));
    }
    
    */
    public Labyrinth.DIR getFacing(){
        return this.facing;
    }
}
