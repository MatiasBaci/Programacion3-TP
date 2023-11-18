package orgFiuba.View.EstadosView;

import orgFiuba.Model.Estados.EstadoEnvenenado;

import static orgFiuba.Constantes.ANSI_RESET;
import static orgFiuba.Constantes.ANSI_VERDE;

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
        System.out.println(ANSI_VERDE + "El daño por envenenamiento es de " + this.estadoEnvenenado.getDanioVeneno() + ". " + ANSI_RESET);
    }
}
