//********************************************************************
//  Tunes.java       Author: Lewis/Loftus
//
//  Demonstrates the use of an array of objects.
//********************************************************************

public class Tunes
{
   //-----------------------------------------------------------------
   //  Creates a CDCollection object and adds some CDs to it. Prints
   //  reports on the status of the collection.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      CDCollection music = new CDCollection ();

      music.addCD ("Storm Front", "Billy Joel", 14.95, 10);
      music.addCD ("Come On Over", "Shania Twain", 14.95, 16);
      CDwithLabel cdwl = new CDwithLabel("Thriller", "Michael Jackson",
                                  9.95,9,"Motown");
      music.addCD(cdwl);
      music.addCD ("Soundtrack", "Les Miserables", 17.95, 33);
      cdwl = new CDwithLabel("Graceland", "Paul Simon",13.90,11,"Arista");

      music.addCD (cdwl);

      System.out.println (music);

      music.addCD ("Double Live", "Garth Brooks", 19.99, 26);
      music.addCD ("Greatest Hits", "Jimmy Buffet", 15.95, 13);

      System.out.println (music);
   }
}
