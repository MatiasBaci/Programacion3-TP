package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Fantasma extends Tipo {

    public Fantasma(){

        super();
        this.nombre = "Fantasma";
        this.color = ANSI_VIOLETA;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_NORMAL, RELACION_NULA);
        this.tablaEfectividad.put(TIPO_PSIQUICO, RELACION_NULA);
    }
}