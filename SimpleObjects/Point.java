

//Point.java
public class Point 
{ 
    int x,y;      // cooordinates of thePoint
	 //Point object constructor
    public Point(int initx, int inity)
    {
        x = initx;
        y = inity;
    }
//instance method to return x coord of Point
    public int getX()
    {
        return x;
    }
//instance method to return y coord of Point
    public int  getY()
	 {
        return y;
    }
//instance method to return the quadrant of the Point
    public int getQuadrant()
    {
		 if ( x>=0 && y>=0)
         return 1;
		 else if ( x<=0 && y>=0)
		        return 2;    
				else if ( x<=0 && y<=0)
			        	 return 3;
					  else
					    return 4;
    }
}
