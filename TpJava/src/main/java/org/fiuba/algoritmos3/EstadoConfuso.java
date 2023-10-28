package org.fiuba.algoritmos3;

import java.util.Random;

import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoConfuso extends Estado{

    private int turnosConfuso;
    private final int duracionMaxima;

    private boolean confundido;

    public EstadoConfuso(){
        this.nombre = ESTADO_CONFUSO;
        this.duracionMaxima = 3;
        this.turnosConfuso = 0;
        this.confundido = false;
        this.color = ANSI_FONDO_ROJO + ANSI_BLANCO;
    }

    
    @Override
    public boolean puedeAtacar(){
        Random newRandom = new Random();
        double probabilidad = newRandom.nextDouble(); //Numero random de 0(incluyendo) a 1(excluyendo)
        this.confundido = probabilidad <= PROBABILIDAD_DE_HERIRSE; // quiero que se guarde para luego usarlo en aplicar EfectoPasivoEstado
        return probabilidad <= PROBABILIDAD_DE_HERIRSE;
    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
        if(this.turnosConfuso >= this.duracionMaxima){
            this.cualidades.cambiarseEstado(new EstadoNormal());
            System.out.println("El pokemon ya no esta confuso");//sacarlo
            return;
        }
        if(this.confundido){
            double danioPorCofusion = PORCENTAJE_DANIO_CONFUSO * this.cualidades.getVidaMaxima();
            this.cualidades.recibirDanio(danioPorCofusion);
            System.out.println("El pokemon se hizo daño asi mismo!!! ");//sacarlo
        }
        this.turnosConfuso++;
        this.confundido = false;// caso borde contemplado / cuando no ataca pero usa otra opcion.
    }
}
