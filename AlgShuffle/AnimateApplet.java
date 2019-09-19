/*
 * AnimateApplet.java
 *
 * Created on December 6, 2007, 3:39 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package mypackage;
import java.awt.*; 
//import java.awt.Graphics;
import javax.swing.*;
public class AnimateApplet extends JApplet implements Runnable
{
   Thread theThread;  
   Font myfont;   
   FontMetrics fontmet;   
   String str="The Last Java Example";
   boolean loop = true;  
   int strWidth;  
   int xpos;  
   int ypos;  
   int winWidth;  
   public void init() 
   {  
          myfont = new Font("TimesRoman",Font.BOLD,24);  
          fontmet = getFontMetrics(myfont);  
          strWidth = fontmet.stringWidth(str);
		  Toolkit tools = this.getToolkit();  
		  Dimension size = tools.getScreenSize();
          winWidth=size.width;  
          ypos = (size.height/2 - fontmet.getHeight());  
          ypos=ypos+fontmet.getHeight();  
          setBackground(Color.white);  
   }  
   public void start() 
   {  
      if (theThread==null) 
      {  
         theThread=new Thread(this);  
         theThread.start();  
      }  
   }  
   public void run() 
   {  
       while (loop) 
       {  
         for (int i=winWidth; i>0-strWidth; i--) 
         {  
            xpos=i;  
            repaint();  
            try {theThread.sleep(50);}  
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
      g.setColor(Color.blue);  
      g.setFont(myfont);  
      g.drawString(str,xpos,ypos);  
   }  
} 

