/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import gameframework.Command;
import gameframework.CommandWord;
import gameframework.Parser;
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
   private Player p;
   private Actor a;
   private boolean flee = false;
   private Parser parser;
   
   public Fighting (Player p, Actor a)
   {
       this.p = p;
       this.a = a;
       parser = new Parser();
               
   }
   public void fightingLoop(Player p, Actor a)
    {
         int playerHitpoint;
         int actorHitpoint;
         
         boolean isAlive = true;
         boolean flee = false;
         
         
         
         while (isAlive)
         {
             //Command command = parser.getCombatCommand, skal laves i parseren
             if (command == CombatCommandWord.attack) attack(p,a);
             isAlive = alive(a);
             if (!isAlive)
             {
                 int oldLevel = p.getLevel();
                 p.setXp(p.getXp() + 1);
                 int newLevel = p.getLevel();
                if (newLevel > oldLevel){
                    System.out.println("Congratulations, you lvled up!");
                }
             }
             
             
             
             
             
             
             attack (a,p);
             isAlive = alive(p);
             if (!isAlive){ 
                 System.out.println("You are dead");
             }
         
             if (flee){
                 break;
             }
                         
         }
    }
   private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CombatCommandWord commandWord = command.getCombatCommandWord();

        if(commandWord == CombatCommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CombatCommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CombatCommandWord.ATTACK) {
            attack(p,a);
        }
        else if (commandWord == CombatCommandWord.FLEE){
        flee = true;
        }
        else if(commandWord == CombatCommandWord.INVENTORY){
            p.getInventory().getInventoryList();
        }
        else if (commandWord == CombatCommandWord.USE_ITEM){
            int id = Integer.parseInt(command.getSecondWord());
            p.getInventory().useItem(id);
        }
        else if (commandWord == CombatCommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        return wantToQuit;
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
   private void useItem(Command command){
       if(!command.hasSecondWord()){ 
           System.out.println("Which item");
           return;
       }
       
   }
   private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCombatCommands();
    }
   private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }
}
