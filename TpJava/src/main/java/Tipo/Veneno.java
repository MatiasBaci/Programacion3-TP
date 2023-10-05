package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Veneno extends Tipo {

    public Veneno(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_BICHO, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_FANTASMA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_PLANTA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_ROCA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_TIERRA, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_DEBIL);
    }
}


