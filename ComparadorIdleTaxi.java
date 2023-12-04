import java.util.*;
/**
 * This is the class of the comparator of the taxis idle time.
 */
public class ComparadorIdleTaxi implements Comparator <Taxi>
{
    /**
     * 
     * @param t1 and t2: the taxi we will compare. 
     * @return compare two taxis by their idle time in ascending order.
     */
    public int compare(Taxi t1, Taxi t2)
    {
        if(t1.getIdleCount()<t2.getIdleCount()){
            return 1;
        }
        else if(t1.getIdleCount()>t2.getIdleCount()){
            return  -1;
        }
        else{
            return (t1.getName().compareTo(t2.getName()));
        }
    }
}

