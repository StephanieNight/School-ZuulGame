/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

/**
 *
 * @author BenPaxIndustries
 */
public class GhostWanderer extends Actor
{
    String greeting;
    String[] tips;
    
    public GhostWanderer(String name, Message msg)
    {
        super(name, 1, 1, 1, 'g', 1, 1, msg);
        this.tips = new String[5];
        this.greeting = greeting();
        tips[0] = tip1();
        tips[1] = tip2();
        tips[2] = tip3();
        tips[3] = tip4();
        tips[4] = tip5();
    }
    
    public String getQuote(int number)
    {
        return tips[number];
    }

    private String greeting()
    {
        return "Hello wanderer! (speech)";
    }

    private String tip1()
    {
        return "The map icon on the bottom opens the minimap.";
    }
    
    private String tip2()
    {
        return "You can use the four buttons on the right"
                + " to move around in the maze.";
    }
    
    private String tip3()
    {
        return "If you press search on the bottom of your screen,"
                + " you may find items in the current room.";
    }
    
    private String tip4()
    {
        return "I recommend you to find weapons "
                + "and armor before you face Zuul.";
    }
    
    private String tip5()
    {
        return "There's chests hidden around the maze. "
                + "Find them to get equipment.";
    }
    public String getQuote()
    {
        return getQuote((int)(Math.random() * tips.length));
    }
    
}
