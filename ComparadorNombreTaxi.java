import java.util.*;

/** 
 *This is the class of the comparator of the taxis name
 */
public class ComparadorNombreTaxi implements Comparator<Taxi>
{
    /** 
     * @return compare two taxis by their names in ascending order
     */
    public int compare(Taxi t1, Taxi t2){  
        return t1.getName().compareTo(t2.getName());
    } 
}
