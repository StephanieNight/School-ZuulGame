/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

import Stephie_build.GameEngine;

/**
 *
 * @author Stephanie
 */
public class Start {
    public static void main(String[] args)
    {
        GameEngine gameEngine = new GameEngine();
        gameEngine.playTEST();
        /*
        Game g = new Game();
        long time = System.currentTimeMillis();
        g.playTEST();
        time = System.currentTimeMillis()-time;
        System.out.println("Execution in ms: " +time);
*/
    }
}