/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nicolai;

/**
 *
 * @author nicol
 */
public class Player extends Actor{
    
    public Player(String name, int defaultHealthpoint, int defaultDefense, int DefaultDamgeOutput) {
        super(name, defaultHealthpoint, defaultDefense, DefaultDamgeOutput, 'P');
    }    
}
