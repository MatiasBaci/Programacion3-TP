package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private final int duracionMaxima;

    private double numeroRandom;

    public EstadoDormido(){
        this.nombre = ESTADO_DORMIDO;
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
        this.color = ANSI_FONDO_BLANCO + ANSI_NEGRO;
    }

    public int getTurnosDormido() {
        return turnosDormido;
    }

    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public double getNumeroRandom() {
        return numeroRandom;
    }

    @Override
    public boolean puedeAtacar(){

        Random newRandom = new Random();
        
        //set a new random between 0.25 and turnosDormido * 0.25
        double random = ((float)newRandom.nextFloat((float) 0.25)+this.turnosDormido*0.25);
        this.numeroRandom = random;

        
        if (this.turnosDormido >= this.duracionMaxima || random >= 1)
        {
            //this.cualidades.cambiarseEstado(new EstadoNormal()); --> Version de un solo estado
            this.cualidades.eliminarEstado(this);
            return true;
        }
        else
        {
            this.turnosDormido ++;
            return false;
        }
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){

    }
}
