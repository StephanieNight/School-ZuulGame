/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ahmets_package;

import gameframework.CommandWord;

/**
 * Has the same fuction as the Command class, but this class is for the combat 
 * commands. 
 * @author Michael Kolling and David J. Barnes
 * modified by Malte, Ahmet og Nicolai
 */
public class CombatCommand {
    private CombatCommandWord commandWord;
    private String secondWord;
    /**
    * the constructor.
    * @param commandWord the main command word associated like attack, 
    * help, and so on.
    * @param secondWord used then you need to pair the command with something 
    * like what direction to go in
    */
    public CombatCommand(CombatCommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    /**
     * Returns the command word of the instance class
     * @return Commandword
     */
    public CombatCommandWord getCombatCommandWord()
    {
        return commandWord;
    }
    /**
     * Returns the second word word of the instance class
     * @return Second word that is a string
     */    
    public String getSecondWord()
    {
        return secondWord;
    }
    /**
     * Checks if this is an unknown command.
     * @return a true or false value.
     */
    public boolean isUnknown()
    {
        return (commandWord == CombatCommandWord.UNKNOWN);
    }
    /**
     * Returns whenever or not that the command has a second word, used in game 
     * to check if the useItem command has an item id associated with it.
     * @return a True or False;
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}
