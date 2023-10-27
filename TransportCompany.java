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
     * A vehicle has arrived at a passenger's destination.
     * @param vehicle The vehicle at the destination.
     * @param passenger The passenger being dropped off.
     */
    public void arrivedAtDestination(Taxi vehicle,
    Passenger passenger)
    {
        System.out.println(vehicle + " offloads " + passenger);
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
        Collections.sort(this.vehicles, new ComparadorDistanciaTaxi());
        Taxi libre=null;
        boolean enc=false;
        for(int i=0; i<this.vehicles.size() && !enc ;i++){
            if(vehicles.get(i).isFree()==true){
                libre=vehicles.get(i);
                enc=true;
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
        Assignment a=null;
        Taxi t=scheduleVehicle(passenger.getPickup());
        t.setPickupLocation(passenger.getPickup());
        if(t!=null){
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
        if(taxi.getLocation()==taxi.getTargetLocation()){
            //taxi.pickup(); 
            //System.out.println("<<<< "+taxi + " picks up " + passenger.getName());
            Iterator<Assignment> it=assignments.iterator();
            it.remove();

        }
        //TODO Obtener el pasajero asignado al taxi y eliminar la asignación correspondiente taxi/pasajero
        //TODO Descomentar siguiente línea cuando esté el método completamente implementado

        //TODO el pasajero debe guardar el nombre del taxi que le ha recogido
        //TODO el taxi debe recoger al pasajero
    }

    public String arrivedAtDestination()
    {
        String mensaje;
        for(int i=0; i<vehicles.size(); i++){
            if(vehicles.get(i).getTargetLocation()==vehicles.get(i).getPassenger().getDestination()){
                mensaje=“Taxi (name) at (location) offloads Passenger (passenger) travelling from (location1) to (location2)”;
            }
        }
        return mensaje;
    }
}
 