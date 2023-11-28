
/**
 * Write a description of class PassengerNoVip here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class PassengerNoVip extends Passenger
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name,Reliable reliable)
    {
        // initialise instance variables
        super(pickup,destination,name,reliable);
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
    
    public int calculateEvaluationValue(Taxi t){
         int a=getValorReliable() * 2;
         t.setValuation(a);
         return t.getValuation();
    }
}
