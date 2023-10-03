package Tipo;

public class Planta extends Tipo {

    public Planta(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Agua", "Fuerte");
        this.tablaEfectividad.put("Bicho", "Debil");
        this.tablaEfectividad.put("Dragon", "Debil");
        this.tablaEfectividad.put("Fuego", "Debil");
        this.tablaEfectividad.put("Roca", "Fuerte");
        this.tablaEfectividad.put("Tierra", "Fuerte");
        this.tablaEfectividad.put("Veneno", "Debil");
        this.tablaEfectividad.put("Volador", "Debil");
    }
}
