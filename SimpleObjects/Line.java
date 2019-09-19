
public class Line
  {
    
	private Point first,second;// two instance variables from class Point

	public Line( Point initfirst, Point initsecond)  // constructor of the class
	{
		first=initfirst;
		second=initsecond;
	}


	public Point getPoint1()  // instance method to get 1st point
	{
	    return first;
	}
	
	public Point getpoint2()   // instance method to get 2nd point
	{
	    return second;
	}

	public double getSlope() // instance method to calc and return slope of line
	{
	    double slope;
	    double d;
	    d=(second.getX()-first.getX());
	    if (d==0)
	    {
	        System.out.println("slope is undefined");
	        return 99999.9;
	    }
            else 
	    {
	        slope=(second.getY()-first.getY())/d;
	        return slope;
            }
        }
 }
