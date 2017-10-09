/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stephie_build;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author Stephanie
 */
public class Viewport extends JPanel
{
    private BufferedImage forgroundScreen; // forground picture, the room that the player is staying in
    private BufferedImage backgroundScreen; // smaller picture behind the main one to give a feel of debth

    public Viewport() 
    { 
        // sets the background to be black.
        this.setBackground(Color.BLACK);       
    }
    public void changeRooms(int forgroundID,int BackgroundID )
    {
        if(forgroundID==1)
        {
            try
            {                
                forgroundScreen = ImageIO.read(new File("assets\\rooms\\straigth.png"));
                backgroundScreen = ImageIO.read(new File("assets\\rooms\\CornerLeft.png"));                
            } 
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            this.repaint();
        }
        else if(forgroundID==2)
        {
            try
            {                
                forgroundScreen = ImageIO.read(new File("assets\\rooms\\straigth.png"));
                backgroundScreen = ImageIO.read(new File("assets\\rooms\\CornerRigth.png"));                
            } 
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }
            this.repaint();
        } 
    }
    @Override
    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g);
                
        //scales the backound image;
        int w = backgroundScreen.getWidth();
        int h = backgroundScreen.getHeight();
        BufferedImage scaledBGScreen = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(0.5,0.5);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        scaledBGScreen = scaleOp.filter(backgroundScreen, scaledBGScreen);
        
        //gets location to put BG Sceen.
        int frameW = this.getWidth();
        int frameH =this.getHeight();
        int bgX =(frameW/2)-(frameW/4);
        int bgY =(frameH/2)-(frameH/4);
        
        //Prints the imagies.       
        g.drawImage(scaledBGScreen, bgX,bgY, this); // see javadoc for more info on the parameters   
        g.drawImage(forgroundScreen, 0, 0, this); // see javadoc for more info on the parameters          
    }
}