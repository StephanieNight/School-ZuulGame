/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

/**
 * Sketch for how combat can be resolved
 * @author Malte
 */
public class Combat {
    
    
    /**
     * Calculate if hit, and how much damage done.
     * @param attack
     * @param defense 
     */
    public void attack (CharacterBase attack, CharacterBase defense)
    {
        if (!isHit(attack.getAttackHitModifier(), defense.getDefenseEvation()))
        {
            System.out.println("It's a miss");
        }
        else
        {
            System.out.println("It's a hit!");
            System.out.println((attack.getAttackDamage() - 
                    defense.getDefenseArmor()) + " damage done.");
            defense.setHealthPoints(defense.getHealthPoints() - 
                    (attack.getAttackDamage() - defense.getDefenseArmor()));
        }
    }
    
    /**
     * Calculate if hit is true.
     * @param attack
     * @param defense
     * @return 
     */
    private boolean isHit(int attack, int defense)
    {
        if ((int)(Math.random() * 100) + attack - defense >= 100)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    
    /**
     * Loop for combat ending when a character dies.
     * @param character1
     * @param character2 
     */
    public void combatLoop(CharacterBase character1, CharacterBase character2)
    {
        while (character1.getHealthPoints() > 0 && character2.getHealthPoints() > 0)
        {
            attack(character1, character2);
            if (character2.getHealthPoints() < 0)
            {
                character1.setTotalExp(character2.getExpWorth());
                character1.updateLevel();
                System.out.println(character1.getCharacterName() + " killed " + character2.getCharacterName());
                break;
            }
            
            attack(character2, character1);
            if (character1.getHealthPoints() < 0)
            {
                character2.setTotalExp(character1.getExpWorth());
                character2.updateLevel();
                System.out.println(character1.getCharacterName() + " killed " + character1.getCharacterName());
                break;
            }
            
            
        }
    }
    
    
}
