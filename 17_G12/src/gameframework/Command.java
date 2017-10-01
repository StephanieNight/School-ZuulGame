package gameframework;

/** 
 * this is the command class it is used ass a way of storring valid commands 
 * for the game. it is primarily used by the parser class to parse input 
 * from the command line to the game.
 * @author Michael Kolling and David J. Barnes
 * @author Groupe 12.
 * @version 2006.03.30
 */
public class Command
{
    private CommandWord commandWord;
    private String secondWord;
    /**
    * the constructer.
    * @param commandWord the main command word associated like go, 
    * help, and so on.
    * @param secondWord used then you need to pair the commant with something 
    * like what direction to go in
    */
    public Command(CommandWord commandWord, String secondWord)
    {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }
    /**
     * Returns the command word of the instqance class
     * @return Commandword
     */
    public CommandWord getCommandWord()
    {
        return commandWord;
    }
    /**
     * Returns the second word word of the instqance class
     * @return Second word that is a string
     */    
    public String getSecondWord()
    {
        return secondWord;
    }
    /**
     * is this a unknown command.
     * @return a true or false value.
     */
    public boolean isUnknown()
    {
        return (commandWord == CommandWord.UNKNOWN);
    }
    /**
     * Returms when ever or not that the command has a second word, used in game 
     * to check if the go command has a direction associated with it.
     * @return a True or False;
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}