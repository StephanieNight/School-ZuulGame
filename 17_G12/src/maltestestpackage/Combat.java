///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package maltestestpackage;

import java.util.Scanner;
import core_engine.Actor;
import core_engine.Monster;
import core_engine.Player;
import core_engine.Zuul;
///**
// * Sketch for how combat can be resolved
// * @author Malte
// */
public class Combat {
//    
//    
    
    public Combat(Player p, Actor m)
    {
        this.combatLoop(p, m);
    }
    
    public Combat(Player p, Zuul z)
    {
        this.combatLoop(p, z);
    }
    
    
    /**
     * loop for combat that lets the player choose between fighting and fleeing
     * every round. If the player flees the monster gets to try and hit him.
     * @param player Player object
     * @param monster Monster object
     */
    public void combatLoop(Player player, Actor monster)
    {
        boolean isDead = false;
        boolean flee = false;
        Scanner input = new Scanner(System.in);
        String in;
        int monsterHealth = monster.getCurrentHealth();
        int damage;
        int playerHealth = player.getCurrentHealth();
        
        
        
        while(!isDead)
        {
            System.out.println("type \"A\" to attack and \"F\" to flee");
            System.out.print("> ");
            in = input.next();
            if(in.toUpperCase().equals("A"))
            {
                if(isHit(25))
                {
                    damage = (int)(Math.random()*10 + player.getModifiedDamgeOutput());
                    monsterHealth -= damage;
                    System.out.println("You hit " + monster.getName() + " for " 
                            + damage + " damage");                   
                    
                }
                else
                {
                    System.out.println("You miss!");
                }     
                
            }
            
            if(monsterHealth < 0)
            {
                this.youWon(player, monster);
                break;
            }
            else if(in.toUpperCase().equals("F"))
            {
                flee = true;
            }
            else
            {
                System.out.println("You wasted your turn...");
            }
            
            if(isHit(0))
                {
                    damage = (int)(Math.random()*10 + monster.getModifiedDamgeOutput());
                    playerHealth -= damage;
                    System.out.println(monster.getName() + " hits you for " 
                            + damage + " damage");                   
                    player.setCurrentHealth(playerHealth);
                }
                else
                {
                    System.out.println(monster.getName() + " misses!");
                }
        
            if(playerHealth > 0)
            {
            }
            else
            {
                System.out.println("You've died!");
                System.out.println("Do you wish to start a new game?");
                //restart or quit
                break;
            }
            if(flee == true)
            {
                break;
            }
            
        }
            
            
            
            
            
        
    }

        
    /**
    * checks if the attack hits.
    * @param hitChance taken from the actor object.
    * @return true if a random number between 0 and 100 is under the actors
    * hit chance.
    */
    private boolean isHit(int hitChance)
    {
        return (int)(Math.random() * 100) <= 75 + hitChance;
    }
    
     
    /**
        * assigns exp to the player when he defeats monsters
        * @param player player object
        * @param monster monster object
        */
    public void youWon(Player player, Actor monster)
    {
        System.out.println(player.getCurrentRoom().getMonster().getName()+" has been slain you win");
        player.getCurrentRoom().setMonster(null);
        
        player.setTotalXp(player.getTotalXp() + monster.getXp());
        
    }


}
