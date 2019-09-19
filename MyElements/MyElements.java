//********************************************************************
//  MyElements       Author: GScott
//
//  Demonstrates the use of the JOptionPane class.
//********************************************************************

import javax.swing.JOptionPane;

public class MyElements
{
   //-----------------------------------------------------------------
   //  Determines if the value input by the user is even or odd.
   //  Uses multiple dialog boxes for user interaction.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String name, symbol, numStr, message;
      int number, again;

      do 
      {  
         
         name = JOptionPane.showInputDialog ("Enter the Element name: ");
         symbol = JOptionPane.showInputDialog ("Enter the Element symbol: ");
         numStr = JOptionPane.showInputDialog ("Enter the Element number: ");
         number = Integer.parseInt(numStr);
         ChemicalElement e = new ChemicalElement(name,symbol,number);

         message = "The element name is "+e.getName()+"\n" +
                   "Its atomic symbol is "+e.getSymbol()+"\n" +
                   "Its atomic number is "+e.getNumber();
         JOptionPane.showMessageDialog (null, message);

         again = JOptionPane.showConfirmDialog (null, "Do Another?");
      }
      while (again == JOptionPane.YES_OPTION);
      
      message = "The number of elements processed was "+
                ChemicalElement.getNumOfElements();
     
      JOptionPane.showMessageDialog (null, message);         
   }
}
