/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

/**
 *
 * @author Stephanie
 */
public class Labyrinth 
{
    private Room[][] map;
    public Labyrinth(int size) 
    {
        generateMap(size);
    }
    public Room getNeigthboor(Room currentRoom, String direction) 
    {
        return new Room("lol");
    }
    public boolean spawnMobs() 
    {
        return true;
    }
    public void goRoom(Command command) 
    {

    }
    public void renderMap() 
    {
        int size = map.length;
        System.out.println("");// fresh line
        for (int r = 0; r < size; r++) 
        {
            for (int c = 0; c < size;c++) 
            {
                if(map[r][c]==null)
                {
                    return;
                }
                Room rm = map[r][c];
                System.out.print("["+ rm.getOccupant() +"]");
                if(rm.hasExit("east"))
                {
                    System.out.print("-");  
                }
                else
                {
                     System.out.print(" ");  
                }
            }
            System.out.println("");
            if(r!=size-1)
            {
                for (int c = 0; c < size;c++) 
                {
                    Room rm = map[r][c];
                    System.out.print(" ");
                    if(rm.hasExit("south"))
                    {
                        System.out.print("|");  
                    }
                    else
                    {
                        System.out.print(" ");  
                    }
                    System.out.print("  ");
                }
                System.out.println("");
            }
        }
    }
    private Room[] getSpawnableRooms() 
    {
        return new Room[0];
    }
    private void generateMap(int size) 
    {
        // fuck hvad den var før nu skal der testes
        size = 6;
        map = new Room[size][size];
        //
        // improv Generator
        for (int r = 0; r < size; r++) 
        {
            for (int c = 0; c < size; c++) 
            {
                //System.out.println("r : " + r +" c : "+c);
                if (c == 0 && r == 0)// Top west corner
                {
                    String[] exits = {"east", "south"};
                    map[r][c] = generateRoom(exits);
                    map[r][c].setOccupant('P');
                   // System.out.println("Exits for room is Top West Corner ");

                } 
                else if (c == size - 1 && r == 0)//top east corner
                {
                    String[] exits = {"west", "south"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is top east corner");
                } 
                else if (c == 0 && r == size - 1)// botton  west corner
                {
                    String[] exits = {"north", "east"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is botton east corner");

                } 
                else if (c == size - 1 && r == size - 1)// botton east corner
                {
                    String[] exits = {"north", "west"};
                    map[r][c] = generateRoom(exits);
                    map[r][c].setOccupant('Z');
                    //System.out.println("Exits for room is botton east corner");
                }
                else if (r == 0 && c >0 && c<size-1)// top edge
                {
                    String[] exits = {"east", "south", "west"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is top edge");
                }
                else if (r == size - 1 && c >0 && c<size-1)// bottom edge
                {
                    String[] exits = {"east", "north", "west"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is botton edge");
                }
                else if (c == 0) // west edge. 
                {
                    String[] exits = {"east", "south", "north"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is west edge ");
                } 
                
                else if (c == size - 1) // east edge.
                {
                    String[] exits = {"south", "north", "west"};
                    map[r][c] = generateRoom(exits);
                    //System.out.println("Exits for room is east edge");
                }
                else // middle 
                {
                    String[] exits = {"east", "south", "north", "west"};
                    map[r][c] = generateRoom(exits);
                    map[r][c].setOccupant('M');
                    //System.out.println("Exits for room is middle");
                }
                //System.out.println("Generating map with values r: "+r+" and c: "+c);
                //renderMap();
                //System.out.println("");
            }
            //System.out.println("");
            //renderMap();
        }
    }
    private Room generateRoom(String[] exits) 
    {
        Room genericRoom = new Room("generic room");
        for (String s : exits) {
            int i = (int)(Math.random()*2);
            if (i ==1)
            {
                genericRoom.setExit(s, null);
            }
        }
        return genericRoom;
    }
}
