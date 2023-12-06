import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PassengerTest.
 *
 * @author  David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class PassengerTest
{
    private Location l1;
    private Location l2;
    private Location l3;
    private Location l4;
    private Location location1;
    private Location l5;
    private Location location2;
    private Reliable[] reliable;
    private Reliable reliable1;
    private Reliable reliable2;
    private PassengerNoVip passenger1;
    private PassengerVip passenger2;
    private TransportCompany transport1;
    private FuelConsumption[] fuelCons;
    private FuelConsumption fuelCons1;
    private FuelConsumption fuelCons2;
    private TaxiShuttle taxiShut1;
    private TaxiExclusive taxiExcl1;
    /**
     * Default constructor for test class PassengerTest
     */
    public PassengerTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        l1 = new Location(10, 4);
        l2 = new Location(6, 6);
        l3 = new Location(4, 3);
        l4 = new Location(2, 9);
        location1 = new Location(15, 9);
        l5 = new Location(9, 5);
        location2 = new Location(10, 2);
        reliable = Reliable.values();
        reliable1 = reliable[0];
        reliable2 = reliable[1];
        passenger1 = new PassengerNoVip(l1, l4, "Amador", 11, 9000, reliable1);
        passenger2 = new PassengerVip(l2, l5, "Cecilia", 17, 28000, reliable2);
        transport1 = new TransportCompany("Taxi Chollo");
        fuelCons = FuelConsumption.values();
        fuelCons1 = fuelCons[1];
        fuelCons2 = fuelCons[2];
        taxiShut1 = new TaxiShuttle(transport1, l3, "T1", fuelCons1, 4);
        taxiExcl1 = new TaxiExclusive(transport1, location2, "T2", fuelCons2, 2500);
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
     * Test basic creation of a passenger.
     * Ensure that the pickup and destination locations
     * have been set.
     */
    @Test
    public void testCreation()
    {
        assertEquals(passenger1.getPickup(),l1);
        assertEquals(passenger1.getDestination(),l4);
        assertEquals(passenger1.getName(),"Amador");
        assertEquals(passenger1.getArrivalTime(),11);
        assertEquals(passenger1.getCreditCard(),9000);
        assertEquals(passenger1.getReliable(),reliable1);
        
        assertEquals(passenger2.getPickup(),l2);
        assertEquals(passenger2.getDestination(),l5);
        assertEquals(passenger2.getName(),"Cecilia");
        assertEquals(passenger2.getArrivalTime(),17);
        assertEquals(passenger2.getCreditCard(),28000);
        assertEquals(passenger2.getReliable(),reliable2);
    }

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName()
    {
        passenger1.setTaxiName("T1");
        passenger2.setTaxiName("T2");
        
        assertEquals(passenger1.getTaxiName(),"T1");
        assertEquals(passenger2.getTaxiName(),"T2");
      
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation ()
    {
        assertTrue(passenger1.getPickup()==l1);
        assertTrue(passenger2.getPickup()==l2);
    }
}
