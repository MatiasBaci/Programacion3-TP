package view.EstadosView;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.EstadoEnvenenado;

public class EstadoEnvenenadoView extends EstadoView{

    private EstadoEnvenenado estadoEnvenenado;

    public EstadoEnvenenadoView(EstadoEnvenenado estadoEnvenenado){
        super(estadoEnvenenado);
        this.estadoEnvenenado = estadoEnvenenado;
    }

    public boolean mostrar(){

        return true;
    }

    public void mostrarEfectoPasivoDeEstado(){
        System.out.println("El daño por envenenamiento es de " + this.estadoEnvenenado.getDanioVeneno() + ". ");
    }
}
