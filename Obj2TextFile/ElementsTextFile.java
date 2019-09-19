//********************************************************************
// ElementsTextFile       Author: GScott
//
//  Demonstrates the PrintWriter and Scanner classes for Text I/O
//********************************************************************

import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.*;

public class ElementsTextFile
{
   //-----------------------------------------------------------------
   //  Determines if the value input by the user is even or odd.
   //  Uses multiple dialog boxes for user interaction.
   //-----------------------------------------------------------------
   public static void main (String[] args) throws IOException
   {
      String name, symbol, numStr, message;
      int number, again;

      PrintWriter out = new PrintWriter(new FileOutputStream("c:\\student\\elements.dat"));

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

         out.println(name+" "+symbol+" "+numStr);

         again = JOptionPane.showConfirmDialog (null, "Do Another?");
      }
      while (again == JOptionPane.YES_OPTION);
      
      out.close();
      
      message = "The number of elements processed to the file was "+
                ChemicalElement.getNumOfElements();
      JOptionPane.showMessageDialog (null, message);
 
      Scanner in = new Scanner (new FileInputStream("c:\\student\\elements.dat"));     
      
      int count = 0;
      while (in.hasNext( ))
        {
            count++;
            for (int i=1; i<4; i++)
            { 
               switch (i)
               {
                  case 1:
                          name = in.next();
                          break;
                  case 2:
                          symbol = in.next();
                          break;
                  case 3:
                          numStr = in.next();
                          break;
                }
             }
             number = Integer.parseInt(numStr);
             ChemicalElement e = new ChemicalElement(name,symbol,number);

             message = "The element name is "+e.getName()+"\n" +
                       "Its atomic symbol is "+e.getSymbol()+"\n" +
                       "Its atomic number is "+e.getNumber();
             JOptionPane.showMessageDialog (null, message);

         }

      in.close( );
      message = "The number of elements processed From the file was "+count;
      JOptionPane.showMessageDialog (null, message);
       
   }
}
