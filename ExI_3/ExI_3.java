
class ExI_3
{
	public static void main(String[] args)
	{

	  Employee caterer = new Employee("Millie Johnson", "Catering", 7);
	  Employee caterer2 = new Employee("Millie Johnson", "Catering", 7);
          
	  Technician lineWorker = new Technician("Millie Johnson", "Micro Laboratory", 7);
          
          System.out.println(caterer);// calls the Object class toString()
          
          System.out.println(caterer.getName()+" in the "+
 			caterer.getDepartment()+" department has "+
			caterer.getHolidays()+
                        " days holiday entitlement\n\n");

		// use overridden method getHolidays in the Technician class
	  System.out.println(lineWorker.getName()+" in the "+
                        lineWorker.getDepartment()+" department has "+
			 lineWorker.getHolidays()+
                        " days holiday entitlement\n\n");
		
          //call the overridden equals method to compare to Employee objects
          if (caterer.equals(lineWorker))
              System.out.println("The two objects have the same name");
          else 
              System.out.println("The two objects do not have the same name");
	}
}
