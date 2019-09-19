//********************************************************************
//  MyElements2       Author: GScott
//
//-----------------------------------------------------------------
//  Demonstrates the use of radio buttons with listener
//  and multiple dialog boxes for user interaction.
//  Demonstrates the use of the JOptionPane class.
//********************************************************************

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MyElements2I
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
      JTextArea text = new JTextArea();
      String message = "";
      int num;
      text.setOpaque(false);
      text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
      text.setBorder(null);
      message+="Number     Name       Symbol       AtomicNumber\n\n";
      for ( num=0; num < ChemicalElement.getNumOfElements();num++)
      {  
         message += String.format("%3d        %-10s  %2s            %3d\n", num,
                  eList[num].getName(),eList[num].getSymbol(),
                    eList[num].getNumber());
      }
      text.setText(message);
      JOptionPane.showMessageDialog(null, text);
    }


   public static void inputElements()
   {  
       String name="", symbol="", numStr="", message;
       int number=0, again, index;
       frame.setVisible(false);

 
    do 
    {  
    JTextField field1 = new JTextField("");
    JTextField field2 = new JTextField("");
    JTextField field3 = new JTextField("");

    JPanel panel = new JPanel(new GridLayout(0, 1));

    panel.add(new JLabel("Name"));
    panel.add(field1);
    panel.add(new JLabel("Symbol"));
    panel.add(field2);
    panel.add(new JLabel(" AtomicNumber"));
    panel.add(field3);
    field1.addAncestorListener(new SetFocus());
   // field1.requestFocusInWindow();
    int result = JOptionPane.showConfirmDialog(null, panel, "Test",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    if (result == JOptionPane.OK_OPTION) {
           name=field1.getText();
           symbol= field2.getText();
           numStr= field3.getText();
           number = Integer.parseInt(numStr);
    } else {
        System.out.println("Cancelled");
        System.exit(0);
    }

         index = ChemicalElement.getNumOfElements(); 
         eList[index] = new ChemicalElement(name,symbol,number);

         message = eList[index].toString();
         JOptionPane.showMessageDialog (null, message);
         again = JOptionPane.showConfirmDialog (null, "Input Another?");
    }
    while (again == JOptionPane.YES_OPTION);
       frame.setVisible(true);
    }
private static class SetFocus implements AncestorListener {



  public void ancestorAdded(AncestorEvent e) {
    JComponent component = e.getComponent();
    component.requestFocusInWindow();

   
  }

  public void ancestorMoved(AncestorEvent e) {
  }

  public void ancestorRemoved(AncestorEvent e) {
  }
}

}
