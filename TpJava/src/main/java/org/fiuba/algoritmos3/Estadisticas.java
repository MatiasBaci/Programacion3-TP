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
        this.nivel = nivel; //modificar
    }

    public double getVidaMaxima() { return vidaMaxima ;} // es necesario retornar la vida? o que la estadistica se encargue de reducir la misma

    public int getVelocidad() {return velocidad;}

    public int getDefensa() {return defensa;}

    public int getAtaque() {return ataque;}

    public void mostrarEstadisticas(){

        System.out.println(" ");
        System.out.println(
            " -HP: " + this.vidaActual + 
            "\n -Velocidad: " + this.velocidad + 
            "\n -Defensa: " + this.defensa + 
            "\n -Ataque: " + this.ataque);
    }

    public void aumentarVida(double vida){
        this.vidaMaxima += vida;
    }

    public void reduccionVida(double vida){
        this.vidaActual -= vida;
    }

    public void aumentarVelocidad(int etapas){
        this.velocidad += velocidad * etapas * 0.1; 
    }

    public void aumentarDefensa(int etapas){
        this.defensa += defensa * etapas * 0.1; 
    }

    public void aumentarAtaque(int etapas){
        this.ataque += ataque * etapas * 0.1; 
    }

    public void disminuirVelocidad(int etapas){
        this.velocidad -= velocidad * etapas * 0.1; 
    }

    public void disminuirDefensa(int etapas){
        this.defensa -= defensa * etapas * 0.1; 
    }

    public void disminuirAtaque(int etapas){
        this.ataque -= ataque * etapas * 0.1; 
    }

    public double getNivel() {
        return this.nivel;
    }

    public double getVida() {
        return this.vidaActual;
    }

}
