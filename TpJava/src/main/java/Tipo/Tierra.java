package Tipo;

public class Tierra extends Tipo {

    public Tierra(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Bicho","Debil");
        this.tablaEfectividad.put("Electrico","Fuerte");
        this.tablaEfectividad.put("Fuego","Fuerte");
        this.tablaEfectividad.put("Planta","Debil");
        this.tablaEfectividad.put("Roca","Fuerte");
        this.tablaEfectividad.put("Veneno","Fuerte");
        this.tablaEfectividad.put("Volador","Nula");
    }
}


