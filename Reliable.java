
/**
 * Write a description of class Reliable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Reliable
{
    // instance variables - replace the example below with your own
    HIGH("High",10),
    LOW("Low",5);
    
    private final String nombre;
    private final int valor;
    /**
     * Constructor for objects of class Reliable
     */
    Reliable(String nombre, int valor)
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
    
    public String showInfoReliable(){
        return "<reliable: "+ getNombre() + "(value:" + getValor() + ")>"; 
    }
}
