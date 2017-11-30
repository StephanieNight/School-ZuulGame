/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.IGameEngine;
import acquaintance.IInventory;
import acquaintance.ISaveGameHandler;
import acquaintance.IScore;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Stephanie
 */
public class GameEngine implements IGameEngine {
    private ZuulGame game;
    private Message msg;
    private ISaveGameHandler sh;
    public GameEngine()
    {
        msg = new Message();
        this.game = new ZuulGame(msg);
    }
    @Override
    public boolean startNewGame(int difficulty, String name) {
       return game.startNewGame(difficulty, name);
    }

    @Override
    public int getDifficulty() {
        return game.getDifficulty();
    }
    
    @Override
    public boolean saveHighScore() {
      game.saveHighScore();
      return true;
    }

    @Override
    public IScore[] loadHighScore() {
        return game.loadHighScore();
    }

    @Override
    public boolean saveGame() {
      return game.saveGame();
    }

    @Override
    public boolean loadGame() {
       return game.loadGame();
    }

    @Override
    public String getName() {
        return game.getName();
    }

    @Override
    public boolean setName() {
        return game.setName();
    }

    @Override
    public Image renderMazeView() {
        return game.renderMazeView();
    }

    @Override
    public Image renderMiniMapView() {
        return game.renderMiniMapView();
    }

    @Override
    public Image renderBattleView() {
       return game.renderBattleView();
    }
    
    @Override
    public Image getMainMenuBackground()
    {
        return game.getMainMenuBackground();
    }

    @Override
    public Image getNewGameBackground()
    {
        return game.getNewGameBackground();
    }
    
    @Override
    public Image getGameAndCombatSceneBackground()
    {
        return game.getGameAndCombatSceneBackground();
    }
    
    @Override
    public Image getGameOverSceneBackground()
    {
        return game.getGameOverSceneBackground();
    }
    
    @Override
    public Image getGameWonSceneBackground()
    {
        return game.getGameWonSceneBackground();
    }
    
    @Override
    public Image getHighscoreAndCreditsSceneBackground()
    {
        return game.getHighscoreAndCreditsSceneBackground();
    }
    
    @Override
    public Image getOptionsAndHelpSceneBackground()
    {
        return game.getOptionsAndHelpSceneBackground();
    }
    
    @Override
    public boolean move() {
       return game.move();
    }

    @Override
    public boolean turnRight() {
        return game.turnRight();
    }

    @Override
    public boolean turnLeft() {
        return game.turnLeft();
    }

    @Override
    public boolean turnBack() {
    return game.turnBack();
    }

    @Override
    public String[] getInventory() {
        return game.getInventory();
    }

    @Override
    public boolean checkForCombat() {
       return game.checkForCombat();
    }

    @Override
    public boolean attack() {
        return game.attack();
    }

    @Override
    public boolean flee() {
      return game.flee();
    }

    @Override
    public boolean checkWinCondition() {
        return game.checkWinCondition();
    }

    @Override
    public boolean useItem(int itemNumber) {
        game.useItem(itemNumber);
        return false;
    }
    
    @Override
    public boolean dropItem(int itemNumber){
        game.dropItem(itemNumber);
        return false;
    }
    
    @Override
    public String itemDescription(int itemNumber){
        return game.itemDescription(itemNumber);
    }

    @Override
    public String getMessage() {
        
        return msg.getDescription();
    }

    @Override
    public String getCurrentHealthToString()
    {
        return Integer.toString(game.getPlayerCurrentHealth());
    }

    @Override
    public boolean checkForGameOver() {
        return game.checkForGameOver();
    }

    @Override
    public String[] getLoot() {
        return game.getLoot();
    }

    @Override
    public void useLootItem(int itemNumber) {
        game.useLootItem(itemNumber);
    }

    @Override
    public void pickUpItem(int itemNumber) {
        game.pickUpItem(itemNumber);
    }

    @Override
    public String getLootItemDescription(int itemNumber) {
        return game.getLootItemDescription(itemNumber);
    }

    @Override
    public void injectData(ISaveGameHandler sh) {
        this.game.setSavegameHandler(sh);
        this.sh = sh;
    }
    @Override
    public String checkForMonster() {
        return game.getMonsterName();
    }

    @Override
    public String talkToBob() {
        return game.talkToBob();
    }
    @Override
    public String getScoreString()
    {
        return game.getScoreString();
    }
    @Override
    public String getDifficultyString()
    {
        return game.getDifficultyString();
    }

}