
package nicolai;

import Stephie_build.GameEngine;

/**
 *
 * @author nicol
 */
public class Monster extends Actor
{
    private final boolean IS_BOSS;
    
    public Monster(String name, int defaultHealthpoint, int defaultDefense, int defaultDamgeOutput, char mapCode, boolean isBoss) {
        super(name, defaultHealthpoint, defaultDefense, defaultDamgeOutput, mapCode);
        this.IS_BOSS = isBoss;
        this.setLevel(GameEngine.getDifficulty());
    }
    
    public boolean isBoss() {
        return IS_BOSS;
    }
}
