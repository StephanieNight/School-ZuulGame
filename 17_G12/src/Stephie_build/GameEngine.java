/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import gameframework.Command;
import gameframework.CommandWord;
import gameframework.Game;
import gameframework.Parser;
import nicolai.Actor;
import nicolai.Monster;
import nicolai.Player;
import nicolai.Zuul;

/**
 *
 * @author Stephanie
 */
public class GameEngine extends Game{
    private static int difficulty;  
    private Parser parser;
    // ---------------------
    // Primary instances
    private Player player;
    private Zuul zuul;
    private Monster[] minions;
    // ---------------------
    private Labyrinth labyrinth;
    private int mazeSize ;
    private int maxNumberOfMinions;
    public GameEngine()
    {       
        this.parser = new Parser();
        int i = -1;
        while(i == -1)
        {
          i = parser.getDifficulty();
        }
        this.difficulty = i;        
        this.mazeSize = (int)((1.5*difficulty)+3);
        this.maxNumberOfMinions= (int)Math.pow(this.mazeSize,1.5)/2;
        this.minions = new Monster[maxNumberOfMinions];
        this.labyrinth= new Labyrinth(mazeSize);   
        spawnMobs();
        this.labyrinth.display();
    }
    @Override
    public void play()
    {    
        printWelcome();
        boolean finished = false;
        while (! finished) {
            //player
            Command command = parser.getCommand();
            finished = processCommand(command);
            // check for confligs.
            // Minions 
            // Zuul
            // check for congfligs 
            labyrinth.display();
        }
        System.out.println("Thank you for playing.  Good bye.");
    }
    private void printWelcome()
    {   System.out.println("+----------------------------------------------+");
        System.out.println("| You are lost. You are alone. You wander.     |");
        System.out.println("| in a endless maze. you hear a GROWL near you.|");
        System.out.println("|                                              |");
        System.out.println("| what do you do ?                             |");
        System.out.println("+----------------------------------------------+");
        
    }
    
    public boolean spawnMobs() 
    { 
        
        player= new Player("Player", 100, 100, 100);
        zuul = new Zuul();
        labyrinth.spawnPlayer(0,0, player);
        labyrinth.spawnMonster(this.mazeSize-1, this.mazeSize-1,zuul);
        for (int i = 0; i < this.maxNumberOfMinions ; i++) 
        {
            boolean added = false;
            while (!added)
            {
                int x = (int)(1+ Math.random()*(this.mazeSize-1)); 
                int y = (int)(1+ Math.random()*(this.mazeSize-1));
                Monster min = new Monster(("mionion"+i));
                added = labyrinth.spawnMonster(x, y,min);
                if(added)
                {
                    minions[i]=min;
                }
            }            
        }
        return true;
    }    
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (null != commandWord) switch (commandWord) {
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command, player);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
            default:
                break;
        }
        return wantToQuit;
    }
    private void printHelp() 
    {
        System.out.println("you have the following uptions :");
        parser.showCommands();
    }    
    private void goRoom(Command command, Actor actor) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = actor.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            labyrinth.movePlayer(actor, nextRoom);
            actor.setCurrentRoom(nextRoom);
            System.out.println(actor.getCurrentRoom().getLongDescription());
        }
    }
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
    public static int getDifficulty()
    {
        return difficulty;
    }
    public static int getMaxNumberOfMinions()
    {
        return difficulty;
    }  
}
