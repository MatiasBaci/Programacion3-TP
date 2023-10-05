package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


public class Normal extends Tipo {

    public Normal(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_NULA);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_DEBIL);
    }
}


