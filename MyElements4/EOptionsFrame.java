import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class EOptionsFrame extends JFrameL
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;
    private JMenu fileMenu, elementsMenu;
    private JMenuItem readFile,writeFile,addElement,listElements,findElement;
    private JMenuBar bar;
    public EOptionsFrame(String title )
    {
        super(title);
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        fileMenu = new JMenu("File");
        
        MenuListener ml = new MenuListener();     

        readFile = new JMenuItem("Read Elements");
        readFile.addActionListener(ml);
        fileMenu.add(readFile);

        writeFile = new JMenuItem("Save Elements");
        writeFile.addActionListener(ml);
        fileMenu.add(writeFile);

        elementsMenu = new JMenu("Elements");
        
        addElement = new JMenuItem("Add Element");
        addElement.addActionListener(ml);
        elementsMenu.add(addElement);

        listElements = new JMenuItem("List Elements");
        listElements.addActionListener(ml);
        elementsMenu.add(listElements);

        findElement = new JMenuItem("Find Element");
        findElement.addActionListener(ml);
        elementsMenu.add(findElement);

        bar = new JMenuBar( );
        bar.add(fileMenu);
        bar.add(elementsMenu);
        setJMenuBar(bar);


    }
    private class MenuListener implements ActionListener
    {
      public void actionPerformed (ActionEvent event) 
      {
         String source = event.getActionCommand();

         if (source.equals("Add Element"))
           MyElements4.addElements();
         else
            if (source.equals("List Elements"))
               MyElements4.listElements();
            else
                if (source.equals("Find Element"))
                   MyElements4.findElement();
                else
                   if (source.equals("Read Elements"))
                      MyElements4.readElements();
                  else
                     if (source.equals("Save Elements"))
                        MyElements4.writeElements();
      }
    } //End of inner class
}
