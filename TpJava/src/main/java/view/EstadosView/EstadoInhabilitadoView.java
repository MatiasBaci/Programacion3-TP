package view.EstadosView;

import Estados.EstadoInhabilitado;

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
