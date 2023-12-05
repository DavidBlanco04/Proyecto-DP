import java.util.TreeSet;
/**
 *This is the Taxi class 
 */
public abstract class Taxi 
{
    // The Taxi Company of this Taxi.
    private TransportCompany company;   
    // Where the vehicle is.
    private Location location;     
    // Where the vehicle is headed.
    private  Location targetLocation;   
    //The position where the taxi where created initially
    private Location initialPosition;
    // Record how often the vehicle has nothing to do.
    private int idleCount;    
    //name of the taxi
    private String name; 
    //the passenger who is in the taxi right now.
    private TreeSet<Passenger> passenger;
    //Total number of passengers that the taxi transport.
    private int passengersTransported;
    //valuation for each taxi
    int valuation;
    //The maximum occupation of th taxi it must be a number between 1 and 4
    int occupation;
    
    FuelConsumption fuelConsumption;
    /**
     * Constructor of class Vehicle
     * @param company The taxi company. Must not be null.
     * @param location The vehicle's starting point. Must not be null.
     * @param name. The vehicle's name. Must not be null.
     * @param fuelConsumption. The average vehicle fuel consumption. 
     * Must not be null.
     * @throws NullPointerException If company or location is null.
     */
    public Taxi(TransportCompany company, Location location, String name, FuelConsumption fuelConsumption)
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
        this.initialPosition = location;
        setFuelConsumption(fuelConsumption);
        targetLocation = null;
        idleCount = 0;
        passenger =new TreeSet< >(new ComparadorArrivalTime());
        passengersTransported = 0;
        this.occupation = 1;
        valuation=0;
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
        return passenger.first();
    }

    /**
     *Receive a passenger. This passenger will be added to the passengers set.
     *@param the passenger name
     */
    public void setPassenger(Passenger passenger){
        this.passenger.add(passenger);
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
     * @return Where this vehicle where created initially.
     */
    public Location getInitialPosition()
    {
        return initialPosition;
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
     * Receive a number of steps. This becomes the steps this vehicle has been 
     * idle.
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
     * Receive a number of passengers. This becomes the number of passengers 
     * this vehicle has trasnported.
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
     * Receive a company. This becomes the company where the taxi is from has 
     * been idle.
     * @param the company.
     */
    public void setCompany(TransportCompany c){
        company=c;
    }
    
    /**
     * @return the valuation of the vehicle.
     */
    public int getValuation(){
        return valuation;
    }
    
    /**
     * Recieve a valuation. This becomes the valuation of a vehicle.
     * @param the valuation that the passengers give to a vehicle.
     */
    public void setValuation(int valuation){
        this.valuation = valuation;
    }
    
    /**
     * @return a enum that represents the average vehicle fuel consumption.
     */
    public FuelConsumption getFuelConsumption(){
        return fuelConsumption;
    }
    
    /**
     *@return the exact value of the average vehicle fuel consumption.
     */
    public int getValorFuelConsumption(){
        return fuelConsumption.getValor();
    }
    
    /**
     * Recieve a fuel consumption amount. This becomes the vehicle fuel 
     * consumption
     * @param The average vehicle fuel consumption.
     */
    public void setFuelConsumption(FuelConsumption fuelConsumption){
        this.fuelConsumption = fuelConsumption;
    }
    
    /**
     * @return the maximum occupation of a taxi.
     */
    public int getOccupation(){
        return occupation;
    }
    
    /**
     * Recieve a number. This will be the maximum occupation of the taxi. 
     * @param An integer that represents the maximum occupation of the vehicle.
     */
    public void setOccupation(int occupation){
        this.occupation = occupation;
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
        return getClass().getName() + " " +getName()+" at location: " + getLocation()+ " occupation: "
        + getOccupation()+ " <fuel consumption: "+ getFuelConsumption()+ " (value: "+ getValorFuelConsumption()
        + ")>";
    }

    /**
     * Is the taxi free?
     * @return Whether or not this taxi is free.
     */
    public boolean isFree()
    {
        if(occupation<4){
            return true;
        }
        return false;
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
     * Set passenger's destination as its target location. 
     * Also set the name of the taxi where the passenger will be transported 
     * and set the taxi's passenger.
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
                    notifyPassengerArrival(passenger.first());
                    offloadPassenger();
                    incrementPassengersTransported();

                }
            }
        }
    }
    
    /**
     *returns the fuel consumption made. Each type of taxi will 
     *calculate this consumption in a different way.
     * @return The fuel consumtion of the taxi.
     */
    public abstract int obtainConsumption(Taxi t);

    /**
     * Return details of the taxi, such as where it is.
     * @return A string representation of the taxi.
     */
    public String showFinalInfo()
    {
        return (getClass().getName() +" "+ getName() + " at " + getLocation() 
            + " Passengers transported: " + getPassengersTransported()
            + " - non active for: " + getIdleCount() + " times - valuation: "+ getValuation()
            + " - consumption: "+ getValorFuelConsumption());

    }

}
