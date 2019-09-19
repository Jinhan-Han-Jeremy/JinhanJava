
/**
 * Write a description of class Robot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Robot
{
    private int x;
    private int y;
    
    private Picture pic;
    
    public Robot(int theX, int theY)
    {
        this.x = theX;
        this.y = theY;
        pic = new Picture("/Users/jinhanhan/Documents/cs46a/labs/lab3/graphics/myrobot.jpeg");
        pic.draw();
        
    }
    
    public void moveDown()
    {
      
        pic.translate(0,-1);
    
    }
    
    public void moveHorizontally(int x)
    {
       pic.translate(5,0); 
    }   
    /**@param x is
    */
   
    public void moveRight()
    {
      
        pic.translate(2,0);
    
    }
    /**
     public moveRight()
     @translate the position
         */
}