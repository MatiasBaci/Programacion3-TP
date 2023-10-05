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
        this.tipo = Tipo.obtenerUnTipo(tipo);
        this.historia = historia;
        this.estadisticas = new Estadisticas(vidaMax,nivel,velocidad,defensa,ataque);
        this.estadoActual = new EstadoNormal();
        this.misHabilidades = new HashMap<>();
    }


    public String getNombre() {return this.nombre;}

    public Tipo getTipo() {return this.tipo;}
    public Map<String, Habilidad> getMisHabilidades() {
        return this.misHabilidades;
    }
    public Estadisticas getEstadisticas() {return this.estadisticas;}
    public int getVelocidad() {return this.estadisticas.getVelocidad();}
    public double getVidaMaxima() {return this.estadisticas.getVidaMaxima();}
    public double getVida() {return this.estadisticas.getVida();}

    public Estado getEstadoActual() {
        return this.estadoActual;
    }

    public String suEstadoEs() {return this.estadoActual.getNombre();}


    public void añadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }


    public void recibirDanio(double damageEnemigo){
        this.estadisticas.reduccionVida(damageEnemigo);
    }

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public void aplicarEfectoPasivoPokemon(){
        this.estadoActual.aplicarEfectoPasivoDeEstado(this);
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
        return this.estadoActual.puedeAtacar(this);
    }

    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad); //es un puntero? :V

        if (this.puedeAtacar()) {
            unaHabilidad.usarHabilidad(pokemonEnemigoActual, this);
            System.out.println("La vida de " + pokemonEnemigoActual.getNombre() + " es = " + pokemonEnemigoActual.getVida());
            pokemonEnemigoActual.getEstadisticas().mostrarEstadisticas();
        }
    }

    public void mostrarPokemon(){
        System.out.println(" Nombre: " + this.nombre);
        System.out.println(" Tipo: " + this.tipo.getNombre());
        this.estadisticas.mostrarEstadisticas();
        System.out.println(" Historia: " + this.historia);
        System.out.println(" Estado: " + this.estadoActual.getNombre() + "\n");
    }

    public void mostrarHabilidades() {
        this.misHabilidades.forEach((k, v) -> v.mostrarHabilidad());
    }
}
