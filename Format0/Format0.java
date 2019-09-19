import java.text.*;
import javax.swing.*;
import java.awt.Font;

public class Format0 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       double value;
       int num;
       String name;
       String amtStr,line="";
       DecimalFormat fmt = new DecimalFormat("$#,##0.00;($#,##0.00)");
      // NumberFormat fmt = NumberFormat.getCurrencyInstance();
         line = String.format("\nNames      Nums      Values\n");
         for(int i = 0;i < 3;i++)
         {
          name = JOptionPane.showInputDialog(null,"Enter your name");
          amtStr = JOptionPane.showInputDialog(null,"Enter your int");         
          num = Integer.parseInt(amtStr);
          
          amtStr = JOptionPane.showInputDialog(null,"Enter your real");
          value = Double.parseDouble(amtStr);
          amtStr = fmt.format(value);
          
          System.out.printf("%-10s  %3o  %12s %n",name,num,amtStr);
          
          line += String.format("%-10s  %3d  %12s",name,num,amtStr)+ "\n";
         }
 
 	 JTextArea text = new JTextArea(line);
	// text.setOpaque(false);
	// text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
	 JOptionPane.showMessageDialog(null, text);

     }
}
