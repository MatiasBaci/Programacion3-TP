package org.fiuba.algoritmos3;
import static org.fiuba.algoritmos3.Constantes.*;

import java.util.Random;

public class EstadoDormido extends Estado{

    private int turnosDormido;
    private final int duracionMaxima;

    private double numeroRandom;

    private double probabilidadDeDespertar;

    public EstadoDormido(){
        this.nombre = ESTADO_DORMIDO;
        this.duracionMaxima = 4;
        this.turnosDormido = 0;
        this.color = ANSI_FONDO_BLANCO + ANSI_NEGRO;
    }

    public int getTurnosDormido() {
        return this.turnosDormido;
    }

    public int getDuracionMaxima() {
        return this.duracionMaxima;
    }
    public double getNumeroRandom() {return this.numeroRandom;}

    public double getProbabilidadDeDespertar(){return this.probabilidadDeDespertar;}

    @Override
    public boolean puedeAtacar(){

        Random unNumeroRandom = new Random();
        
        //set a new random between 0.25 and turnosDormido * 0.25
        //double random = ((float)newRandom.nextFloat((float) 0.25)+this.turnosDormido*0.25);
        this.probabilidadDeDespertar = Math.round((0.25 + this.turnosDormido * 0.25) * 100.0) / 100.0; //--> para que genere una numero de dos cirfas signficativas
        this.numeroRandom = Math.round(unNumeroRandom.nextDouble() * 100) / 100.0;

        
        if (this.turnosDormido >= this.duracionMaxima || this.numeroRandom <= this.probabilidadDeDespertar){
            //this.cualidades.cambiarseEstado(new EstadoNormal()); --> Version de un solo estado
            //this.cualidades.eliminarEstado(this);
            this.eliminarse = true;
            return true;
        } else {
            this.turnosDormido ++;
            return false;
        }
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){

    }
}
