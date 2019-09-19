//********************************************************************
//  CDwithLabel.java       Author: G. Scott
//
//  Represents a compact disc with a company label.
//********************************************************************

import java.text.NumberFormat;

public class CDwithLabel  extends CD
{
   private String label;

   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public CDwithLabel (String name, String singer, double price, int numTracks, String label)
   {
      super(name,singer,price,numTracks);
      this.label = label;
   }
   //-----------------------------------------------------------------
   //  Returns the cost of the CD
   //-----------------------------------------------------------------
   public double getCost()
   {
      return cost;
   }
   //-----------------------------------------------------------------
   //  Returns a string description of this CDwithLabel appending to 
   //  Parent class description
   //-----------------------------------------------------------------
   public String toString()
   {
      String description = super.toString();
      description += "  " + label;
      return description;
   }
}
