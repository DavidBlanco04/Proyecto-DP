/**
 * Model a passenger wishing to get from one
 * location to another.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Passenger
{
    private String name;
    private Location pickup;
    private Location destination;
    private String taxiName;

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name)
    {
        if(pickup == null) {
            throw new NullPointerException("Pickup location");
        }
        if(destination == null) {
            throw new NullPointerException("Destination location");
        }
        this.pickup = pickup;
        this.destination = destination;
        this.name = name;
        this.taxiName = null;

    }

    /**
     *Receive a name. This becomes the passenger's name.
     *@param the passenger's name
     */
    public void setName(String Name){
        this.name = name;
    }

    /**
     * @return The name of the passenger.
     */
    public String getName()
    {
        return name;
    }

    /**
     *Receive a location. This becomes the location where the passenger wants to go.
     *@param the destination location
     */
    public void setDestination(Location destination)
    {
        this.destination = destination;
    }

    /**
     * @return The destination location.
     */
    public Location getDestination()
    {
        return destination;
    }

    /**
     * Return details of the passenger, such as where it is.
     * @return A string representation of the passenger.
     */
    public String toString()
    {
        return "Passenger "+getName()+" travelling from " +
        pickup + " to " + destination;
    }

    /**
     *Receive a location. This becomes the location where the passenger will be picked up.
     *@param the pick up location
     */
    public void setPickup(Location pickup)
    {
        this.pickup = pickup;
    }

    /**
     *@return the pick up location
     */
    public Location getPickup(){
        return pickup;
    }

    /**
     *Receive a name. This will be the name of the taxi where the passenger will be transported.
     *@param the taxi name
     */
    public void setTaxiName(String taxiName){
        this.taxiName = taxiName;
    }

    /**
     *@return the name of the taxi where the passenger will be transported
     */
    public String getTaxiName(){
        return taxiName;
    }

    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public String showFinalInfo()
    {
        return ("Passenger: "+ getName() + " in " + getDestination() + " Transported by : " + getTaxiName());
    }

}
