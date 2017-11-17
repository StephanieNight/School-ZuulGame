/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Stephanie
 */
public class RenderEngine implements IGameConstants{
    public static Image renderMiniMapView(Room[][] maze)      
    {
                String north = "north";
        String south = "south";
        String east = "east";
        String west = "west";
        try {             
        int mazeSize = maze.length;
            //set basic canves
            int size = 181* mazeSize;
            BufferedImage renderedView = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = renderedView.createGraphics();
            for(int row = 0; row < mazeSize; row++){
                for(int col = 0; col < mazeSize; col++){
                    Room room = maze[row][col];
                    BufferedImage tile = new BufferedImage(181,181,BufferedImage.TYPE_INT_ARGB); // stars as a blank imagae
                    switch (room.getExits().length)
                    {
                            case 1:
                                // <editor-fold defaultstate="collapsed" desc="dead ends">
                                if(room.getExits()[0].equals(north))
                                {
                                    //dead end exit north
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[9]));  
                                    break;
                                }
                                else if (room.getExits()[0].equals(south))
                                {
                                    //dead end exit sout
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[12]));  
                                    break;

                                }
                                else if (room.getExits()[0].equals(east))
                                {
                                    //dead end exit east
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[11]));  
                                    break;
                                }
                                else 
                                {
                                    //dead end ext west
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[10]));  
                                    break;
                                }
                                // </editor-fold>
                            case 2:
                                // <editor-fold defaultstate="collapsed" desc="Straigths and corners">
                                if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south)))
                                {
                                    //straigt room north south
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[14]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                                    && (room.getExits()[1].equals(east) || room.getExits()[1].equals(west)))
                                {
                                    //straigt room east west
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[13]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east)))
                                {
                                    //cornor room exits north and east
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[2]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(west)) 
                                    && (room.getExits()[1].equals(north) || room.getExits()[1].equals(west)))
                                {
                                    //cornor room exits north and west
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[3]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                                    && (room.getExits()[1].equals(south) || room.getExits()[1].equals(east)))
                                {
                                    //cornor room exits south and east
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[0]));  
                                    break;
                                }
                                else
                                {
                                    //cornor room exits south and west
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[1]));  
                                    break;
                                }
                                // </editor-fold>
                            case 3:
                                // <editor-fold defaultstate="collapsed" desc="T Rooms">
                                if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(east)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(east))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(east)))
                                {
                                    //T-room exits north, south and east
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[4]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(south) || room.getExits()[0].equals(west)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(south) || room.getExits()[1].equals(west))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(south) || room.getExits()[2].equals(west)))
                                {
                                    //T-room exits north, south and west
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[5]));  
                                    break;
                                }
                                else if((room.getExits()[0].equals(north) || room.getExits()[0].equals(east) || room.getExits()[0].equals(west)) 
                                            && (room.getExits()[1].equals(north) || room.getExits()[1].equals(east) || room.getExits()[1].equals(west))
                                        && (room.getExits()[2].equals(north) || room.getExits()[2].equals(east) || room.getExits()[2].equals(west)))
                                {
                                    //T-room exits north, east and west
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[7]));  
                                    break;
                                }
                                else 
                                {
                                    //T-room exits south, east and west
                                     tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[6]));  
                                    break;
                                }
                                // </editor-fold>
                            default:
                                //croos roads
                                tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[8]));  
                                break;
                    } 
                    graph.drawImage(tile, 181*row, 181*col,null);                   
                }
            }
            return SwingFXUtils.toFXImage(renderedView,null);         
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return null;        
    }
    public static Image renderMiniMapViewOLD(Room[][] maze)            
    { 
        try {             
        int mazeSize = maze.length;
            //set basic canves
            int size = 181* mazeSize;
            BufferedImage renderedView = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = renderedView.createGraphics();
            for(int row = 0; row < mazeSize; row++){
                for(int col = 0; col < mazeSize; col++){
                    String[] exits = maze[row][col].getExits(); 
                    BufferedImage tile = new BufferedImage(181,181,BufferedImage.TYPE_INT_ARGB); // stars as a blank imagae
                    switch(exits.length)
                    {    
                       
                        case(1): 
                            // <editor-fold defaultstate="collapsed" desc="Case dead ends"> 
                            switch(exits[0])
                            {
                                case ("east"):
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[11]));  
                                    break;
                                case ("west"):
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[10]));  
                                    break;
                                case ("south"):
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[12]));  
                                    break;
                                case ("north"):
                                    tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[9]));  
                                    break;
                            }
                            // </editor-fold>
                            break;

                        case(2):
                            
                            switch(exits[0])
                            {
                                case ("east"):
                                    switch(exits[1])
                                    {                                     
                                        case ("west"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[13]));  
                                            break;
                                        case ("south"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[0]));  
                                            break;
                                        case ("north"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[2]));  
                                            break;
                                    }                               
                                    break;
                                case ("west"):
                                    switch(exits[1])
                                    {
                                        case ("east"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[11]));  
                                            break;
                                        case ("south"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[12]));  
                                            break;
                                        case ("north"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[9]));  
                                            break;
                                    }
                                    break;
                                case ("south"):
                                      switch(exits[1])
                                    {
                                        case ("east"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[11]));  
                                            break;
                                        case ("west"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[10]));  
                                            break;
                                        case ("north"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[9]));  
                                            break;
                                    }
                                    break;
                                case ("north"):
                                    switch(exits[1])
                                    {
                                        case ("east"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[11]));  
                                            break;
                                        case ("west"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[10]));  
                                            break;
                                        case ("south"):
                                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[12]));  
                                            break;
                                    }
                                    break;
                            }
                        break;
                        
                        case(3):
                            
                            
                            
                            
                            
                            
                            break;
                        case(4):
                            
                            
                            tile = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[8]));    
                            break;
                        default:
                            break;
                    }
                    graph.drawImage(tile, 181*row, 181*col,null);
                   
                   
                   
                   
                }
            }
            Image toview=SwingFXUtils.toFXImage(renderedView,null);
            
            return toview;            
        } catch (IOException ex) {
             System.out.println(ex.getMessage());
        }
        return null;
    }   
    public Image renderMazeView(Room foreGround, Room backGround) {
    try {
//            //set basic canves
//            BufferedImage renderedView = new BufferedImage(700,600,BufferedImage.TYPE_INT_ARGB);
//            
//            BufferedImage backGround = ImageIO.read(new File(FILEPATH_MAZEVIEW_DIR+"\\CornerLeft.png"));
//            
//            Graphics2D graph = renderedView.createGraphics();
//            graph.drawImage(backGround, 0, 0,null);
//            
//            Image toview=SwingFXUtils.toFXImage(renderedView,null);
//            
//            return toview;
            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
         return null;
    }
}
