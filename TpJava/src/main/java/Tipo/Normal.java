package Tipo;


public class Normal extends Tipo {

    public Normal(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Fantasma","Nula");
        this.tablaEfectividad.put("Roca","Debil");
    }
}


