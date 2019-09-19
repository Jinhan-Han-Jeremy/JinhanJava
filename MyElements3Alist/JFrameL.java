/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gscott
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class JFrameL extends JFrame
{
    /** Creates a new instance of JFrameL */
    public JFrameL(String title) {
        super(title);
        FrameListener listener = new FrameListener();
        addWindowListener(listener);
    }
   private class FrameListener extends WindowAdapter
   {

    public void windowClosing(WindowEvent e) {
            //This will only be seen on standard output.
        if (!MyElements3AList.saved)
        {
            JOptionPane.showMessageDialog(null,"Hey, you havent saved your data, dummy!");
             MyElements3AList.writeElements();
        }
       System.out.println("WindowListener method called: windowClosed.");
       MyElements3AList.frame.setVisible(false);
       System.exit(0);
    }
   }   
}
