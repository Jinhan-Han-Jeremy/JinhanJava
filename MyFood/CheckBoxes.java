import java.awt.*;
import java.awt.event.*;

public class CheckBoxes extends Dialog implements ItemListener
{
	private static final int POINT_SIZE = 12;
	private static final int HEIGHT_OF_BAR = 20;

	private boolean[] selectedItems;
	private String[] namesOfItems;
	private Label textLabel;
	private Checkbox[] item;
	private int numberOfItems;
		
	/**
	The CheckBoxes class enables an object that represents a label and 
      any number of check boxes defined by the programmer, to be 
represented in a dialog box.
	@param parent is the container to which the CheckBoxes object is 
      added.
	@param prompt is a text prompt indicating the generic content of the
      check box labels.
	@param itemsInList is an array of labels for the check boxes.
	*/
	public CheckBoxes(Frame parent, String prompt, String[] itemsInList)
	{
		super(parent, " Select item(s) then CLOSE ..", true);	
		numberOfItems = itemsInList.length;

		addWindowListener(new CloseDialogWindow());
		namesOfItems = itemsInList;			
		selectedItems = new boolean[numberOfItems];

		// set width and height of dialog box
		int screenWidth = parent.getWidth();
		int screenHeight = parent.getHeight();		

		// set location and size of dialog box
		int xLocationOfBox = (int)(0.7f * screenWidth);
		int yLocationOfBox = (int)(0.1f * screenHeight);
		int widthOfBox     = (int)(0.25f * screenWidth);
		int heightOfBox    = (int)((screenHeight/24)*(numberOfItems))+
                                 3*HEIGHT_OF_BAR;

		// set location and size of label
		int xLocationOfLabel = (int)(0.125f * widthOfBox);
		int yLocationOfLabel = (int)(1.5*HEIGHT_OF_BAR);
		int widthOfLabel     = (int)(0.9f * widthOfBox);
		int heightOfLabel    = (int)(HEIGHT_OF_BAR);

		// set size and location of first item
		int heightOfItem     = (int)(screenHeight/24);
		int widthOfItem      = (int)(0.9f * widthOfBox);
		int xLocationOfItem  = (int)(0.05f * widthOfBox);
		int yLocationOfItem  = (int)(2*HEIGHT_OF_BAR+
                                   (int)(heightOfItem/4));

		// set fonts
		Font dialog = new Font("Dialog", Font.PLAIN, POINT_SIZE);
		Font dialogInput = new Font("DialogInput", Font.BOLD, 
                                         POINT_SIZE);
		
		// set parameters of dialog box
		this.setBackground(Color.lightGray);
		this.setForeground(Color.black);
		this.setLocation(xLocationOfBox,yLocationOfBox);
		this.setSize(widthOfBox,heightOfBox);
		this.setFont(dialog);
		setLayout(null);

		// insert prompt into dialog box
		textLabel = new Label(prompt, Label.LEFT);
		textLabel.setLocation(xLocationOfLabel, yLocationOfLabel);
		textLabel.setSize(widthOfLabel,heightOfLabel);	
		textLabel.setFont(dialogInput);
		textLabel.setForeground(Color.black);
		this.add(textLabel);

		// insert a check box for each item
		item = new Checkbox[numberOfItems];
		for (int index=0; index != numberOfItems; index++)
		{
			item[index] = new Checkbox(itemsInList[index],false);			
			item[index].setLocation(xLocationOfItem, yLocationOfItem+
                                         (index*heightOfItem));
			item[index].setSize(widthOfItem, heightOfItem);			
			this.add(item[index]);
			item[index].addItemListener(this);
		}
	}

	/**
	Display the check boxes on the container.
	*/
	public void showCheckBoxes()
	{
	      for (int index=0; index != numberOfItems; index++)
			selectedItems[index] = false;
		
		this.setVisible(true);
	}

	/**
	Get a boolean array containing true for all those boxes checked,
	and false if the boxes are not checked.
	@return Returns a boolean array of items set to true that have been 
      checked.
	*/
	public boolean[] getCheckedBoxes()
	{
		return selectedItems;
	}

	public void itemStateChanged(ItemEvent event) 
	{ 
	   	int indexOfSelection = 0;
		String item = (String)event.getItem();		

		for (int index=0; index != numberOfItems; index++)
		{
			if (item.equals(namesOfItems[index]))
				indexOfSelection = index;
		}		

		if (event.getStateChange() == ItemEvent.SELECTED)
			selectedItems[indexOfSelection] = true;
		else if (event.getStateChange() == ItemEvent.DESELECTED)
			selectedItems[indexOfSelection] = false;					
	} 

	// inner class to handle closing dialog box event
	private class CloseDialogWindow extends WindowAdapter
	{
		public void windowClosing(WindowEvent event)
		{
			boolean boxesChecked = false;

			// check to see if any boxes are checked
			for (int index=0; index != numberOfItems; index++)
			{
				if (item[index].getState())
				{
					boxesChecked = true;
					break;
				}
			}

			if (boxesChecked)
			{
				CheckBoxes.this.setVisible(false);			

				for (int index=0; index != numberOfItems; index++)
				{
					item[index].setState(false);				
				}
			}	
		}
	}	
}
