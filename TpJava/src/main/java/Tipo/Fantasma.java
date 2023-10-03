package Tipo;

public class Fantasma extends Tipo {

    public Fantasma(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Fantasma","Fuerte");
        this.tablaEfectividad.put("Normal","Nula");
        this.tablaEfectividad.put("Psiquico","Nula");
    }
}