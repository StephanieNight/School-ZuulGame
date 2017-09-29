package gameframework;

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

    /**
     * Constructor 
     */
    public Parser() 
    {
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
}
