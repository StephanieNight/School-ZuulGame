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
    boolean isDebug = true;
    String FILEPATH_RUNNING_DIR = "";
    String FILEPATH_CHARACTORS_DIR = "assets//charactors//";
    String FILEPATH_MINIMAP_DIR = "assets//minimap tiles//";
    String FILEPATH_MAZEVIEW_DIR = "assets//rooms//textures//";
    String FILENAME_SAVEGAME = "savegame.zuul";
    String FILENAME_HIGHSCORE_LIST = "highscore.zuul";
    String[] FILENAME_PICTURES_CHARACTOR =
    {
        "innerMinion.png",          // 0
        "innerZuul.png",            // 1
        "outerMinion.png",          // 2
        "outerZuul.png"             // 3
    };
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
        "Background.png",       // 0      
        "InnerTemplate.png",    // 1
        "InnerLeft.png",        // 2
        "InnerRight.png",       // 3
        "InnerNoForward.png",   // 4
        "InnerNoLeft.png",      // 5
        "InnerNoRight.png",     // 6            
        "OuterTemplate.png",    // 7
        "OuterLeft.png",        // 8
        "OuterRight.png",       // 9
        "OuterNoForward.png",   // 10
        "OuterNoLeft.png",      // 11
        "OuterNoRight.png",     // 12
        "OuterForward.png"      // 13    
    };
    String[] FILENAME_PICTURES_TOKEN = 
    {
        "Player Token.png",      // 0
        "Monster Token.png",     // 1
        "Zuul Token.png",        // 2   
    };
    String[] SCREEN_RES =
    {
        "800x450",              // 0
        "1280x720",             // 1
        "1366x768",             // 2
        "1920x1080"             // 3 
    };
    String[] DIFFICULTY_NAMES =
    {
        "PLAESE DONT HURT ME",  // 0
        "EASY",                 // 1
        "NORMAL",               // 2
        "BRING IT ON",          // 3
        "I AM DEATH"            // 4
    };
}
