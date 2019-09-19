//********************************************************************
//  DieRoll.java       Author: Lewis/Loftus
//
//  Demonstrates an animation and the use of the Timer class.
//********************************************************************
import java.applet.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DieRoll
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
   }

}
