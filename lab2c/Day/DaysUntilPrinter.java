
/**
 * Write a description of class DaysUntilPrinter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DaysUntilPrinter
{
    // instance variables - replace the example below with your own

    public static void main(String[] args)
    {
        Day today = new Day();
        //do not change this line
        System.out.println("Today is " + today.toString());
        Day ThanksgivingDay = new Day(2018, 11, 22);
        System.out.println(ThanksgivingDay.daysFrom(today));
        today.addDays(30);
         System.out.println(today.getYear());
          System.out.println(today.getMonth());
           System.out.println(today.getDayOfMonth());
    }
}
