package Tipo;

// import java.util.HashMap;

public class Lucha extends Tipo { //extends de Tipo

    public Lucha(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

//  public static void completarTablaEfectividad(){
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Bicho","Debil");
        this.tablaEfectividad.put("Fantasma","Nula");
        this.tablaEfectividad.put("Hielo","Fuerte");
        this.tablaEfectividad.put("Normal","Fuerte");
        this.tablaEfectividad.put("Psiquico","Debil");
        this.tablaEfectividad.put("Roca","Fuerte");
        this.tablaEfectividad.put("Veneno","Debil");
        this.tablaEfectividad.put("Volador","Debil");
    }
}