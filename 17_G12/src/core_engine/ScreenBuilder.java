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
public class ScreenBuilder {
    public static Image buildmap(Room[][] maze)            
    {
        String path ="C:\\Users\\Stephanie\\Dropbox\\SDUX\\Civ -(batchelor)  Software Enginere\\OOP\\NetBeansProjects\\_SemsterProjects\\17G12SemesterProject\\17_G12\\assets\\Minimap tiles";
         try {
            //split
            BufferedImage returnedView = new BufferedImage(543,543,BufferedImage.TYPE_INT_ARGB);
            
            BufferedImage topCornerLeft = ImageIO.read(new File(path+"\\bend south east.png"));
            BufferedImage topCornerRigth = ImageIO.read(new File(path+"\\bend south west.png"));
            BufferedImage buttomCornerLeft = ImageIO.read(new File(path+"\\bend north east.png"));
            BufferedImage bottomCornerRigth= ImageIO.read(new File(path+"\\bend north west.png"));
            
            BufferedImage leftSide = ImageIO.read(new File(path+"\\T way north south east.png"));
            BufferedImage RigthSide = ImageIO.read(new File(path+"\\T way south west north.png"));
            BufferedImage top = ImageIO.read(new File(path+"\\T way south, east, west.png"));
            BufferedImage botton= ImageIO.read(new File(path+"\\T way north east west.png"));
            
            BufferedImage center = ImageIO.read(new File(path+"\\Crossroads.png"));
           
            Graphics2D graph = returnedView.createGraphics();
            graph.drawImage(topCornerLeft, 0, 0,null);
            graph.drawImage(top, 0, 182,null);
            graph.drawImage(topCornerRigth, 0,363,null);
            
            graph.drawImage(leftSide, 182, 0,null);
            graph.drawImage(center, 182, 182,null);
            graph.drawImage(RigthSide, 182, 363,null);
           
            graph.drawImage(buttomCornerLeft, 363, 0,null);
            graph.drawImage(botton, 363, 182,null);
            graph.drawImage(bottomCornerRigth, 363, 363,null);
            
            Image toview=SwingFXUtils.toFXImage(returnedView,null);
            
            return toview;
            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
            
        }
         return null;
    }    
    public static Image buildviewport(Room foreground,Room background)            
    {
        String path ="C:\\Users\\Stephanie\\Dropbox\\SDUX\\Civ -(batchelor)  Software Enginere\\OOP\\NetBeansProjects\\_SemsterProjects\\17G12SemesterProject\\17_G12\\assets\\Minimap tiles";
         try {
            //split
            BufferedImage image = new BufferedImage(543,543,BufferedImage.TYPE_INT_ARGB);
            
            BufferedImage topCornerLeft = ImageIO.read(new File(path+"\\bend south east.png"));
            BufferedImage topCornerRigth = ImageIO.read(new File(path+"\\bend south west.png"));
            BufferedImage buttomCornerLeft = ImageIO.read(new File(path+"\\bend north east.png"));
            BufferedImage bottomCornerRigth= ImageIO.read(new File(path+"\\bend north west.png"));
            
            BufferedImage leftSide = ImageIO.read(new File(path+"\\T way north south east.png"));
            BufferedImage RigthSide = ImageIO.read(new File(path+"\\T way south west north.png"));
            BufferedImage top = ImageIO.read(new File(path+"\\T way south, east, west.png"));
            BufferedImage botton= ImageIO.read(new File(path+"\\T way north east west.png"));
            
            BufferedImage center = ImageIO.read(new File(path+"\\Crossroads.png"));
           
            Graphics2D graph = image.createGraphics();
            graph.drawImage(topCornerLeft, 0, 0,null);
            graph.drawImage(top, 0, 182,null);
            graph.drawImage(topCornerRigth, 0,363,null);
            
            graph.drawImage(leftSide, 182, 0,null);
            graph.drawImage(center, 182, 182,null);
            graph.drawImage(RigthSide, 182, 363,null);
           
            graph.drawImage(buttomCornerLeft, 363, 0,null);
            graph.drawImage(botton, 363, 182,null);
            graph.drawImage(bottomCornerRigth, 363, 363,null);
            
            Image toview=SwingFXUtils.toFXImage(image,null);
            
            return toview;
            
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
         return null;
    }
}
