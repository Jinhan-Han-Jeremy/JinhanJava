//********************************************************************
//  DieRoll2.java       Author: Lewis/Loftus
//
//  Demonstrates an animation and the use of the Timer class.
//********************************************************************
import java.applet.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieRoll2
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws InterruptedException
   {

      JFrame frame = new JFrame ("DieRoll");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new DieRollPanel());
      frame.pack();
      frame.setVisible(true);
      //setup panel data for a one die to roll out
      DieRollPanel.url = "file:C:/student/Diroll/one1.wav";
      DieRollPanel.imageList[0]="die11.jpg";
      DieRollPanel.x = 0;
      DieRollPanel.y = 40;
      DieRollPanel.moveX = 15;
      DieRollPanel.moveY = -5;
      DieRollPanel.timer.start();
      Thread.sleep(4000);
      //setup panel data for a five die to roll out
      DieRollPanel.url = "file:C:/student/Diroll/five5.wav";
      DieRollPanel.imageList[0]="die53.jpg";
      DieRollPanel.x = 0;
      DieRollPanel.y = 40;
      DieRollPanel.moveX = 15;
      DieRollPanel.moveY = -5;
      DieRollPanel.timer.start();
      Thread.sleep(4000);
   }

}
