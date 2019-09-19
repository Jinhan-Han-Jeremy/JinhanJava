import avi.*;

public class Order
{
	// instance variable
	private boolean[] preSelection;
	private static String[] foodNames;
	
	// constructor
	/**
	The Order class enables an object to be created that represents the 
      quantities of food/beverages ordered from the menu.
	@param selectedItems is the one-dimensional array containing the 
      selected items from the menu.
	*/ 
	public Order(boolean[] selectedItems)
	{
		preSelection = selectedItems;
		foodNames = Menu.getFoodNames();		
	}

	// instance method
	/**
	Stores the quantity of food/ beverages required from the selected 
      items.
      @param screen is the container for the slider object
	@return An integer array with each cell corresponding to each of the 
      items on the menu, and representing the quanity of food/ beverages 
      ordered.
	*/
	public int[] quantityOrdered(Window screen)
	{
		int[] quantity = new int[preSelection.length];

		Slider inputQuantity = new Slider(screen,"Quantity?",1,10,1);
		
		for (int index=0; index != preSelection.length; index++)
		{
			if (preSelection[index])
			{
				screen.write("What quantity of "+foodNames[index]+
                                     " do you want to order?\n");
				inputQuantity.showSlider();
				quantity[index] = inputQuantity.getValue();
			}
			else
			{
				quantity[index] = 0;
			}
		}

		screen.clearTextArea();

		return quantity;
	}
}
