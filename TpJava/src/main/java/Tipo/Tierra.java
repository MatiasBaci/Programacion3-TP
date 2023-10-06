package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Tierra extends Tipo {

    public Tierra(){
        super();
        this.nombre = "Tierra";
        this.color = ANSI_MARRON;
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ELECTRICO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_NULA);
    }
}


