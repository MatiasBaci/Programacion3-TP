package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Lucha extends Tipo {

    public Lucha(){
        super();
        this.nombre = "Lucha";
        this.color = ANSI_NARANJA;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_NULA);
        this.tablaEfectividad.put(TIPO_HIELO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_NORMAL, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PSIQUICO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_DEBIL);
    }
}