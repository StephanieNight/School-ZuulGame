/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import Jacobs_package.Sword;
import Stephie_build.Labyrinth;
import Stephie_build.Labyrinth;
import Stephie_build.Room;
import Stephie_build.Room;
import Stephie_build.SaveGameInstance;
import gameframework.Command;
import gameframework.CommandWord;
import gameframework.Game;
import gameframework.Parser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import maltestestpackage.Item;
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
    private final Parser parser;
    //-----------------------------------------------------------
    // Primary instances
    private static Player player;
    private static ArrayList<Monster> monsters;
    //-----------------------------------------------------------
    private static Labyrinth labyrinth;
    private final int mazeSize ;
    private final int maxNumberOfMinions;
    private boolean finished;
    public GameEngine()
    {
        this.parser = new Parser();
        int i = -1;
        while(i == -1)
        {
          i = parser.getDifficulty();
        }
        difficulty = i;        
        mazeSize = (int)((1.5*difficulty)+3);
        maxNumberOfMinions= (int)Math.pow(this.mazeSize,1.5)/2;
        monsters =new ArrayList<>();
        labyrinth= new Labyrinth(mazeSize);   
        spawnMobs();
        finished = false;
        labyrinth.display();
        System.out.println("Size                : "+this.mazeSize);
        System.out.println("number of minions   : "+ GameEngine.getMaxNumberOfMinions());
        System.out.println("Deffictulty is      : "+ GameEngine.getDifficulty());
    }
    //-----------------------------------------------------------
    //--------------------------General--------------------------
    //-----------------------------------------------------------    
    @Override
    public void play()
    {
        saveGame();
        //loadGame();      
        
        printWelcome();
        while (!finished) {
            //player
            processPlayer();
            processMonsters();
            labyrinth.display();
        }
        System.out.println("Thank you for playing. Good bye.");
    }    
    private static void saveGame()
    {
        SaveGameInstance sa = new SaveGameInstance(labyrinth.getMaze(),player,monsters,difficulty);
        try
        {
           SaveGameInstance.serializeToFile(sa);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    private static void loadGame()
    { 
        SaveGameInstance sa = new SaveGameInstance();
        try
        {
            sa =SaveGameInstance.deserializeFromFile();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        labyrinth.setMaze(sa.getMaze());
        monsters = sa.getMonsters();
        player = sa.getPlayer();
        difficulty = sa.getDifficulty();
        
    }
    private void processPlayer() {
        Command command = parser.getCommand();
        if (!processCommand(command))
            processPlayer();
    }    
    private void goRoom(Command command, Actor actor) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Problem with monster "+actor.getName());
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = actor.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
        }
        else {
            labyrinth.moveMonster(actor, nextRoom);
        }
    }
    private boolean goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return false;
        }
        String direction = command.getSecondWord();
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
            return false;
        }
        else {
            labyrinth.movePlayer(player, nextRoom);
            System.out.println(player.getCurrentRoom().getLongDescription());
        }
        return true;
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
    private void sleep()
    {
        try
        {
        Thread.sleep(1000);
        }
        catch(Exception e)
        {
        }
    }
    private boolean Conflict(Actor monster)
    {
        boolean isOver = false;
        boolean didWin = false;
        Command command;
        int mhp = monster.getCurrentHealth();
        System.out.println("you have incountered : "+ monster.getName());
        System.out.println("BATTLE ! write A to Attack and F for Flee");
        Scanner scn = new Scanner(System.in);
        while(!isOver)
        {                    
            System.out.println("Monsters CurrentHP : "+mhp);
            System.out.println("Your     CurrentHP : "+player.getCurrentHealth());
            System.out.print(">");
            String move = scn.nextLine();
            if (move.equals("A"))
            {
                System.out.println("You choose Attac");
                int dmg =20+(int)(Math.random()*20);
                System.out.println("You did "+ dmg + " dmg");
                mhp = mhp - dmg;
                if(mhp <0)
                {
                    System.out.println(player.getCurrentRoom().getMonster().getName()+" has been slain you win");
                    player.getCurrentRoom().setMonster(null);
                    isOver = true;
                    didWin = true;
                    return didWin;
                }
            }
            else if (move.equals("F"))
            {
                System.out.println("You Chose poorly");
                for(String s : player.getCurrentRoom().getExits())
                {
                    if(player.getCurrentRoom().getExit(s).getMonster() == null)
                    {
                        command = new Command(CommandWord.GO, s);
                        goRoom(command);
                        isOver = true;
                        break;
                    }
                }
                System.out.println("there is nowhere to run");
            }
        }
        return false;
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
        
        labyrinth.spawnPlayer(0,0, player);
        Monster zuul = new Monster("Zuul", 500, 500, 500, 'Z', true);
        labyrinth.spawnMonster(this.mazeSize-1, this.mazeSize-1,zuul);
        monsters.add(zuul);
        for (int i = 0; i < this.maxNumberOfMinions ; i++) 
        {
            boolean added = false;
            while (!added)
            {
                int x = (int)(1+ Math.random()*(this.mazeSize-1)); 
                int y = (int)(1+ Math.random()*(this.mazeSize-1));
                Monster min = new Monster(("minion"+i), 30, 30, 30, 'M', false);
                added = labyrinth.spawnMonster(x, y,min);
                if(added)
                {
                    monsters.add(min);
                }
            }            
        }
        return true;
    }    
    private boolean processCommand(Command command)
    {
        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }
        if (null != commandWord) switch (commandWord) {
            case HELP:
                printHelp();
                return true;
            case GO:
                return goRoom(command);
            case QUIT:
                finished = quit(command);
                return true;
            default:
                break;
        }
        return false;
    }
    private void printHelp() 
    {
        System.out.println("you have the following uptions :");
        parser.showCommands();
    }    
    //-----------------------------------------------------------
    //------------------------AI Handling------------------------
    //-----------------------------------------------------------    
    private void processMonsters() {
        Monster defeatedMinion = null;
        for(Monster m : monsters)
        {
            if (m.getCurrentRoom().isConflict())
            {
                defeatedMinion = m;
                labyrinth.display();
            } else {
                moveMonster(m);
            }
        }
        
        if (defeatedMinion != null)
            deleteMonster(defeatedMinion);
        
    }
    
    private void moveMonster(Monster m) {
        String[] exits= m.getCurrentRoom().getExits();
        for(String s : exits)
        {
            try
            {   
                Room current = m.getCurrentRoom();
                Room ex = current.getExit(s);
                if(ex.getMonster() ==null)
                {
                    //Der laves et nyt object hver gang denne køres
                    Command command = new Command(CommandWord.GO, s);
                    goRoom(command, m);
                    System.out.println("Minion " + m.getName() + " has moved "+ s);
                    break;
                }
            }
            catch (Exception e)
            {
                System.out.println(" Problem occured " + e.getMessage());

            }
        }
    }
    
    private void deleteMonster(Monster m) {
        m.getCurrentRoom().setMonster(null);
        monsters.remove(m);
    }
    
}
