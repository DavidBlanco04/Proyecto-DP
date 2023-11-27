
/**
 * Write a description of class TaxiExclsuive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TaxiExclusive extends Taxi
{
    // instance variables - replace the example below with your own
    private int x;
    private int weight;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name)
    {
        super(company,location,name);
        weight = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
