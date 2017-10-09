
package nicolai;

import Stephie_build.GameEngine;

/**
 *
 * @author nicol
 */
public class Minions extends Actor
{
    
    public Minions(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'M');
        this.setLevel(GameEngine.getDifficulty());
    }
    
}
