package org.fiuba.algoritmos3;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    //Atributos:
    private String nombre;
    private Tipo tipo;
    private String historia;
    private Estadisticas estadisticas;

    private Map<String, Habilidad> misHabilidades;

    private Estado estadoActual;


    //Metodos:
    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.tipo = Tipo.instanciarUnTipoDe(tipo);
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,nivel,velocidad,defensa,ataque);
        this.estadoActual = new EstadoNormal();
        this.misHabilidades = new HashMap<>();
    }


    public String getNombre() {return nombre;}

    public Tipo getTipo() {return tipo;}
    public Map<String, Habilidad> getMisHabilidades() {
        return misHabilidades;
    }
    public Estadisticas getEstadisticas() {return estadisticas;}
    public int getVelocidad() {return estadisticas.getVelocidad();}
    public double getVidaMaxima() {return this.estadisticas.getVidaMaxima();}
    public double getVida() {return this.estadisticas.getVida();}

    public Estado getEstadoActual() {
        return estadoActual;
    }

    public String suEstadoEs() {return estadoActual.getNombre();}


    public void aniadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }


    public void recibirDanio(double damageEnemigo){
        this.estadisticas.reduccionVida(damageEnemigo);
    }

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public void aplicarEfectoPasivoPokemon(){
        estadoActual.aplicarEfectoPasivoDeEstado(this);
    }

    public void cambiarseEstado(Estado unEstado){
        this.estadoActual = unEstado;
    }


    public boolean estaConciente() {
        if(this.estadisticas.getVida() == 0){ //<=
            this.cambiarseEstado(new EstadoInhabilitado());
            return false;
        }
        return true;
    }

    public boolean puedeAtacar(){
        return estadoActual.puedeAtacar(this);
    }

    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);

        if (this.puedeAtacar()) {
            unaHabilidad.usarHabilidad(pokemonEnemigoActual, this);
        }
    }

    public void mostrarPokemon(){
        System.out.println(" Nombre: " + this.nombre);
        System.out.println(" Tipo: " + this.tipo.getNombreConColor());
        this.estadisticas.mostrarEstadisticas();
        System.out.println(" Historia: " + this.historia);
        System.out.println(" Estado: " + this.estadoActual.getNombreConColor() + "\n");
    }

    public void mostrarHabilidades() {
        this.misHabilidades.forEach((k, v) -> v.mostrarHabilidad());
    }
}
