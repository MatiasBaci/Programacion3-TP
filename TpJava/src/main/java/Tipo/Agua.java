package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


public class Agua extends Tipo {

    public Agua(String nombre){

        super(nombre);
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_FUERTE);
    }
}