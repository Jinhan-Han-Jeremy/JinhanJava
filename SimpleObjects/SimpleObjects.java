

/* @author gscott */
public class SimpleObjects {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        TrafficLight tl = new TrafficLight();
        tl.change();
        tl.change();
        tl.change();
        tl.change();
        
        Elevator e =  new Elevator(1);
        e.request(6);
        Elevator e2 =  new Elevator(5);
        e2.request(1);
        e.request(3); 
        
    }    
}
