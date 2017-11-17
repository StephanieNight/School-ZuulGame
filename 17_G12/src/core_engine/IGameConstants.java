/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;


/**
 * contains constants used in the game. like file locations and names
 * suppertet resulotions and so on.
 * @author Stephanie
 */
public interface IGameConstants {
    String FILEPATH_RUNNING_DIR = "";
    String FILEPATH_CHARACTORS_DIR = "assets\\charactors\\";
    String FILEPATH_MINIMAP_DIR = "assets\\Minimap tiles\\";
    String FILEPATH_MAZEVIEW_DIR = "assets\\rooms\\";
    String FILENAME_SAVEGAME = "savegame.zuul";
    String FILENAME_HIGHSCORE_LIST = "highscore.zuul";
    String[] FILENAME_PICTURES_MINIMAP = 
    {
        "bend south east.png",          // 0
        "bend south west.png",          // 1
        "bend north east.png",          // 2
        "bend north west.png",          // 3  
        "T way north south east.png",   // 4
        "T way south west north.png",   // 5
        "T way south, east, west.png",  // 6  
        "T way north east west.png",    // 7       
        "Crossroads.png",               // 8
        "dead end north.png",           // 9
        "dead end west.png",            // 10
        "dead end east.png",            // 11
        "dead end south.png",           // 12
        "Straight path east west.png",  // 13
        "Straight path north south.png",// 14
    };
    String[] FILENAME_PICTURES_VIEWPORT = 
    {
        
    };
    String[] FILENAME_PICTURES_TOKEN = 
    {
        "Player Token.png",
        "Monster Token.png",
        "Zuul Token.png" 
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
}
