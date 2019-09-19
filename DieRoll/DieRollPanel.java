//********************************************************************
//  DieRollPanel.java       Author: Lewis/Loftus
//
//  Represents the primary panel for the DieRoll program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieRollPanel extends JPanel
{
   private final int WIDTH = 300, HEIGHT = 100;
   private final int DELAY = 150, IMAGE_SIZE = 35;
   //a random list of names of images to display
   private static String[] imageList = { 
                                        "die11.jpg","die22.jpg","die53.jpg","die43.jpg",
                                        "die62.jpg","die31.jpg"
                                      };
   private static ImageIcon image;
   private static int imageNum = -1;
   private static boolean soundFlag = true;
   private Timer timer;
   private int x, y, moveX, moveY;

   //-----------------------------------------------------------------
   //  Sets up the panel, including the timer for the animation.
   //-----------------------------------------------------------------
   public DieRollPanel()
   {
      timer = new Timer(DELAY, new DieRollListener());

      x = 0;
      y = 40;
      moveX = 15;
      moveY = -5;
      setPreferredSize (new Dimension(WIDTH, HEIGHT));
      setBackground (Color.black);
      timer.start();
   }

   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      if (image !=null)
      image.paintIcon (this, page, x, y);
   }

   //*****************************************************************
   //  Represents the action listener for the timer.
   //*****************************************************************
   private class DieRollListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image 
      //  whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         x += moveX;
         String url = "file:C:/student/Diroll/rolldie.wav";
         moveY *= -1;
         y += moveY;
         if (soundFlag)
         {
             try
             {
                      PlaySound.myPlay(url);
                      soundFlag = false;
             }
             catch (InterruptedException ie) {
                System.out.println(ie);
                }
         }
         if (x < WIDTH-IMAGE_SIZE)
           {
             
              imageNum++;
              imageNum = imageNum % 6;
              image = new ImageIcon (imageList[imageNum]);             
              repaint();
           }  
         else
           {
              timer.stop();
              //final image displayed is the first image in the array
              image = new ImageIcon (imageList[0]);
              repaint(); 
              // url for soundfile to match the last image displayed
               url = "file:C:/student/Diroll/one1.wav";
               try
                {
                      PlaySound.myPlay(url);
                 }
               catch (InterruptedException ie) {
                System.out.println(ie);
                }
          }
      }
   }
}
