package core_engine;

import java.util.HashMap;

/**
 * used in the parser as a ref. to legal commands to use. 
 * @author  Groupe 12
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class CommandWords
{
    /**
     * 
     */
    private HashMap<String, CommandWord> validCommands;
    /**
     * 
     */
    public CommandWords()
    {
        validCommands = new HashMap<String, CommandWord>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }
    /**
     * 
     * @param commandWord the command world to be found
     * @return a commandword.
     */
    public CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = validCommands.get(commandWord);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
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
