
/**
 * Write a description of class Reliable here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public enum Reliable
{
    HIGH("High",10),
    LOW("Low",5);
    
    private final String nombre;
    private final int valor;
    /**
     * Constructor for objects of class Reliable
     */
    Reliable(String nombre, int valor)
    {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * @return the type of the reliability. It could be 'high', 'medium' or 'low'
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @return The value of the passenger's reability. 
     */
    public int getValor()
    {
        return valor;
    }
    /**
     * Shows all the information (type and value) of the passenger's reability. 
     */
    public String showInfoReliable(){
        return "<reliable: "+ getNombre() + "(value:" + getValor() + ")>"; 
    }
}
