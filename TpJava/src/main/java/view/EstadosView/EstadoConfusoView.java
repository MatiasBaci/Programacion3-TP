package view.EstadosView;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.EstadoConfuso;

public class EstadoConfusoView extends EstadoView{

    private EstadoConfuso estadoConfuso;

    public EstadoConfusoView(EstadoConfuso estadoConfuso){
        super(estadoConfuso);
        this.estadoConfuso = estadoConfuso;
    }

    public boolean mostrar(){

        if(this.estadoConfuso.getTurnosConfuso() >= this.estadoConfuso.getDuracionMaxima()){
            System.out.println("El pokemon ya no esta confuso");
            return true;
        }
        if(this.estadoConfuso.isConfundido()){
            System.out.println("El pokemon se hizo daño asi mismo!!! ");
            System.out.println("El daño es de " + this.estadoConfuso.getDanioPorConfusion());
        }
        return false;

    }

    public void mostrarEfectoPasivoDeEstado(){
        System.out.println("El pokemon esta confuso por " + this.estadoConfuso.getTurnosConfuso() + " turnos.");
    }
}
