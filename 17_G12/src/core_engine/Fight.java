/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;
/**
 * Class to resolve conflict between a player and a monster.
 * @author collaboration between Ahmet, Malte and Nicolai.
 */
public class Fight {
    private boolean survived;
    private final Message message;
    /**
    * This is the constructor for the class and automatically runs the fighting 
    * loop method with the given arguements
    * @param message 
    */
    public Fight (Message message)
    {
       this.message = message;
   }
    /**
     * did the player survive the battle
     * @return true if player is not dead.
     */
    public boolean didSurvive() {
        return survived;
    }    
    
    /**
    * This is a method to resolve the attack. First it checks if the attack hits
    * by rolling a random number between 0 and 99. If the number is higher than
    * the defense of the victim, the victim is hit. If it hits, damage dealt and 
    * current health of the victim is updated. Also checks if victim dies, and
    * grants xp to the victor.
    * @param a1 The attacker
    * @param a2 The victim
    * @return Returns false if a2 is still alive, true if dead.
    */
    public boolean attack(Actor a1, Actor a2) {
        int actorDefense = a2.getModifiedDefense();
        int actorHitpoint = a2.getCurrentHealth();
        int damage;
       
        if ((int)(Math.random()*100) > actorDefense)//hit chance
        {
            damage = a1.getModifiedDamgeOutput() + 
                    (int)(Math.random()*a1.getModifiedDamgeOutput()/5) 
                    - a1.getModifiedDamgeOutput()/10; //calculates damage with up to 10% variance.
            actorHitpoint -= damage;
            a2.setCurrentHealth(actorHitpoint);
            announceAttack(damage, a2.getCurrentHealth(), 
                   a1.getName(), a2.getName());
        }
        else
        {
            announceMiss(a1.getName(), a2.getName());
        }
       
        if(a2.getCurrentHealth() > 0){
            return false;
        } else {
            message.setDescription(a1.getName() + " killed " + a2.getName());
            int oldLevel = a1.getLevel();//grants xp to victor.
            a1.setXp(a1.getXp() + 1);
            int newLevel = a1.getLevel();
            if(newLevel > oldLevel)//notifies the player of a level up.
            {
                message.setDescription("You've gained a level!");
            }
            return true;
        }
    }
    /**
    * Sets the description in the object message to a string announcing
    * the damage dealt, the remaining health of the defending actor and
    * the name of the attacking and defending actor.
    * @param damage - The amount of damage dealt
    * @param remainingHealth - The amount of health back
    * @param actor1Name - The name of the attacking actor
    * @param actor2Name - The name of the defending actor
    */
    public void announceAttack(int damage, int remainingHealth, 
            String actor1Name, String actor2Name) {
        message.setDescription(actor1Name + " dealt " + damage + 
                " damage. " + actor2Name + " has " + remainingHealth + 
                " health left.");
    }    
    /**
    * Sets the description in the object message to a string announcing,
    * that the attack has missed.
    * @param actor1Name - The name of the attacking actor
    * @param actor2Name - The name of the defending actor
    */
    public void announceMiss(String actor1Name, String actor2Name) {
        message.setDescription(actor1Name + " missed " + actor2Name + ".");
    }   
}
