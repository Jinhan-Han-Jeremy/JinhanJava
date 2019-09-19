
class ExI_1 {

    public static void main(String[] args) {

        // instantiate an employee and a technician
        Employee caterer = new Employee("Millie Johnson", "Catering", 7);
        Technician lineWorker = new Technician("Susan Schroeder", "Electronics", 7);

        // use methods of superclass to display details of employee
        System.out.println("Using the superclass methods \n");
        System.out.println("Name: " + caterer.getName() + "\n");
        System.out.println("Department: " + caterer.getDepartment() + "\n");
        System.out.println("Service: " + caterer.getLengthOfService() +
                " years\n");
        System.out.println("Holidays: " + caterer.getHolidays() + " days\n\n");

        // use inherited methods of superclass to display details of a
        // technician
        System.out.println("Using the inherited superclass methods \n");
        System.out.println("Name: " + lineWorker.getName() + "\n");
        System.out.println("Department: " +
                lineWorker.getDepartment() + "\n");
        System.out.println("Service: " + lineWorker.getLengthOfService() +
                " years\n");
        System.out.println("Holidays: " + lineWorker.getHolidays() +
                " days\n\n");
    }
}
