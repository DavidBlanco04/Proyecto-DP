
/**
 *This is the assignment class which assigns a taxi to the passenger who requests it
 */
public class Assignment
{
    private Taxi t;
    private Passenger P;

    /**
     * Constructor for objects of class Assignment
     */
    public Assignment(Taxi t, Passenger P)
    {
        this.t = t;
        this.P = P;

    }

    /**
     * @return the taxi of the assignment
     */
    public Taxi getTaxi()
    {
        return this.t;
    }

    /**
     * @return the passenger of the assignment
     */
    public Passenger getPassenger()
    {
        return this.P;
    }

    /**
     * Recieve a taxi and sets it to the assignments taxi.
     * @param the taxi of the assignment
     */
    public void setTaxi(Taxi taxi1)
    {
        this.t = taxi1;
    }

    /**
     * Recieve a passenger and sets it to the assignments taxi.
     * @param the passenger of the assignment
     */
    public void setPassenger(Passenger P1)
    {
        this.P = P1;
    }
}
