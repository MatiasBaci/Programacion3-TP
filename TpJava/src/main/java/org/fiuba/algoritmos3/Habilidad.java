package org.fiuba.algoritmos3;
public class Habilidad {
    private String nombre;

    private Tipo untipo;
    public String getTipo() {return untipo.getNombre();}

    public String getNombre() {return nombre;}

    public Habilidad(String nombre,Tipo tipo){
        this.nombre = nombre;
        this.untipo = tipo;
    }

    public double potenciaDeDaño(Tipo tipoPokemon){
        return this.untipo.calcularMultiplicadorDeDanio(tipoPokemon);
    }

}
