//  Propagate.java  Demonstrates exception propagation.
//********************************************************************
class Propagate
{
   //-----------------------------------------------------------------
   //  Catches and handles the exception that is thrown in level3.
   //-----------------------------------------------------------------
   public static void level1()
   {
      System.out.println("Level 1 beginning.");
      try
      {
         level2();
      }
      catch (ArithmeticException problem)
      {
         System.out.println ();
         System.out.println ("The exception message is: " +
                             problem.getMessage());
         System.out.println ();
         System.out.println ("The call stack trace:");
         problem.printStackTrace();
         System.out.println ();
      }
      System.out.println("Level 1 ending.");
   }
   //-----------------------------------------------------------------
   //  Serves as an intermediate level.  The exception propagates
   //  through this method back to level1.
   //-----------------------------------------------------------------
   public static void level2()
   {
      System.out.println("Level 2 beginning.");
      level3 ();
      System.out.println("Level 2 ending.");
   }
   //-----------------------------------------------------------------
   //  Performs a calculation to produce an exception.  It is not
   //  caught and handled at this level.
   //-----------------------------------------------------------------
   public static void level3 ()
   {
      int numerator = 10, denominator = 0;
      System.out.println("Level 3 beginning.");
      int result = numerator / denominator;
      System.out.println("Level 3 ending.");
   }
   //-----------------------------------------------------------------
   //  Invokes the level1 method to begin the exception demonstation.
   //-----------------------------------------------------------------
   public static  void main (String[] args)
   {
      System.out.println("Program beginning.");
      level1();
      System.out.println("Program ending.");
   }
}
