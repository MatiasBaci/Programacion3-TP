package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Fuego extends Tipo {

    public Fuego(String nombre){

        super(nombre);
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_BICHO,RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_DEBIL);
    }
}
