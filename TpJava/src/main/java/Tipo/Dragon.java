package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Dragon extends Tipo {

    public Dragon(){

        super();
        this.nombre = TIPO_DRAGON;
        this.color = ANSI_VIOLETAOSCURO;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_DRAGON,RELACION_FUERTE);
    }
}