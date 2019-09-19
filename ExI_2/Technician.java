
      public class Technician extends Employee
       {
               // instance variable
               protected float holidays;
     
               // constructor
               public Technician(String name, String department, int yearsService)
               {
                       super(name, department, yearsService);
             }
    
              // overridden instance method
              public float getHolidays()
              {
                      int service = this.getLengthOfService();
   
                     if (service > 5)
                              holidays = (float)(holidayEntitlement+0.5f*(service-5));
                     else
                              holidays = (float)holidayEntitlement;
    
                      return holidays;
              }
    
              public String toString()
              {
                      String temporary = new String("TECHNICIAN\t"+super.toString());
                      return temporary;
              }
    
      }    