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
     * Get the location.
     * @return Where this taxi is currently located.
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Get the location.
     * @return .
     */
    public Passenger getPassenger()
    {
        return passenger;
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
    * @return on how many passengers this vehicle has transported.
    */
    public int getPassengersTransported(){
        return passengersTransported;
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
            System.out.println ("El taxi que ha solicitado esta libre");
        }
        else{
            System.out.println ("El taxi que ha solicitado esta ocupado");
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
        this.company.arrivedAtDestination(this, passenger);
    }

    /**
     * Receive a passenger.
     * Set passenger's destination as its target location.
     * @param passenger The passenger.
     */
    public void pickup(Passenger passenger)
    {
        targetLocation = passenger.getDestination();
        passenger.setTaxiName(name);

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
            idleCount++;
        }
        else{
            Location next=location;
            next.nextLocation(targetLocation);
            if(next.equals(targetLocation)){
                if(passenger==null){
                    notifyPickupArrival();
                    pickup(passenger);
                }
                else{
                    notifyPassengerArrival(passenger);
                    offloadPassenger();
                    passengersTransported++;
                    
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
        return ("Taxi name: "+ getName() +" "+"Location: " + getLocation() 
        + " " + "Number of passenger transported: " + getPassengersTransported()
        + " " + "Number of inactive steps: " + getIdleCount());

    }

}
