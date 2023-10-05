package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Fantasma extends Tipo {

    public Fantasma(String nombre){

        super(nombre);
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_NORMAL, RELACION_NULA);
        this.tablaEfectividad.put(TIPO_PSIQUICO, RELACION_NULA);
    }
}