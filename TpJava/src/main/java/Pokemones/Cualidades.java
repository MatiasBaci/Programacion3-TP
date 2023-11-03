package Pokemones;

import Estados.Estado;
import Estados.EstadoInhabilitado;
import Estados.EstadoNormal;
import Tipo.Tipo;

import java.util.HashSet;
import java.util.Set;

import static org.fiuba.algoritmos3.Constantes.PORCENTAJE;
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

    private Set<Estado> estados = new HashSet<>();


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
        Estado unEstado = new EstadoNormal();
        unEstado.setCualidades(this);
        this.estados.add(unEstado);
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

    public Set<Estado> getEstadosActuales() {
        return this.estados;
    }
    public  void agregarEstado(Estado unEstado){ //throws EstadoDuplicadoException {
        /*if (estados.contains(unEstado)) {
            throw new EstadoDuplicadoException("El estado ya está presente en el conjunto.");
        }*/
        unEstado.setCualidades(this);
        this.estados.add(unEstado); // Al ser un Set no se va añadir ademas hay una verificacion arriba para el mensaje.
    }

    public void eliminarEstado(Estado unEstado) {
        this.estados.remove(unEstado);
    }

    public boolean atacarConEstadosActuales(){
        boolean puedeAtacarConSusEstados = this.estados.stream().allMatch(estado -> estado.puedeAtacar());
        this.estados.removeIf(Estado::debeSerEliminado);
        return puedeAtacarConSusEstados;
    }

    public void aplicarEfectoPasivoDeEstadosActuales(){ // Esto solo func para todsos pero los que realizan algo es Estado Confuso y estado ENVENADO
        this.estados.forEach(estado -> estado.aplicarEfectoPasivoDeEstado());
    }

    public void actualizarEstados() { // Posiblemente no se use porque estan pasados por referencia
        this.estados.forEach(estado -> estado.setCualidades(this));
    }

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

    private void reduccionVida(double vida){
        double vidaTotal = (this.vidaActual - vida);
        if(vidaTotal < 0){
            this.vidaActual = 0;
        }
        else{ this.vidaActual -= vida;}
    }

    public void recibirDanio(double damageEnemigo){
        this.reduccionVida(damageEnemigo);
    }

    public void cambiarLosEstadosA(Estado unEstado) {
        this.estados.clear(); // elimina todos los estados
        this.agregarEstado(unEstado);
    }

    public boolean estaConsciente() {
        if(this.getVida() == 0){
            this.cambiarLosEstadosA(new EstadoInhabilitado());
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
}
