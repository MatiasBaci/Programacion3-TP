package org.fiuba.algoritmos3;
public class Estadisticas {

    //Atributos:
    //Los atributos Base no deben poder cambiar, deben ser constantes o estaticos
    private double vidaMaxima;
    private int velocidadBase;
    private int defensaBase;
    private int ataqueBase;

    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;

    private int nivel;

    //Metodos:

    public Estadisticas(double vida,int nivel ,int velocidad, int defensa, int ataque){
        this.vidaMaxima = vida;
        this.vidaActual = vida;
        this.velocidadBase = velocidad;
        this.velocidad = velocidad;
        this.defensaBase = defensa;
        this.defensa = defensa;
        this.ataqueBase = ataque;
        this.ataque = ataque;
        this.nivel = nivel;
    }

    public double getVidaMaxima() { return this.vidaMaxima ;} // es necesario retornar la vida? o que la estadistica se encargue de reducir la misma

    public int getVelocidad() {return this.velocidad;}

    public int getDefensa() {return this.defensa;}

    public int getAtaque() {return this.ataque;}

    public double getNivel() {
        return this.nivel;
    }

    public double getVida() {
        return this.vidaActual;
    }

    public void aumentarVida(double vida){
        double vidaTotal = (this.vidaActual + vida);
        if(this.vidaActual != this.vidaMaxima) {
            if (vidaTotal > this.vidaMaxima) {
                this.vidaActual = this.vidaMaxima;
            } else {
                this.vidaActual += vida;
            }
        }
    }

    public void reduccionVida(double vida){
        double vidaTotal = (vidaActual - vida);
        if(vidaTotal < 0){
            this.vidaActual = 0;
        }
        else{ this.vidaActual -= vida;}
    }


    public void modificarVelocidad(int etapas){
        this.velocidad += this.velocidad * etapas * 0.1;
    }


    public void modificarDefensa(int etapas){
        this.defensa += this.defensa * etapas * 0.1;
    }


    public void modificarAtaque(int etapas){
        this.ataque += this.ataque * etapas * 0.1;
    }


    public void resetearEstadisticas(){
        this.velocidad = this.velocidadBase;
        this.defensa = this.defensaBase;
        this.ataque = this.ataqueBase;
    }

    public void mostrarEstadisticas(){
        System.out.println(
                " Nivel: " + this.nivel + " --" +
                " HP: " + this.vidaActual + " --" +
                        " Velocidad: " + this.velocidad + " --" +
                        " Defensa: " + this.defensa + " --" +
                        " Ataque: " + this.ataque);
    }



}
