import java.util.*;
/**
 * This is the class of the comparator of the taxis valuation.
 */
public class ComparadorValuationTaxi implements Comparator <Taxi>
{
    /**
     * @return This method compares two taxis by their valuation in descending order 
     * @param t1 and t2:the taxis we will compare
     */
    public int compare(Taxi t1, Taxi t2)
    { 
        if(t1.getValuation()>t2.getValuation()){
            return  1;
        }
        else if(t1.getValuation()<t2.getValuation()){
            return -1;
        }
        else{
            return (t1.getName().compareTo(t2.getName()));
        }
    }
}
