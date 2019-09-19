//********************************************************************
//  DieMoverPanel.java       Author:GScott
//
//  Represents the primary panel for the DieMover program.
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieMoverPanel extends JPanel
{
   private final int WIDTH = 300, HEIGHT = 100;
   private final int DELAY1 = 100,DELAY2 = 150, IMAGE_SIZE = 35;
   //a random list of names of images to display
   
   private static ImageIcon image1;
   private static ImageIcon image2;
   private Timer timer1,timer2;
   private int x1, y1, moveX1, x2, y2, moveX2;

   //-----------------------------------------------------------------
   //  Sets up the panel, including the timers for the animation.
   //-----------------------------------------------------------------
   public DieMoverPanel()
   {
      timer1 = new Timer(DELAY1, new DieMoverListener());
      timer2 = new Timer(DELAY2, new DieMoverListener());

      x1 = 0;
      y1 = 30;
      moveX1 = 15;
      x2 = WIDTH-IMAGE_SIZE;
      y2 = 60;
      moveX2 = 10;

   
      setPreferredSize (new Dimension(WIDTH, HEIGHT));
      setBackground (Color.black);
      timer1.start();
      timer2.start();
   }

   //-----------------------------------------------------------------
   //  Draws the image in the current location.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      if (image1 !=null)
      image1.paintIcon (this, page, x1, y1);
      if (image2 !=null)
      image2.paintIcon (this, page, x2, y2);

   }

   //*****************************************************************
   //  Represents the action listener for the timer.
   //*****************************************************************
   private class DieMoverListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image 
      //  whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
          Object source = event.getSource();
          if (source == timer1)
               x1 += moveX1;
          else if (source == timer2)
               x2 -= moveX2;
    
         if (x1 < WIDTH-IMAGE_SIZE)
           {
             image1 = new ImageIcon ("die11.jpg");
              repaint();
           }  
         else
           {
              timer1.stop();
               repaint(); 
           }
          if (x2 > 0)
           {

              image2 = new ImageIcon ("die22.jpg");
              repaint();
           }
         else
           {
              timer2.stop();
               repaint();

          }
      }
   }
}
