import java.util.*;

/**
 * Model the operation of a taxi company, operating different
 * types of vehicle. This version operates a single taxi.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TransportCompany  
{
    private String name; //nombre de la compañía
    private ArrayList <Taxi> vehicles;
    private ArrayList <Passenger> passengers;
    private ArrayList <Assignment> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        this.vehicles = new ArrayList <Taxi>();
        this.passengers = new ArrayList <Passenger>();
        this.assignments = new ArrayList <Assignment>();

    }

    /**
     * @return The name of the company.
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return The list of vehicles.
     */
    public List<Taxi> getVehicles()
    {       
        return vehicles;
    }

    /**
     * @return The list of passengers.
     */
    public List<Passenger> getPassengers()
    { 
        return passengers;
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
        Taxi libre=null;
        boolean enc=false;
        ArrayList<Taxi> aux = new ArrayList<Taxi>();
        for(int i=0; i<this.vehicles.size();i++){
            if(vehicles.get(i).isFree()==true){
                aux.add(vehicles.get(i));
                vehicles.get(i).setTargetLocation(location);
            }
        }
        Collections.sort(aux, new ComparadorDistanciaTaxi());
        libre = aux.get(0);
        /*for(int i=1; i<aux.size();i++){
                aux.get(i).setTargetLocation(null);
        }*/
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
        Assignment a=null;
        Taxi t=scheduleVehicle(passenger.getPickup());
        if(t!=null){
            t.setPickupLocation(passenger.getPickup());
            enc=true;
            a=new Assignment(t,passenger);
            assignments.add(a);
        }
        return enc;
    }

    /**
     * A vehicle has arrived at a pickup point.
     * @param vehicle The vehicle at the pickup point.
     */
    public void arrivedAtPickup(Taxi taxi)
    {
        int i = 0;
        /*boolean enc=false;
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
        }*/
        if(taxi != null){
            taxi.pickup(assignments.get(i).getPassenger());
            System.out.println("<<<< Taxi "+taxi.getName() +" at location "+ taxi.getLocation()+" pick up "
            + assignments.get(0).getPassenger().getName());
            assignments.remove(0);
        }
    }

    public String arrivedAtDestination(Taxi t, Passenger p)
    {
        String mensaje = " ";
        mensaje=("Taxi " + t.getName() + " at " + t.getLocation()
            + " offloads "+ p);
        return mensaje;
    }
}
 