/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core_engine;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;

/**
 *
 * @author Stephanie
 */
public class RenderEngine implements IGameConstants{
    public static Image buildmap(Room[][] maze)            
    { try {             
            //set basic canves
            int size = 181* mazeSize;
            BufferedImage renderedView = new BufferedImage(size,size,BufferedImage.TYPE_INT_ARGB);
            Graphics2D graph = renderedView.createGraphics();
            for(int row = 0; row < mazeSize; row++){
                for(int col = 0; col < mazeSize; col++){
                    
                   BufferedImage backGround;
                   
                   backGround = ImageIO.read(new File(FILEPATH_MINIMAP_DIR+FILENAME_PICTURES_MINIMAP[1])); 
                   
                   graph.drawImage(backGround, 181*row, 181*col,null);
                }
            }
            Image toview=SwingFXUtils.toFXImage(renderedView,null);
            
            return toview;            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        return null;
    }   
    public Image renderMazeView(Room foreGround, Room backGround) {
    try {
            //set basic canves
            BufferedImage renderedView = new BufferedImage(700,600,BufferedImage.TYPE_INT_ARGB);
            
            BufferedImage backGround = ImageIO.read(new File(FILEPATH_MAZEVIEW_DIR+"\\CornerLeft.png"));
            
            Graphics2D graph = renderedView.createGraphics();
            graph.drawImage(backGround, 0, 0,null);
            
            Image toview=SwingFXUtils.toFXImage(renderedView,null);
            
            return toview;
            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
         return null;
    }
}
