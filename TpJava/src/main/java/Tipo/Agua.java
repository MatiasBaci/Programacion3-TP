package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;


public class Agua extends Tipo {

    public Agua(){
        super();
        this.nombre = TIPO_AGUA;
        this.color = ANSI_AZULFUERTE;
        this.completarTablaEfectividad();
    }

    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_AGUA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_DRAGON, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_FUEGO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_FUERTE);
    }
}