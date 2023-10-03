package Tipo;

public class Veneno extends Tipo {

    public Veneno(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Bicho","Fuerte");
        this.tablaEfectividad.put("Fantasma","Debil");
        this.tablaEfectividad.put("Planta","Fuerte");
        this.tablaEfectividad.put("Roca","Debil");
        this.tablaEfectividad.put("Tierra","Debil");
        this.tablaEfectividad.put("Veneno","Debil");
    }
}


