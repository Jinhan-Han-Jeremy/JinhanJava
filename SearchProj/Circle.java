
//-----Circle.java--------------
public class Circle 
{
	private double radius;
	private Point center;
}
public Circle(double rad, Point middle)
{
radius = rad;
center = middle;
}
public double getRadius()
{
return radius;
}
public double getDiameter()
{
return 2.0*radius;
}
public double getCircumference()
{
return 2.0*Math.PI*radius;
}
public double getArea()
{
return Math.PI*radius*radius;
}
}
