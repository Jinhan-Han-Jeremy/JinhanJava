//********************************************************************
//  MyElements2       Author: GScott
//
//-----------------------------------------------------------------
//  Demonstrates the use of radio buttons with listener
//  and multiple dialog boxes for user interaction.
//  Demonstrates the use of the JOptionPane class.
//********************************************************************
package myelements2;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class MyElements2
{

   public static JFrame frame;
   public static ChemicalElement[] eList;
   
   public static void main (String[] args)
   {
      eList = new ChemicalElement[10];
      String message;
  

      frame = new JFrame ("Chemical Elements Options");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      EOptionsPanel panel = new EOptionsPanel();
      frame.getContentPane().add (panel);

      frame.pack();
      frame.setVisible(true);
        
   }

   public static void listElements()
   {  
   
      String message, ntabs;
      int num;
      System.out.println("\nNumber"+"\t"+"Name"+"\t\t"+"Symbol"+"\t"+"AtomicNumber"+"\n");
      for ( num=0; num < ChemicalElement.getNumOfElements();num++)
      {  
         if (eList[num].getName().length() < 8)
             ntabs="\t\t";
         else
             ntabs="\t";
         message = num + "\t"+eList[num].getName()+ntabs+eList[num].getSymbol()+"\t"+eList[num].getNumber();
         System.out.println(message);
       
      }
     
    }


   public static void inputElements()
   {  
       String name, symbol, numStr, message;
       int number, again, index;
       frame.setVisible(false);
       do 
       {  
       
         name = JOptionPane.showInputDialog ("Enter the Element name: ");
         symbol = JOptionPane.showInputDialog ("Enter the Element symbol: ");
         numStr = JOptionPane.showInputDialog ("Enter the Element number: ");
         number = Integer.parseInt(numStr);

         index = ChemicalElement.getNumOfElements(); 
         eList[index] = new ChemicalElement(name,symbol,number);

         message = eList[index].toString();
         JOptionPane.showMessageDialog (null, message);
         again = JOptionPane.showConfirmDialog (null, "Input Another?");
       }
       while (again == JOptionPane.YES_OPTION);
       frame.setVisible(true);
    }


}
