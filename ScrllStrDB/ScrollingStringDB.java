/*
 * ScrollingString.java
 *
 * Created on December 6, 2007, 4:17 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
  
public class ScrollingStringDB extends Applet implements Runnable   
{  
   Graphics bufferGraphics; 
   Image offscreen; 
   Thread theThread;  
   Font myfont;   
   FontMetrics fontmet;   
   String str="The Last Java Example";
   boolean loop = true;  
   int strWidth;  
   int xpos;  
   int ypos;  
   int winWidth;  
   Dimension size;
   public void init() 
   {  
          myfont = new Font("TimesRoman",Font.BOLD,22);  
          fontmet = getFontMetrics(myfont);  
          strWidth = fontmet.stringWidth(str);
		  Toolkit tools = this.getToolkit();  
		  size = tools.getScreenSize();
          winWidth=size.width;  
          ypos = (size.height/2 - fontmet.getHeight());  
          ypos=ypos+fontmet.getHeight();  
          setBackground(Color.white);
          offscreen = createImage(size.width,size.height); 
          bufferGraphics = offscreen.getGraphics(); 
   }  
   public void start() 
   {  
      if (theThread==null) 
      {  
         theThread=new Thread(this);  
         theThread.start();  
      }  
   }  
   public void run() //this method belongs to the Thread
   {  
       while (loop) 
       {  
         for (int i=winWidth; i>0-strWidth; i--) 
         {  
            xpos=i;  
            repaint();  
            try {theThread.sleep(2);}  
            catch (InterruptedException e) {}  
         }  
      }  
   }  
   public void stop() 
   {  
      if (theThread!=null) 
      {  
         loop=false;  
         theThread=null;  
      }  
   }  
   public void paint(Graphics g) 
   { 
      bufferGraphics.clearRect(0,0,size.width,size.height); 
      bufferGraphics.setColor(Color.blue);
      bufferGraphics.setFont(myfont);
      bufferGraphics.drawString(str,xpos,ypos);
      g.drawImage(offscreen,0,0,this);
    }  
    public void update(Graphics g) 
   { 
      paint(g); 
   } 
  
} 

