/**
 *This is the Passenger class 
 */
public abstract class Passenger
{
    private String name;
    private Location pickup;
    private Location destination;
    private String taxiName;
    private int arrivalTime;//Hora en la que le pasajero debería llegar a su destino.
    private int creditCard;
    private Reliable reliable;

    /**
     * Constructor for objects of class Passenger
     * @param pickup The pickup location, must not be null.
     * @param destination The destination location, must not be null.
     * @param name The passenger's name
     * @param taxiName The taxi's name 
     * @param arrivalTime the time when the passenger should arrive at the destination
     * @param crediCard how much money has the passenger in his/her creditCard
     * @param reliable the level of reliability of the passenger
     * @throws NullPointerException If either location is null.
     */
    public Passenger(Location pickup, Location destination, String name,int arrivalTime, int creditCard,Reliable reliable)
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
        setReliable(reliable);
        this.arrivalTime= arrivalTime;
        this.creditCard= creditCard;
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
     *Receive a name. This becomes the passenger's name.
     *@param the passenger's name
     */
    public void setCreditCard(int creditCard){
        this.creditCard = creditCard;
    }

    /**
     * @return The name of the passenger.
     */
    public int getCreditCard()
    {
        return creditCard;
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
        return getClass().getName()+ " " +getName()+" travelling from " +
        pickup + " to " + destination + " arrival time: " + getArrivalTime()+ " money in the credit card: "+
        getCreditCard()+ " <reliable: "+ getReliable() + " (value: "+ getValorReliable()+ ")>";
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
     *@return a enum that represents the reliability of the passenger
     */
    public Reliable getReliable(){
        return reliable;
    }

    /**
     *@return the value of the reliability of the passenger
     */
    public int getValorReliable(){
        return reliable.getValor();
    }

    /**
     *Recieves a reliability. This will be the reliability of the passenger. 
     *@param the new reliability of the vehicle's passenger
     */
    public void setReliable(Reliable reliable){
        this.reliable = reliable;
    }

     /**
     *@return the time when the passenger should arrive at their destination.
     */
    public int getArrivalTime(){
        return arrivalTime;
    }
    
    /**
     *Recieves an hour. This becomes the passenger's arrival time. 
     *@param the hour when the passenger should arrive at their destination.
     */
    public void setArrivalTime(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }
    /**
     * Show the final information about the passenger, including the name of the taxi that used.
     */
    public String showFinalInfo()
    {
        return (getClass().getName()+ " "+ getName() + " in " + getDestination() + " Transported by : " + getTaxiName()+ " with "+ getCreditCard()+ " money in the credit card");
    }
    /**
     * This method allows a passenger to pay the vehicle where was trasnported.
     * Each type of passenger pays in a different way.
     */
    public abstract void pay();
    /**
     * This method increments the vehicle's valuation with the double of the 
     * passengers reliability value.
     * @return the vehicle's valuation where the passenger traveled
     */
    public int calculateEvaluationValue(){
         int a=getValorReliable() * 2;
         return a;
    }
    /**
     * This method allows the passenger to pay the transport service and 
     * valuate the vehicle where was transported invoking the last two methods
     * @return the vehicle's valuation
     */
    public int act(){
        pay();
        return calculateEvaluationValue();

    }
}