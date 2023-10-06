package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Hielo extends Tipo {

    public Hielo(){

        super();
        this.nombre = "Hielo";
        this.color = ANSI_CELESTE;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_HIELO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_FUERTE);
    }
}