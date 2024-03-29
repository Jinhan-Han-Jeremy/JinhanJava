//********************************************************************
//  Einstein.java       Author: Lewis/Loftus
//
//  Demonstrates a basic applet.
//********************************************************************
import java.awt.*;
public class Einstein extends java.applet.Applet 
{
//-----------------------------------------------------------------   
//  Draws a quotation by Albert Einstein among some shapes.   
//-----------------------------------------------------------------
   public void paint (Graphics page)
   {
      page.drawRect (50, 50, 40, 40);     // square
      page.drawRect (60, 80, 225, 30);   // rectangle
      page.drawOval (75, 65, 20, 20);    // circle
      page.drawLine (35, 60, 100, 120);  // line
      page.drawString ("Out of clutter, find simplicity.", 110, 70);
      page.drawString ("-- Albert Einstein", 130, 100);
   }
}