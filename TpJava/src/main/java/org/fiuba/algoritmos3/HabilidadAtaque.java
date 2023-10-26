package org.fiuba.algoritmos3;

import Tipo.Tipo;

import java.util.Random;

import static org.fiuba.algoritmos3.Constantes.*;

public class HabilidadAtaque extends Habilidad {
    private final Tipo tipo;
    private final int poder;

    public HabilidadAtaque(String nombre, Tipo tipo, int poder, int cantidad){
        super(nombre,cantidad);
        this.tipo = tipo;
        this.poder = poder;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public int getPoder() {
        return poder;
    }

    private double potenciaDeDanio(Tipo tipoPokemon){
        return this.tipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

    private double calculoAtaqueSegunTipo(Tipo tipoDeUnPokemonPropio, Tipo unTipoPokemonEnemigo) {

        double efectividadTipo = this.potenciaDeDanio(unTipoPokemonEnemigo);
        double mismoTipo = tipoDeUnPokemonPropio.calcularBonusDelMismoTipo(this.tipo);

        Random unRandom = new Random();
        double random = ((double)unRandom.nextInt(38)+217 ) / 255.0;

        return efectividadTipo*mismoTipo*random;
    }

    private double calculoCritico() {
        Random unRandom = new Random();
        int resultado = unRandom.nextInt(100);
        if (resultado < PROBABILIDAD_CRITICO) {
            return NO_CRITICO;
        }
        return CRITICO;
    }

    private double calculoAtaqueSegunEstadisticas(Cualidades cualidadesPropio, Cualidades cualidadesEnemigo) {
        double ataque = (double)cualidadesPropio.getAtaque();
        double defensa = (double)cualidadesEnemigo.getDefensa();
        double poderHabilidad = (double) this.poder;
        double critico = this.calculoCritico();
        double nivel = (double)cualidadesPropio.getNivel();

        return (2.0*nivel*poderHabilidad*ataque*critico/(defensa*5.0)+2.0)/50.0;
    }

        private double atacar(Cualidades cualidadesPokemonPropio, Cualidades cualidadesPokemonEnemigo){
        double danioEstadisticas = this.calculoAtaqueSegunEstadisticas(cualidadesPokemonPropio,cualidadesPokemonEnemigo);
        double danioTipo = this.calculoAtaqueSegunTipo(cualidadesPokemonPropio.getTipo(),cualidadesPokemonEnemigo.getTipo());
        return danioEstadisticas * danioTipo;
    }

    @Override
    public void usarHabilidad(Cualidades cualidadesPokemonEnemigo,Cualidades cualidadesPokemonPropio){
        this.cantidadDeUsos -= 1;
        double danio = Math.round(this.atacar(cualidadesPokemonPropio,cualidadesPokemonEnemigo));
        cualidadesPokemonEnemigo.recibirDanio(danio);
        System.out.println("El daño infligido de la habiilidad: "+this.nombre +" es = " +danio );
    }



}
