//********************************************************************
//  MyElements4       Author: GScott
//-----------------------------------------------------------------
//  Demonstrates the use of JMenuBar, JMenu, JMenuItem, and JTextArea 
//  with listeners and multiple dialog boxes for user interaction.
//********************************************************************

import java.io.*;
import javax.swing.*;
import java.util.Vector;
import java.awt.Font;

public class MyElements4
{

   public static EOptionsFrame frame;
   public static Vector<ChemicalElement> dataStore; 
   public static String filename = "C:\\student\\elements.dat";
   public static JTextArea ta;
   public static boolean saved=false;
   
   public static void main (String[] args)
   {
      dataStore = new Vector<ChemicalElement>();

      frame = new EOptionsFrame("Chemical Elements Menu");

      ta = new JTextArea(10,50);
      ta.setFont(new Font("Monospaced",Font.PLAIN, 12));

      frame.getContentPane().add(ta);
      frame.pack();
      frame.setVisible(true);  
   }

   public static void listElements()
   {  
      ChemicalElement datum;   
      String message;
     
      message = "\nNumber"+"\t"+"Name"+"\t\t"+"Symbol"+"\t"+"AtomicNumber"+"\n";
      for (int index=0; index != dataStore.size();index++)
      {
	datum = dataStore.elementAt(index);
        message += String.format("%2d      %-10s     %3s        %3d",index,
                            datum.getName(),datum.getSymbol(),datum.getNumber());;
        message +="\n";

      }
      ta.setText(message);
    }

   public static void addElements()
   {  
       String name, symbol, numStr, message;
       int number, again, index;
       ChemicalElement datum;

       do 
       {  
         name = JOptionPane.showInputDialog ("Enter the Element name: ");
         symbol = JOptionPane.showInputDialog ("Enter the Element symbol: ");
         numStr = JOptionPane.showInputDialog ("Enter the Element number: ");
         number = Integer.parseInt(numStr);

         index = ChemicalElement.getNumOfElements();
	 datum = new ChemicalElement(name,symbol,number); 
         dataStore.addElement(datum);
         saved = false;
         message = datum.toString();
         JOptionPane.showMessageDialog (null, message);
         again = JOptionPane.showConfirmDialog (null, "Input Another?");
       }
       while (again == JOptionPane.YES_OPTION);

   }

   public static void findElement()
   {  
        String name, symbol, message;
        int number;

        name = JOptionPane.showInputDialog ("Enter the Element name: ");
	// search through vector
	for (int index=0; index != dataStore.size(); index++)
	{
	  ChemicalElement datum = dataStore.elementAt(index);
					
	  // check on the name of the element
	  if (name.equals(datum.getName()))
		{
			symbol = datum.getSymbol();
			number = datum.getNumber();
			// display chosen chemical element
      			message = "Name"+"\t"+name+"\n"+"Symbol"+"\t"+symbol+"\n"+
					"AtomicNumber  "+number+"\n";
                        ta.setText(message);         
		}
	}
   }


   public static void readElements() 
   {  
        int confirm;  
        if (!saved)
        {
           String  message = "The data in the application is not saved.\n"+
               "would you like to save it before reading the new file in?";
           confirm = JOptionPane.showConfirmDialog (null, message);
           if (confirm == JOptionPane.YES_OPTION)
              chooseFile(2); 
        }
        chooseFile(1);	
	try
		{
			FileInputStream fis = new
			    FileInputStream(filename);
			ObjectInputStream in = new
				       ObjectInputStream(fis);
                    	dataStore = (Vector<ChemicalElement>)in.readObject();        
			in.close();
                        saved = true;
                        ChemicalElement.setNumOfElements(dataStore.size());
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
                        out.writeObject(dataStore);
                        out.close();
                        saved = true;
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
