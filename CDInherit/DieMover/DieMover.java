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

public class DieMover
{
   //-----------------------------------------------------------------
   //  Displays the main frame of the program.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws InterruptedException
   {

      JFrame frame = new JFrame ("DieMover");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(new DieMoverPanel());
      frame.pack();
      frame.setVisible(true);
   }

}
