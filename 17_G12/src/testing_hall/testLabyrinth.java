/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing_hall;

import core_engine.Labyrinth;
import java.util.ArrayList;

/**
 * Test for the lapyrinth 
 * @author Stephanie
 */
public class testLabyrinth {
    public static void main(String[] args) {
        for(int i = 0; i < 10;i++)        
        {
            int mazeSize = (int)((1.5*i)+3);
            Labyrinth labyrinth= new Labyrinth(mazeSize);
            labyrinth.display();
        }
    }
}
