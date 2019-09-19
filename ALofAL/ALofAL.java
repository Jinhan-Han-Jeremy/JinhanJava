//********************************************************************
//  SodaSurvey.java       Author: Lewis/Loftus
//
//  Demonstrates the use of a two-dimensional array.
//********************************************************************

import java.text.DecimalFormat;
import java.util.*;
public class ALofAL
{
   //-----------------------------------------------------------------
   //  Determines and prints the average of each row (soda) and each
   //  column (respondent) of the survey scores.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
       
      int i;
      ArrayList<String>  names1 = new  ArrayList<String>();
      ArrayList<String>  names2 = new  ArrayList<String>();
      ArrayList<ArrayList<String>>  name2D = new  ArrayList<ArrayList<String>>();
      names1.add("Greg");
      names1.add("Bob");
      names1.add("Sue");
      names2.add("John");
      names2.add("Paul");
      names2.add("Nancy");
      names2.add("Sarah");
      name2D.add(names1);
      name2D.add(names2);
      name2D.get(1).add("Smile");
      System.out.println("The name is " + names2.get(4));        
              
      Scanner scan = new Scanner(System.in);
      do
      {
      System.out.print("Enter your list number ( 0 or 1) ");

       i = scan.nextInt();
      System.out.print("Enter your entry  number ( 0-2 for list 0, 0-3 for list1) ");
      int j = scan.nextInt();
      System.out.println("The name is " + name2D.get(i).get(j) );
      System.out.println("Do another(1=y/0=n)? ");
      i = scan.nextInt();       
      } while ( i != 0);
      
   }
}
