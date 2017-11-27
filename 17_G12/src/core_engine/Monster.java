
package core_engine;

import core_engine.GameEngine;

/**
 *
 * @author nicol
 */
public class Monster extends Actor
{
    private final boolean IS_BOSS;
    
    public Monster(String name, int defaultHealthpoint, int defaultDefense, int defaultDamgeOutput, char mapCode, int level, boolean isBoss, int difficulty, Message msg) {
        super(name, defaultHealthpoint, defaultDefense, defaultDamgeOutput, mapCode, level, difficulty, msg);
        this.IS_BOSS = isBoss;
        updateLevel();
        setCurrentHealth(10000);
    }    
    public boolean isBoss() {
        return IS_BOSS;
    }
}
