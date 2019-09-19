
/* @author gscott  */

public class TrafficLight
{
  // data declaration section
  private String color;
  // methods declaration section 
  public TrafficLight() // default constructor
  {
	  color = "red";
  }
  public void change()
  {
    if(color.equals("red"))
	{
		color = "green";
		System.out.println("The color changed to green");
	}
	else if(color.equals("yellow"))
	{
		color = "red";
		System.out.println("The color changed to red");
	}
	else
	{
		color = "yellow";
		System.out.println("The color changed to yellow");
	}
  }
}



