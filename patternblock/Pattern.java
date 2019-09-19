import java.awt.*;
import javax.swing.*;

public class Pattern extends JComponent
{
   public static final int GRID_SIZE = 20;
   public static final int ROWS = 10;
   public static final int COLUMNS = 10;      

   public boolean fill(int row, int column)
   { 
       //return ((column<7&&column>=3)&&(row<7&&row>=3));
       //return ((row<7&&row>=3));
        //return ((column%2 == 1 || row %2 == 0) && (column%2 == 0 || row %2 == 1));   
        return !(column%2==1&&row%2==1);
   }
   
   //return !(row>0 && row<10 && column<10 && column>0);
   // return (row%2==0);
   //return !(column%2==0);    
   public void paintComponent(Graphics g)
   {
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.RED);
      Pattern pattern = new Pattern();
      for (int i = 0; i < ROWS; i++)
         for (int j = 0; j < COLUMNS; j++)
            if (pattern.fill(i, j))
               g2.fill(new Rectangle(
                     j * GRID_SIZE,
                     i * GRID_SIZE, 
                     GRID_SIZE - 1, 
                     GRID_SIZE - 1));
   }
   
   public Dimension getPreferredSize() 
   {
      return new Dimension(GRID_SIZE * COLUMNS,
         GRID_SIZE * ROWS);
   }

   public static void main(String[] args)
   {
      JFrame frame = new JFrame();
      frame.add(new Pattern());
      frame.pack();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }
}