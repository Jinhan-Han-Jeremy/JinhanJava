//********************************************************************
//  MyElements3       Author: GScott
//
//-----------------------------------------------------------------
//  Demonstrates the use of radio buttons with listener
//  and multiple dialog boxes for user interaction.
//  Demonstrates the use of the JOptionPane class.
//********************************************************************
import java.util.*;
import java.io.*;
import javax.swing.*;
//import javax.swing.JFrame;

public class MyElements3AList
{

   public static JFrameL frame;
   public static ArrayList<ChemicalElement> eList;
   public static String filename = "C:\\elements.dat";
   public static boolean saved = true;
   
   public static void main (String[] args)
   {
      eList = new ArrayList<ChemicalElement>();
      String message;
  

      frame = new JFrameL ("Chemical Elements Options");
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
         if (eList.get(num).getName().length() < 8)
             ntabs="\t\t";
         else
             ntabs="\t";
         message = num + "\t"+eList.get(num).getName()+ntabs+eList.get(num).getSymbol()+"\t"+eList.get(num).getNumber();
         System.out.println(message);
      }
    }


   public static void addElements()
   {  
       String name, symbol, numStr, message;
       int number, again, index;
       frame.setVisible(false);
       saved = false;
       do 
       {  
       
         name = JOptionPane.showInputDialog ("Enter the Element name: ");
         symbol = JOptionPane.showInputDialog ("Enter the Element symbol: ");
         numStr = JOptionPane.showInputDialog ("Enter the Element number: ");
         number = Integer.parseInt(numStr);

         index = ChemicalElement.getNumOfElements(); 
         eList.add( new ChemicalElement(name,symbol,number));

         message = eList.get(index).toString();
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
                    
                        eList = (ArrayList<ChemicalElement>)in.readObject();
			in.close();
                        ChemicalElement.setNumOfElements(eList.size());
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

                        out.writeObject(eList);
                        out.close();
		
		}	
	catch(IOException e)	
                { 
                     System.out.println(e);
                }
        saved = true;
 
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
