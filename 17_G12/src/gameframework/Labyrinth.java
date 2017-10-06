/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameframework;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author Stephanie
 */
public class Labyrinth
{
    private final int size;
    private Room[][] map;
    private final int[][] maze;
    
    public Labyrinth(int size) 
    {
        this.size = size;
        maze = new int[this.size][this.size];
        generateMaze(0, 0);
        //generateMap(size);
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
    private void generateMapOLD(int size) 
    {
        // fuck hvad den var før nu skal der testes
        size = 8;
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
                    int i = (int)(Math.random()*2);
                    if (i ==1)
                    {
                        map[r][c].setOccupant('M');
                    }
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
    private void generateMap(int size)
    {
        
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
    public void display() 
    {
        for (int i = 0; i < this.size; i++) {
                // draw the north edge
                for (int j = 0; j < this.size; j++) {
                        System.out.print((maze[j][i] & 1) == 0 ? "+---" : "+   ");
                }
                System.out.println("+");
                // draw the west edge
                for (int j = 0; j < this.size; j++) {
                        System.out.print((maze[j][i] & 8) == 0 ? "|   " : "    ");
                }
                System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < this.size; j++) {
                System.out.print("+---");
        }
        System.out.println("+");
    }
    private void generateMaze(int cx, int cy) 
    {
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs)
        {
            int nx = cx + dir.dx;
            int ny = cy + dir.dy;
            if (between(nx, this.size) && between(ny, this.size)
                            && (maze[nx][ny] == 0)) 
            {
                maze[cx][cy] |= dir.bit;
                maze[nx][ny] |= dir.opposite.bit;
                generateMaze(nx, ny);
            }
        }
    }
    private static boolean between(int v, int upper) 
    {
            return (v >= 0) && (v < upper);
    }
    private enum DIR 
    {
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dx;
        private final int dy;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
                N.opposite = S;
                S.opposite = N;
                E.opposite = W;
                W.opposite = E;
        }

        private DIR(int bit, int dx, int dy) {
                this.bit = bit;
                this.dx = dx;
                this.dy = dy;
        }
    };    
}