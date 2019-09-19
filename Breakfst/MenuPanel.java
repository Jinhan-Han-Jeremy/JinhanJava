import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.NumberFormat;

public class MenuPanel extends JPanel {
    private static NumberFormat fmt = NumberFormat.getCurrencyInstance();

    //private boolean[] selectedItems;

    private JLabel foodColLabel,priceColLabel,priceLabel;
    public static JCheckBox[] items;
    private int numberOfItems;
    private JButton checkOut;
    public static String[] namesOfItems = {"Eggs","Blueberry Pancakes",
                            "Bagels with Cream Cheese",
        		     "English Muffin","Yogurt",
                                 "Corned Beef Hash","Toast",
				     "Fries","Tea","Coffee","Hot Chocolate"};
    public static float[] prices = {2.75f,4.0f,1.5f,0.95f,1.0f,1.75f,
                                    0.75f,1.0f,0.75f,1.20f,1.95f};		

    public MenuPanel()
    {

	numberOfItems = namesOfItems.length;		
	//selectedItems = new boolean[numberOfItems];
		// set layout
	setLayout(new GridLayout(numberOfItems+2,2));
		// insert labels 
	foodColLabel = new JLabel("MenuItems");
	priceColLabel = new JLabel("Price of Items");
	add(foodColLabel);
	add(priceColLabel);
		// insert a check box for each item
	items = new JCheckBox[numberOfItems];
	for (int index=0; index != numberOfItems; index++)
	{
            items[index] = new JCheckBox(namesOfItems[index],false);
            items[index].setBackground (Color.green);
            add(items[index]);
            priceLabel = new JLabel(fmt.format(prices[index]));
            add(priceLabel);                
		//	item[index].addItemListener(this);		}
        }
        checkOut = new JButton("CheckOut");
        ButtonListener bl = new ButtonListener();
        checkOut.addActionListener(bl);
 	add(checkOut);       
        setBackground (Color.green);
        setPreferredSize (new Dimension(400, 500));
   }        
        
        
    private class ButtonListener implements ActionListener
   {
      //--------------------------------------------------------------
      //  Calls the method when Button is pressed
      //--------------------------------------------------------------
      public void actionPerformed (ActionEvent event)
      {
         Object source = event.getSource();

         if (source == checkOut)
         {
         //  Breakfast.frame.setVisible(false);
           Breakfast.displayInvoice(items,prices,namesOfItems);
         }
      }
   }
}