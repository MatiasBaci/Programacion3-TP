package org.fiuba.algoritmos3;
import Tipo.Tipo;
import view.CualidadesView;

import static org.fiuba.algoritmos3.Constantes.*;
public class Cualidades {

    //Atributos:
    private final double vidaMaxima;
    private final int velocidadBase;
    private final int defensaBase;
    private final int ataqueBase;

    private double vidaActual;
    private int velocidad;
    private int defensa;
    private int ataque;

    private final int nivel;

    private Tipo tipo;

    private Estado estadoActual;


    //Metodos:

    public Cualidades(double vida,int nivel ,int velocidad, int defensa, int ataque, String tipo){
        this.vidaMaxima = vida;
        this.vidaActual = vida;
        this.velocidadBase = velocidad;
        this.velocidad = velocidad;
        this.defensaBase = defensa;
        this.defensa = defensa;
        this.ataqueBase = ataque;
        this.ataque = ataque;
        this.nivel = nivel;
        this.tipo = Tipo.instanciarUnTipoDe(tipo);
        this.estadoActual = new EstadoNormal();
        this.estadoActual.setCualidades(this);

    }

    public double getVidaMaxima() { return this.vidaMaxima ;}

    public int getVelocidad() {return this.velocidad;}

    public int getDefensa() {return this.defensa;}

    public int getAtaque() {return this.ataque;}

    public double getNivel() {
        return this.nivel;
    }

    public double getVida() {
        return this.vidaActual;
    }


    public Estado getEstadoActual() {
        return estadoActual;
    }

    public String suEstadoEs() {return estadoActual.getNombre();}


    public void cambiarseEstado(Estado unEstado){
        this.estadoActual = unEstado;
        this.estadoActual.setCualidades(this);
    }

    public boolean atacarConEstadoActual(){ return this.estadoActual.puedeAtacar(); }
    public void aplicarEfectoPasivoDeEstadoActual(){ this.estadoActual.aplicarEfectoPasivoDeEstado();}
    public Tipo getTipo() {return tipo;}

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
        double vidaTotal = (this.vidaActual - vida);
        if(vidaTotal < 0){
            this.vidaActual = 0;
        }
        else{ this.vidaActual -= vida;}
    }

    public void recibirDanio(double damageEnemigo){
        this.reduccionVida(damageEnemigo);
    }

    public boolean estaConciente() {
        if(this.getVida() == 0){ //<=
            this.cambiarseEstado(new EstadoInhabilitado());
            return false;
        }
        return true;
    }

    public void modificarVelocidad(int etapas){
        this.velocidad += this.velocidad * etapas * PORCENTAJE;
    }

    public void modificarDefensa(int etapas){
        this.defensa += this.defensa * etapas * PORCENTAJE;
    }

    public void modificarAtaque(int etapas){
        this.ataque += this.ataque * etapas * PORCENTAJE;
    }

    public void resetearEstadisticas(){
        this.velocidad = this.velocidadBase;
        this.defensa = this.defensaBase;
        this.ataque = this.ataqueBase;
    }


}
