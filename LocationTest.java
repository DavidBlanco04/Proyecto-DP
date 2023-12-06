import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test implementation of the Location class.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 * @version 2023.10.10 DP classes 
 */
public class LocationTest
{
    Location location1;
    Location location2;
    Location startLocation;
    Location destination;
    /**
     * Default constructor for test class LocationTest
     */
    public LocationTest()
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
        location1 = new Location(5, 6);
        location2 = new Location(9, 5);
        startLocation = new Location(1, 2);
        destination = new Location(2, 2);
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
     * Test the distance method of the Location class.
     */
    @Test
    public void testDistance()
    {
        assertEquals(startLocation.distance(new Location(5, 7)), 5);
        assertEquals(startLocation.distance(destination), 1);
        assertTrue(startLocation.distance(destination) == 1);
        assertEquals(startLocation.distance(new Location(3,4)),2);
        assertTrue(startLocation.distance(new Location(0,0))==2);
        
    }

    /**
     * Run tests of the nextLocation method of the Location class.
     */
    @Test
    public void testAdjacentLocations()
    {
        Location l1=new Location(6,6);
        Location l2=new Location(5,5);
        Location l3=new Location(5,4);
        
        assertEquals(l2.nextLocation(l1),l1);
        assertEquals(startLocation.nextLocation(destination),destination);
        assertEquals(l3.nextLocation(l3),l3);
        assertEquals(l2.nextLocation(location1),location1);

    }
}
