//********************************************************************
//  RocketPanel.java       Author: Lewis/Loftus
//
//  Demonstrates the use of polygons and polylines.
//********************************************************************

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public class RocketPanel extends JPanel
{
   private int[] xRocket = {100, 120, 120, 130, 130, 70, 70, 80, 80};
   private int[] yRocket = {15, 40, 115, 125, 150, 150, 125, 115, 40};

   private int[] xWindow = {95, 105, 110, 90};
   private int[] yWindow = {45, 45, 70, 70};

   private int[] xFlame = {70, 70, 75, 80, 90, 100, 110, 115, 120,
                           130, 130};
   private int[] yFlame = {155, 170, 165, 190, 170, 175, 160, 185,
                           160, 175, 155};
   private int moveX, moveCount;
   private Timer timer;
   //-----------------------------------------------------------------
   //  Constructor: Sets up the basic characteristics of this panel.
   //-----------------------------------------------------------------
   public RocketPanel()
   {
      RocketMoverListener rml = new RocketMoverListener();
      timer = new Timer(1000/15, rml);
      setBackground (Color.black);
      setPreferredSize (new Dimension(400, 200));
      for (int i=0;i<xRocket.length;i++)
          xRocket[i]-=130;
      for (int i=0;i<xWindow.length;i++)
          xWindow[i]-=130;
      for (int i=0;i<xFlame.length;i++)
          xFlame[i]-=130;    
      moveX = 2;
      moveCount = 0;
      timer.start();
   }

   //-----------------------------------------------------------------
   //  Draws a rocket using polygons and polylines.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      int i;
      for (i=0;i<xRocket.length;i++)
          xRocket[i]+=moveX;
      for (i=0;i<xWindow.length;i++)
          xWindow[i]+=moveX;
      for (i=0;i<xFlame.length;i++)
          xFlame[i]+=moveX;
      super.paintComponent (page);
      page.setColor (Color.cyan);
      page.fillPolygon (xRocket, yRocket, xRocket.length);

      page.setColor (Color.gray);
      page.fillPolygon (xWindow, yWindow, xWindow.length);

      page.setColor (Color.red);
      page.drawPolyline (xFlame, yFlame, xFlame.length);
   }
   private class RocketMoverListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Updates the position of the image 
      //  whenever the timer fires an action event.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
          int i;
         if ((xRocket[5]+moveX)<= 400)
         {
             moveCount++;
              repaint();
         }
         else
           {
//            System.out.println("reset");
              timer.stop();
//              for (i=0;i<xRocket.length;i++)
//                xRocket[i]-=(moveX*moveCount);
//              for (i=0;i<xWindow.length;i++)
//                xWindow[i]-=(moveX*moveCount);
//              for (i=0;i<xFlame.length;i++)
//                xFlame[i]-=(moveX*moveCount);
//              repaint();
//              moveCount=0;
           }
       }
   }
 }   

