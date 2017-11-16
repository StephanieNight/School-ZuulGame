/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;


/**
 * contains constants used in the game. like file locations and names
 * suppertet resulotions and so on.
 * @author Stephanie
 */
public interface IGameConstants {
    String FILEPATH_RUNNING_DIR = "";
    String FILEPATH_MINIMAP_DIR = "assets\\Minimap tiles\\";
    String FILENAME_SAVEGAME = "savegame.zuul";
    String FILENAME_HIGHSCORE_LIST = "highscore.zuul";
    String[] FILENAME_PICTURES_MINIMAP = 
    {
        "bend south east.png",
        "bend south west.png",
        "bend north east.png",
        "bend north west.png",            
        "T way north south east.png",
        "T way south west north.png",
        "T way south, east, west.png",
        "T way north east west.png",           
        "Crossroads.png",
        "dead end north.png",
        "dead end west.png",
        "dead end east.png",
        "dead end south.png"
    };
    String[] FILENAME_PICTURES_VIEWPORT = 
    {
        
    };
    String[] SCREEN_RES =
    {
        "800x450",  
        "1280x720",   
        "1366x768",
        "1920x1080"
    };
    String[] DIFFICULTY_NAMES =
    {
        "PLAESE DONT HURT ME",
        "EASY",  
        "NORMAL",   
        "BRING IT ON",
        "I AM DEATH"
    };
    public void play();
//    private static void saveGame();
//    private static void loadGame();
//    private void processPlayer();
//    private void goRoom(Command command, Actor actor) ;
//    private boolean goRoom(Command command) ;
//    private boolean quit(Command command);
    public int getDifficulty();
    public int getMaxNumberOfMinions();
    public void spawnMobs();
    
}
