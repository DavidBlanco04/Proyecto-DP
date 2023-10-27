
/**
 * Write a description of class Assignment here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Assignment
{
    private Taxi t;
    private Passenger P;

    /**
     * Constructor for objects of class Assignment
     */
    public Assignment(Taxi t, Passenger P)
    {
        this.t = t;
        this.P = P;
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public Taxi getTaxi()
    {
        return this.t;
    }
    
    public Passenger getPassenger()
    {
        return this.P;
    }
    
    public void setTaxi(Taxi taxi1)
    {
        this.t = taxi1;
    }
    
    public void setPassenger(Passenger P1)
    {
        this.P = P1;
    }
}
