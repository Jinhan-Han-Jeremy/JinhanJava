

    
        class ExI_4
        {
              static void displayDetails(Employee person)
              {
                      System.out.println(person+"\n");
                      System.out.println("Holidays: "+person.getHolidays()+"\n\n");
              }
    
              public static void main(String[] args)
              {
    
                      Technician lineWorker = new
                           Technician("Franco Ramirez","Electronics",18);
                      Manager computerManager = new
                          Manager("Brian Biggins","Computing",21);
    
                      displayDetails(lineWorker);
                      displayDetails(computerManager);
              }
      } 
