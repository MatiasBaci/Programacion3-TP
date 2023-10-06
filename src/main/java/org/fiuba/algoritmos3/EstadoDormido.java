package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private int duracionMaxima;

    public EstadoDormido(){
        this.nombre = ESTADO_DORMIDO;
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
    }

    
    @Override
    public boolean puedeAtacar(Pokemon unPokemon){

        Random newRandom = new Random();

        double random = ((float)newRandom.nextFloat((float) 0.25)+this.turnosDormido*0.25);

        
        if (this.turnosDormido >= this.duracionMaxima || random >= 1)
        {
            System.out.println("El Pokemon " + unPokemon.getNombre() +" se despertó!");
            unPokemon.cambiarseEstado(new EstadoNormal());
            return true;
        }
        else
        {
            this.turnosDormido ++;
            System.out.println("El Pokemon " + unPokemon.getNombre() + " esta dormido.");
            return false;
        }
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon){
    }
}
