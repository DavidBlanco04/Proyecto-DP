
/**
 * This is the class 'Passengers VIP' which has the same characteristics that
 * the superclass which belongs to (Passenger) but with other way to pay.
 */
public abstract class PassengerNoVip extends Passenger
{

    /**
     * Constructor for objects of class PassengerNoVip
     */
    public PassengerNoVip(Location pickup, Location destination, String name,Reliable reliable)
    {
        super(pickup,destination,name,reliable);
    }

    /**
     * The passenger pays the transport and the money on his/her credit card
     * is reduced on 30 euros.
     */
    @Override
    public void pay()
    {
        this.setCreditCard(this.getCreditCard()-30);
    }
}
