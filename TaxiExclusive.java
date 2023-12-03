
/**
 * This is the class 'Taxi Exclusive' which has the same characteristics that
 * the superclass which belongs to (Taxi). This kind of taxi has its own 
 * propierties such as its weight and its level of popularity on social networks. 
 */
public abstract class TaxiExclusive extends Taxi
{
    private int weight;
    private int popularity;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption, int weight)
    {
        super(company,location,name,fuelConsumption);
        this.weight = weight;
        popularity = 6;
    }

    /**
     * This method calculates the fuel consumption of the vehicle, multiplying
     * the half of its weight by its average fuel consumtion by the total 
     * distance traveled.
     * @param the taxi which we want to calculate its fuel consumption.
     * @return returns the fuel consumption made.
     */
    public int obtainComsumption(Taxi t)
    {
        int consumption = (weight/2) * t.getValorFuelConsumption() * t.getInitialPosition().distance(t.getLocation());
        return consumption;
    }

    /**
     * This method increases or decreases the vehicle's popularity on social 
     * networks depending on the vehicle's  valoration.  
     */
    public void serPopularEnRedes(Taxi t){
        if(t.getPassenger().getCreditCard() > 20000){
            popularity =+ 4;
        }
        else{
            popularity--;
        }
    }

    /**
     * Carry out a taxi's actions after increase or decrease the vehicle's
     * popularity on social networks.
     */
    @Override
    public void act(){
        serPopularEnRedes(this);
        super.act();
    }
}
