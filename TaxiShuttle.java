
/**
 * This is the class 'Taxi Shuttle' which has the same characteristics that
 * the superclass which belongs to (Taxi) but with other way to calculate the
 * fuel consumption and with a maximum occupation of 4 people. 
 */
public class TaxiShuttle extends Taxi
{
    /**
     * Constructor for objects of class TaxiShuttle
     */
    public TaxiShuttle(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption, int occupation)
    {
        super(company,location,name,fuelConsumption);
        this.occupation = occupation;
    }

    /**
     * This method calculates the fuel consumption of the vehicle, multiplying
     * its average fuel consumtion by the total distance traveled.
     * @param the taxi which we want to calculate its fuel consumption.
     * @return returns the fuel consumption made.
     */
    public int obtainConsumption(Taxi t)
    {
        int consumption =t.getValorFuelConsumption() * t.getInitialPosition().distance(t.getLocation()) ;
        return consumption;
    }
}
