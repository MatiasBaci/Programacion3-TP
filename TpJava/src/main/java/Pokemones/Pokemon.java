package Pokemones;

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
        this.cualidades.aplicarEfectoPasivoDeEstadosActuales(); // cambiarlo a aplicarEfectoPasivoEstadosActuales
    }
    public String getNombre() {return nombre;}
    public Map<String, Habilidad> getMisHabilidades() {
        return misHabilidades;
    }
    public Cualidades getCualidades() {return cualidades;}
    public int getVelocidad() {return cualidades.getVelocidad();}
    public double getVidaMaxima() {return this.cualidades.getVidaMaxima();}
    public String getHistoria() {
        return historia;
    }

    public void aniadirHabilidad(Habilidad unaHabilidad){
        this.misHabilidades.put(unaHabilidad.getNombre(), unaHabilidad);
    }

    public Habilidad seleccionarHabilidad(String unaHabilidad){
        return misHabilidades.get(unaHabilidad);
    }

    public boolean estaConsciente() {return this.cualidades.estaConsciente();}

    public void atacar(Pokemon pokemonEnemigoActual, String nombreDeHabilidad) {

        Habilidad unaHabilidad = this.seleccionarHabilidad(nombreDeHabilidad);


        if (this.cualidades.atacarConEstadosActuales()) { //this.cualidades.atacarConEstadoActual() --> version uno solo
            unaHabilidad.usarHabilidad(pokemonEnemigoActual.getCualidades(), this.cualidades);
        }
    }

    public Tipo getTipo() {return this.cualidades.getTipo(); }

}
