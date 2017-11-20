/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import acquaintance.IGameEngine;
import acquaintance.IInventory;
import data.SaveGameInstance;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Stephanie
 */
public class GameEngine implements IGameEngine {
    private ZuulGame game;
    public GameEngine()
    {
        this.game = new ZuulGame();
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
      return game.saveHighScore();
    }

    @Override
    public boolean loadHighScore() {
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
    public IInventory getInventory() {
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
}