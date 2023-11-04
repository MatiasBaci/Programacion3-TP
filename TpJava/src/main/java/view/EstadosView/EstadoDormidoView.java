package view.EstadosView;

import Estados.EstadoDormido;

import static org.fiuba.algoritmos3.Constantes.ANSI_RESET;
import static org.fiuba.algoritmos3.Constantes.ANSI_VERDE;

public class EstadoDormidoView extends EstadoView{

    private EstadoDormido estadoDormido;

    public EstadoDormidoView(EstadoDormido estadoDormido){
        super(estadoDormido);
        this.estadoDormido = estadoDormido;
    }

    public boolean mostrar(){


        if (this.estadoDormido.getTurnosDormido() >= this.estadoDormido.getDuracionMaxima() || this.estadoDormido.getProbabilidadDeDormir() <=  this.estadoDormido.getProbabilidadDeDespertar()){
            System.out.println(ANSI_VERDE + "El pokemon se despertó!" + ANSI_RESET);
            return true;
        } else {
            System.out.println(ANSI_VERDE + "El pokemon esta dormido por " + (this.estadoDormido.getDuracionMaxima() - this.estadoDormido.getTurnosDormido()) + " turnos." + ANSI_RESET);
            return false;
        }

    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
