/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Legacy_framework;

import Legacy_framework.CombatCommandWord;
import java.util.HashMap;

/**
 *
 * @author Michael Kolling and David J. Barnes
 * modified by Ahmet, Malte and Nicolai
 */
public class CombatCommandWords {
     /**
     * Hashmap over valid commands with strings as keys and combat command word
     * enums as values. 
     */
    private HashMap<String, CombatCommandWord> validCommands;
    /**
     * Constructor that creates a hashmap with all the valid commands.
     */
    public CombatCommandWords()
    {
        validCommands = new HashMap<String, CombatCommandWord>();
        for(CombatCommandWord command : CombatCommandWord.values()) {
            if(command != CombatCommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }
    /**
     * 
     * @param commandWord the command word to be found.
     * @return a commandword.
     */
    public CombatCommandWord getCombatCommandWord(String commandWord)
    {
        CombatCommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CombatCommandWord.UNKNOWN;
        }
    }
    /**
     * Checks if the given string is a valid command. 
     * @param aString
     * @return 
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    /**
     * prints all commands, used in the parser to show all available commands. 
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }   
}
