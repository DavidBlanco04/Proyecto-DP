import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public  class TransportCompany  
{
    private String name; //company name
    private ArrayList <Taxi> vehicles;
    private ArrayList <Passenger> passengers;
    private TreeMap <Taxi,Passenger> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        this.vehicles = new ArrayList <Taxi>();
        this.passengers = new ArrayList <Passenger>();
        this.assignments = new TreeMap <Taxi,Passenger>();

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Recieve a name and sets it as the name of the trasnport company
     * @param The name of the company.
     */
    public void setName(String name)
    {
        this.name=name;
    }

    /**
     * @return The list of vehicles.
     */
    public ArrayList<Taxi> getVehicles()
    {       
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public ArrayList<Passenger> getPassengers()
    { 
        return passengers;
    }

    /**
     * @return The list of assignments.
     */
    public TreeMap <Taxi,Passenger> getAssignment()
    { 
        return assignments;
    }

    /**
     * @param Add the new Vehicle.
     */
    public void addVehicle(Taxi vehicle)
    {
        this.vehicles.add(vehicle);
    }

    /**
     * Add a new passenger in the company.
     * @param passenger The new passenger.
     */
    public void addPassenger(Passenger passenger)
    { 
        this.passengers.add(passenger);
    }

    /**
     * Find a the most closed free vehicle to a location, if any.
     * @param location location to go
     * @return A free vehicle, or null if there is none.
     */
    private Taxi scheduleVehicle(Location location)
    {
        Taxi libre = null;
        boolean enc=true;
        ComparadorDistanciaTaxi c= new ComparadorArrivalTime();
        c.setLocation(location);
        Collections.sort(this.vehicles, c);
        for(int i=0; i<this.vehicles.size() && libre == null ;i++){
            Taxi t=this.vehicles.get(i);
            enc = true;
            for (Map.Entry<Taxi, Passenger> a : assignments.entrySet()){ //Recorrer los pares{
                if(a.getKey().getName().equals(t.getName())){
                    enc=false;
                }    
            }
            if(enc){

                libre=t;
            }
        }
        return libre;
    }

    /**
     * Request a pickup for the given passenger.
     * @param passenger The passenger requesting a pickup.
     * @return Whether a free vehicle is available.
     */
    public boolean requestPickup(Passenger passenger)
    {
        boolean enc=false;
        //Assignment a=null;
        Taxi t=scheduleVehicle(passenger.getPickup());
        if(t!=null){
            t.setPickupLocation(passenger.getPickup());
            enc=true;
            //a=new Assignment(t,passenger);
            assignments.put(t,passenger);
            System.out.println (t.toString() + " go to pick up "
                + passenger.getName()+ " at " + t.getTargetLocation());
        }
        return enc;
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        boolean enc=false;
        Taxi t = null;
        Assignment a = null;
        Passenger p = null;
        Iterator<Assignment> it=assignments.iterator();
        while (it.hasNext() && !enc){
            a = it.next();
            if(a.getTaxi().getName().equals(taxi.getName())){
                t = a.getTaxi();
                p = a.getPassenger();
                it.remove();
                enc = true;

            }
        }
        if(t!= null ){
            t.pickup(p);
            System.out.println("<<<< Taxi "+t.getName() +" at location "+ t.getLocation()+" pick up "
                + p.getName());

        }
    }

    /**
     * Show a message when the taxi arrives to the destination location
     * @param the taxi where trasnport the passenger and the passenger who is transpoted in this taxi.
     */
    public String arrivedAtDestination(Taxi t, Passenger p)
    {
        String mensaje = " ";
        mensaje=("Taxi " + t.getName() + " at " + t.getLocation()
            + " offloads "+ p);
        return mensaje;
    }
}
 