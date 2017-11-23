/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import Legacy_framework.CombatCommandWord;
import Legacy_framework.CombatCommand;
import Legacy_framework.Command;
import Legacy_framework.CommandWord;
import java.util.Scanner;
import core_engine.Actor;
import core_engine.Message;
import core_engine.Monster;
import core_engine.Player;
/**
 * Class to resolve conflict between a player and a monster.
 * @author collaboration between Ahmet, Malte and Nicolai.
 */
public class Fight {
   private boolean flee = false;
   private boolean survived;
   private Message message;
   
   
   /**
    * This is the constructor for the class and automatically runs the fighting 
    * loop method with the given arguements
    * @param p The main player
    * @param m The monster you meet
    */
   public Fight (Message message)
   {
       this.message = message;
       //survived = fightingLoop(p,m);
   }

    public boolean didSurvive() {
        return survived;
    }
    
    /**
     * This is the main loop for resolving combat. It uses a combat command so 
     * you cant use the same command as when exploring. In case you kill
     * your opponent you will be rewarded xp and check if you level up. 
     * @param p The main player
     * @param m The monster you meet
     * @return Returns a boolean value if survive the counter (true if you
     * surive and false if you die)
     */
   public boolean fightingLoop(Player p, Monster m)
    {
         boolean isAlive = true;
         boolean didAction = false;
         
         while (isAlive)
         {
             //CombatCommand command = parser.getCombatCommand();
             //didAction = processCommand(command);
             if (!didAction){
                 continue;
             }
             isAlive = alive(m);
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

             attack (m,p);
             isAlive = alive(p);
             if (!isAlive){ 
                 System.out.println("You are dead");
                 return false;
             }
         
             if (flee){
                 return true;
             }
                         
         }
         return true;
    }
 
   /**
    * Receives input through the parser from the player and checks if it is a
    * valid command and executes the command.
    * @param command The class CombatCommand is being used to make sure the
    * commands are correctly written.
    * @return Returns true if you did one of the following commands attack, 
    * flee or use item and otherwise it returns false so the player can give 
    * another command. 
    */
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
            //attack(p,m);
            return true;
        }
        else if (commandWord == CombatCommandWord.FLEE){
            flee = true;
            return true;
        }
        else if(commandWord == CombatCommandWord.INVENTORY){
            //p.getInventory().getInventoryList();
            return false;
        }
        else if (commandWord == CombatCommandWord.USE_ITEM){
            return useItem(command);
        }
        else if (commandWord == CombatCommandWord.QUIT) {
            //wantToQuit = quit(command);
        }
        return didAction;
    }
   
   /**
    * This is a method to resolve the attack. First it checks if the attack hits
    * by rolling a random number between 0 and 99. If the number is higher than
    * the defense of the victim, the victim is hit. If it hits damage dealt and 
    * current health of the victim is updated.
    * @param a1 The attacker
    * @param a2 The victim
    */
   private boolean attack(Actor a1, Actor a2)
   {
       int actorDefense = a2.getModifiedDefense();
       int actorHitpoint = a2.getCurrentHealth();
       
       if ((int)(Math.random()*100) > actorDefense)
       {
           actorHitpoint -= a1.getModifiedDamgeOutput();
           a2.setCurrentHealth(actorHitpoint);
           //announceAttack();
       }
       else
       {
           //announceMiss();
           System.out.println(a1.getName() + " misses " + a2.getName());
       }
       
       //announceAttack();
       
       if(a2.getCurrentHealth() > 0){
           return false;
       } else {
           return true;
       }
       
       
          
   }
   /*
   public String announceAttack()
   {
       
   }
   
   public String announceMiss()
   {
       
   }*/
   
   /**
    * Checks if the given actor is still alive.
    * @param a1
    * @return true if alive.
    */
   private boolean alive(Actor a1)
   {
       return a1.getCurrentHealth() > 0;
       
   }
   
   /**
    * Use item by giving a number. If no number or a valid number is given it 
    * cannot use the item.
    * @param command 
    */
   private boolean useItem(CombatCommand command){
       
       if(!command.hasSecondWord()){ 
           System.out.println("Which item");
           return false;
       }
       try
       {
       int id = Integer.parseInt(command.getSecondWord());
            //return p.getInventory().useItem(id);
       }
       catch (NumberFormatException e)
               {
                   System.out.println("Please enter the number for the item you wish to use.");
               }
       return false;
   }
   
   /**
    * Prints the list of commands and text.  
    */
   private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");

    }
   
   /**
    * Checks to make sure you dont add a second word.
    * @param command
    * @return a boolean a value.
    */
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
