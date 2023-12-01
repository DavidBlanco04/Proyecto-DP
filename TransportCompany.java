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
    private HashMap <Taxi,TreeSet<Passenger>> assignments;

    /**
     * Constructor for objects of class TransportCompany
     */
    public TransportCompany(String name)
    {
        this.name = name;
        this.vehicles = new ArrayList <Taxi>();
        this.passengers = new ArrayList <Passenger>();
        this.assignments = new HashMap <>();

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
    public HashMap <Taxi,TreeSet<Passenger>> getAssignment()
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
    private Taxi scheduleVehicle(Passenger p)
    {
        Taxi libre = null;
        boolean enc=true;
        ComparadorDistanciaTaxi c= new ComparadorDistanciaTaxi();
        c.setLocation(p.getPickup());
        Collections.sort(this.vehicles, c);
        for(int i=0; i<this.vehicles.size() && libre == null;i++){
            Taxi t=this.vehicles.get(i);
                if(t.getPassenger().getCreditCard() > 20000 && t.getOccupation() == 1 && t.isFree()){
                    libre=t;
                }
                else if(t.getOccupation() < 4 && t.isFree() && p.getCreditCard() < 200000 && t.getOccupation() > 1){
                    libre = t;
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
        Taxi t=scheduleVehicle(passenger);
        TreeSet<Passenger>p =new TreeSet< >(new ComparadorArrivalTime());
        if(t!=null){
            if(assignments.containsKey(t)){
               p = assignments.get(t);
               assignments.remove(t);
             }  
            enc=true;
            assignments.put(t,p);
            t.setPickupLocation(passenger.getPickup());
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
        Map.Entry <Taxi,TreeSet<Passenger>> a = null;
        Set<Map.Entry <Taxi,TreeSet<Passenger>>> entrada = assignments.entrySet();
        TreeSet<Passenger>p = null;
        Iterator<Map.Entry <Taxi,TreeSet<Passenger>>> it=entrada.iterator();
        while (it.hasNext() && !enc){
            a = it.next();
            if(a.getKey().getName().equals(taxi.getName())){
                t = a.getKey();
                p = a.getValue();
                it.remove();
                enc = true;

            }
        }
        if(t!= null ){
            t.pickup(p.first());
            System.out.println("<<<< Taxi "+t.getName() +" at location "+ t.getLocation()+" pick up "
                + p.first().getName());

        }
    }

    /**
     * Show a message when the taxi arrives to the destination location
     * @param the taxi where trasnport the passenger and the passenger who is transpoted in this taxi.
     */
    public String arrivedAtDestination(Taxi t, Passenger p)
    {
        String mensaje = " ";
        if(assignments.containsKey(t)){
        mensaje=("Taxi " + t.getName() + " at " + t.getLocation()
            + " offloads "+ p);
            assignments.get(t).pollFirst();
            t.setValuation(p.act());
            if(assignments.get(t).size() >0){
                t.setTargetLocation(assignments.get(t).first().getPickup());
            }
            else{
                t.clearTargetLocation();
            }
        }
        return mensaje;
    }
}
 