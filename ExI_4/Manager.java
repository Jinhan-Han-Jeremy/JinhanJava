

      public class Manager extends Employee
      {
              // instance variable
              protected float holidays;
    
              // constructor
              public Manager(String name, String department, int yearsService)
              {
                      super(name, department, yearsService);
              }
    
              // instance methods
              public float getHolidays()
              {
                      int service = super.getLengthOfService();
    
                      if (service > 10)
                              holidays = (float)(holidayEntitlement + (service - 10));
                      else
                              holidays = (float)holidayEntitlement;
    
                      return holidays;
              }
    
              public String toString()
             {
                      String temporary = new String("MANAGER\t"+super.toString());
                      return temporary;
              }
      }       