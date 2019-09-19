//********************************************************************
//  Primes2.java       Author: Lewis/Loftus/GScott
//
//  Demonstrates the use of an initializer list for an array, use of the
//  clone method, and the foreach version of the for loop.
//********************************************************************
 
public class Primes2
{
   //-----------------------------------------------------------------
   //  Stores some prime numbers in  arrays and prints them.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      int[] primeNums = {2, 3, 5, 7, 11, 13, 17, 19};
      int [] clone_arr = (int [ ])primeNums.clone( ); 
    //Clone the array primeNums and returns a reference to it of type
    //    java.lang.Object, then casts the reference java.lang.Object
    //to int []. 
      System.out.println ("Array length: " + primeNums.length);
      System.out.println ("The first array of prime numbers are:");
      for (int prime : primeNums)
         System.out.print (prime + "  ");
      System.out.println ("  ");
         System.out.println ("The clone array of prime numbers are:");
      for (int clone : clone_arr)
         System.out.print (clone + "  ");
 
   }
}

