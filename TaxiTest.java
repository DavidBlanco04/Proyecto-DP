import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class TaxiTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class TaxiTest
{
    private Location pickup;
    private Location destination;
    private Location taxiLocation;
    private Reliable[] reliable;
    private Reliable reliable1;
    private Reliable reliable2;
    private FuelConsumption[] fuelCons;
    private FuelConsumption fuelCons1;
    private FuelConsumption fuelCons2;
    private FuelConsumption fuelCons3;
    private TransportCompany company;
    private PassengerNoVip passenger;
    private TaxiShuttle taxi;
    private Location location1;
    private Location location2;
    private PassengerVip passenger1;
    private TaxiExclusive taxiExcl1;
    private Location location3;
    private Location location4;
    private Location taxiLocation2;
    private PassengerNoVip passenger2;
    private TaxiShuttle taxiShut2;
    /**
     * Default constructor for test class TaxiTest
     */
    public TaxiTest()
    {
    }

    /**
     * Create a taxi.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        pickup = new Location(1, 2);
        destination = new Location(5, 6);
        taxiLocation = new Location(0, 0);
        reliable = Reliable.values();
        reliable1 = reliable[0];
        reliable2 = reliable[1];
        fuelCons = FuelConsumption.values();
        fuelCons1 = fuelCons[0];
        fuelCons2 = fuelCons[1];
        fuelCons3 = fuelCons[2];
        company = new TransportCompany("Compañía Taxis Cáceres");
        passenger = new PassengerNoVip(pickup, destination, "Kevin", 19, 14000, reliable1);
        taxi = new TaxiShuttle(company, taxiLocation, "T1", fuelCons1, 4);
        location1 = new Location(3, 4);
        location2 = new Location(8, 8);
        passenger1 = new PassengerVip(location1, location2, "Amalia", 16, 90000, reliable2);
        taxiExcl1 = new TaxiExclusive(company, taxiLocation, "T2", fuelCons3, 3000);
        location3 = new Location(4, 4);
        location4 = new Location(9, 5);
        taxiLocation2 = new Location(3, 4);
        passenger2 = new PassengerNoVip(location3, location4, "Luis Miguel", 9, 16000, reliable2);
        taxiShut2 = new TaxiShuttle(company, taxiLocation2, "T3", fuelCons1, 3);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test creation and the initial state of a taxi.
     */
    @Test
    public void testCreation()
    {
        assertTrue(taxi.isFree());
        assertTrue(taxiExcl1.isFree());
        assertEquals(true,taxiShut2.isFree());

        assertEquals(taxi.getCompany(),company);
        assertEquals(taxi.getLocation(),taxiLocation);
        assertEquals(taxi.getName(),"T1");
        assertEquals(taxi.getFuelConsumption(),fuelCons1);
        assertEquals(taxi.getOccupation(),4);

        assertEquals(taxiExcl1.getCompany(),company);
        assertEquals(taxiExcl1.getLocation(),taxiLocation);
        assertEquals(taxiExcl1.getName(),"T2");
        assertEquals(taxiExcl1.getFuelConsumption(),fuelCons3);
        assertEquals(taxiExcl1.getWeight(),3000);

        assertEquals(taxiShut2.getCompany(),company);
        assertEquals(taxiShut2.getLocation(),taxiLocation2);
        assertEquals(taxiShut2.getName(),"T3");
        assertEquals(taxiShut2.getFuelConsumption(),fuelCons1);
        assertEquals(taxiShut2.getOccupation(),3);
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        taxi.pickup(passenger);
        assertEquals(taxi.getTargetLocation(),passenger.getDestination());
        assertEquals(passenger.getTaxiName(),taxi.getName());
        assertEquals(taxi.getPassenger(),passenger);

        taxiExcl1.pickup(passenger1);
        assertEquals(taxiExcl1.getTargetLocation(),passenger1.getDestination());
        assertEquals(passenger1.getTaxiName(),taxiExcl1.getName());
        assertEquals(taxiExcl1.getPassenger(),passenger1);

        taxiShut2.pickup(passenger2);
        assertEquals(taxiShut2.getTargetLocation(),passenger2.getDestination());
        assertEquals(passenger2.getTaxiName(),taxiShut2.getName());
        assertEquals(taxiShut2.getPassenger(),passenger2);

    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    public void testOffload()
    {
        taxi.offloadPassenger();
        assertEquals(taxi.getPassenger(),null);
        taxi.clearTargetLocation();
        assertEquals(taxi.getTargetLocation(),null);

        taxiExcl1.offloadPassenger();
        assertEquals(taxiExcl1.getPassenger(),null);
        taxiExcl1.clearTargetLocation();
        assertEquals(taxiExcl1.getTargetLocation(),null);

        taxiShut2.offloadPassenger();
        assertEquals(taxiShut2.getPassenger(),null);
        taxiShut2.clearTargetLocation();
        assertEquals(taxiShut2.getTargetLocation(),null);

    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    public void testDelivery()
    {
        //Taxi picks up and delivers its passenger
        taxi.pickup(passenger);
        assertEquals(taxi.getTargetLocation(),passenger.getDestination());
        assertEquals(passenger.getTaxiName(),taxi.getName());
        assertEquals(taxi.getPassenger(),passenger);
        taxi.offloadPassenger();
        assertEquals(taxi.getPassenger(),null);
        taxi.clearTargetLocation();
        assertEquals(taxi.getTargetLocation(),null);

        //TaxiExcl1 picks up and delivers its passenger
        taxiExcl1.pickup(passenger1);
        assertEquals(taxiExcl1.getTargetLocation(),passenger1.getDestination());
        assertEquals(passenger1.getTaxiName(),taxiExcl1.getName());
        assertEquals(taxiExcl1.getPassenger(),passenger1);
        taxiExcl1.offloadPassenger();
        assertEquals(taxiExcl1.getPassenger(),null);
        taxiExcl1.clearTargetLocation();
        assertEquals(taxiExcl1.getTargetLocation(),null);

        //TaxiShut2 picks up and delivers its passenger
        taxiShut2.pickup(passenger2);
        assertEquals(taxiShut2.getTargetLocation(),passenger2.getDestination());
        assertEquals(passenger2.getTaxiName(),taxiShut2.getName());
        assertEquals(taxiShut2.getPassenger(),passenger2);
        taxiShut2.offloadPassenger();
        assertEquals(taxiShut2.getPassenger(),null);
        taxiShut2.clearTargetLocation();
        assertEquals(taxiShut2.getTargetLocation(),null);
    }

    /**
     * Test the calculation of the consumption of different taxis.
     */
    @Test
    public void testObtainComsumption (){
        assertEquals(taxi.obtainConsumption(taxi),taxi.getValorFuelConsumption() * taxi.getInitialPosition().distance(taxi.getLocation()));;
        assertEquals(taxiShut2.obtainConsumption(taxiShut2),taxiShut2.getValorFuelConsumption() * taxiShut2.getInitialPosition().distance(taxiShut2.getLocation()));
        assertEquals(taxiExcl1.obtainConsumption(taxiExcl1),((taxiExcl1.getWeight())/2) * taxiExcl1.getValorFuelConsumption() * taxiExcl1.getInitialPosition().distance(taxiExcl1.getLocation()));
    }

    /**
     * Test the obtaining of the first passenger (in case the taxi carries one or more passengers)
     */  
    @Test
    public void testGetPassenger(){
        taxi.setPassenger(passenger);
        taxi.setPassenger(passenger2);
        assertEquals(taxi.getPassenger(),passenger2);
    }
}

