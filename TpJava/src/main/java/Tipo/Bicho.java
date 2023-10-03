package Tipo;

public class Bicho extends Tipo {

    public Bicho(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Fantasma","Debil");
        this.tablaEfectividad.put("Fuego","Debil");
        this.tablaEfectividad.put("Lucha","Debil");
        this.tablaEfectividad.put("Planta","Fuerte");
        this.tablaEfectividad.put("Psiquico","Fuerte");
        this.tablaEfectividad.put("Veneno","Fuerte");
        this.tablaEfectividad.put("Volador","Debil");
    }
}