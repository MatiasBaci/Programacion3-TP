package org.fiuba.algoritmos3;
public class Estadisticas {

    //Atributos:
    private double vidaMaxima;
    private int velocidad;
    private int defensa;
    private int ataque;

    //Metodos:

    public Estadisticas(double vidaMaxima, int velocidad, int defensa, int ataque){
        this.vidaMaxima = vidaMaxima;
        this.velocidad = velocidad;
        this.defensa = defensa;
        this.ataque = ataque;
    }
    public double getVidaMaxima() { return vidaMaxima ;} // es necesario retornar la vida? o que la estadistica se encargue de reducir la misma

    public int getVelocidad() {return velocidad;}

    public int getDefensa() {return defensa;}

    public int getAtaque() {return ataque;}

    public void reduccionVida(double damage){
        this.vidaMaxima -= damage;
    }

}
