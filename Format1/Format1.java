/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.NumberFormat;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JOptionPane;
/**
 *
 * @author Administrator
 */
public class Format1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
       double[] values= {3.4,212.8,33.0};
       int[] nums = {3,244,46};
       String[] names = {"John","Marilyn", "Bob"};
       String amtStr,line;

        NumberFormat fmt = NumberFormat.getCurrencyInstance();

         for(int i = 0;i < 3;i++)
         {
           System.out.println(nums[i]); // default is left justified
         }
         for(int i = 0;i < 3;i++)
         {
           System.out.println(values[i]); // default is left justified
         }
         for(int i = 0;i < 3;i++)
         {
           amtStr = fmt.format(values[i]);   // format value as currency
           System.out.println(amtStr);     // default leftjustified
         }

          line = String.format("\nNames      Nums      Values\n");
         for(int i = 0;i < 3;i++)
         {
           amtStr = fmt.format(values[i]);
     // %2d=2col right justified decimal integer field,%-10s=10col left justified
     //      String field, %10s=10col right justified String field
           line += String.format("%-10s  %3d  %10s",names[i],nums[i],amtStr)+ "\n";
         }
 	 JTextArea text = new JTextArea(line);
	 text.setBorder(null);
	 text.setOpaque(false);
	 text.setFont(new Font("Monospaced", Font.PLAIN, 14) );
	 JOptionPane.showMessageDialog(null, text);

     }

}
