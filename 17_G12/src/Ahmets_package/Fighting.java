/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import java.util.Scanner;
import nicolai.Actor;
import nicolai.Monster;
import nicolai.Player;
import nicolai.Zuul;
/**
 *
 * @author AC
 */
public class Fighting {
    
   public void fightingLoop(Player p, Actor a)
    {
         int playerHitpoint;
         int actorHitpoint;
         
         boolean isAlive = true;
         boolean flee = false;
         
         while (isAlive)
         {
             //Command command = parser.getCombatCommand, skal laves i parseren
             //if (command == attack) attack(p,a);
             isAlive = alive(a);
             if (!isAlive)
             {
                 int oldLevel = p.getLevel();
                 p.setXp(p.getXp() + 1);
                 int newLevel = p.getLevel();
                if (newLevel > oldLevel) System.out.println(" Congratulations, you lvled up!");
             }
         }
    }
   private void attack(Actor a1, Actor a2)
   {
       int actorDefense = a2.getModifiedDefense();
       int actorHitpoint = a2.getCurrentHealth();
       if ((int)(Math.random()*100) > actorDefense)
       {
           actorHitpoint -= a1.getModifiedDamgeOutput();
           a2.setCurrentHealth(actorHitpoint);
       }
       else System.out.println(a1.getName() + " misses " + a2.getName());
   }
   private boolean alive(Actor a1)
   {
       return a1.getCurrentHealth() > 0;
       
   }
   
}
