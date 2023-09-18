package org.fiuba.algoritmos3;
public class Estadisticas {

    //Atributos:
    private int vidaMaxima;
    private int velocidad;
    private int defensa;
    private int ataque;

    //Metodos:

    public Estadisticas(int vidaMaxima, int velocidad, int defensa, int ataque){
        this.vidaMaxima = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
    }
    public int getVidaMaxima() { return vidaMaxima ;}

    public int getVelocidad() {return velocidad;}

    public int getDefensa() {return defensa;}

    public int getAtaque() {return ataque;}

}
