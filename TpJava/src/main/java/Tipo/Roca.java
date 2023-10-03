package Tipo;

public class Roca extends Tipo {

    public Roca(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Bicho","Fuerte");
        this.tablaEfectividad.put("Fuego","Fuerte");
        this.tablaEfectividad.put("Hielo","Fuerte");
        this.tablaEfectividad.put("Lucha","Debil");
        this.tablaEfectividad.put("Tierra","Debil");
        this.tablaEfectividad.put("Volador","Fuerte");
    }
}


