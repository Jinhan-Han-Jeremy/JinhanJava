
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
       System.out.println("WindowListener method called: windowClosed.");
       MyElements3.frame.setVisible(false);
       System.exit(0);
    }
   }   
}
