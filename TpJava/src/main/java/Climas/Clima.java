package Climas;

import Pokemones.Cualidades;

import static org.fiuba.algoritmos3.Constantes.DURACION_MAXIMA_DE_CLIMA;

public abstract class Clima {

    protected String nombre;

    protected int duracionActual;


    public Clima(){
        this.duracionActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionActual() {
        return duracionActual;
    }


    public void aumentarDuracion(){
        duracionActual ++;
    }

    public abstract void aplicarEfectoClima(Cualidades cualidades);

}
