
package nicolai;

import Stephie_build.GameEngine;

/**
 *
 * @author nicol
 */
public class Monster extends Actor
{
    
    public Monster(String name) {
        super(name, 30, 30, 20, 'M');
        this.setLevel(GameEngine.getDifficulty());
    }
    
}
