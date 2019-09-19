/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gscott
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EOptionsPanel extends JPanel
{

   private String ioFile = "";
   private JLabel prompt;
   private JRadioButton one, two, three, four;

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and a set of radio buttons
   //  that present options to the user.
   //-----------------------------------------------------------------
   public EOptionsPanel()
   {
      prompt = new JLabel ("Choose your input option?");
      prompt.setFont (new Font ("Helvetica", Font.BOLD, 24));

      one = new JRadioButton ("add element");
      one.setBackground (Color.green);
      two = new JRadioButton ("list all elements");
      two.setBackground (Color.green);
      three = new JRadioButton ("read elements from file");
      three.setBackground (Color.green);
      four= new JRadioButton ("write elements to file");
      four.setBackground (Color.green);

      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
      group.add (four); 
             
      EOptionListener listener = new EOptionListener();
      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      four.addActionListener (listener);
      
      add (prompt);
      add (one);
      add (two);
      add (three);
      add (four);
      
      setBackground (Color.green);
      setPreferredSize (new Dimension(400, 100));
   }

   //*****************************************************************
   //  Represents the listener for the radio buttons
   //*****************************************************************
   private class EOptionListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Calls the method to process the option for which radio
      //  button was pressed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event) 
      {
         Object source = event.getSource();

         if (source == one)
           MyElements3AList.addElements();
         else
            if (source == two)
               MyElements3AList.listElements();
            else
               if (source == three)
                 MyElements3AList.readElements();
            else
               MyElements3AList.writeElements();
      }
   }
}
