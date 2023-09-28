package org.fiuba.algoritmos3;

import java.util.Random;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private int duracionMaxima;

    public EstadoDormido(String nombre){
        super(nombre);
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
    }


    public void dormirUnTurno(){
        this.turnosDormido ++;
    }


    public void efectoActivo(Pokemon unPokemon){

        Random newRandom = new Random();
        
        //set a new random between 0.25 and turnosDormido * 0.25
        double random = ((float)newRandom.nextFloat((float) 0.25)+this.turnosDormido*0.25);

        
        if (this.turnosDormido >= this.duracionMaxima || random >= 1)
        {
            System.out.println("El pokemon se despertó!");
            unPokemon.cambiarseEstado(new EstadoNormal("Normal", 0));

        }
        else
        {
            this.turnosDormido ++;
            System.out.println("El pokemon esta dormido.");
        }
    }

    public void efectoPasivo(Pokemon unPokemon){

    }

}
