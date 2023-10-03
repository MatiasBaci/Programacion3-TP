package Tipo;

public class Psiquico extends Tipo {

    public Psiquico(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Lucha","Fuerte");
        this.tablaEfectividad.put("Psiquico","Debil");
        this.tablaEfectividad.put("Veneno","Fuerte");
    }
}


