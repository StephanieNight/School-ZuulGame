/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import Stephie_build.Room;
/**
 * constructor to set a description fitting the number of exits a given room has.
 * @author Malte
 */
public class RoomDescription {
    private int numberOfExits;
    String description;
    //Image File something something;
    public RoomDescription(Room room)
    {
        numberOfExits = room.getExits().length;
        switch (numberOfExits)
        {
                case 1:
                    this.description = "at a dead end.";
                    break;
                    
                case 2:
                    DIR[] dir = DIR.values();
                    for(DIR dir1: dir) 
                    {
                        if(room.getExits()[0].equals(dir1.direction))
                        {
                            this.description = "at a straigt path.";
                        }
                        else
                        {
                            this.description = "at a bend in the path.";
                        }
                    }
                    break;
                case 3:
                    this.description = "at a split in the path.";
                    break;
                default:
                    this.description = "at a crossroad.";
                    break;
        }           
    room.changeDescription(this.description);    
    }
    
    
    /**
     * copied the enum DIR to make it easily accesible.
     */
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
    
}
}
