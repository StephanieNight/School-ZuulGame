
package core_engine;

import core_engine.GameEngine;

/**
 * the Monster class extending Actor, used for monsters with the only specific 
 * method used to distinguish between normal monsters and the boss monster
 * @author nicol
 */
public class Monster extends Actor
{
    private final boolean IS_BOSS;
    
    /**
     * The constructor for the monster class, updating the values of the monster 
     * to match the level they are set to
     * @param name the name of the monster
  @param defaultHealthpoint starting health points before adding extra from levels
     * @param defaultDefense starting defense before adding extra from levels
     * @param DefaultDamgeOutput starting damage done before adding extra from levels
     * @param mapCode the char used to show the monster, is used in some methods 
     * to distinguish between normal and boss monsters
     * @param level the level the monsters will be.
     * @param isBoss a boolean, true if the monster is a boss
     * @param difficulty the current difficulty
     * @param msg the message class
     */
    
    public Monster(String name, int defaultHealthpoint, int defaultDefense, int defaultDamgeOutput, char mapCode, int level, boolean isBoss, int difficulty, Message msg) {
        super(name, defaultHealthpoint, defaultDefense, defaultDamgeOutput, mapCode, level, difficulty, msg);
        this.IS_BOSS = isBoss;
        updateLevel();
        setCurrentHealth(10000);
    }    
    
    /**
     * the method to access the 
     * @return boolean true if boss, false if normal monster
     */
    public boolean isBoss() {
        return IS_BOSS;
    }
}
