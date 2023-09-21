package org.fiuba.algoritmos3;
public class Habilidad {

    private String nombre;
    private Tipo untipo;

    private int poder;

    // Metodos------------------------------------------------------------

    public Habilidad(String nombre,Tipo tipo){
        this.nombre = nombre;
        this.untipo = tipo;
        this.poder = 5;
    }
    public Tipo getTipo() {return untipo;}

    public String getNombre() {return nombre;}

    public double getPoder() { return poder; }

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.untipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

}
