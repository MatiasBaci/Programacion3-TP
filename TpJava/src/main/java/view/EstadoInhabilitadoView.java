package view;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.EstadoInhabilitado;

public class EstadoInhabilitadoView extends EstadoView{

    private EstadoInhabilitado estadoInhabilitado;

    public EstadoInhabilitadoView(EstadoInhabilitado estadoInhabilitado){
        super(estadoInhabilitado);
        this.estadoInhabilitado = estadoInhabilitado;
    }

    public boolean mostrar(){
        return false;
    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
