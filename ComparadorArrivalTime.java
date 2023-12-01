import java.util.*;
/**
 * Write a description of class ComparadorArrivalTime here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComparadorArrivalTime implements Comparator<Passenger>
{
    /**
     * @return compares the taxis by their actual location to a destination location. 
     * If their distances from the destination location are equals they will be compared by their names in ascending order.
     */
    public int compare(Passenger p1, Passenger p2){  
        if (p1.getArrivalTime()==p2.getArrivalTime()){
            return new ComparadorNombrePassenger().compare(p1,p2);
        }
        else if(p1.getArrivalTime()<p2.getArrivalTime()){
            return 1;
        }
        else{
            return -1;
        }
    } 
}
