/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import gameframework.CommandWord;
import java.util.HashMap;

/**
 *
 * @author AC
 */
public enum CombatCommandWord {
     /**
     * Creates Enums for each commandword
     */
    ATTACK("attack"), FLEE("flee"), INVENTORY("inventory"), USE_ITEM("use"), HELP("help"), QUIT("quit"), UNKNOWN("?");
    
    private String commandString;
    /**
     * Constructer
     * @param commandString 
     */
    CombatCommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    /**
     * gets a string representation of the Commandword
     * @return String 
     */
    public String toString()
    {
        return commandString;
    }
    
}
