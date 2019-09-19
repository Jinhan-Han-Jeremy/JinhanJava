import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.*;
import java.text.NumberFormat;
import java.awt.Font;

public class Breakfast
{
    public static JFrame frame;
    static public void main(String[] args)
    {
      frame = new JFrame ("Ben's Breakfast Bar Menu");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      MenuOptionsPanel panel = new MenuOptionsPanel();
      frame.getContentPane().add (panel);

      frame.pack();
      frame.setLocation(200,300);
      frame.setVisible(true);
    }
 
    public static void  displayInvoice(JCheckBox[] items,float[] prices,String[] namesOfItems)
    {		
        NumberFormat money = NumberFormat.getCurrencyInstance();
	float costOfItems=0.0f;
        String message = "";
        message+= "You ordered:\n------------------------------\n";
	message+= String.format("%-24s%6s\n","Food Item","Price")+"\n";	
	for (int index=0; index != items.length; index++)
	{
            if (items[index].isSelected())
            {
		costOfItems += prices[index];
                message += String.format("%-24s%6s\n", namesOfItems[index], 
                                                           money.format(prices[index]));

            }
	}

	message +="\n------------------------------\n";
	message +=String.format("%-24s%6s","AMOUNT TO PAY",  money.format(costOfItems));
	message +=            "\n------------------------------\n\n";
	message +="Thank you - enjoy your meal!";
 	JTextArea text = new JTextArea(message);
	text.setBorder(null);
	text.setOpaque(false);
	text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
        MenuOptionsPanel.frame2.setVisible(false);
	JOptionPane.showMessageDialog(null, text);        
	}
}
