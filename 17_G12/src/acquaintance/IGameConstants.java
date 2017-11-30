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
    boolean isDebug = true;
    String DIR_CHARACTORS = "assets//charactors//";
    String DIR_MINIMAP = "assets//minimap tiles//";
    String DIR_MAZEVIEW_LABYRITH = "assets//rooms//textures//";
    String DIR_MAZEVIEW_OBJECTS = "assets//rooms//Objects//";
    String DIR_MAZEVIEW_MALTE = "assets//rooms//MaltesEdit//";
    String FILENAME_SAVEGAME = "savegame.zuul";
    String FILENAME_HIGHSCORE_LIST = "highscore.zuul";
    String DIR_MAIN_MENU_BACKGROUND = "assets//backgrounds//gateBG2.png";
    String DIR_NEW_GAME_BACKGROUND = "assets//backgrounds//caveBG3.jpg";
    String DIR_GAME_AND_COMBAT_SCENE_BACKGROUND = 
            "assets//backgrounds//gameSceneBackground.png";
    String DIR_GAME_OVER_SCENE_BACKGROUND = 
            "assets//backgrounds//gameOverSceneBackground.png";
    String DIR_GAME_WON_SCENE_BACKGROUND = 
            "assets//backgrounds//gameWonSceneBackground.png";
    String DIR_HIGHSCORE_AND_CREDITS_SCENE_BACKGROUND = 
            "assets//backgrounds//highscoreSceneBackground.png";
    String DIR_OPTIONS_AND_HELP_SCENE_BACKGROUND = 
            "assets//backgrounds//optionsSceneBackground.png";
    String[] FILENAME_PICTURES_CHARACTOR =
    {
        "innerMinion.png",              // 0
        "innerZuul.png",                // 1
        "innerGhoust.png",              // 2
        "outerMinion.png",              // 3
        "outerZuul.png",                // 4       
        "outerGhouts.png"               // 5
    };
    String[] FILENAME_PICTURES_CHARACTOR_BATTLE =
    {
        "HealthBars.png",               // 0
        "MonsterImp.png",               // 1
        "MonsterZuul.png",              // 2
        "PlayerHighLevel.png",          // 3
        "PlayerLowLevel.png"            // 4      
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
        "Straight path north south.png" // 14        
    };
    String[] FILENAME_PICTURES_MAZE = 
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
        String[] FILENAME_PICTURES_MAZE_OBJECTS = 
    {
        "outerChest.png",       // 0
        "innerChest.png",       // 1
        "outerDoorForward.png", // 2      
        "innerDoorForward.png", // 3     
        
        "innerDoorLeft.png",    // 4
        "innerDoorRight.png",   // 5
        "outerDoorLeft.png",    // 6            
        "outerDoorRight.png",   // 7
        "outerDoorForward.png",  // 8 
            
        "CompassRoseEast.png",  // 9
        "CompassRoseNorth.png", // 10
        "CompassRoseSouth.png", // 11
        "CompassRoseWest.png"   // 12
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
        "VERY EASY",           // 0
        "EASY",                // 1
        "NORMAL",              // 2
        "HARD",                // 3
        "VERY HARD"            // 4
    };
    String[] MALTES_TILES = 
    {
        "innerRoomMalte.png",   //0
        "noLeft.png",           //1
        "noRight.png"           //2
    };
}
