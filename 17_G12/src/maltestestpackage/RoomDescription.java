/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maltestestpackage;

import core_engine.Room;
/**
 * constructor to set a description fitting the number of exits a given room has.
 * @author Malte
 */
public class RoomDescription {
    
    
    public RoomDescription()
    {
        
    }
    
    
    public void generateMiniMap(Room room)
    {
       
        String north = "north";
        String south = "south";
        String east = "east";
        String west = "west";
        
        switch (room.getExits().length)
        {
                case 1:
                    if(room.getExits()[0].equals(north))
                    {
                        //dead end exit north
                        room.setPictureID_MiniMap(1);
                        break;
                    }
                    else if (room.getExits()[0].equals(south))
                    {
                        //dead end exit sout
                        room.setPictureID_MiniMap(2);
                        break;
                        
                    }
                    else if (room.getExits()[0].equals(east))
                    {
                        //dead end exit east
                        room.setPictureID_MiniMap(3);
                        break;
                    }
                    else 
                    {
                        //dead end ext west
                        room.setPictureID_MiniMap(4);
                        break;
                    }
                    
                    
                case 2:

                    if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south)) 
                        && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south)))
                    {
                        //straigt room north south
                        room.setPictureID_MiniMap(5);
                        break;
                    }
                    else if((room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                        && (room.getExits()[1].equals(east) || room.getExits()[1].equals(west)))
                    {
                        //straigt room east west
                        room.setPictureID_MiniMap(6);
                        break;
                    }
                    else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east)) 
                        && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east)))
                    {
                        //cornor room exits north and east
                        room.setPictureID_MiniMap(7);
                        break;
                    }
                    else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(west)) 
                        && (room.getExits()[1].equals(north) || room.getExits()[1].equals(west)))
                    {
                        //cornor room exits north and west
                        room.setPictureID_MiniMap(8);
                        break;
                    }
                    else if((room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                        && (room.getExits()[1].equals(south) || room.getExits()[1].equals(east)))
                    {
                        //cornor room exits south and east
                        room.setPictureID_MiniMap(9);
                        break;
                    }
                    else
                    {
                        //cornor room exits south and west
                        room.setPictureID_MiniMap(10);
                        break;
                    }
                            
                    
                case 3:
                    if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                                && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(east))
                            && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(east)))
                    {
                        //T-room exits north, south and east
                        room.setPictureID_MiniMap(11);
                        break;
                    }
                    else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(west)) 
                                && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(west))
                            && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(west)))
                    {
                        //T-room exits north, south and west
                        room.setPictureID_MiniMap(12);
                        break;
                    }
                    else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                                && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east) || room.getExits()[1].equals(west))
                            && (room.getExits()[2].equals(north) || room.getExits()[2].equals(east) || room.getExits()[2].equals(west)))
                    {
                        //T-room exits north, east and west
                        room.setPictureID_MiniMap(13);
                        break;
                    }
                    else 
                    {
                        //T-room exits south, east and west
                        room.setPictureID_MiniMap(14);
                        break;
                    }
                  
                default:
                    //croos roads
                    room.setPictureID_MiniMap(15);
                    break;
        }               
    }
    
    
}
