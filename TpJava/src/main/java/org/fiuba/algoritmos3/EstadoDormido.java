package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private final int duracionMaxima;

    public EstadoDormido(){
        this.nombre = ESTADO_DORMIDO;
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
        this.color = ANSI_FONDO_BLANCO + ANSI_NEGRO;
    }

    
    @Override
    public boolean puedeAtacar(){

        Random newRandom = new Random();
        
        //set a new random between 0.25 and turnosDormido * 0.25
        double random = ((float)newRandom.nextFloat((float) 0.25)+this.turnosDormido*0.25);

        
        if (this.turnosDormido >= this.duracionMaxima || random >= 1)
        {
            System.out.println("El pokemon se despertó!");
            this.cualidades.cambiarseEstado(new EstadoNormal());
            return true;
        }
        else
        {
            this.turnosDormido ++;
            System.out.println("El pokemon esta dormido.");
            return false;
        }
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
