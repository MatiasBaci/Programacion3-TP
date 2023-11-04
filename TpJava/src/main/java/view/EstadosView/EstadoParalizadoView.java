package view.EstadosView;

import Estados.EstadoParalizado;

import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;
import static org.fiuba.algoritmos3.Constantes.ANSI_VERDE;

public class EstadoParalizadoView extends EstadoView{

    private EstadoParalizado estadoParalizado;

    public EstadoParalizadoView(EstadoParalizado estadoParalizado){
        super(estadoParalizado);
        this.estadoParalizado = estadoParalizado;
    }

    public boolean mostrar(){


        if (this.estadoParalizado.getNumeroRandom() <= 50) {
            System.out.println(ANSI_VERDE + "El pokemon está paralizado y no pudo atacar." + ANSI_RESET);
            return false;
        }
        return true;

    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
