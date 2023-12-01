
/**
 * Write a description of class TaxiShuttle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TaxiShuttle extends Taxi
{

    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption)
    {
        super(company,location,name, fuelConsumption);
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int obtainComsumption(Taxi t)
    {
        int consumption =t.getValorFuelConsumption() * t.getInitialPosition().distance(t.getLocation()) ;
        return consumption;
    }
}
