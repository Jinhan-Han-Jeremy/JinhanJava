

public class ChemicalElement 
{
	private String nameOfElement;
	private String chemicalSymbol;
	private int  atomicNumber;
        private static int numOfElements=0;

	/**
	The ChemicalElement class enables an object that represents a 
	chemical element from the periodic table of elements.
	@param name is the name of the element.
	@param symbol is the chemical symbol of the element.
	@param number is the atomic number of the element.
	*/
	public ChemicalElement(String name, String symbol, int number)
	{
		nameOfElement = name;
		chemicalSymbol = symbol;
		atomicNumber = number;
                numOfElements++;
	}

	/**
	@return The name of the element.
	*/
	public String getName()
	{
		return nameOfElement;
	}

	/**
	@return The chemical symbol of the element.
	*/
	public String getSymbol()
	{
		return chemicalSymbol;
	}

/**
	@return the atomic number of the element.
	*/
	public int getNumber()
	{
		return atomicNumber;
	}
/**
	@return the number of elements constructed.
	*/
	public static int getNumOfElements()
	{
		return numOfElements;
	}
/**
	@return an output string for the contents of the Object
	*/
	public  String toString()
	{
            String message;
                message = "The element name is "+nameOfElement+"\n" +
                "Its atomic symbol is "+chemicalSymbol+"\n" +
                "Its atomic number is "+atomicNumber;
		return message;
	}
}