package org.fiuba.algoritmos3;

import java.util.Random;

import static org.fiuba.algoritmos3.Constantes.*;

public class EstadoConfuso extends Estado{

    private int turnosConfuso;
    private final int duracionMaxima;


    public EstadoConfuso(){
        this.nombre = ESTADO_CONFUSO;
        this.duracionMaxima = 3;
        this.turnosConfuso = 0;
        this.color = ANSI_FONDO_ROJO + ANSI_BLANCO;
    }

    
    @Override
    public boolean puedeAtacar(){
        Random newRandom = new Random();
        double probabilidad = newRandom.nextDouble(); //Numero random de 0(incluyendo) a 1(excluyendo)
        boolean confundido = probabilidad <= PROBABILIDAD_DE_HERIRSE; // quiero que se guarde para luego usarlo en aplicar EfectoPasivoEstado

        if(this.turnosConfuso >= this.duracionMaxima){
            //this.cualidades.cambiarseEstado(new EstadoNormal()); // cambiarlo------------>
            this.cualidades.eliminarEstado(this);
            System.out.println("El pokemon ya no esta confuso");//sacarlo
            return true;
        }
        if(confundido){
            double danioPorCofusion = PORCENTAJE_DANIO_CONFUSO * this.cualidades.getVidaMaxima();
            this.cualidades.recibirDanio(danioPorCofusion);
            //this.cualidades.actualizarEstados(); // para que todos los estados sepan que se actualizaron
            System.out.println("El pokemon se hizo daño asi mismo!!! ");//sacarlo
        }
        this.turnosConfuso++;
        return false;

    }

    @Override
    public void aplicarEfectoPasivoDeEstado(){
    }
}
