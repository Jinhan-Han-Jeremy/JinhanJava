//********************************************************************
//  MyElements3       Author: GScott
//
//-----------------------------------------------------------------
//  Demonstrates the use of radio buttons with listener
//  and multiple dialog boxes for user interaction.
//  Demonstrates the use of the JOptionPane class.
//********************************************************************

import java.io.*;
import javax.swing.*;
//import javax.swing.JFrame;

public class MyElements3
{

   public static JFrameL frame;
   public static ChemicalElement[] eList;
   public static String filename = "C:\\student\\elements.dat";
   
   public static void main (String[] args)
   {
      eList = new ChemicalElement[10];
      String message;
  

      frame = new JFrameL ("Chemical Elements Options");
      frame.setDefaultCloseOperation (JFrame.DO_NOTHING_ON_CLOSE);

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


   public static void addElements()
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
   public static void readElements() 
   {  
        chooseFile(1);	
	try
		{
			FileInputStream fis = new
			    FileInputStream(filename);
			ObjectInputStream in = new
				       ObjectInputStream(fis);
                        Integer eCountObj = (Integer)in.readObject();
                        int eCount = eCountObj.intValue();
                        System.out.println("count of objects in file = "+ eCount);
                        for (int i = 0; i < eCount; i++)
                        {
                                System.out.println("reading object "+ i);
				eList[i] = (ChemicalElement)in.readObject();
                        }
			in.close();
                        ChemicalElement.setNumOfElements(eCount);
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
        chooseFile(2);
      	try
		{
			FileOutputStream fos = new
			    FileOutputStream(filename);
			ObjectOutputStream out = new
				       ObjectOutputStream(fos);
                        int eCount = ChemicalElement.getNumOfElements();
                        Integer eCountObj = new Integer(eCount);
                        out.writeObject(eCountObj);
                        for (int i = 0; i < eCount; i++)
                        {
                                System.out.println("writing object "+ i);
				out.writeObject(eList[i]);
                        }
                        out.close();
		
		}	
	catch(IOException e)	
                { 
                     System.out.println(e);
                }
 
   }
   public static void chooseFile(int ioOption) 
   {  
      int status, confirm;       
                
      String  message = "Would you like to use the current default file: \n" +
                          filename;
      confirm = JOptionPane.showConfirmDialog (null, message);
      if (confirm == JOptionPane.YES_OPTION)
          return;
      JFileChooser chooser = new JFileChooser();
      if (ioOption == 1)
          status = chooser.showOpenDialog (null);
      else
          status = chooser.showSaveDialog (null);
      if (status == JFileChooser.APPROVE_OPTION)
      {
          File file = chooser.getSelectedFile();
          filename = file.getPath();
      }
   }
}
