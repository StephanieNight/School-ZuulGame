/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acquaintance;

import javafx.scene.image.Image;

/**
 *
 * @author Malte
 */
public interface IGameEngine {
    public boolean startNewGame(int difficulty, String name);
    public int getDifficulty();
    public boolean saveHighScore();
    public boolean loadHighScore();
    public boolean saveGame();
    public boolean loadGame();    
    public String getName();
    public boolean setName(); 
    public String getMessage();
    public String getCurrentHealthToString();
    
    public Image renderMazeView();
    public Image renderMiniMapView();
    public Image renderBattleView();
        
    public boolean move();
    public boolean turnRight();
    public boolean turnLeft();
    public boolean turnBack();
    
    public String[] getInventory();
    public boolean useItem(int itemNumber);
    public boolean dropItem(int ItemNumber);
    public String itemDescription(int itemNumber);
    
    public String[] getLoot();
    public void useLootIem(int itemNumber);
    public void pickUpItem(int itemNumber);
    public String getLootItemDescription(int itemNumber);
    
    public boolean checkForCombat();
    public boolean attack();
    public boolean flee();
    public boolean checkWinCondition();
    public boolean checkForGameOver();
    
}
