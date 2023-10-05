package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Electrico extends Tipo {

    public Electrico(String nombre){

        super(nombre);
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ELECTRICO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_NULA);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_FUERTE);
    }
}