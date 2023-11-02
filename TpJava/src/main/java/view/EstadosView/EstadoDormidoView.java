package view.EstadosView;

import Estados.EstadoDormido;

public class EstadoDormidoView extends EstadoView{

    private EstadoDormido estadoDormido;

    public EstadoDormidoView(EstadoDormido estadoDormido){
        super(estadoDormido);
        this.estadoDormido = estadoDormido;
    }

    public boolean mostrar(){


        if (this.estadoDormido.getTurnosDormido() >= this.estadoDormido.getDuracionMaxima() || this.estadoDormido.getNumeroRandom() <=  this.estadoDormido.getProbabilidadDeDespertar()){
            System.out.println("El pokemon se despertó!");
            return true;
        } else {
            System.out.println("El pokemon esta dormido por " + (this.estadoDormido.getDuracionMaxima() - this.estadoDormido.getTurnosDormido()) + " turnos.");
            return false;
        }

    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
