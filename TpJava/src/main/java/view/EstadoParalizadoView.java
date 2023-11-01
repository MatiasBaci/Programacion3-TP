package view;

import org.fiuba.algoritmos3.Estado;
import org.fiuba.algoritmos3.EstadoParalizado;

import java.util.Random;

public class EstadoParalizadoView extends EstadoView{

    private EstadoParalizado estadoParalizado;

    public EstadoParalizadoView(EstadoParalizado estadoParalizado){
        super(estadoParalizado);
        this.estadoParalizado = estadoParalizado;
    }

    public boolean mostrar(){


        if (this.estadoParalizado.getNumeroRandom() <= 50) {
            System.out.println("El pokemon está paralizado y no pudo atacar.");
            return false;
        }
        return true;

    }

    public void mostrarEfectoPasivoDeEstado(){
    }
}
