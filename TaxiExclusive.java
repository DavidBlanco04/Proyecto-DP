
/**
 * Write a description of class TaxiExclsuive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int obtainComsumption(Taxi t)
    {
        int consumption = weight * t.getValorFuelConsumption() * t.getInitialPosition().distance(t.getLocation());
        return consumption;
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
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
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    @Override
   public void act(){
        serPopularEnRedes(this);
        super.act();
    }
}
