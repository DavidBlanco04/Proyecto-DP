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
    private Location location1;
    private Location location2;
    private Location location3;
    private Location location4;
    private Reliable[] reliable1;
    private Reliable reliable2;
    private Reliable reliable3;
    private PassengerNoVip p1;
    private PassengerVip p2;

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
        location1 = new Location(10, 4);
        location2 = new Location(3, 5);
        location3 = new Location(2, 9);
        location4 = new Location(11, 3);
        reliable1 = Reliable.values();
        reliable2 = reliable1[0];
        reliable3 = reliable1[1];
        p1 = new PassengerNoVip(location1, location2, "Amador", 11, 9000, reliable2);
        p2 = new PassengerVip(location3, location4, "Cecilia", 17, 30000, reliable3);
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
        //TODO implementar este método
        // Testear la creación correcta de objetos de tipo Passenger comprobando 
        // que la inicialización de campos como dirección de recogida y destino es correcta.
       
    }

    /**
     * Test of the getTaxiName method.
     * Ensure that this method gets and returns the name of the taxi correctly.
     */
    @Test
    public void testGetTaxiName()
    {
        //TODO implementar este método
        // Testear el método que devuelve el nombre del taxi que ha transportado
        //al pasajero/a
      
    }

    /**
     * Test of the getPickupLocation method.
     * Ensure that this method gets and returns the pickup location correctly.
     */
    @Test
    public void testGetPickupLocation ()
    {
        //TODO implementar este método
        // Testear el método que devuelve la dirección de recogida del objeto.
    }
}
