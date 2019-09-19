import avi.*;
import java.text.NumberFormat;

public class Menu
{
	// instance variables
	private CheckBoxes menu;
	private String[] menuItems;

	// class (static) variables
	private static String[] foodNames;
	private static float[] foodPrices;

	// constructor
	/**
	The Menu class enables an object to be created that represents a menu
      of food and beverages. The menu is represented as check boxes.
	@param screen is the container for the check boxes object.
	@param titleOfMenu is the titel that appears across the menu.
	@param food is a one-dimensional array containing the names of the
      foods/ beverages that appear on the menu.
	@param prices is a one-dimensional array of the prices of the food 
      and beverages.
	*/
	public Menu(Window screen, String titleOfMenu, 
                  String[] food, float[] prices)
	{
		NumberFormat money = NumberFormat.getCurrencyInstance();
		
		foodNames = new String[food.length];
		foodNames = food;
		foodPrices = new float[prices.length];
		foodPrices = prices;
		
		menuItems = new String[food.length];
		// concatenate price and food description
		for (int index=0; index != food.length; index++)
		{
			menuItems[index] = food[index]+
                  "  "+money.format(prices[index]);
		}
	
		menu = new CheckBoxes(screen, titleOfMenu, menuItems);		
	}

	// class (static) methods
	/**
	Get the names of foods on the menu.
	@return Returns an array of the names of the foods.
	*/
	public static String[] getFoodNames()
	{
		return foodNames;
	}

	/**
	Get the prices of foods on the menu.
	@return Returns an array of the prices of the foods.
	*/
	public static float[] getFoodPrices()
	{
		return foodPrices;
	}
	
	// instance methods
	/**
	Displays the menu on the screen.
	*/
	public void showMenu()
	{
		menu.showCheckBoxes();
	}

	/**
	Stores the checked items as true in a corresponding boolean array.
	@return A boolean array with each cell set at true for each 
      respective check box ticked.
	*/
	public boolean[] selection()
	{
		return menu.getCheckedBoxes();
	}	
}
