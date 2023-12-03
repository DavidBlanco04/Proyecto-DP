
/**
 * This is a enum which represents the level of fuel consumption of a vehicle.
 */
public enum FuelConsumption
{
    HIGH("High",8),
    MEDIUM("Medium",6),
    LOW("Low",4);
    
    private final String nombre;
    private final int valor;
    /**
     * Constructor for objects of enum FuelConsumption
     */
    FuelConsumption(String nombre, int valor)
    {
        this.nombre = nombre;
        this.valor = valor;
    }

    /**
     * @return the type of fuel consumption. It can be 'high', 'medium' or 'low'.
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * @return the value of vehicle's fuel consumption.
     */
    public int getValor()
    {
        return valor;
    }
    /**
     * Shows all the information (type and value) of the vehicles's fuel
     * consumption
     */
    public String showInfoFuelConsumption(){
        return "<fuel consumption: "+ getNombre() + "(value:" + getValor() + ")>"; 
    }
}
