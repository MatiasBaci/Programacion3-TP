package Tipo;

public class Electrico extends Tipo {

    public Electrico(String nombre){

        super(nombre); //Aqui se le pasa el nombre del tipo ---> Deberia borrarse
        this.completarTablaEfectividad(); // Consultarlo si se puede hacer esto o hacer un metodo estatico que se inicialice al hacer new ()
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put("Agua","Fuerte");
        this.tablaEfectividad.put("Dragon","Debil");
        this.tablaEfectividad.put("Electrico","Debil");
        this.tablaEfectividad.put("Planta","Debil");
        this.tablaEfectividad.put("Tierra","Nula");
        this.tablaEfectividad.put("Volador","Fuerte");
    }
}