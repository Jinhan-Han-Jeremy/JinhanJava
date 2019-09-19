//********************************************************************
//  Array2File      Author: GScott
//
//-----------------------------------------------------------------
//  Demonstrates the use of ObjectInput/Output Streams with arrays
//  of objects.
//  Demonstrates the use of the JOptionPane class.
//********************************************************************

import java.io.*;
import javax.swing.*;
//import javax.swing.JFrame;

public class Array2File
{

   public static JFrame frame;
   public static ChemicalElement[] eList;
   public static String filename = "C:\\student\\elements.dat";
   
   public static void main (String[] args)
   {
      eList = new ChemicalElement[10];
       String name, symbol, numStr, message;
       int number, again, index;
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
       writeElements();
       readElements();
       
        
   }


   public static void readElements() 
   {  
	
	try
		{
			FileInputStream fis = new
			    FileInputStream(filename);
			ObjectInputStream inFile = new
				       ObjectInputStream(fis);

			eList = (ChemicalElement[])inFile.readObject();

			inFile.close();

		}	
		catch(ClassNotFoundException e)	
                 { 
                     System.out.println(e);
                 }

                catch (IOException e) 
                 { 
                     System.out.println(e);
                 }
   }
   public static void writeElements() 
   {  
      
      	try
		{
			FileOutputStream fos = new
			    FileOutputStream(filename);
			ObjectOutputStream outFile = new
				       ObjectOutputStream(fos);

                        outFile.writeObject(eList);
                       
                        System.out.println("writing array object ");
                        outFile.close();
		
		}	
	catch(IOException e)	
                { 
                     System.out.println(e);
                }
 
   }
   public static void trimArray() 
   {  
      int num = ChemicalElement.getNumOfElements();
      ChemicalElement[] temp = new ChemicalElement[ num];

      for (int i = 0; i < num; i++)
         temp[i] = eList[i];

      eList = temp;
   }

}
