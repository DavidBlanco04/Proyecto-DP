import java.util.*;
/**
 * This is the class of the comparator of taxis by their distance to an objective location
 */
public class ComparadorDistanciaTaxi implements Comparator<Taxi>
{
    private Location l;
    public void setLocation(Location l){
        this.l = l ;
    } 

    /**
     * @return compares the taxis by their actual location to a destination location. 
     * If their distances from the destination location are equals they will be compared by their names in ascending order.
     */
    public int compare(Taxi t1, Taxi t2){  
        if (t1.getLocation().distance(this.l)==t2.getLocation().distance(this.l)){
            return new ComparadorNombreTaxi().compare(t1,t2);
        }
        else if(t1.getLocation().distance(this.l)<t2.getLocation().distance(this.l)){
            return 1;
        }
        else{
            return -1;
        }
    } 
}
