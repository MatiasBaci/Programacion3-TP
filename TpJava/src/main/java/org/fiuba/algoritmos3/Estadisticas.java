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
        this.vidaActual = vidaMaxima;
        this.velocidadBase = velocidad;
        this.velocidad = velocidad;
        this.defensaBase = defensa;
        this.defensa = defensa;
        this.ataqueBase = ataque;
        this.ataque = ataque;
        this.nivel = nivel;
    }

    public double getVidaMaxima() { return vidaMaxima ;} // es necesario retornar la vida? o que la estadistica se encargue de reducir la misma

    public int getVelocidad() {return velocidad;}

    public int getDefensa() {return defensa;}

    public int getAtaque() {return ataque;}

    public void mostrarEstadisticas(){

        System.out.println(
            " HP: " + this.vidaActual + " --" +
            " Velocidad: " + this.velocidad + " --" +
            " Defensa: " + this.defensa + " --" +
            " Ataque: " + this.ataque);
    }

    public void aumentarVida(double vida){
        double vidaTotal = (vidaActual + vida);
        if(vidaActual != vidaMaxima) {
            if (vidaTotal > vidaMaxima) {
                this.vidaActual = this.vidaMaxima;
            } else {
                this.vidaActual += vida;
            }
        }
    }

    public void reduccionVida(double vida){
        double vidaTotal = (vidaActual - vida);
        if(vidaTotal < 0){
            vidaActual = 0;
        }
        else{ this.vidaActual -= vida;}
    }


    public void modificarVelocidad(int etapas){
        this.velocidad += velocidad * etapas * 0.1; 
    }


    public void modificarDefensa(int etapas){
        this.defensa += defensa * etapas * 0.1; 
    }


    public void modificarAtaque(int etapas){
        this.ataque += ataque * etapas * 0.1; 
    }


    public double getNivel() {
        return this.nivel;
    }


    public double getVida() {
        return this.vidaActual;
    }


    public void modificarEstadistica(String unaEstadistica,int etapa){ //AQUI REFACTORIZAR LOS IFS :C
        if(unaEstadistica == "Defensa"){
            this.modificarDefensa(etapa);
        } else if(unaEstadistica == "Ataque"){
            this.modificarAtaque(etapa);
        } else if(unaEstadistica == "Velocidad"){
            this.modificarVelocidad(etapa);
        }
    }
    

    public void resetearEstadisticas(){
        this.vidaActual = this.vidaMaxima;
        this.velocidad = this.velocidadBase;
        this.defensa = this.defensaBase;
        this.ataque = this.ataqueBase;
    }



}
