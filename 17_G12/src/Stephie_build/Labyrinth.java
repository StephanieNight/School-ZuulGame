/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;

import java.util.Arrays;
import java.util.Collections;
import nicolai.*;

/**
 *
 * @author Stephanie
 */
public class Labyrinth
{
    private final int SIZE;
    private Room[][] maze;
    private boolean isLoop = false;  
    public Labyrinth(int size) 
    {
        this.SIZE = size;
        maze = new Room[this.SIZE][this.SIZE];
        // fills the Maze with emptie 
        for(int r = 0; r <size; r++)
        {
            for(int c = 0; c <size; c++)
            {
                maze[r][c] = new Room("A room");
            }
        }
        generateMaze(0, 0);
    }  
    public boolean spawnPlayer(int x, int y,Actor actor)
    {
        if (maze[x][y].getPlayer()== null)
        {
            maze[x][y].setPlayer(actor);
            actor.setCurrentRoom(maze[x][y]);
            return true;
        }
        else 
        {
            return false;
        } 
    }
    public boolean spawnMonster(int x, int y,Actor actor)
    {
        if (maze[x][y].getMonster()== null)
        {
            maze[x][y].setMonster(actor);
            actor.setCurrentRoom(maze[x][y]);
            return true;
        }
        else 
        {
            return false;
        } 
    }
    public void movePlayer(Actor actor,Room NextRoom)
    {        
        actor.getCurrentRoom().setPlayer(null); 
        NextRoom.setPlayer(actor);
        actor.setCurrentRoom(NextRoom);      
    } 
    public void moveMonster(Actor actor,Room NextRoom)
    {        
        actor.getCurrentRoom().setMonster(null); 
        NextRoom.setMonster(actor);
        actor.setCurrentRoom(NextRoom);      
    } 
    public void display() 
    {
        for (int i = 0; i < this.SIZE; i++) {
                // draw the north edge
                for (int j = 0; j < this.SIZE; j++) {
                        System.out.print(!maze[j][i].hasExit(DIR.N.direction)  ? "+---" : "+   ");
                }
                System.out.println("+");
                // draw the west edge
                for (int j = 0; j < this.SIZE; j++) {
                        System.out.print(!maze[j][i].hasExit(DIR.W.direction) ? "| " : "  ");
                        System.out.print(maze[j][i].getMapCode());
                        System.out.print(" ");
                        
                }
                System.out.println("|");
        }
        // draw the bottom line
        for (int j = 0; j < this.SIZE; j++) {
                System.out.print("+---");
        }
        System.out.println("+");
    }    
    private void generateMaze(int currentX, int currentY) 
    {
        DIR[] dirs = DIR.values(); // gets all 4 enums for direction
        Collections.shuffle(Arrays.asList(dirs)); // mixes them up to get a reandom direction.
        for (DIR dir : dirs) // loops through each posible direction
        {
            int nextX = currentX + dir.dx;      // gets X for the next Room 
            int nextY = currentY + dir.dy;      // gets Y for the nex Room
            if (isInsideMaze(nextX, this.SIZE)  // checks if x is indside maze.
             && isInsideMaze(nextY, this.SIZE))  // checks if y is indside maze.
            { 
                // checks if room has no exits 
                if(!maze[nextX][nextY].hasAnyExits())
                {
                   // Add Exit to Current Room
                   maze[currentX][currentY].setExit(dir.direction, maze[nextX][nextY]);
                   // Add oppesite exit to next Room to bind them together
                   maze[nextX][nextY].setExit(dir.opposite.direction,maze[currentX][currentY]); 
                   // goes to next Cell and start the proces over again untill all rooms is full.
                   generateMaze(nextX, nextY);
                    
                }
                else
                {
                    // we have reached a dead end, checks if we should punch a hole 
                    // before backtracking to make sure the map is a loop
                    if(!maze[nextX][nextY].hasExit(dir.opposite.direction) // is there allready a exit to this room
                        &&(!isLoop || ((int)(Math.random()*20)==5))) // force or random
                    {
                        // Add Exit to Current Room
                        maze[currentX][currentY].setExit(dir.direction, maze[nextX][nextY]);
                        // Add oppesite exit to next Room to bind them together
                        maze[nextX][nextY].setExit(dir.opposite.direction,maze[currentX][currentY]);
                        // the maze is now a loop
                        isLoop = true;   // no need to force no more                     
                    }
                }                
            }
        }
    }
    /*
     * Why is this static. ?
     */
    private static boolean isInsideMaze(int v, int upper) 
    {
            return (v >= 0) && (v < upper);
    }   
    public boolean hasConflict()
    {
        for(Room[] r : maze)
        {
            for(Room c:r)
            {
                if(c.isConflict())
                {
                    return true;
                }
               
            }            
        }
        return false;
        
    }
    private enum DIR 
    {
        N("north", 0, -1), S("south", 0, 1), E("east", 1, 0), W("west", -1, 0);
        private final String direction; // binary representation of direction i 4 bits. 
        private final int dx;  // Direction in the array out of the x axis 
        private final int dy;  // Direction in the array out of the y axis
        private DIR opposite;  // deklares the opposite direction for ref.
 
        // use the static initializer to resolve forward references
        static {
                N.opposite = S;
                S.opposite = N;
                E.opposite = W;
                W.opposite = E;
        }

        private DIR(String dir, int dx, int dy)
        {
                this.direction = dir;
                this.dx = dx;
                this.dy = dy;
        }
    };    
} 
    /*
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


    public void renderMap() 
    {
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
                if(rm.hasExit("west"))
                {
                    System.out.print("-");  
                }
                else
                {
                     System.out.print(" ");  
                }
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
*/