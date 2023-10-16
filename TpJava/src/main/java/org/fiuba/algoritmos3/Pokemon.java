package org.fiuba.algoritmos3;
import Tipo.Tipo;

import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    //Atributos:
    private String nombre;
    private String historia;
    private Cualidades cualidades;

    private Map<String, Habilidad> misHabilidades;

    //Metodos:
    public Pokemon(String nombre, int nivel,String tipo, String historia,double vidaMax,int velocidad,int defensa,int ataque){
        this.nombre = nombre;
        this.historia = historia;
        this.cualidades = new Cualidades(vidaMax,nivel,velocidad,defensa,ataque, tipo);
        this.misHabilidades = new HashMap<>();
    }

    public void aplicarEfectoPasivoPokemon(){
        this.getCualidades().getEstadoActual().aplicarEfectoPasivoDeEstado(this.cualidades); //Cambiar
    }
    public String getNombre() {return nombre;}

    public Map<String, Habilidad> getMisHabilidades() {
        return misHabilidades;
    }
    public Cualidades getCualidades() {return cualidades;}
    public int getVelocidad() {return cualidades.getVelocidad();}
    public double getVidaMaxima() {return this.cualidades.getVidaMaxima();}
    public double getVida() {return this.cualidades.getVida();}

    public void aniadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }


    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }
    public boolean estaConciente() {
        return this.cualidades.estaConciente();
    }

    public boolean puedeAtacar(){
        return this.cualidades.getEstadoActual().puedeAtacar(this.cualidades);
    }

    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);

        if (this.puedeAtacar()) {
            System.out.println("¡"+ pokemonEnemigoActual.getNombre() + " uso " + this.nombre + "!");
            unaHabilidad.usarHabilidad(pokemonEnemigoActual.getCualidades(), this.cualidades);

        }
    }

    public void mostrarPokemon(){
        System.out.println(" Nombre: " + this.nombre);
        this.cualidades.mostrarCualidades();
        System.out.println(" Historia: " + this.historia);
    }

    public Tipo getTipo() {return this.cualidades.getTipo(); }

    public void mostrarHabilidades() {
        this.misHabilidades.forEach((k, v) -> v.mostrarHabilidad());
    }
}
