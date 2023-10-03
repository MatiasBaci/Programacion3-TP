package Tipo;

public class Volador extends Tipo {

    public Volador(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Bicho","Fuerte");
        this.tablaEfectividad.put("Electrico","Debil");
        this.tablaEfectividad.put("Lucha","Fuerte");
        this.tablaEfectividad.put("Planta","Fuerte");
        this.tablaEfectividad.put("Roca","Debil");
    }
}


