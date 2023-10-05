package Tipo;
import static org.fiuba.algoritmos3.Constantes.*;

public class Psiquico extends Tipo {

    public Psiquico(String nombre){
        super(nombre);
        this.completarTablaEfectividad();
    }
    
    @Override
    public void completarTablaEfectividad(){
        this.tablaEfectividad.put(TIPO_LUCHA, RELACION_FUERTE);
        this.tablaEfectividad.put(TIPO_PSIQUICO, RELACION_DEBIL);
        this.tablaEfectividad.put(TIPO_VENENO, RELACION_FUERTE);
    }
}


