package org.fiuba.algoritmos3;

public abstract class Clima {

    protected String nombre;

    protected int duracionMaxima;

    protected int duracionActual;


    public Clima(){
        this.duracionMaxima = 10;
        this.duracionActual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMaxima() {
        return duracionMaxima;
    }

    public int getDuracionActual() {
        return duracionActual;
    }

    public void setDuracionActual(int duracionActual) {
        this.duracionActual = duracionActual;
    }

    public void aumentarDuracion(){
        duracionActual ++;
    }

    protected abstract void aplicarEfectoClima(Pokemon pokemon);

}
