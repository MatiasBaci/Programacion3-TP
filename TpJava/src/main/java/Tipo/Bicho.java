package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Bicho extends Tipo {

    public Bicho(){

        super();
        this.nombre = "Bicho";
        this.color = ANSI_VERDEOSCURO;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_LUCHA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PSIQUICO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_DEBIL);
    }
}