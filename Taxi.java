/**
 * Model the common elements of taxis and shuttles.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;   //TODO cambiar a private
    // Where the vehicle is.
    private Location location;     //TODO cambiar a private
    // Where the vehicle is headed.
    private  Location targetLocation;   //TODO cambiar a private
    // Record how often the vehicle has nothing to do.
    private int idleCount;       //TODO cambiar a private
    //name of the taxi
    private String name; //TODO cambiar a private
    //the passenger who is in the taxi right now.
    private Passenger passenger;
    //Total number of passengers that the taxi transport.
    private int passengersTransported;
    //TODO añadir campos necesarios
    int valuation;//valoracion para cada taxi
    int occupation;

    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TransportCompany company, Location location, String name)
    {
        if(company == null) {
            throw new NullPointerException("company");
        }
        if(location == null) {
            throw new NullPointerException("location");
        }
        this.company = company;
        this.location = location;
        this.name = name;
        targetLocation = null;
        idleCount = 0;
        passenger = null;
        passengersTransported = 0;
    }

    /**
     * @return the name of the taxi
     */
    public String getName()
    {
        return name;
    }

    /**
     *Receive a name. This will be the taxi name
     *@param the taxi name
     */
    public void setName(String name)
    {
        this.name=name;
    }

    /**
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }

    /**
     * Get the passenger.
     * @return the passenger who is in the taxi right now.
     */
    public Passenger getPassenger()
    {
        return passenger;
    }

    /**
     *Receive a passenger. This will be the name of the passenger who is in the taxi.
     *@param the passenger name
     */
    public void setPassenger(Passenger passenger){
        this.passenger = passenger;
    }

    /**
     * Set the current location.
     * @param location Where it is. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setLocation(Location location)
    {
        if(location != null) {
            this.location = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Get the target location.
     * @return Where this vehicle is currently headed, or null
     *         if it is idle.
     */
    public Location getTargetLocation()
    {
        return targetLocation;
    }

    /**
     * Set the required target location.
     * @param location Where to go. Must not be null.
     * @throws NullPointerException If location is null.
     */
    public void setTargetLocation(Location location)
    {
        if(location != null) {
            targetLocation = location;
        }
        else {
            throw new NullPointerException();
        }
    }

    /**
     * Receive a pickup location. This becomes the
     * target location.
     * @param location The pickup location.
     */
    public void setPickupLocation(Location location)
    {
        setTargetLocation(location);
    }

    /**
     * Has the vehicle a target Location?
     * @return Whether or not this vehicle has a target Location.
     */
    public boolean hasTargetLocation(){
        return getTargetLocation() != null;
    }

    /**
     * Clear the target location.
     */
    public void clearTargetLocation()
    {
        targetLocation = null;
    }

    /**
     * @return on how many steps this vehicle has been idle.
     */
    public int getIdleCount()
    {
        return idleCount;
    }

    /**
     * Receive a number of steps. This becomes the steps this vehicle has been idle.
     * @param a number of steps.
     */
    public void setIdleCount(int idleCount)
    {
        this.idleCount=idleCount;
    }

    /**
     * @return on how many passengers this vehicle has transported.
     */
    public int getPassengersTransported(){
        return passengersTransported;
    }

    /**
     * Receive a number of passengers. This becomes the number of passengers this vehicle has trasnported.
     * @param a number of steps.
     */
    public void setPassengersTransported(int passengersTransported){
        this.passengersTransported=passengersTransported;
    }

    /**
     * @return the company that the taxi is from.
     */
    public TransportCompany getCompany(){
        return this.company;
    }

    /**
     * Receive a company. This becomes the company where the taxi is from has been idle.
     * @param the company.
     */
    public void setCompany(TransportCompany c){
        company=c;
    }

    /**
     * Increment the number of steps on which this vehicle
     * has been idle.
     */
    public void incrementIdleCount()
    {
        idleCount++;
    }

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String toString()
    {
        return getClass().getName() + " " +getName()+" at " + getLocation();
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        boolean free = false;
        if(passenger == null){
            free = true;
        }
        return free;
    }

    /**
     * Notify the company of our arrival at a pickup location.
     */
    public void notifyPickupArrival()
    {
        this.company.arrivedAtPickup(this);
    }

    /**
     * Notify the company of our arrival at a passenger's destination.
     */
    public void notifyPassengerArrival(Passenger passenger)
    {
        System.out.println(this.company.arrivedAtDestination(this, passenger));
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location. Also set the name of the taxi where the passenger will be transported 
     *                                                     and set the taxi's passenger.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        targetLocation = passenger.getDestination();
        passenger.setTaxiName(this.name);
        setPassenger(passenger);

    }

    /**
     * Offload the passenger.
     */
    public void offloadPassenger()
    {
        passenger=null;
        clearTargetLocation();
    }

    /**
     * @return how many passengers this vehicle has transported.
     */
    public int passengersTransported()
    {
        return passengersTransported;
    }

    /**
     * Increment the number of passengers this vehicle has transported.
     */
    protected void incrementPassengersTransported()
    {
        passengersTransported++;

    }

    /**
     * Get the distance to the target location from the current location.
     * @return distance to target location.
     */
    public int distanceToTheTargetLocation()
    {
        return this.location.distance(targetLocation);
    }

    /**
     * Carry out a taxi's actions.
     */
    public void act()
    {
        if(targetLocation==null){
            incrementIdleCount();
        }
        else{
            location = location.nextLocation(targetLocation);
            System.out.println(this.getName() +" moving to:"+ location);
            if(this.location.equals(this.targetLocation)){
                if(isFree()){
                    notifyPickupArrival();

                }
                else{
                    notifyPassengerArrival(passenger);
                    offloadPassenger();
                    incrementPassengersTransported();

                }
            }
        }
    }

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String showFinalInfo()
    {
        return ("Taxi "+ getName() + " at " + getLocation() 
            + " Passengers transported: " + getPassengersTransported()
            + " - non active for: " + getIdleCount() + " times");

    }

}
