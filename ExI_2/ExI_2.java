

class ExI_2
{
	public static void main(String[] args)
	{


		Employee worker; 
		Technician lineWorker;
		Employee laboratoryWorker = new
                Employee("Peter Potter","Micro Laboratory",7);

		// any object of a subclass (Technician) can be assigned to an 
		// object of a superclass (Employee)
		worker = laboratoryWorker;
		System.out.println("The employee's name is "+worker.getName()+"\n");
		System.out.println("working in the "+worker.getDepartment()+
                         " department\n\n");

		// any object of a superclass (Employee) can be assigned to a 
		// subclass (Technician) using an appropriate cast
		lineWorker =(Technician)  worker;
		System.out.println("The technician's name is also "+
                          lineWorker.getName()+"\n");
		System.out.println("also working in the "+lineWorker.getDepartment()+
                         " department\n\n");
	}
}
