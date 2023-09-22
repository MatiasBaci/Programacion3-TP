package org.fiuba.algoritmos3;

import java.util.Random;

public class CalculoAtaque {
    private  Estadisticas estadisticasPropio;
    private Estadisticas estadisticasEnemigo;

    private Random unRandom;

    public CalculoAtaque(Estadisticas estadisticaPropio,Estadisticas estadisticaEnemigo){ //Estaria bien que reciba estadisticas? porque practicamente esta recibiendo otra informacion que no le importa
        this.estadisticasPropio = estadisticaPropio;
        this.estadisticasEnemigo = estadisticaEnemigo;
        this.unRandom = new Random();
    }

    public double calculoAtaqueTotal(Tipo unTipoPokemonEnemigo,Tipo unTipoPokemonPropio, Habilidad unaHabilidadPokemonPropio,int nivelPokemonPropio){

        // faltaria critico.
        double ataquePropio = (double)estadisticasPropio.getAtaque();
        double defensaEnemigo = (double)estadisticasEnemigo.getDefensa();
        double poderHabilidad = (double)unaHabilidadPokemonPropio.getPoder();
        double efectividadTipo = unaHabilidadPokemonPropio.potenciaDeDaño(unTipoPokemonEnemigo);
        double mismoTipo = unTipoPokemonPropio.calcularSTAB(unaHabilidadPokemonPropio.getTipo());
        double random = ((double)this.unRandom.nextInt(39)+217 ) / 255.0;
        double nivel = (double)nivelPokemonPropio;

        double numerador = ((2.0*nivel*poderHabilidad*ataquePropio/defensaEnemigo)/5.0) + 2.0;
        return (numerador/50.0)*mismoTipo*efectividadTipo*random;



    }
}
