package org.fiuba.algoritmos3;

import java.util.Random;

public class EstadoParalizado extends Estado{

    public EstadoParalizado(String nombre) {
        super(nombre);
    }

    @Override
    public boolean puedeAtacar(Pokemon unPokemon) {
        
        Random newRandom = new Random();
        //set a new random between 1 and 100
        int random = newRandom.nextInt(100)+1;
        
        if (random <= 50)
        {
            System.out.println("El pokemon está paralizado y no pudo atacar.");
            return false;
        }
        return true;
        }


    @Override
    public void aplicarEfectoPasivoDeEstado(Pokemon unPokemon) {
    }
}
