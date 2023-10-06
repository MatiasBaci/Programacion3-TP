package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Roca extends Tipo {

    public Roca(){
        super();
        this.nombre = "Roca";
        this.color = ANSI_MARRONOSCURO;
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_BICHO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_LUCHA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_FUERTE);
    }
}


