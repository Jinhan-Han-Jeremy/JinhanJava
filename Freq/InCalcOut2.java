//********************************************************************
//  InCalcOut2.java       Author: Greg Scott
//  Program calculates how many months old you are after prompting you
//  for your name and age. 
//  Demonstrates the use of the Helper methods in the Main class 
//  of InCalcOut1.java

//********************************************************************


import java.util.Scanner;
import java.text.DecimalFormat;


public class InCalcOut2 
{
   //-----------------------------------------------------------------
   //  Reads a name and age and calculates the number of months from
   //  the age, then display the results.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      String name;
      int age;
      double months;

      name = getName();

      age = getAge();

      months =  age * (double)365 /  30;

  // Round the output to three decimal places
      DecimalFormat fmt = new DecimalFormat ("0.###");

      System.out.println (name + " you are " + fmt.format(months) + " months old.");
   }
   //-----------------------------------------------------------------
   //  Reads a character string from the user and returns it to main
   //-----------------------------------------------------------------

   public static String getName()
   {
      String name;
      Scanner scan = new Scanner(System.in);

      System.out.println("Enter your name:");
      name = scan.nextLine();
      return name;
   }

   //-----------------------------------------------------------------
   //  Reads an int from the user and returns it to main
   //-----------------------------------------------------------------

   public static int getAge()
   {
      int age;
      Scanner scan = new Scanner(System.in);

      System.out.println("Enter your age:");
      age = scan.nextInt();
      return age;
   }

}
