package org.fiuba.algoritmos3;

import Tipo.Tipo;

import java.util.Random;

public class HabilidadAtaque extends Habilidad {
    private Tipo tipo;
    private int poder;

    public HabilidadAtaque(String nombre, Tipo tipo, int poder, int cantidad){
        super(nombre,cantidad); //Habilidad(String nombre, int cantidadDeUsos
        this.tipo = tipo;
        this.poder = poder;
    }

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.tipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

    private double calculoAtaqueSegunTipo(Tipo tipoDeUnPokemonPropio, Tipo unTipoPokemonEnemigo) {

        double efectividadTipo = this.potenciaDeDaño(unTipoPokemonEnemigo);
        double mismoTipo = tipoDeUnPokemonPropio.calcularSTAB(this.tipo);

        Random unRandom = new Random();
        double random = ((double)unRandom.nextInt(38)+217 ) / 255.0;

        return efectividadTipo*mismoTipo*random;
    }

    private double calculoCritico() {
        Random unRandom = new Random();
        int resultado = unRandom.nextInt(100);
        if (resultado < 90) {
            return 1.0;
        }
        return 2.0;
    }

    private double calculoAtaqueSegunEstadisticas(Estadisticas estadisticasPropio, Estadisticas estadisticasEnemigo) {
        double ataque = (double)estadisticasPropio.getAtaque();
        double defensa = (double)estadisticasEnemigo.getDefensa();
        double poderHabilidad = (double) this.poder;
        double critico = this.calculoCritico();
        double nivel = (double)estadisticasPropio.getNivel();

        return (2.0*nivel*poderHabilidad*ataque*critico/(defensa*5.0)+2.0)/50.0;
    }

    private double atacar(Pokemon unPokemonPropio, Pokemon unPokemonEnemigo){
        double danioEstadisticas = this.calculoAtaqueSegunEstadisticas(unPokemonPropio.getEstadisticas(),unPokemonEnemigo.getEstadisticas());
        double danioTipo = this.calculoAtaqueSegunTipo(unPokemonPropio.getTipo(),unPokemonEnemigo.getTipo());
        return danioEstadisticas * danioTipo;
    }

    @Override
    public void usarHabilidad(Pokemon unPokemonEnemigo,Pokemon unPokemonPropio){
        this.cantidadDeUsos -= 1;
        double danio = this.atacar(unPokemonPropio,unPokemonEnemigo);
        unPokemonEnemigo.recibirDanio(danio);
        System.out.println("¡" + unPokemonPropio.getNombre() + " usó " + this.getNombre() + "!");
        this.mostrarUso(unPokemonEnemigo);
        System.out.println("El daño infligido de la habiilidad: "+this.nombre +" es = " +danio );
    }

    @Override
    public void mostrarHabilidad(){
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Tipo: " + this.tipo.getNombre());
        System.out.println("Poder: " + this.poder);
        System.out.println("Cantidad de usos: " + this.cantidadDeUsos);
        System.out.println("\n");
    }


    @Override
    public void mostrarUso(Pokemon unPokemon){
        System.out.println("La vida de " + unPokemon.getNombre() + " es = " + unPokemon.getVida());
    }


}
