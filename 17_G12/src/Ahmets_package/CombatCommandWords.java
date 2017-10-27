/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import java.util.HashMap;

/**
 *
 * @author AC
 */
public class CombatCommandWords {
     /**
     * 
     */
    private HashMap<String, CombatCommandWord> validCommands;
    /**
     * 
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
     * @param commandWord the command world to be found
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
     * 
     * @param aString
     * @return 
     */
    public boolean isCommand(String aString)
    {
        return validCommands.containsKey(aString);
    }
    /**
     * prints all commands, used in the parser to show all awailable commands. 
     */
    public void showAll() 
    {
        for(String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }   
}
