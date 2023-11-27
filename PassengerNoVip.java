
/**
 * Write a description of class PassengerNoVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PassengerNoVip extends Passenger
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name)
    {
        // initialise instance variables
        super(pickup,destination,name);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void pay()
    {
        this.setCreditCard(this.getCreditCard()-30);
    }
    
    public void calculateEvaluationValue(){
        
    }
}
