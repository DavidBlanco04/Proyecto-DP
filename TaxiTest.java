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
        assertEquals(true, taxi.isFree());
    }

    /**
     * Test that a taxi is no longer free after it has
     * picked up a passenger.
     */
    @Test
    public void testPickup()
    {
        
    }

    /**
     * Test that a taxi becomes free again after offloading
     * a passenger.
     */
    public void testOffload()
    {
        
    }

    /**
     * Test that a taxi picks up and delivers a passenger within
     * a reasonable number of steps.
     */
    public void testDelivery()
    {
        
    }
}

