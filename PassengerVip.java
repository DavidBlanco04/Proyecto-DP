
/**
 * This is the class 'Passengers VIP' which has the same characteristics that
 * the superclass which belongs to (Passenger) but with other new ones.
 */
public class PassengerVip extends Passenger
{
    /**
     * Constructor for objects of class PassengerVip
     */
    public PassengerVip(Location pickup, Location destination, String name,int arrivalTime, int creditCard,Reliable reliable)
    {
        super(pickup,destination,name,arrivalTime,creditCard,reliable);
    }

    /**
     * The passanger pays 600 euros for the transport because this kind of 
     * passenger makes very exclusive trips. The passanger also gives a 10 
     * euros tip to the driver.
     */
    @Override
    public void pay()
    {
        this.setCreditCard(this.getCreditCard()-610);
    }
    /**
     * This method calculates the valuation of the vehicle such the rest of
     * passengers but incrementing it in 15 points.
     * @return 
     */
    public int calculateEvaluationValue(){
         return super.calculateEvaluationValue()+15;
    }
}
