package Tipo;

// import java.util.HashMap;

public class Hielo extends Tipo { //extends de Tipo

    public Hielo(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

//  public static void completarTablaEfectividad(){
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Agua","Debil");
        this.tablaEfectividad.put("Dragon","Fuerte");
        this.tablaEfectividad.put("Hielo","Debil");
        this.tablaEfectividad.put("Planta","Fuerte");
        this.tablaEfectividad.put("Tierra","Fuerte");
        this.tablaEfectividad.put("Volador","Fuerte");
    }
}