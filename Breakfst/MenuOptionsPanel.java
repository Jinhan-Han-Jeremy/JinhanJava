//********************************************************************
//  MenuOptionsPanel.java       Author: Greg Scott
//  Demonstrates the use of radio buttons to capture input options.
//  and listener to call methods to process the options
//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuOptionsPanel extends JPanel
{

   private static JLabel prompt;
   private static JRadioButton one, two, three;
   private static MenuPanel mp;
   public static JFrame frame2;

   //-----------------------------------------------------------------
   //  Sets up a panel with a label and a set of radio buttons
   //  that present options to the user.
   //-----------------------------------------------------------------
   public MenuOptionsPanel()
   {
      setLayout(new GridLayout(4,1));       
      prompt = new JLabel ("Choose your option?");
      prompt.setFont (new Font ("Helvetica", Font.BOLD, 24));

      one = new JRadioButton ("Choose from the Menu");
      one.setBackground (Color.green);
      two = new JRadioButton ("Display Purchase Invoice");
      two.setBackground (Color.green);
      three = new JRadioButton ("Exit");
      three.setBackground (Color.green);
    
      ButtonGroup group = new ButtonGroup();
      group.add (one);
      group.add (two);
      group.add (three);
              
      MenuOptionListener mol = new MenuOptionListener();
      one.addActionListener (mol);
      two.addActionListener (mol);
      three.addActionListener (mol);
      
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
   private class MenuOptionListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Calls the method to process the option for which radio
      //  button was pressed.
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         Object source = event.getSource();

         if (source == one)
         {
           mp = new MenuPanel();
           frame2 = new JFrame("Breakfast Menu");
           frame2.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);           
           frame2.getContentPane().add(mp);
           frame2.setLocation(500,100);
           frame2.pack();
           frame2.setVisible(true);
         }
         else
            if (source == two)
               Breakfast.displayInvoice(MenuPanel.items, MenuPanel.prices, MenuPanel.namesOfItems);
            else
            {   
                String message; 
                message = "Thanks for Dining at Bobs\nHope you enjoyed your meal";
                JOptionPane.showMessageDialog (null, message);
                System.exit(0);

            }
      }
   }
}
