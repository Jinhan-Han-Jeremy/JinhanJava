
class Elevator
{
  final int MAXFLOOR = 15;
  static private int currentfloor;
  public Elevator(int cfloor)
{
  currentfloor = cfloor;
}
public void request(int newfloor)
{
  if (newfloor < 1 || newfloor > MAXFLOOR || newfloor == currentfloor)
    ;  // do nothing
  else if ( newfloor > currentfloor)  // move elevator up
           moveUp(newfloor);
  else  // move elevator down
	      moveDown(newfloor);   
  return;
}
  private void moveUp(int newfloor)
  {
   System.out.println("\nStarting at floor " + currentfloor + "\n");
    while (newfloor > currentfloor)
    {
      currentfloor++;    // add one to current floor
      System.out.println( "   Going Up - now at floor " + currentfloor + "\n");
    }
    System.out.println("Stopping at floor " + currentfloor + "\n");
  }
private void moveDown(int newfloor)
  {
    System.out.println("\nStarting at floor " + currentfloor + "\n");
    while (newfloor < currentfloor)
    {
      currentfloor--;   // subtract one from current floor
      System.out.println("   Going Down   now at floor " + currentfloor + "\n");
    }
	    System.out.println("Stopping at floor " + currentfloor + "\n");
  }
}

