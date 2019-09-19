//********************************************************************
//  CD.java       Author: Lewis/Loftus
//
//  Represents a compact disc.
//********************************************************************

import java.text.NumberFormat;

public class CD
{
   protected String title, artist;
   protected double cost;
   protected int tracks;

   //-----------------------------------------------------------------
   //  Creates a new CD with the specified information.
   //-----------------------------------------------------------------
   public CD (String name, String singer, double price, int numTracks)
   {
      title = name;
      artist = singer;
      cost = price;
      tracks = numTracks;
   }

   //-----------------------------------------------------------------
   //  Returns a string description of this CD.
   //-----------------------------------------------------------------
   public String toString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String description;
      String costStr = fmt.format(cost);
      description = String.format("%6s  %2d  %-15s  %-15s",costStr,tracks,
              title,artist);

      return description;
   }
   public String oldtoString()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      String description;

      description = fmt.format(cost) + "\t" + tracks + "\t";
      description += title + "\t" + artist;

      return description;
   }
}
