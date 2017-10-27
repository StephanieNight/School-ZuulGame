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
   private boolean survived;
   
   public Fighting (Player p, Actor a)
   {
       this.p = p;
       this.a = a;
       parser = new Parser();
       survived = fightingLoop(p,a);
   }

    public boolean didSurvive() {
        return survived;
    }
   public boolean fightingLoop(Player p, Actor a)
    {
         int playerHitpoint;
         int actorHitpoint;
         
         boolean isAlive = true;
         boolean didAction = false;
         
         
         while (isAlive)
         {
             CombatCommand command = parser.getCombatCommand();
             didAction = processCommand(command);
             if (!didAction){
                 continue;
             }
             isAlive = alive(a);
             if (!isAlive)
             {
                 int oldLevel = p.getLevel();
                 p.setXp(p.getXp() + 1);
                 int newLevel = p.getLevel();
                if (newLevel > oldLevel){
                    System.out.println("Congratulations, you lvled up!");
                }
                return true;
             }
             
             
             
             
             
             
             attack (a,p);
             isAlive = alive(p);
             if (!isAlive){ 
                 System.out.println("You are dead");
                 return false;
             }
         
             if (flee){
                 return true;
             }
                         
         }
    }
   private boolean processCommand(CombatCommand command) 
    {
        boolean didAction = false;

        CombatCommandWord commandWord = command.getCombatCommandWord();

        if(commandWord == CombatCommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CombatCommandWord.HELP) {
            printHelp();
            return false;
        }
        else if (commandWord == CombatCommandWord.ATTACK) {
            attack(p,a);
            return true;
        }
        else if (commandWord == CombatCommandWord.FLEE){
            flee = true;
            return true;
        }
        else if(commandWord == CombatCommandWord.INVENTORY){
            p.getInventory().getInventoryList();
            return false;
        }
        else if (commandWord == CombatCommandWord.USE_ITEM){
            useItem(command);
            return true;
        }
        else if (commandWord == CombatCommandWord.QUIT) {
            //wantToQuit = quit(command);
        }
        return didAction;
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
   private void useItem(CombatCommand command){
       if(!command.hasSecondWord()){ 
           System.out.println("Which item");
           return;
       }
       int id = Integer.parseInt(command.getSecondWord());
            p.getInventory().useItem(id);
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
