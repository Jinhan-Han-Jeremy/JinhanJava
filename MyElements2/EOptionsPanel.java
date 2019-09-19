//********************************************************************
//  EOptionsPanel.java       Author: Greg Scott
//  Demonstrates the use of radio buttons to capture input options.
//  and listener to call methods to process the options
//********************************************************************
package myelements2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EOptionsPanel extends JPanel
{
   private JLabel prompt;
   private JRadioButton one, two, three;

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and a set of radio buttons
   //  that present options to the user.
   //-----------------------------------------------------------------
   public EOptionsPanel()
   {
      prompt = new JLabel ("Choose your input option?");
      prompt.setFont (new Font ("Helvetica", Font.BOLD, 24));

      one = new JRadioButton ("input element");
      one.setBackground (Color.green);
      two = new JRadioButton ("list all elements");
      two.setBackground (Color.green);
      three = new JRadioButton ("show element count");
      three.setBackground (Color.green);
    
      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
              
      EOptionListener listener = new EOptionListener();
      one.addActionListener (listener);
      two.addActionListener (listener);
      three.addActionListener (listener);
      
      add (prompt);
      add (one);
      add (two);
      add (three);
      
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
           MyElements2.inputElements();

         else
            if (source == two)
               MyElements2.listElements();
            else
            {   
                String message; 
                message = "The number of elements processed was "+
                           ChemicalElement.getNumOfElements();
     
                JOptionPane.showMessageDialog (null, message);         

            }
      }
   }
}
