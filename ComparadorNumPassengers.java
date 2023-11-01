import java.util.*;
/**
 *This is the class of the comparator of the number of passengers that a taxi transport.
 */
public class ComparadorNumPassengers implements Comparator<Taxi>{
    /**
     *@return compare two taxis by the total number of passengers they have transported.
     */
    public int compare(Taxi t1, Taxi t2){
        if(t1.getPassengersTransported()>t2.getPassengersTransported()){
            return 1;
        }
        else if(t1.getPassengersTransported()<t2.getPassengersTransported()){
            return -1;
        }
        else{
            return (t1.getName().compareTo(t2.getName()));
        }
    }
}

