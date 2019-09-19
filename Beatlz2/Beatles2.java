//********************************************************************
//  Beatles2.java       Author: Lewis/Loftus/Gscott
//
//  Demonstrates the use of an ArrayList object.
//********************************************************************
import java.util.ArrayList;

public class Beatles2
{
   //-----------------------------------------------------------------
   //  Stores and modifies a list of objects
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      ArrayList<String> band = new ArrayList<String>();
      
      ChemicalElement element = new ChemicalElement("Hydrogen","H",1);
      
      band.add ("Paul");
      band.add ("Pete");
      band.add ("John");
      band.add ("George");
      band.add(element);

      System.out.println (band);

      int location = band.indexOf ("Pete");
      band.remove (location);
      
      location = band.indexOf (element);
      System.out.println (location);

      System.out.println (band);
      System.out.println ("At index 1: " + band.get(1));

      //ChemicalElement element2 = (ChemicalElement)band.get(3); 
      System.out.println (element2);
      
      band.add (2, "Ringo");

      System.out.println (band);
      System.out.println ("Size of the band: " + band.size());
   }
}
