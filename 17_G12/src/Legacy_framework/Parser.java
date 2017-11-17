package Legacy_framework;

import Legacy_framework.CommandWords;
import Legacy_framework.Command;
import Legacy_framework.CombatCommand;
import Legacy_framework.CombatCommandWords;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Parsses commands from the command line to the game.
 * @author Groupe 12
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 */
public class Parser 
{
    private CommandWords commands;
    private Scanner reader;
    private CombatCommandWords combatCommands;

    /**
     * Constructor 
     */
    public Parser() 
    {
        combatCommands = new CombatCommandWords();
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }
    /**
     * gets the command from the command line. 
     * @return a parsed, command if found. 
     */
    public Command getCommand() 
    {
        
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new Command(commands.getCommandWord(word1), word2);
    }
    /**
     * prints all commands.
     */
    public void showCommands()
    {
        commands.showAll();
    }
    /*
     * gets the difficulty from 1-5 if errors occur return -1.
     */
    public int getDifficulty()
    { 
        System.out.println("choose your difficulty. from 1-5");
        System.out.print("> ");

        String inputLine = reader.nextLine();
        try
        {
            int i = Integer.parseInt(inputLine);
            if(i >0 && i <6)
            {
                return i;
            }
            return -1;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return -1;
        }        
    }
        public CombatCommand getCombatCommand() 
    {
        
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }

        return new CombatCommand(combatCommands.getCombatCommandWord(word1), word2);
    }
    /**
     * prints all commands.
     */
    public void showCombatCommands()
    {
        combatCommands.showAll();
    }
    
}
