import java.util.*; 

/**
 *This is the comparator of the name of the passengers.
 */
public class ComparadorNombrePassenger implements Comparator<Passenger>
{
    /**
     *@return compare two passengers by their names in ascending order.
     */
    public int compare(Passenger p1, Passenger p2){  
        return (p1.getName().compareTo(p2.getName()));
    } 
}
