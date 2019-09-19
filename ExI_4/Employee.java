

       public class Employee
       {
               // constant
               protected final static float holidayEntitlement = 20.0f;
     
               // instance variables
               protected String employeeName;
               protected String employeeDept;
               protected int lengthOfService;
    
              // constructor
              public Employee(String name, String department, int yearsService)
              {
                      employeeName = name;
                      employeeDept = department;
                      lengthOfService = yearsService;
              }
    
              // instance methods
              public String getName()
              {
                      return employeeName;
              }
    
              public String getDepartment()
              {
                      return employeeDept;
              }
    
              public int getLengthOfService()
             {
                      return lengthOfService;
              }
    
              public float getHolidays()
              {
                      return holidayEntitlement;
              }
    
              public String toString()
              {
                      String temporary = new String("Name: "+employeeName+
                                             "\nDept: "+employeeDept+
                                                   "\nService: " +lengthOfService);
                      return temporary;
              }

              public boolean equals(Object e)  
              {
                   if (this.employeeName.equals(((Employee)e).employeeName))
                        return true;
                      else
                        return false;
              }


      } 