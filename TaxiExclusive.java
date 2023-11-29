
/**
 * Write a description of class TaxiExclsuive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TaxiExclusive extends Taxi
{
    // instance variables - replace the example below with your own
    private int weight;
    private int popularity;
    /**
     * Constructor for objects of class TaxiExclusive
     */
    public TaxiExclusive(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption)
    {
        super(company,location,name,fuelConsumption);
        weight = 0;
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
    
    public void serPopularEnRedes(Taxi t){
        if(t.getPassenger().getCreditCard() > 20000){
            popularity =+ 4;
        }
        else{
            popularity--;
        }
    }
    @Override
   public void act(){
        
    }
}
