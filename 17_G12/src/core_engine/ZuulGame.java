/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import Ahmets_package.Fight;
import acquaintance.IGameEngine;
import acquaintance.IInventory;
import core_engine.Items.Key;
import core_engine.Items.PlateArmor;
import core_engine.Items.Sword;
import data.SaveGameInstance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javafx.scene.image.Image;

/**
 *
 * @author Stephanie
 */
public class ZuulGame implements IGameConstants {
    private int difficulty;  
    //private Parser parser;
    //-----------------------------------------------------------
    // Primary instances
    private Player player;
    private ArrayList<Monster> monsters;
    private GhostWanderer ghost;
    //-----------------------------------------------------------
    private Labyrinth labyrinth;
    private int mazeSize ;
    private int maxNumberOfMinions;
    private boolean finished;
    private ItemGenerator itemGenerator;
    private Fight fight;
    private Message message;
    
    /** the constructer for the game engine to world of zuul this 
     * means it set the world size acording to dificulty 
     * mixes in apropreate numper of monsters and generates the 
     * lapyrinth.
     */
    public ZuulGame() {
        this.message = new Message();
        this.fight = new Fight(message);
        //this.parser = new Parser();
//        int i = -1;
//        while(i == -1)
//        {
//          i = parser.getDifficulty();
//        }
//        difficulty = 3;        
//        mazeSize = (int)((1.5*difficulty)+3);
//        maxNumberOfMinions= (int)Math.pow(this.mazeSize,1.5)/2;
//        monsters =new ArrayList<>();
//        labyrinth= new Labyrinth(mazeSize);   
//        spawnMobs();
//        finished = false;
//        System.out.println("Size                : "+this.mazeSize);
//        System.out.println("number of minions   : "+ this.maxNumberOfMinions);
//        System.out.println("Diffictulty is      : "+ this.difficulty);
    }
    //-----------------------------------------------------------
    //--------------------------General--------------------------
    //-----------------------------------------------------------  
    /**
     * 
     */
    public void play() {          
        printWelcome();
        while (!finished) {            
            labyrinth.display();
            processPlayer();
            processMonsters();           
        }
        System.out.println("Thank you for playing. Good bye.");
    }    
    /**
        Saves the game to local disc.
    */   
    public boolean saveGame() {
        SaveGameInstance sa = new SaveGameInstance(labyrinth.getMaze(),player,monsters,difficulty);
        try
        {
           SaveGameInstance.serializeToFile(sa);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
            return false;
        }       
        return true;
    }
    /**
    Loads game from disc
    */
    public boolean loadGame() { 
        SaveGameInstance sa;
        try
        {
            sa =SaveGameInstance.deserializeFromFile();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            return false;
        }
        labyrinth.setMaze(sa.getMaze());
        monsters = sa.getMonsters();
        player = sa.getPlayer();
        difficulty = sa.getDifficulty();
        System.out.println("Loaded old Game"); 
        return true;
    }
    /**
     * handle the players input and turn.
     */
    private void processPlayer() {
//        Command command = parser.getCommand();
//        if (!processCommand(command))
//            processPlayer();
    }  
    /**
     * a version of the old go room from the legacy zuul game 
     * modified to handle the AI/NPC movement around the map.
     * @param command command, with what direction the NPC should move.
     * @param actor the NPC that should move.
     */
    private void goRoom(Command command, Actor actor) {
        if(!command.hasSecondWord()) {
            System.out.println("Problem with monster "+actor.getName());
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = actor.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            labyrinth.moveMonster(actor, nextRoom);
        }
    }
    /**
    * the legacy go room from the zuul framework, modified to have a Boolean return
    * this is so that it the player tryes to go somewhere that it cant, you dont 
    * miss a turn.
    * @param command
    * @return Boolean was move successefull.
    */
    private boolean goRoom(Command command) {
        Labyrinth.DIR dir =  Labyrinth.DIR.getDir(command.getSecondWord());
        Room nextRoom = player.getCurrentRoom().getExit(dir.direction);
        
        if (nextRoom == null) {
            System.out.println("There is no door!");
            return false;
        }
        else if(nextRoom.hasDoor(dir.opposite.direction))
        {
                Door d = nextRoom.getDoor(dir.opposite.direction);
            if(d.isLocked())
            {
                System.out.println("Door in directin "+ dir.direction+ " is Locked ");
                // TODO Add key 
            }            
            else
            {
                labyrinth.movePlayer(player, nextRoom);
                return true;
            }            
        }
        else
        {
            labyrinth.movePlayer(player, nextRoom);
            return true;
        }            
        return false;
    }
    /**
     * chacks if the quit command is valid
     * @param command the command to be checked
     * @return Boolean if the command is valied
     */
    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
    /**
     * gets the Difficulty.
     * @return the difficulty.
     */
    public int getDifficulty() {
        return difficulty;
    }    
    public int getPlayerCurrentHealth() {
        return player.getCurrentHealth();
    }
    /**
     * prints the welcome screen to system out.
     */
    private void printWelcome() {   System.out.println("+----------------------------------------------+");
        System.out.println("| You are lost. You are alone. You wander.     |");
        System.out.println("| in a endless maze. you hear a GROWL near you.|");
        System.out.println("|                                              |");
        System.out.println("| what do you do ?                             |");
        System.out.println("+----------------------------------------------+");        
    }    
    /**
     * handles the spawning of of the player, minions and Zuul.
     */
    private void spawnMobs(String playerName) {         
        player = new Player(playerName, 100, 20, 30, 1, 1);    
        labyrinth.spawnPlayer(0,0, player);
        
        ghost = new GhostWanderer("bob");
        labyrinth.spawnMonster(1,1,ghost); 
        
        Monster zuul = new Monster("Zuul", 140 + ((int)(Math.pow(this.difficulty, 2))*10), 15, 25, 'Z',this.difficulty, true, this.difficulty);
        labyrinth.spawnMonster(this.mazeSize-1, this.mazeSize-1,zuul);
        monsters.add(zuul);
        for (int i = 0; i < this.maxNumberOfMinions ; i++) 
        {
            boolean added = false;
            while (!added)
            {
                int x = (int)(1+ Math.random()*(this.mazeSize-1)); 
                int y = (int)(1+ Math.random()*(this.mazeSize-1));
                Monster min = new Monster(("minion"+i), 30, 0, 10, 'M',this.difficulty, false, this.difficulty);
                added = labyrinth.spawnMonster(x, y,min);
                if(added)
                {
                    monsters.add(min);
                }
            }            
        }
        
        if(difficulty == 1)
        {
            player.addItem(itemGenerator.generateItem(1));
            player.addItem(itemGenerator.generateItem(2));
        }
    }    
    /**
     * process the command given, from the player 
     * used to se if the player whants help - to move 
     * or to quit.
     * @param command the command created by the player 
     * @return was the action succesfull.
     */
    private boolean processCommand(Command command) {
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
    /**
     * 
     */
    private void printHelp() {
        System.out.println("you have the following uptions :");
//        parser.showCommands();
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
     
        
    } 
    private void moveMonster(Monster m) {
        String[] exits = m.getCurrentRoom().getExits();
        Collections.shuffle(Arrays.asList(exits));
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
    private void deleteMonster(Actor m) {
        m.getCurrentRoom().setMonster(null);
        monsters.remove(m);
    }
    public boolean saveHighScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean loadHighScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean setName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
    public Image renderMazeView() {
       return RenderEngine.renderMazeView(player);
    }
    public Image renderMiniMapView() {           
       return RenderEngine.renderMiniMapView(labyrinth.getMaze());
    }
    public Image renderBattleView() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean move() {
        Command command=new Command(CommandWord.GO, player.getFacing().direction);
        
        boolean moved = goRoom(command);
        
        if(moved)
        {
            if(!player.isSwiftness())
            {
                processMonsters();
                player.useLampOil();

            }        
            if(player.isInvis())
            {
            return false;
            }
        }
        System.out.println(player.getLampOil());
        return checkForCombat();
    }    
    public boolean turnRight() {
        player.setFacing(player.getFacing().right);
        return false;
    }    
    public boolean turnLeft() {
        player.setFacing(player.getFacing().left);
        return false;
    }    
    public boolean turnBack() {
        player.setFacing(player.getFacing().opposite);
        return false;
    }    
    public String[] getInventory() {
        return player.getInventory().getInventoryList();
    }
    public boolean attack() {
        Actor m = player.getCurrentRoom().getMonster();
        if(fight.attack(player, m))
        {
            if(m.getMapCode() == 'Z')
            {
                player.getCurrentRoom().dropItem(new Key());
            }
            deleteMonster(m);
            player.getCurrentRoom().dropItem(itemGenerator.generateRandomItem());
           return true; 
        }
        else if(fight.attack(m, player))
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    public boolean flee() {
        return true;
    }   
    public boolean checkForCombat() {
        return player.getCurrentRoom().getMonster() != null;
    }
    public boolean startNewGame(int difficulty, String name) {
        this.difficulty = difficulty;        
        this.mazeSize = (int)((1.5*difficulty)+3);
        this.maxNumberOfMinions= (int)Math.pow(this.mazeSize,1.5)/2;
        this.monsters =new ArrayList<>();
        this.labyrinth= new Labyrinth(mazeSize);   
        this.itemGenerator = new ItemGenerator(labyrinth);
        
        spawnMobs(name);
        finished = false;
        System.out.println("Size                : "+this.mazeSize);
        System.out.println("number of minions   : "+ this.maxNumberOfMinions);
        System.out.println("Diffictulty is      : "+ this.difficulty);
        
        
        int randomX = (int)(Math.random() * labyrinth.getMaze().length);
        int randomY = (int)(Math.random() * labyrinth.getMaze().length);
        labyrinth.getMaze()[randomX][randomY].dropItem(new PlateArmor());
            
        randomX = (int)(Math.random() * labyrinth.getMaze().length);
        randomY = (int)(Math.random() * labyrinth.getMaze().length);
        labyrinth.getMaze()[randomX][randomY].dropItem(new Sword());
            
        randomX = (int)(Math.random() * labyrinth.getMaze().length);
        randomY = (int)(Math.random() * labyrinth.getMaze().length);
        labyrinth.getMaze()[randomX][randomY].dropItem(new PlateArmor());
        
        return true;
    }    
    public boolean checkWinCondition() {
        return player.getCurrentRoom().isExit();
    }    
    public void useItem(int itemID) {
        player.getInventory().useItem(itemID);
    }    
    public void dropItem(int itemID){
        player.getInventory().dropItem(itemID);
    }    
    public String itemDescription(int itemID){
        return player.getInventory().getItemDescription(itemID);
    }
    public boolean checkForGameOver() {
        return (player.getCurrentHealth() < 1 || player.getLampOil() < 1);
    }
    public String[] getLoot()
    {
        String[] lootArray = new String[player.getCurrentRoom().itemList().length];
        for (int i = 0; i < lootArray.length; i++) {
            lootArray[i] = player.getCurrentRoom().itemList()[i].getName();
            }
        return lootArray;
    }
    public void useLootItem(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 1)
                   player.getCurrentRoom().useItem(itemNumber,player);
    }
    public void pickUpItem(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 1)
        player.getCurrentRoom().useItem(itemNumber, player);
    }
    public String getLootItemDescription(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 1)
            return player.getCurrentRoom().itemList()[itemNumber].getDescription();
        return "";
    }
}
    

