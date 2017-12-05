/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;
import acquaintance.IGameConstants;
import acquaintance.ISaveGameHandler;
import acquaintance.IScore;
import acquaintance.IHighScore;
import core_engine.Items.Key;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import java.awt.Graphics2D;
import java.io.File;
import javax.imageio.ImageIO;
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
    //private IActor player;
    private ArrayList<Monster> monsters;
    //private ArrayList<IActor> monsters;
    private GhostWanderer ghost;
    //-----------------------------------------------------------
    private Labyrinth labyrinth;
    private int mazeSize ;
    private int maxNumberOfMinions;
    private boolean finished;
    private ItemGenerator itemGenerator;
    private Fight fight;
    private Message message;
    private ISaveGameHandler savegameHandler;   
    private HighScoreHandler highScoreHandler;
    private ScoreTracker scoreTracker;
    /** the constructer for the game engine to world of zuul this 
     * means it set the world size acording to dificulty 
     * mixes in apropreate numper of monsters and generates the 
     * lapyrinth.
     */
    public ZuulGame(Message msg) {
        this.message = msg;
        this.fight = new Fight(message);
        this.highScoreHandler = new HighScoreHandler();
        this.labyrinth = new Labyrinth(msg);
        this.monsters =new ArrayList<>();
    }
    //-----------------------------------------------------------
    //----------------------- General Play ----------------------
    //-----------------------------------------------------------  
    /**
     *   Saves the game to local disc.
     */   
    public boolean saveGame() {             
        
        try
        {
            SaveGameInstance sa = new SaveGameInstance(labyrinth.getMaze(),player,monsters,difficulty);
            savegameHandler.saveGame(sa);
        }
        catch (IOException ex) {
            return false;
        }        
        return true;
    }
    /**
     * Loads game from local disc
     */
    public boolean loadGame() { 
       
        try
        {
            SaveGameInstance sa = (SaveGameInstance)savegameHandler.loadGame();            
            //startNewGame(sa.getDifficulty(),sa.getPlayer().getName());
            labyrinth.loadMaze((Room[][])sa.getMaze());
            monsters.clear();
            monsters.addAll(sa.getMonsters());
            player = (Player)sa.getPlayer();
            if (isDebug)
                System.out.println("Loaded old Game"); 
            return true;
        }
        catch(IOException | ClassNotFoundException e)
        {            
            System.out.println(e.getMessage());
            return false;
        }  
    }
    /**
     * Checks if there is a monser in the players room, if there is the player 
     * is in combat.
     * @return 
     */
    public boolean checkForCombat() {
        return player.getCurrentRoom().getMonster() != null;
    }
    /**
     * starts a new game, from the deficulty it calculates what size the maze 
     * shall be, the amount of monsters and start level they shal have. 
     * 
     * map size is calculates from the formula : 
     * (1.5*difficulty)+3 then converted to a int since you can't have * 0.67 of a room. 
     * number of minions is calculated from the formula : 
     * Math.pow(mazeSize,1.5)/2 and then also converted to a int because the same reason
     * a half monster dont exist.
     * @param difficulty a int based represention of the deficulty, the higther 
     * the number the bigger the pain.
     * @param name the name of the player. 
     * @return true it successfull in creating a game.
     */
    public boolean startNewGame(int difficulty, String name) {
        this.difficulty = difficulty;        
        this.mazeSize = (int)((1.5*difficulty)+3);
        this.maxNumberOfMinions= (int)Math.pow(this.mazeSize,1.5)/2;    
        this.labyrinth.newMaze(mazeSize);
        this.itemGenerator = new ItemGenerator(labyrinth, message);
        spawnMobs(name);
        this.scoreTracker = new ScoreTracker(player, difficulty);
        this.finished = false;
        if(isDebug)
        {
            System.out.println("Size                : "+this.mazeSize);
            System.out.println("number of minions   : "+ this.maxNumberOfMinions);
            System.out.println("Diffictulty is      : "+ this.difficulty);
        }        
        return true;
    }    
    /**
     * checks if the player has won.
     * @return false based on if the door is locked and true if the player has unlocked
     * the door and is back in the exit room.
     */
    public boolean checkWinCondition() {
        if(labyrinth.getMaze()[0][0].getDoor("south").isLocked())
        {
            return false;
        }
        return player.getCurrentRoom().isExit();
    }    
    /**
     * checks if you ran out of lamp oil or is dead
     * @return returns true based on if p.currrenthealt or p.lampoil is below 1
     */
    public boolean checkForGameOver() {
        return (player.getCurrentHealth() < 1 || player.getLampOil() < 1);
    }   
    /**
     * gets the Difficulty.
     * @return the difficulty.
     */
    public int getDifficulty() {
        return difficulty;
    }    
    /**
   * handles the spawning of of the player, minions and Zuul. takes in a name
   * to give the player
   * @param playerName name of the player
   */
    private void spawnMobs(String playerName) {         
        player = new Player(playerName, 100, 20, 30, 1, this.difficulty, message);    
        labyrinth.spawnPlayer(0,0, player);
        
        ghost = new GhostWanderer("bob", message);
        labyrinth.spawnNPC(0,1,ghost); 
        
        Monster zuul = new Monster("Zuul", 140 + ((int)(Math.pow(this.difficulty, 2))*10), 15, 25, 'Z',this.difficulty, true, this.difficulty, message);
        labyrinth.spawnMonster(this.mazeSize-1, this.mazeSize-1,zuul);
        monsters.add(zuul);
        for (int i = 0; i < this.maxNumberOfMinions ; i++) 
        {
            boolean added = false;
            while (!added)
            {
                int x = (int)(1+ Math.random()*(this.mazeSize-1)); 
                int y = (int)(1+ Math.random()*(this.mazeSize-1));
                Monster min = new Monster(("minion"+i), 30, 0, 10, 'M',this.difficulty, false, this.difficulty, message);
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
     * saves the highscore to local disk.
     */
    public void saveHighScore() {
        if(highScoreHandler.addScore(scoreTracker.getScore()))
        {
            try
            {
            savegameHandler.saveHighScore(highScoreHandler);
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * loads all highscores fron the local disk
     * @return highscores.
     */
    public IScore[] loadHighScore() {
        try
        {
            highScoreHandler = (HighScoreHandler)savegameHandler.loadHighScore();
            if (isDebug)
                System.out.println("Loaded old Game"); 
            highScoreHandler.sortHighScore();
            return highScoreHandler.getScores();
        }
        catch(IOException | ClassNotFoundException e)
        {
            highScoreHandler.sortHighScore();
            System.out.println(e.getMessage());
            return highScoreHandler.getScores();
        } 
//        return highScoreHandler.getScores();

    }
    /**
     * gets the descripion if a surtan pice of loot in the room the player is standing in.
     * @param itemNumber ID of the item 
     * @return a string of the description
     */
    public String getLootItemDescription(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 0)
            return player.getCurrentRoom().itemList()[itemNumber].getDescription();
        return "";
    } 
    /**
     * gets the descripion if a surtan pice of loot in the players inventory.
     * @param itemID  ID of the item 
     * @return  a string of the description
     */
    public String itemDescription(int itemID) {
        return player.getInventory().getItemDescription(itemID);
    }
    /**
     * Injecs the data layer logic to the game 
     * @param savegameHandler savegamehandler that implement isavegameghander
     */
    public void setSavegameHandler(ISaveGameHandler savegameHandler) {
        this.savegameHandler = savegameHandler;
    }
    /**
     * gets a string representation of the amount of points the player has collected. 
     * @return string value of score.
     */
    public String getScoreString() {
        return scoreTracker.getScore().getScoreString();
    }
    /**
     * get the difficulty string of the game. 
     * @return a string represention of the dificulty 
     */
    public String getDifficultyString() {
        return scoreTracker.getScore().getDifficulty();
    }       
    //-----------------------------------------------------------
    //---------------------Player Handling-----------------------
    //-----------------------------------------------------------
   /**
    * the legacy go room from the zuul framework, modified to have a Boolean return
    * this is so that then player tryes to go somewhere that it cant, you dont 
    * miss a turn.allso command is removed, and replaced with a DIR enum for the 
    * direction the player wishes to go in.
    * @param dir direction that wishes to be moved
    * @return if the move woas succesfull
    */
    private boolean goRoom(Labyrinth.DIR dir) {       
        Room nextRoom = player.getCurrentRoom().getExit(dir.direction);        
        if (nextRoom == null) {
            if (isDebug)
                System.out.println("There is no door!");
            return false;
        }
        else if(nextRoom.hasDoor(dir.opposite.direction))
        {
                Door d = nextRoom.getDoor(dir.opposite.direction);
            if(d.isLocked())
            {
                if (isDebug)
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
     * gets the player name. 
     * @return player name.
     */
    public String getName() {
        return player.getName();
    }
    /**
     * gets the players current healt
     * @return int of players health
     */
    public int getPlayerCurrentHealth() {
        return player.getCurrentHealth();
    }
    /**
     * handles all about the turn of the player and allso the monsters 
     * if the playes is in swiftness mode, use lampoil and calls process monster
     * @return true if there is a confligt
     */
    public boolean move() {
       
        boolean moved = goRoom(player.getFacing());
        
        if(moved)
        {
            if(!player.isSwiftness())
            {
                processMonsters();
                player.useLampOil();
                scoreTracker.turnEnd();

            }        
            if(player.isInvis())
            {
                return false;
            }
            message.setDescription("LampOil left : "+player.getLampOil());
        }
        if(isDebug)
        {
            labyrinth.display();
        }
        return checkForCombat();
    }
    /**
     * turns the players facing direction to the rigth.
     * @return false because this does not cost a turn
     */
    public boolean turnRight() {
        player.setFacing(player.getFacing().right);
        return false;
    }    
    /**
     * turns the players facing direction to the left.
     * @return  false because this does not cost a turn
     */
    public boolean turnLeft() {
        player.setFacing(player.getFacing().left);
        return false;
    }    
    /**
     * turns the players facing direction 180 .
     * @return  false because this does not cost a turn
     */
    public boolean turnBack() {
        player.setFacing(player.getFacing().opposite);
        return false;
    }    
    /**
     * get list of items in inventory
     * @return string array of all the names in the inventory
     */
    public String[] getInventory() {
        return player.getInventory().getInventoryList();
    }
    /**
     * the actual attack handler for one swing againts a monster 
     * if the player is succesfull in killing the monster, it is removed.
     * @return true if the monster died
     */
    public boolean attack() {
        Actor m = player.getCurrentRoom().getMonster();
        if(fight.attack(player, m))
        {
            if(m.getMapCode() == 'Z')
            {
                scoreTracker.bossKill();
                player.getCurrentRoom().dropItem(new Key(message));
            }
            scoreTracker.monsterKill();
            deleteMonster(m);
            int i = 0;
            while(i < 1)
            {
                player.getCurrentRoom().dropItem(itemGenerator.generateRandomItem());
                i = (int)(Math.random() * 4);
            }
           return true; 
        }
        else return fight.attack(m, player);
        
    }
    /**
     * player flees if it is invisible you can get away, if not you will get 
     * damaged by the monster.
     * @return true if player died form attack and false if not
     */
    public boolean flee() {
        if(player.isInvis())
        {
            return false;
        }
        else
        {
            return fight.attack(player.getCurrentRoom().getMonster(), player);
        }
    }  
    /**
     * uses an item selected with ID 
     * @param itemID Id of item selected
     */
    public void useItem(int itemID) {
        player.getInventory().useItem(itemID);
    }    
    /**
     * drops an item to the room the player is currently in
     * @param itemID id of item selected.
     */
    public void dropItem(int itemID){
        player.getInventory().dropItem(itemID);
    } 
    /**
     * makes an array of names if items in the players inventory.
     * @return array of string names of objects, 
     */
    public String[] getLoot() {
        String[] lootArray = new String[player.getCurrentRoom().itemList().length];
        for (int i = 0; i < lootArray.length; i++) {
            lootArray[i] = player.getCurrentRoom().itemList()[i].getName();
            }
        return lootArray;
    }
    /** 
     * uses an item located on the floor of the room that the player is stading 
     * in.
     * @param itemNumber ID of the item that the player whants to use.
     */
    public void useLootItem(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 0)
                   player.getCurrentRoom().useItem(itemNumber,player);
    }
    /**
     * picks up an item located on the floor of the room that the player is stading 
     * in.
     * @param itemNumber ID of the item that the player whants to pickup.
     */
    public void pickUpItem(int itemNumber) {
        if(player.getCurrentRoom().itemList().length > 0)
        player.getCurrentRoom().pickupItem(itemNumber,player.getInventory());
    }          
    /**
     * a sudu talk to the friendly NPC, this is for giving the player tips on 
     * how to play
     * @return tips in string format.
     */
    public String talkToBob() {
        return ghost.getQuote();
    }
    //-----------------------------------------------------------
    //------------------------AI Handling------------------------
    //-----------------------------------------------------------  
    /**
     * a version of the old go room from the legacy zuul game 
     * modified to handle the AI/NPC movement around the map.
     * @param command command, with what direction the NPC should move.
     * @param actor the NPC that should move.
     */
    private void goRoom(String dir, Actor actor) {      
        Room nextRoom =  actor.getCurrentRoom().getExit(dir);
        if (nextRoom != null) {
            labyrinth.moveMonster(actor, nextRoom);
        }
    }    
    /**
     * proccesss the monsteres turn, checks if there is confligts between a 
     * monster and the player and moves the monsters on the field.
     */
    private void processMonsters() {
        for(Monster m : monsters)
        {
            // if the monster is not figthing the player, then move
            if (!m.getCurrentRoom().isConflict())
           {
                moveMonster(m);
            }
        }        
    }   
    /**
     * moves the monster, by getting all exits and picking one at random, checks 
     * if a monster is allready there, if not it moves.
     * 
     * @param m monster that should be moved
     */
    private void moveMonster(Monster m) {
        String[] exits = m.getCurrentRoom().getExits();
        Collections.shuffle(Arrays.asList(exits));
        for(String s : exits)
        {
            try
            {   
                Room current = m.getCurrentRoom();
                Room ex = current.getExit(s);
                if(!ex.isOccupied())
                {
                    goRoom(s, m);
                    if (isDebug == true)
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
    /** 
     * removes monster from list and maze.
     * @param m monster to remove.
     */
    private void deleteMonster(Actor m) {
        m.getCurrentRoom().setMonster(null);
        monsters.remove(m);
    }     
    /**
     * gets the name of a monster in the room of the player.
     * @return name of monster or ghost in the players current room.
     */
    public String getMonsterName() {
        if(player.getCurrentRoom().getGhoust() != null)
        {
            return player.getCurrentRoom().getGhoust().getName();
        }
        else if (player.getCurrentRoom().getMonster() != null)
        {
            return player.getCurrentRoom().getMonster().getName();
        }
        
        return null;
       }
    //-----------------------------------------------------------
    //----------------------- Rendering -------------------------
    //-----------------------------------------------------------
    /**
     * calls the render engine to get a image of the maze from the players
     * current location
     * @return sudu 3D image of the maze
     */
    public Image renderMazeView() {
       return RenderEngine.renderMazeView(player);
    }
    /**
     * calls the render engine to get a image of the map, with only as much as 
     * the player has vissitet unless a map has ben found. monsters and player 
     * is visiable
     * @return a 2D top down image of the maze
     */
    public Image renderMiniMapView() {           
       return RenderEngine.renderMiniMapView(labyrinth.getMaze());
    }
    /** 
     * calls the render engine to get a image of the battle at hand with the 
     * player and a monster 
     * @return sudu 3d view of the player and monster.
     */
    public Image renderBattleView() {
        if(player.getCurrentRoom().getMonster() == null)
            return null;
        else
            return RenderEngine.renderBattleView(player, (Monster)player.getCurrentRoom().getMonster());
    }    
    /**
     * makes a image of the background for the main menu
     * @return image.
     */
    public Image getMainMenuBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_MAIN_MENU_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
        
    }    
    /**
     * makes a image of the background for the new game
     * @return image
     */
    public Image getNewGameBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_NEW_GAME_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }    
    /**
     * makes a image of the background for game and combat
     * @return image
     */
    public Image getGameAndCombatSceneBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_GAME_AND_COMBAT_SCENE_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }    
    /**
     * makes a image of the background for the game over
     * @return image
     */
    public Image getGameOverSceneBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_GAME_OVER_SCENE_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }    
    /**
     * makes a image of the background for the  game won
     * @return image
     */
    public Image getGameWonSceneBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_GAME_WON_SCENE_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }  
    /**
     * makes a image of the background for the  highscore and credits
     * @return image
     */
    public Image getHighscoreAndCreditsSceneBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_HIGHSCORE_AND_CREDITS_SCENE_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }   
    /**
     * makes a image of the background for the options and help
     * @return image
     */
    public Image getOptionsAndHelpSceneBackground() {
        try
        {
            BufferedImage renderedView =
                new BufferedImage(640, 480, BufferedImage.TYPE_INT_ARGB);
            BufferedImage tile = ImageIO.read(new File(DIR_OPTIONS_AND_HELP_SCENE_BACKGROUND));
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(tile, 0,0,null);
            return SwingFXUtils.toFXImage(renderedView, null);
        }
        catch (IOException ex)
        {
            System.out.println("Error message:");
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
   
    

