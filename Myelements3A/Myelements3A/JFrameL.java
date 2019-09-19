/*
 * JFrameL.java
 *
 * Created on November 14, 2007, 8:36 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 *
 * @author faculty
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFrameL extends JFrame 
{
    
    /** Creates a new instance of JFrameL */
    public JFrameL(String title) {
        super(title);
        FrameListener fl = new FrameListener();
        addWindowListener(fl);
    }
   private class FrameListener extends WindowAdapter
   {

    public void windowClosing(WindowEvent e) {
       //This will only be seen on standard output.
       System.out.println("WindowListener method called: windowClosed.");
       setVisible(false);
       System.exit(0);
    }

   }   
}
