package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Dragon extends Tipo {

    public Dragon(String nombre){

        super(nombre);
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_DRAGON,RELACION_FUERTE);
    }
}