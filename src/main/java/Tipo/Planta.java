package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Planta extends Tipo {

    public Planta(){
        super();
        this.nombre = "Planta";
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_BICHO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_VOLADOR, RELACION_DEBIL);
    }
}
