//********************************************************************
//  Array3D.java       Author:Greg Scott
//
//  Demonstrates the use of a three-dimensional array.
//********************************************************************

import java.text.DecimalFormat;
import javax.swing.JOptionPane;
public class Array3D
{
   //-----------------------------------------------------------------
   //  Display the use of a 3D aray
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
       String numStr;
       int i,j,k;
      // creates a 2x2x2 array of ints

      int[][][]scores = {{{ 1,2},{3,4},{5,6}},{{7,8},{9,10},{11,12} },
                 {{0,0},{13,14},{15,16}},{{17,18},{19,20},{21,22} }};

      final int numOfPages = scores.length;
      final int sizeOfPage = scores[0].length;
      final int sizeOfRow = scores[0][0].length;
      
      System.out.println ("scores number of pages = " + numOfPages);
      System.out.println ("scores size of Page = " + sizeOfPage);
      System.out.println ("scores size of Row = " + sizeOfRow);
      System.out.println ("element in the 4th page ,3rd row, 2nd col= " + scores[3][2][1]);
      
      int [][][] numbook = new int[2][3][4];
      int counter = 0;
       for ( i=0; i < 2; i++)
         for ( j=0; j < 3; j++)
             for ( k=0; k < 4; k++)
                numbook[i][j][k]= counter++;
       do
       {
            numStr = JOptionPane.showInputDialog ("Enter the page number(0-1 or-1 to quit): ");
            i = Integer.parseInt(numStr);
            if (i <0) continue; 
            numStr = JOptionPane.showInputDialog ("Enter the row number(0-2): ");
            j = Integer.parseInt(numStr);
            numStr = JOptionPane.showInputDialog ("Enter the col number(0-3): ");
            k = Integer.parseInt(numStr);
           JOptionPane.showMessageDialog (null, "Your chosen number is "+ numbook[i][j][k]);
       }
       while(i != -1);
   }
}
