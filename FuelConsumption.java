
/**
 * Write a description of class fuelConsumption here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum FuelConsumption
{
    // instance variables - replace the example below with your own
    HIGH("High",8),
    MEDIUM("Medium",6),
    LOW("Low",4);
    
    private final String nombre;
    private final int valor;
    /**
     * Constructor for objects of class Reliable
     */
    FuelConsumption(String nombre, int valor)
    {
        // initialise instance variables
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public String getNombre()
    {
        // put your code here
        return nombre;
    }
    
        /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int getValor()
    {
        // put your code here
        return valor;
    }
    
    public String showInfoFuelConsumption(){
        return "<fuel consumption: "+ getNombre() + "(value:" + getValor() + ")>"; 
    }
}
