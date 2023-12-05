import java.util.*;
/**
 * This is the class of the comparator of the passengers arrival time.
 */
public class ComparadorArrivalTime implements Comparator<Passenger>
{
    /**
     * @return Compares passengers by their arrival time at the destination in ascending order.
     *If their arrival time at the destination location are the same, they will be compared by their names..
     */
    public int compare(Passenger p1, Passenger p2){  
        if (p1.getArrivalTime()==p2.getArrivalTime()){
            return new ComparadorNombrePassenger().compare(p1,p2);
        }
        else if(p1.getArrivalTime()>p2.getArrivalTime()){
            return 1;
        }
        else{
            return -1;
        }
    } 
}
